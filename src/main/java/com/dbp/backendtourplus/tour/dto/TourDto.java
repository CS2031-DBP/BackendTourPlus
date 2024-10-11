package com.dbp.backendtourplus.tour.dto;

import lombok.Data;

import java.util.List;

@Data
public class TourDto {
    private String title;
    private String description;
    private Double price;
    private Long tourCategoryId;
    private List<String> imageUrls;
}