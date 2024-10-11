package com.dbp.backendtourplus.tourcategory.application;

import com.dbp.backendtourplus.tourcategory.domain.TourCategory;
import com.dbp.backendtourplus.tourcategory.domain.TourCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tour-categories")
public class TourCategoryController {

    private final TourCategoryService tourCategoryService;

    public TourCategoryController(TourCategoryService tourCategoryService) {
        this.tourCategoryService = tourCategoryService;
    }

    @GetMapping
    public List<TourCategory> getAllTourCategories() {
        return tourCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourCategory> getTourCategoryById(@PathVariable Long id) {
        TourCategory tourCategory = tourCategoryService.findById(id);
        return ResponseEntity.ok(tourCategory);
    }

    @PostMapping
    public TourCategory createTourCategory(@RequestBody TourCategory tourCategory) {
        return tourCategoryService.save(tourCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TourCategory> updateTourCategory(@PathVariable Long id, @RequestBody TourCategory tourCategory) {
        TourCategory updatedTourCategory = tourCategoryService.update(id, tourCategory);
        return ResponseEntity.ok(updatedTourCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTourCategory(@PathVariable Long id) {
        tourCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
