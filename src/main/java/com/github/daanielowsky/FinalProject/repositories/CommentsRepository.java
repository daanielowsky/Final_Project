package com.github.daanielowsky.FinalProject.repositories;

import com.github.daanielowsky.FinalProject.entity.Comments;
import com.github.daanielowsky.FinalProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository <Comments, Long> {

    List<Comments> getAllByCommentedUser(User user);
}
