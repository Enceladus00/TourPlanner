package com.cgproject.tourguide.backend.service;

import com.cgproject.tourguide.backend.entity.Tour;
import com.cgproject.tourguide.backend.repository.TourRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TourService {
    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Tour> getAllTours() { return tourRepository.findAll(); }
    public Tour saveTour(Tour tour) { return tourRepository.save(tour); }
    public void deleteTour(Long id) { tourRepository.deleteById(id); }
    public Tour getTour(Long id) { return tourRepository.findById(id).orElse(null); }
    public Tour updateTour(Long id, Tour updatedTour) {
        return tourRepository.findById(id).map(existingTour -> {
            existingTour.setName(updatedTour.getName());
            existingTour.setDescription(updatedTour.getDescription());
            existingTour.setFromLocation(updatedTour.getFromLocation());
            existingTour.setToLocation(updatedTour.getToLocation());
            existingTour.setTransportType(updatedTour.getTransportType());
            existingTour.setDistance(updatedTour.getDistance());
            existingTour.setEstimatedTime(updatedTour.getEstimatedTime());
            existingTour.setMapImagePath(updatedTour.getMapImagePath());
            existingTour.setLogs(updatedTour.getLogs());
            return tourRepository.save(existingTour);
        }).orElse(null);
    }
}
