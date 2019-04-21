package com.github.daanielowsky.FinalProject.services;

import com.github.daanielowsky.FinalProject.dto.*;
import com.github.daanielowsky.FinalProject.entity.Offer;
import com.github.daanielowsky.FinalProject.entity.User;

public class Converters {

    public static UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setFullname(user.getFullName());
        return userDTO;
    }

    public static User convertToUser(RegistrationFormDTO form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPhoneNumber(form.getPhoneNumber());
        user.setFullName(form.getFullName());
        user.setPassword(form.getPassword());
        user.setUsername(form.getUsername());
        return user;
    }
    public static EditUserDTO convertToEditUserDTO(User user) {
        EditUserDTO dto = new EditUserDTO();
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());

        return dto;
    }

    public static Offer convertToOffer(OfferDTO form){
        Offer offer = new Offer();
        offer.setTitle(form.getTitle());
        offer.setDescription(form.getDescription());
        offer.setPrice(form.getPrice());
        return offer;
    }

    public static EditOfferDTO convertToDTO(Offer offer){
        EditOfferDTO dto = new EditOfferDTO();
        dto.setPrice(offer.getPrice());
        dto.setDescription(offer.getDescription());
        dto.setTitle(offer.getTitle());
        return dto;

    }
}
