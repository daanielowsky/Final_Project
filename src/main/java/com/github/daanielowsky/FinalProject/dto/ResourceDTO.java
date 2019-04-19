package com.github.daanielowsky.FinalProject.dto;

import lombok.Data;
import org.springframework.core.io.Resource;

@Data
public class ResourceDTO {

    private Resource resource;
    private String contentType;
}
