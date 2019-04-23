package com.github.daanielowsky.FinalProject.services;


import com.github.daanielowsky.FinalProject.dto.EditUserDTO;
import com.github.daanielowsky.FinalProject.dto.RegistrationFormDTO;
import com.github.daanielowsky.FinalProject.dto.ResourceDTO;
import com.github.daanielowsky.FinalProject.dto.UserDTO;
import com.github.daanielowsky.FinalProject.entity.Offer;
import com.github.daanielowsky.FinalProject.entity.User;
import com.github.daanielowsky.FinalProject.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.github.daanielowsky.FinalProject.services.Converters.*;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getLoggedUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findFirstByUsername(username).orElse(null);
    }

    @Transactional
    public void registerUser(RegistrationFormDTO form) {
        User user = convertToUser(form);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        logger.info("Rejestracja użytkownika:" + user);
        userRepository.save(user);
        logger.info("Zarejestrowany użytkownik:" + user.getId());
    }

    @Transactional
    public UserDTO findUser(String username) {
        if(username == null){
            throw new IllegalArgumentException("Nazwa użytkownika musi być podana");
        }
        Optional<User> optionalUser  = userRepository.findFirstByUsername(username);
        User user = optionalUser.orElse(null);
        if (user == null) {
            logger.debug("Nie znaleziono użytkownika dla nazwy: " + username);
            return null;
        }
        logger.debug("Znaleziono użytkownika dla nazwy: " + username);
        return  convertToUserDTO(user);
    }
    @Transactional
    public EditUserDTO findUserforEdit(String username) {
        if(username == null){
            throw new IllegalArgumentException("Nazwa użytkownika musi być podana");
        }
        Optional<User> optionalUser  = userRepository.findFirstByUsername(username);
        User user = optionalUser.orElse(null);
        if (user == null) {
            logger.debug("Nie znaleziono użytkownika dla nazwy: " + username);
            return null;
        }
        logger.debug("Znaleziono użytkownika dla nazwy: " + username);
        return  convertToEditUserDTO(user);
    }

    @Transactional
    public User getUserById(Long id){
        User byId = userRepository.findById(id);
        return byId;
    }

    public ResourceDTO getUserImage(Long id) {
        ResourceDTO resourceDTO = new ResourceDTO();
        User user = userRepository.findById(id);
        if (user.getImageType() != null) {
            ByteArrayResource resource = new ByteArrayResource(user.getFile());
            resourceDTO.setResource(resource);
            resourceDTO.setContentType(user.getImageType());
        }
        return resourceDTO;
    }
}
