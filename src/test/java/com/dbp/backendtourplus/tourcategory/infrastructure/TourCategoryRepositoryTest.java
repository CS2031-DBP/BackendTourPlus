package com.dbp.backendtourplus.tourcategory.infrastructure;

import com.dbp.backendtourplus.AbstractContainerBaseTest;
import com.dbp.backendtourplus.tourcategory.domain.TourCategory;
import com.dbp.backendtourplus.tourcategory.domain.TourCategoryStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class TourCategoryRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private TourCategoryRepository tourCategoryRepository;

    private TourCategory tourCategory;

    @BeforeEach
    void setUp() {
        tourCategory = new TourCategory();
        tourCategory.setName("Adventure");
        tourCategory.setStatus(TourCategoryStatus.ADVENTURE);
    }

    @Test
    void testSaveAndFindTourCategory() {
        TourCategory savedTourCategory = tourCategoryRepository.save(tourCategory);

        TourCategory foundTourCategory = tourCategoryRepository.findById(savedTourCategory.getId()).orElse(null);
        assertThat(foundTourCategory).isNotNull();
        assertThat(foundTourCategory.getName()).isEqualTo("Adventure");
        assertThat(foundTourCategory.getStatus()).isEqualTo(TourCategoryStatus.ADVENTURE);
    }
}
