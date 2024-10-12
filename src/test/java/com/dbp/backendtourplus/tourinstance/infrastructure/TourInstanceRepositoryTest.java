package com.dbp.backendtourplus.tourinstance.infrastructure;

import com.dbp.backendtourplus.AbstractContainerBaseTest;
import com.dbp.backendtourplus.tourinstance.domain.TourInstance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class TourInstanceRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private TourInstanceRepository tourInstanceRepository;

    private TourInstance tourInstance;

    @BeforeEach
    void setUp() {
        tourInstance = new TourInstance();
        tourInstance.setStartTime(LocalDateTime.of(2024, 10, 1, 10, 0));
        tourInstance.setEndTime(LocalDateTime.of(2024, 10, 1, 12, 0));
    }

    @Test
    void testSaveAndFindTourInstance() {
        TourInstance savedTourInstance = tourInstanceRepository.save(tourInstance);

        TourInstance foundTourInstance = tourInstanceRepository.findById(savedTourInstance.getId()).orElse(null);
        assertThat(foundTourInstance).isNotNull();
        assertThat(foundTourInstance.getStartTime()).isEqualTo(tourInstance.getStartTime());
        assertThat(foundTourInstance.getEndTime()).isEqualTo(tourInstance.getEndTime());
    }
}
