package com.dbp.backendtourplus.tour.domain;

import com.dbp.backendtourplus.location.domain.Location;
import com.dbp.backendtourplus.company.domain.Company;
import com.dbp.backendtourplus.tourcategory.domain.TourCategory;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "tours")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Double price;

    @ManyToOne
    private TourCategory tourCategory;

    @ElementCollection
    private Map<String, String> frequentQuestions; 

    @ElementCollection
    private List<String> imageUrls;

    @ManyToOne
    private Location location;

    @ManyToOne
    private Company company;
}
