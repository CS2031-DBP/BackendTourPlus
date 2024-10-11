package com.dbp.backendtourplus.tourcategory.domain;

import com.dbp.backendtourplus.exceptions.ResourceNotFoundException;
import com.dbp.backendtourplus.tourcategory.infrastructure.TourCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TourCategoryService {

    private final TourCategoryRepository tourCategoryRepository;

    public List<TourCategory> findAll() {
        return tourCategoryRepository.findAll();
    }

    public Optional<TourCategory> findById(Long id) {
        return tourCategoryRepository.findById(id);
    }

    public TourCategory save(TourCategory tourCategory) {
        return tourCategoryRepository.save(tourCategory);
    }

    public TourCategory update(Long id, TourCategory tourCategoryDetails) {
        return tourCategoryRepository.findById(id)
                .map(existingCategory -> {
                    existingCategory.setName(tourCategoryDetails.getName());
                    existingCategory.setDescription(tourCategoryDetails.getDescription());
                    return tourCategoryRepository.save(existingCategory);
                }).orElseThrow(() -> new ResourceNotFoundException("Tour Category not found with id: " + id));
    }

    public void deleteById(Long id) {
        if (!tourCategoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tour Category not found with id: " + id);
        }
        tourCategoryRepository.deleteById(id);
    }
}
