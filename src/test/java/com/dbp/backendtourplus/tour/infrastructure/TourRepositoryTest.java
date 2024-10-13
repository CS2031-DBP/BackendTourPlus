package com.dbp.backendtourplus.tour.infrastructure;

import com.dbp.backendtourplus.AbstractContainerBaseTest;
import com.dbp.backendtourplus.company.infrastructure.CompanyRepository;
import com.dbp.backendtourplus.tour.domain.Tour;
import com.dbp.backendtourplus.company.domain.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class TourRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private CompanyRepository companyRepository;

    private Company company;
    private Tour tour;

    @BeforeEach
    void setUp() {
        company = new Company();
        company.setName("Adventure Tours");
        company.setRuc("987654321");
        company.setEmail("adventure@example.com");
        companyRepository.save(company);

        tour = new Tour();
        tour.setTitle("Mountain Hiking");
        tour.setDescription("A thrilling mountain hike.");
        tour.setCompany(company);
    }

    @Test
    void testSaveAndFindTour() {
        Tour savedTour = tourRepository.save(tour);
        Tour foundTour = tourRepository.findById(savedTour.getId()).orElse(null);

        assertThat(foundTour).isNotNull();
        assertThat(foundTour.getTitle()).isEqualTo("Mountain Hiking");
        assertThat(foundTour.getCompany().getName()).isEqualTo("Adventure Tours");
    }
}
