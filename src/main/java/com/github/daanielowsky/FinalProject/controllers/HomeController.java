package com.github.daanielowsky.FinalProject.controllers;


import com.github.daanielowsky.FinalProject.services.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {

    private OfferService offerService;

    public HomeController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/")
    public String getHomePage(Model model){
        model.addAttribute("offers", offerService.getFirstTenOffers());
        return "index";
    }

    @ModelAttribute("date")
    public String actualDate(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }
}
