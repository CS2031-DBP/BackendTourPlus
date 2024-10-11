package com.dbp.backendtourplus.tour.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Data
public class TourDto {
    @NotBlank(message = "El título no puede estar vacío")
    private String title;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String description;

    @Positive(message = "El precio debe ser un número positivo")
    private Double price;

    private Long tourCategoryId;
    private List<String> imageUrls;
}
