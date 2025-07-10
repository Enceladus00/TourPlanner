package com.cgproject.tourguide.backend.controller;

import com.cgproject.tourguide.backend.entity.Tour;
import com.cgproject.tourguide.backend.service.TourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/tours")
@CrossOrigin(origins = "http://localhost:8080")
public class TourController {
    private static final Logger logger = LogManager.getLogger(TourController.class);
    private final TourService service;

    public TourController(TourService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tour> getAllTours() {
        logger.info("Fetching all tours");
        return service.getAllTours();
    }

    @GetMapping("/{id}")
    public Tour getTour(@PathVariable Long id) {
        logger.debug("Fetching tour with ID: {}", id);
        return service.getTour(id);
    }

    @PostMapping
    public Tour saveTour(@RequestBody Tour tour) {
        logger.info("Saving new tour: {}", tour);
        return service.saveTour(tour);
    }

    @PutMapping("/{id}")
    public Tour updateTour(@PathVariable("id") Long id, @RequestBody Tour tour) {
        logger.info("Updating tour with ID: {}", id);
        return service.updateTour(id, tour);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable(name = "id") Long id) {
        logger.warn("Deleting tour with ID: {}", id);
        service.deleteTour(id);
        return ResponseEntity.noContent().build();
    }
}
