package com.github.daanielowsky.FinalProject.controllers;


import com.github.daanielowsky.FinalProject.dto.EditUserDTO;
import com.github.daanielowsky.FinalProject.dto.RegistrationFormDTO;
import com.github.daanielowsky.FinalProject.dto.UserDTO;
import com.github.daanielowsky.FinalProject.entity.User;
import com.github.daanielowsky.FinalProject.repositories.UserRepository;
import com.github.daanielowsky.FinalProject.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class LoginController {


    private UserRepository userRepository;
    private UserService userService;

    public LoginController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

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

    @GetMapping("/editprofile")
    public String editProfileForm(Model model){
        User loggedUser = userService.getLoggedUser();
        EditUserDTO editUserDTO = userService.findUserforEdit(loggedUser.getUsername());
        model.addAttribute("editUserDTO", editUserDTO);
        return "editprofile";
    }

    @PostMapping("/editprofile")
    public String editProfileForm(@Valid @ModelAttribute EditUserDTO editUserDTO, BindingResult result){
        if (result.hasErrors()){
            return "editprofile";
        }
        User loggedUser = userService.getLoggedUser();
        loggedUser.setPhoneNumber(editUserDTO.getPhoneNumber());
        loggedUser.setEmail(editUserDTO.getEmail());
        loggedUser.setFullName(editUserDTO.getFullName());
        return "redirect:/";
    }
}
