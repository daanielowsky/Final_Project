package com.github.daanielowsky.FinalProject.controllers;

import com.github.daanielowsky.FinalProject.dto.CommentDTO;
import com.github.daanielowsky.FinalProject.entity.User;
import com.github.daanielowsky.FinalProject.services.CommentsService;
import com.github.daanielowsky.FinalProject.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class CommentController {

    private UserService userService;
    private CommentsService commentsService;

    public CommentController(UserService userService, CommentsService commentsService) {
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

    @PostMapping("addcomment/{id}")
    public String addComment(@ModelAttribute("addcomment") @Valid CommentDTO commentDTO, BindingResult result, @PathVariable Long id){
        if (result.hasErrors()){
            return "userdetails";
        }
        Long id1 = userService.getLoggedUser().getId();
        commentsService.addComment(commentDTO, id1, id);
        return "redirect:/";
    }
}
