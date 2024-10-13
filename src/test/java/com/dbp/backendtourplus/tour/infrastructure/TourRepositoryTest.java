package com.dbp.backendtourplus.tour.infrastructure;

import com.dbp.backendtourplus.AbstractContainerBaseTest;
import com.dbp.backendtourplus.tour.domain.Tour;
import com.dbp.backendtourplus.tourcategory.domain.TourCategory;
import com.dbp.backendtourplus.tourcategory.domain.TourCategoryStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TourRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Tour tour;

    @BeforeEach
    void setUp() {
        TourCategory tourCategory = new TourCategory();
        tourCategory.setName(TourCategoryStatus.NATURE);
        tourCategory.setDescription("A tour of nature.");
        entityManager.persist(tourCategory);

        tour = new Tour();
        tour.setTitle("City Tour");
        tour.setDescription("A fun tour of the city.");
        tour.setPrice(50.0);
        tour.setTourCategory(tourCategory);

        entityManager.persist(tour);
        entityManager.flush();
    }


    @Test
    public void testCreateTour() {
        Tour newTour = new Tour();
        newTour.setTitle("Beach Tour");
        newTour.setDescription("A relaxing day at the beach.");
        newTour.setPrice(75.0);

        TourCategory tourCategory = new TourCategory();
        tourCategory.setName(TourCategoryStatus.NATURE);
        entityManager.persist(tourCategory);
        newTour.setTourCategory(tour.getTourCategory());

        Tour savedTour = tourRepository.save(newTour);
        entityManager.flush();
        entityManager.clear();

        Optional<Tour> createdTour = tourRepository.findById(savedTour.getId());
        assertTrue(createdTour.isPresent());
        assertEquals(newTour.getTitle(), createdTour.get().getTitle());
    }


    @Test
    public void testFindById() {
        Optional<Tour> optionalTour = tourRepository.findById(tour.getId());
        assertTrue(optionalTour.isPresent(), "El tour no se encontró");

        Tour foundTourById = optionalTour.get();
        assertEquals(tour.getId(), foundTourById.getId());
    }

    @Test
    public void testDeleteById() {
        tourRepository.deleteById(tour.getId());
        Optional<Tour> optionalDeletedTour = tourRepository.findById(tour.getId());
        assertFalse(optionalDeletedTour.isPresent(), "El tour no se eliminó correctamente");
    }

}
