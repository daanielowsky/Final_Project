package com.github.daanielowsky.FinalProject.dto;

import com.github.daanielowsky.FinalProject.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferDTO {

    @NotNull @Size(min = 3)
    private String title;

    @NotNull @Size(min = 3)
    private String description;

    @NotNull
    private String category;

    @NotNull
    private String price;

    private String contentType;

    private byte[] image;



}
