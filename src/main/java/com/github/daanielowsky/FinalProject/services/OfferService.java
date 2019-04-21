package com.github.daanielowsky.FinalProject.services;

import com.github.daanielowsky.FinalProject.dto.EditOfferDTO;
import com.github.daanielowsky.FinalProject.dto.OfferDTO;
import com.github.daanielowsky.FinalProject.dto.ResourceDTO;
import com.github.daanielowsky.FinalProject.entity.Offer;
import com.github.daanielowsky.FinalProject.entity.User;
import com.github.daanielowsky.FinalProject.repositories.CategoryRepository;
import com.github.daanielowsky.FinalProject.repositories.OfferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

import static com.github.daanielowsky.FinalProject.services.Converters.convertToDTO;
import static com.github.daanielowsky.FinalProject.services.Converters.convertToOffer;

@Service
public class OfferService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private OfferRepository offerRepository;
    private CategoryRepository categoryRepository;
    private UserService userService;
    private ResourceDTO resourceDTO;

    public OfferService(OfferRepository offerRepository, CategoryRepository categoryRepository, UserService userService) {
        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;
        this.userService = userService;
    }

    @Transactional
    public void registerOffer(OfferDTO form) {
        Offer offer = convertToOffer(form);
        offer.setUser(userService.getLoggedUser());
        offer.setCategory(categoryRepository.getFirstByName(form.getCategory()));
        offer.setImageType(form.getContentType());
        offer.setFile(form.getImage());
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
    public Offer getOfferByID(Long id){
        return offerRepository.getOne(id);
    }

    @Transactional
    public List<Offer> showAllOffersWithTitleLike(String title){
        return offerRepository.getAllByTitleLike(title);
    }

    public ResourceDTO getOfferImage(Long id) {
        ResourceDTO resourceDTO = new ResourceDTO();
        Offer offer = offerRepository.getOne(id);
        if (offer.getImageType() != null) {
            ByteArrayResource resource = new ByteArrayResource(offer.getFile());
            resourceDTO.setResource(resource);
            resourceDTO.setContentType(offer.getImageType());
        }
        return resourceDTO;
    }

    @Transactional
    public List<Offer> getFirstTenOffers() {
        List<Offer> firstTen = offerRepository.getFirstTen();
        return firstTen;
    }


    @Transactional
    public void deleteOffer(Long id){
        Offer offerByID = getOfferByID(id);
        offerRepository.delete(offerByID);
    }

    @Transactional
    public EditOfferDTO getDTOforEdit(Long id){
        Offer offerByID = getOfferByID(id);
        EditOfferDTO editOfferDTO = convertToDTO(offerByID);
        return editOfferDTO;

    }
}
