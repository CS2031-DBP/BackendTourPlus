package com.dbp.backendtourplus.tourinstance.application;

import com.dbp.backendtourplus.tourinstance.domain.TourInstance;
import com.dbp.backendtourplus.tourinstance.dto.TourInstanceDto;
import com.dbp.backendtourplus.tourinstance.domain.TourInstanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tour-instances")
@RequiredArgsConstructor
public class TourInstanceController {

    private final TourInstanceService tourInstanceService;

    @GetMapping
    public List<TourInstance> getAllTourInstances() {
        return tourInstanceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourInstance> getTourInstanceById(@PathVariable Long id) {
        return ResponseEntity.of(tourInstanceService.findById(id));
    }

    @PostMapping
    public TourInstance createTourInstance(@RequestBody TourInstanceDto tourInstanceDto) {
        return tourInstanceService.save(tourInstanceDto);
    }

    @PutMapping("/{id}")
    public TourInstance updateTourInstance(@PathVariable Long id, @RequestBody TourInstanceDto tourInstanceDto) {
        return tourInstanceService.update(id, tourInstanceDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTourInstance(@PathVariable Long id) {
        tourInstanceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
