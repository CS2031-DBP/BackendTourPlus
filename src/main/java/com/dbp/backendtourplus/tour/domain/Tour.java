package com.dbp.backendtourplus.tour.domain;

import com.dbp.backendtourplus.company.domain.Company;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    // Other attributes and methods
}
