package com.dbp.backendtourplus.tourinstance.domain;

import com.dbp.backendtourplus.exceptions.ResourceNotFoundException;
import com.dbp.backendtourplus.tourinstance.dto.TourInstanceDto;
import com.dbp.backendtourplus.tourinstance.infrastructure.TourInstanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TourInstanceService {

    private final TourInstanceRepository tourInstanceRepository;

    public List<TourInstance> findAll() {
        return tourInstanceRepository.findAll();
    }

    public Optional<TourInstance> findById(Long id) {
        return tourInstanceRepository.findById(id);
    }

    public TourInstance save(TourInstanceDto tourInstanceDto) {
        TourInstance tourInstance = new TourInstance();
        tourInstance.setLanguageStatus(tourInstanceDto.getLanguageStatus());
        tourInstance.setTourDuration(tourInstanceDto.getTourDuration());
        tourInstance.setStartDate(tourInstanceDto.getStartDate());
        tourInstance.setEndDate(tourInstanceDto.getEndDate());
        return tourInstanceRepository.save(tourInstance);
    }

    public TourInstance update(Long id, TourInstanceDto tourInstanceDto) {
        TourInstance tourInstance = tourInstanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TourInstance not found with id " + id));

        tourInstance.setLanguageStatus(tourInstanceDto.getLanguageStatus());
        tourInstance.setTourDuration(tourInstanceDto.getTourDuration());
        tourInstance.setStartDate(tourInstanceDto.getStartDate());
        tourInstance.setEndDate(tourInstanceDto.getEndDate());
        return tourInstanceRepository.save(tourInstance);
    }

    public void deleteById(Long id) {
        if (!tourInstanceRepository.existsById(id)) {
            throw new ResourceNotFoundException("TourInstance not found with id " + id);
        }
        tourInstanceRepository.deleteById(id);
    }
}
