package com.github.daanielowsky.FinalProject.repositories;

import com.github.daanielowsky.FinalProject.entity.Category;
import com.github.daanielowsky.FinalProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    User findFirstByUsernameAndPassword(String username, String password);
    Optional<User> findFirstByUsername(String username);
    User findByUsername(String username);
    User findById(Long id);
    List<User> getAllByCategories(Category category);
}
