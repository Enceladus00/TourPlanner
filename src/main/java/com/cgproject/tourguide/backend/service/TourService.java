package com.cgproject.tourguide.backend.service;

import com.cgproject.tourguide.backend.entity.Tour;
import com.cgproject.tourguide.backend.repository.TourRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TourService {
    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    public Tour saveTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public void deleteTour(Long id) {
        if (!tourRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tour not found");
        }
        tourRepository.deleteById(id);
    }

    public Tour getTour(Long id) {
        return tourRepository.findById(id).orElse(null);
    }

    public Tour updateTour(Long id, Tour tour) {
        if (!tourRepository.existsById(id)) {
            throw new EntityNotFoundException("Tour not found with ID: " + id);
        }
        tour.setId(id);
        return tourRepository.save(tour);
    }
}
