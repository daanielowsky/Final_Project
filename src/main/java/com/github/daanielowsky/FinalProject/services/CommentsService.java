package com.github.daanielowsky.FinalProject.services;


import com.github.daanielowsky.FinalProject.dto.CommentDTO;
import com.github.daanielowsky.FinalProject.entity.Comments;
import com.github.daanielowsky.FinalProject.entity.User;
import com.github.daanielowsky.FinalProject.repositories.CommentsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentsService {

    private UserService userService;
    private CommentsRepository commentsRepository;

    public CommentsService(UserService userService, CommentsRepository commentsRepository) {
        this.userService = userService;
        this.commentsRepository = commentsRepository;
    }


    @Transactional
    public void addComment(CommentDTO commentDTO, Long whoComments, Long commentForWho){
        Comments comments = new Comments();
        comments.setComment(commentDTO.getComment());
        comments.setCommentedUser(userService.getUserById(commentForWho));
        comments.setUserCommenting(userService.getUserById(whoComments));
        commentsRepository.save(comments);
    }

    @Transactional
    public List<Comments> getCommentsForUser(Long id){
        User userById = userService.getUserById(id);
        return commentsRepository.getAllByCommentedUser(userById);
    }
}
