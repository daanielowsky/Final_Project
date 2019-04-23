package com.github.daanielowsky.FinalProject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationFormDTO {

    @NotNull @Size(min = 3, max = 20)
    private String username;
    @NotNull @Size(min = 3, max = 20)
    private String password;
    @NotNull @Size(min = 3, max = 20)
    private String confirmedPassword;
    @NotBlank
    private String fullName;
    @NotNull @Min(9)
    private Long phoneNumber;
    @NotBlank
    @Email
    private String email;

    private String contentType;

    private byte[] image;
}
