package com.github.daanielowsky.FinalProject.controllers;


import com.github.daanielowsky.FinalProject.dto.RegistrationFormDTO;
import com.github.daanielowsky.FinalProject.entity.User;
import com.github.daanielowsky.FinalProject.repositories.UserRepository;
import com.github.daanielowsky.FinalProject.validation.RegistrationValidationGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.groups.Default;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @ModelAttribute("date")
    public String actualDate(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }

    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("user", new RegistrationFormDTO());
        return "loginpage";
    }


    @PostMapping("/login")
    public String loginValidation(@Valid @ModelAttribute User user, BindingResult result, HttpSession session){
        if (result.hasErrors()) {
            return "loginpage";
        }
        User existingUser = userRepository.findFirstByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (existingUser == null) {
            result.addError(new FieldError("user", "username", "Username or password is invalid"));
            return "loginpage";
        }
            session.setAttribute("userID", existingUser.getId());
        return "redirect:/";
    }
}
