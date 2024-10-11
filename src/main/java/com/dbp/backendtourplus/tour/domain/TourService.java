package com.dbp.backendtourplus.tour.domain;

import com.dbp.backendtourplus.exceptions.ResourceNotFoundException;
import com.dbp.backendtourplus.tour.dto.TourDto;
import com.dbp.backendtourplus.tour.infrastructure.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourService {

    private final TourRepository tourRepository;

    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    public Tour findById(Long id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tour not found with id " + id));
    }

    public Tour save(TourDto tourDto) {
        Tour tour = new Tour();
        tour.setTitle(tourDto.getTitle());
        tour.setDescription(tourDto.getDescription());
        tour.setPrice(tourDto.getPrice());
        tour.setImageUrls(tourDto.getImageUrls());
        return tourRepository.save(tour);
    }

    public Tour updateTour(Long id, TourDto tourDto) {
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tour not found with id " + id));
        tour.setTitle(tourDto.getTitle());
        tour.setDescription(tourDto.getDescription());
        tour.setPrice(tourDto.getPrice());
        tour.setImageUrls(tourDto.getImageUrls());
        return tourRepository.save(tour);
    }

    public void deleteById(Long id) {
        if (!tourRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tour not found with id " + id);
        }
        tourRepository.deleteById(id);
    }
}
