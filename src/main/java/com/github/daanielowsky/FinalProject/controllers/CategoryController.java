package com.github.daanielowsky.FinalProject.controllers;

import com.github.daanielowsky.FinalProject.entity.Category;
import com.github.daanielowsky.FinalProject.entity.Offer;
import com.github.daanielowsky.FinalProject.repositories.CategoryRepository;
import com.github.daanielowsky.FinalProject.repositories.OfferRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class CategoryController {

    private OfferRepository offerRepository;
    private CategoryRepository categoryRepository;

    public CategoryController(OfferRepository offerRepository, CategoryRepository categoryRepository) {
        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;
    }

    @ModelAttribute("date")
    public String actualDate(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }

    @GetMapping("/search")
    public String getOffersByCategory(@RequestParam String category, Model model){

        Category firstByName = categoryRepository.getFirstByName(category);
        List<Offer> allByCategory = offerRepository.getAllByCategory(firstByName);
        model.addAttribute("oferts", allByCategory);
        return "categoryoffers";

    }
}
