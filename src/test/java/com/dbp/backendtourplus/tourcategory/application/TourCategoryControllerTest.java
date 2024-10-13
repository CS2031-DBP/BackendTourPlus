package com.dbp.backendtourplus.tourcategory.application;

import com.dbp.backendtourplus.exceptions.ResourceNotFoundException;
import com.dbp.backendtourplus.tourcategory.domain.TourCategory;
import com.dbp.backendtourplus.tourcategory.domain.TourCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TourCategoryControllerTest {

    private TourCategoryController tourCategoryController;
    private TourCategoryService tourCategoryService;

    @BeforeEach
    void setUp() {
        tourCategoryService = Mockito.mock(TourCategoryService.class);
        tourCategoryController = new TourCategoryController(tourCategoryService);
    }

    @Test
    void testGetAllTourCategories() {
        TourCategory category1 = new TourCategory();
        TourCategory category2 = new TourCategory();
        when(tourCategoryService.findAll()).thenReturn(Arrays.asList(category1, category2));

        ResponseEntity<List<TourCategory>> response = tourCategoryController.getAllTourCategories();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, Objects.requireNonNull(response.getBody()).size());
        verify(tourCategoryService, times(1)).findAll();
    }

    @Test
    void testGetTourCategoryById_Found() {
        Long categoryId = 1L;
        TourCategory category = new TourCategory();
        when(tourCategoryService.findById(categoryId)).thenReturn(Optional.of(category));

        ResponseEntity<TourCategory> response = tourCategoryController.getTourCategoryById(categoryId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(category, response.getBody());
    }

    @Test
    void testGetTourCategoryById_NotFound() {
        Long categoryId = 1L;
        when(tourCategoryService.findById(categoryId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> tourCategoryController.getTourCategoryById(categoryId));
    }

    @Test
    void testCreateTourCategory() {
        TourCategory tourCategory = new TourCategory();
        when(tourCategoryService.save(tourCategory)).thenReturn(tourCategory);

        ResponseEntity<TourCategory> response = tourCategoryController.createTourCategory(tourCategory);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tourCategory, response.getBody());
        verify(tourCategoryService, times(1)).save(tourCategory);
    }

    @Test
    void testUpdateTourCategory() {
        Long categoryId = 1L;
        TourCategory tourCategory = new TourCategory();
        when(tourCategoryService.update(categoryId, tourCategory)).thenReturn(tourCategory);

        ResponseEntity<TourCategory> response = tourCategoryController.updateTourCategory(categoryId, tourCategory);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tourCategory, response.getBody());
        verify(tourCategoryService, times(1)).update(categoryId, tourCategory);
    }

    @Test
    void testDeleteTourCategory() {
        Long categoryId = 1L;
        doNothing().when(tourCategoryService).deleteById(categoryId);

        ResponseEntity<Void> response = tourCategoryController.deleteTourCategory(categoryId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(tourCategoryService, times(1)).deleteById(categoryId);
    }
}
