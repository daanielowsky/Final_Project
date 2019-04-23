package com.github.daanielowsky.FinalProject.controllers;


import com.github.daanielowsky.FinalProject.dto.CommentDTO;
import com.github.daanielowsky.FinalProject.dto.EditUserDTO;
import com.github.daanielowsky.FinalProject.dto.RegistrationFormDTO;
import com.github.daanielowsky.FinalProject.dto.ResourceDTO;
import com.github.daanielowsky.FinalProject.entity.Comments;
import com.github.daanielowsky.FinalProject.entity.User;
import com.github.daanielowsky.FinalProject.repositories.UserRepository;
import com.github.daanielowsky.FinalProject.services.CommentsService;
import com.github.daanielowsky.FinalProject.services.UserService;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class LoginController {


    private UserRepository userRepository;
    private UserService userService;
    private CommentsService commentsService;

    public LoginController(UserRepository userRepository, UserService userService, CommentsService commentsService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.commentsService = commentsService;
    }

    @ModelAttribute("date")
    public String actualDate(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }

    @ModelAttribute("userprofile")
    public User user(){
        return userService.getLoggedUser();
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
        userRepository.save(loggedUser);
        return "index";
    }

    @GetMapping("/user/{id}")
    public String showProfile(@PathVariable Long id, Model model){
        User userById = userService.getUserById(id);
        List<Comments> commentsForUser = commentsService.getCommentsForUser(id);
        model.addAttribute("comments", commentsForUser);
        model.addAttribute("addcomment", new CommentDTO());
        model.addAttribute("userdetails", userById);
        return "userdetails";
    }

    @GetMapping("/user/{id}/image")
    public ResponseEntity<Resource> getUserImage(@PathVariable Long id) {
        ResourceDTO userImage = userService.getUserImage(id);
        if (userImage.getResource() != null) {
            return ResponseEntity.ok().contentType(MediaType.valueOf(userImage.getContentType())).body(userImage.getResource());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
