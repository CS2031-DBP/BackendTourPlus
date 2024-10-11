package com.dbp.backendtourplus.tourcategory.dto;

import com.dbp.backendtourplus.tourcategory.domain.TourCategoryStatus;
import lombok.Data;

@Data
public class TourCategoryDto {
    private Long id;
    private TourCategoryStatus name;
    private String description;
}
