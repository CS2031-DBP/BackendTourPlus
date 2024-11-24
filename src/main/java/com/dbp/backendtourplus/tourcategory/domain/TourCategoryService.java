package com.dbp.backendtourplus.tourcategory.domain;

import com.dbp.backendtourplus.exceptions.ResourceNotFoundException;
import com.dbp.backendtourplus.tourcategory.dto.TourCategoryDto;
import com.dbp.backendtourplus.tourcategory.infrastructure.TourCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TourCategoryService {

    private final TourCategoryRepository tourCategoryRepository;

    public List<TourCategory> findAll() {
        return tourCategoryRepository.findAll();
    }

    public Optional<TourCategory> findById(Long id) {
        return tourCategoryRepository.findById(id);
    }

    public TourCategory save(TourCategoryDto tourCategoryDto) {
        TourCategory tourCategory = new TourCategory();
        tourCategory.setName(tourCategoryDto.getName());
        tourCategory.setDescription(tourCategoryDto.getDescription());
        return tourCategoryRepository.save(tourCategory);
    }

    public TourCategory update(Long id, TourCategoryDto tourCategoryDto) {
        TourCategory tourCategory = tourCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tour Category not found with id: " + id));
        tourCategory.setName(tourCategoryDto.getName());
        tourCategory.setDescription(tourCategoryDto.getDescription());
        return tourCategoryRepository.save(tourCategory);
    }

    public void deleteById(Long id) {
        tourCategoryRepository.deleteById(id);
    }
}
