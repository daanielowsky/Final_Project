package com.github.daanielowsky.FinalProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditOfferDTO {

    @NotNull
    @Size(min = 3)
    private String title;

    @NotNull @Size(min = 3)
    private String description;

    @NotNull
    private String price;
}
