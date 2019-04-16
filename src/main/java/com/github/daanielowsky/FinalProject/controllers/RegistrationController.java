package com.github.daanielowsky.FinalProject.controllers;

import com.github.daanielowsky.FinalProject.dto.RegistrationFormDTO;
import com.github.daanielowsky.FinalProject.dto.UserDTO;
import com.github.daanielowsky.FinalProject.repositories.UserRepository;
import com.github.daanielowsky.FinalProject.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class RegistrationController {

    private UserService userService;


    private UserRepository userRepository;

    public RegistrationController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @ModelAttribute("date")
    public String actualDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new RegistrationFormDTO());
        return "registerpage";
    }


    @PostMapping(value = "/register")
    public String registerUser(@Valid @ModelAttribute("user") RegistrationFormDTO form, BindingResult result) {
        if (result.hasErrors()) {
            return "registerpage";
        }

        if (!checkPasswordEquality(form)) {
            result.rejectValue("confirmedPassword", null, "Hasło i powtórzone hasło nie są takie same.");
            return "registerpage";
        }

        if (!checkIsUsernameAvaiable(form)) {
            result.rejectValue("username", null, "Nazwa użytkownika już zajęta.");
            return "registerpage";
        }
        userService.registerUser(form);
        return "redirect:/";
    }

    private boolean checkIsUsernameAvaiable(RegistrationFormDTO form) {
        UserDTO user = userService.findUser(form.getUsername());
        if (user == null){
            return true;
        }
        return false;
    }

    private boolean checkPasswordEquality(RegistrationFormDTO form) {
        return form.getPassword().equals(form.getConfirmedPassword());

    }
}
