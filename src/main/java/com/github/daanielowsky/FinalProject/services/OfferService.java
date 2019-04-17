package com.github.daanielowsky.FinalProject.services;

import com.github.daanielowsky.FinalProject.dto.AddOfferFormDTO;
import com.github.daanielowsky.FinalProject.entity.Offer;
import com.github.daanielowsky.FinalProject.entity.User;
import com.github.daanielowsky.FinalProject.repositories.CategoryRepository;
import com.github.daanielowsky.FinalProject.repositories.OfferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

import static com.github.daanielowsky.FinalProject.services.Converters.convertToOffer;

@Service
public class OfferService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private OfferRepository offerRepository;
    private CategoryRepository categoryRepository;
    private UserService userService;

    public OfferService(OfferRepository offerRepository, CategoryRepository categoryRepository, UserService userService) {
        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;
        this.userService = userService;
    }

    @Transactional
    public void registerOffer(AddOfferFormDTO form) {
        Offer offer = convertToOffer(form);
        offer.setUser(userService.getLoggedUser());
        offer.setCategory(categoryRepository.getFirstByName(form.getCategory()));
        logger.info("Dodano ofertę:" + offer);
        offerRepository.save(offer);
        logger.info("Oferta o id:" + offer.getId());
    }

    @Transactional
    public List<Offer> showOffers(){
        User loggedUser = userService.getLoggedUser();
        return offerRepository.getAllByUser(loggedUser);
    }

    @Transactional
    public List<Offer> showAllOffersWithTitleLike(String title){
        return offerRepository.getAllByTitleLike(title);
    }

}
