package com.github.daanielowsky.FinalProject.repositories;

import com.github.daanielowsky.FinalProject.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository <Comments, Long> {
}
