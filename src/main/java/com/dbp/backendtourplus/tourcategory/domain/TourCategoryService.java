package com.dbp.backendtourplus.tourcategory.domain;

import com.dbp.backendtourplus.exceptions.ResourceNotFoundException;
import com.dbp.backendtourplus.tourcategory.infrastructure.TourCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourCategoryService {

    private final TourCategoryRepository tourCategoryRepository;

    public List<TourCategory> findAll() {
        return tourCategoryRepository.findAll();
    }

    public TourCategory findById(Long id) {
        return tourCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tour category not found with id " + id));
    }

    public TourCategory save(TourCategory tourCategory) {
        return tourCategoryRepository.save(tourCategory);
    }

    public TourCategory update(Long id, TourCategory tourCategoryDetails) {
        TourCategory tourCategory = findById(id);
        tourCategory.setName(tourCategoryDetails.getName());
        tourCategory.setDescription(tourCategoryDetails.getDescription());
        return tourCategoryRepository.save(tourCategory);
    }

    public void deleteById(Long id) {
        if (!tourCategoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tour category not found with id " + id);
        }
        tourCategoryRepository.deleteById(id);
    }
}