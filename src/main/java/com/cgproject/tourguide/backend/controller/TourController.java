package com.cgproject.tourguide.backend.controller;

import com.cgproject.tourguide.backend.entity.Tour;
import com.cgproject.tourguide.backend.service.TourService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourController {
    private final TourService service;

    public TourController(TourService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tour> getAllTours() { return service.getAllTours(); }

    @GetMapping("/{id}")
    public Tour getTour(@PathVariable Long id) { return service.getTour(id); }

    @PostMapping
    public Tour saveTour(@RequestBody Tour tour) { return service.saveTour(tour); }

    @DeleteMapping("/{id}")
    public void deleteTour(@PathVariable Long id) { service.deleteTour(id); }
}
