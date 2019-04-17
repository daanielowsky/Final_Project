package com.github.daanielowsky.FinalProject.repositories;

import com.github.daanielowsky.FinalProject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category getFirstByName(String name);

    Category getByName(String name);

}
