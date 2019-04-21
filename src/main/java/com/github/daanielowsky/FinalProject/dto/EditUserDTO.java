package com.github.daanielowsky.FinalProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditUserDTO {


    @NotBlank
    private String fullName;
    @NotNull @Min(9)
    private Long phoneNumber;
    @NotBlank
    @Email
    private String email;
}
