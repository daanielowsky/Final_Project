package com.github.daanielowsky.FinalProject.controllers;

import com.github.daanielowsky.FinalProject.dto.EditOfferDTO;
import com.github.daanielowsky.FinalProject.dto.OfferDTO;
import com.github.daanielowsky.FinalProject.dto.ResourceDTO;
import com.github.daanielowsky.FinalProject.entity.Offer;
import com.github.daanielowsky.FinalProject.entity.User;
import com.github.daanielowsky.FinalProject.repositories.OfferRepository;
import com.github.daanielowsky.FinalProject.repositories.UserRepository;
import com.github.daanielowsky.FinalProject.services.OfferService;
import com.github.daanielowsky.FinalProject.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
public class OfferController {

    private static Logger logger = LoggerFactory.getLogger(OfferController.class);

    private OfferService offerService;
    private UserService userService;
    private UserRepository userRepository;
    private OfferRepository offerRepository;


    public OfferController(OfferService offerService, UserService userService, UserRepository userRepository, OfferRepository offerRepository) {
        this.offerService = offerService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.offerRepository = offerRepository;
    }

    @ModelAttribute("date")
    public String actualDate(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }

    @ModelAttribute("userprofile")
    public User user(){
        return userService.getLoggedUser();
    }

    @GetMapping("/addoffer")
    public String showOfferForm(Model model){
        model.addAttribute("addoffer", new OfferDTO());
        return "addoffer";
    }

    @PostMapping("/addoffer")
    public String addOffer(@Valid @ModelAttribute ("addoffer") OfferDTO offerform, BindingResult result, @RequestParam MultipartFile offerImage) throws IOException {
        if (result.hasErrors()){
            return "addoffer";
        }
        offerform.setContentType(offerImage.getContentType());
        offerform.setImage(offerImage.getBytes());
        offerService.registerOffer(offerform);
        return "redirect:/";
    }

    @GetMapping("/offers")
    public String showOffers(Model model){
        model.addAttribute("offers", offerService.showOffers());
        return "youroffers";
    }

    @GetMapping("/searchoffers")
    public String searchOffers(@RequestParam String title, Model model){
        String[] s = title.split(" ");
        List<Offer> offers = new LinkedList<>();
        Arrays.asList(s).stream().forEach(q -> offers.addAll(offerService.showAllOffersWithTitleLike(q)));
        model.addAttribute("offers", offers);
        return "searchoffers";
    }

    @GetMapping("/offer/{id}/image")
    public ResponseEntity<Resource> getOfferImage(@PathVariable Long id) {
        ResourceDTO offerImage = offerService.getOfferImage(id);
        if (offerImage.getResource() != null) {
            return ResponseEntity.ok().contentType(MediaType.valueOf(offerImage.getContentType())).body(offerImage.getResource());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/offer/{id}")
    public String showCertainOffer(@PathVariable Long id, Model model){
        Offer dto = offerService.getOfferByID(id);
        User user = dto.getUser();
        model.addAttribute("dto", dto);
        model.addAttribute("user", user);
        return "offerdetails";
    }

    @GetMapping("/deleteoffer")
    public String deleteOffer(@RequestParam Long id){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User byUsername = userRepository.findByUsername(username);
        Long userId = byUsername.getId();
        Long offerUserId = offerService.getOfferByID(id).getUser().getId();
        if (userId == offerUserId){
            offerService.deleteOffer(id);
            return "redirect:/offers";
        } else {
            return "redirect:/forbidden";
        }
    }

    @GetMapping("/editoffer")
    public String editOfferForm(@RequestParam Long id, Model model){
        EditOfferDTO dtoforEdit = offerService.getDTOforEdit(id);
        model.addAttribute("editoffer", dtoforEdit);
        return "editoffer";
    }

    @PostMapping("/editoffer")
    public String editForm(@RequestParam Long id, @Valid @ModelAttribute("editoffer") EditOfferDTO editoffer, BindingResult result){
        if (result.hasErrors()){
            return "editoffer";
        }
        Offer offerByID = offerService.getOfferByID(id);
        offerByID.setPrice(editoffer.getPrice());
        offerByID.setDescription(editoffer.getDescription());
        offerByID.setTitle(editoffer.getTitle());
        offerRepository.save(offerByID);
        return "redirect:/offers";
    }

    @GetMapping("/forbidden")
    public String forbidden(){
        return "forbidden";
    }


}
