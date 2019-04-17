package com.github.daanielowsky.FinalProject.controllers;

import com.github.daanielowsky.FinalProject.dto.AddOfferFormDTO;
import com.github.daanielowsky.FinalProject.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    public String addOffer(@Valid @ModelAttribute ("addoffer") AddOfferFormDTO offerform, BindingResult result){
        if (result.hasErrors()){
            return "addoffer";
        }
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
        for(String gettitle : s){
            model.addAttribute("offers", offerService.showAllOffersWithTitleLike(gettitle));
        }
        return "searchoffers";
    }


//    public String addOffer(MultipartHttpServletRequest request) {
//        MultipartFile file = request.getFile("offert_file");
//        try {
//            byte[] bytes = file.getBytes();
//            String contentType = file.getContentType();
//            // image/jpeg
//            // image/gif
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @GetMapping("/offer/offerImage/{offerId}")
//    public void getImage(@PathVariable Long offerId, HttpServletResponse response) throws IOException {
//        String pathToFile = ";'klklklkl";
//        String fileContentType = "image/jpeg";
//
//        Path path = Paths.get(pathToFile);
//        File file = path.toFile();
//
//        response.setContentType(fileContentType);
//        ServletOutputStream outputStream = response.getOutputStream();
//        try {
//            FileInputStream fileInputStream = new FileInputStream(file);
//            int read = fileInputStream.read();
//            outputStream.write(read);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }

}
