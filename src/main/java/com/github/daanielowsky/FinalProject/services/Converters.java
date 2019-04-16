package com.github.daanielowsky.FinalProject.services;

import com.github.daanielowsky.FinalProject.dto.RegistrationFormDTO;
import com.github.daanielowsky.FinalProject.dto.UserDTO;
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
        user.setFullName(form.getFullName());
        user.setPassword(form.getPassword());
        user.setUsername(form.getUsername());
        return user;
    }
}
