package com.dbp.backendtourplus.tourinstance.dto;

import com.dbp.backendtourplus.tourinstance.domain.LanguageStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TourInstanceDto {
    private Long id;
    private LanguageStatus languageStatus;
    private Double tourDuration;
    private Long tourId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
