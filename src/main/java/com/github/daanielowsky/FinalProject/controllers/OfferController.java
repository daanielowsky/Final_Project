package com.github.daanielowsky.FinalProject.controllers;

import com.github.daanielowsky.FinalProject.dto.AddOfferFormDTO;
import com.github.daanielowsky.FinalProject.dto.ResourceDTO;
import com.github.daanielowsky.FinalProject.entity.Offer;
import com.github.daanielowsky.FinalProject.services.OfferService;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    private OfferService offerService;


    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @ModelAttribute("date")
    public String actualDate(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }

    @GetMapping("/addoffer")
    public String showOfferForm(Model model){
        model.addAttribute("addoffer", new AddOfferFormDTO());
        return "addoffer";
    }

    @PostMapping("/addoffer")
    public String addOffer(@Valid @ModelAttribute ("addoffer") AddOfferFormDTO offerform, BindingResult result, @RequestParam MultipartFile offerImage) throws IOException {
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
        model.addAttribute("dto", dto);
        return "offerdetails";
    }
}
