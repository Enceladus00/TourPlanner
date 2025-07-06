package com.cgproject.tourguide.backend.controller;

import com.cgproject.tourguide.backend.entity.TourLog;
import com.cgproject.tourguide.backend.service.TourLogService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tourlogs")
public class TourLogController {
    private final TourLogService service;

    public TourLogController(TourLogService service) {
        this.service = service;
    }

    @GetMapping("/tour/{tourId}")
    public List<TourLog> getLogsByTour(@PathVariable Long tourId) {
        return service.getLogsByTour(tourId);
    }

    @PostMapping
    public TourLog saveLog(@RequestBody TourLog log) {
        return service.saveLog(log);
    }

    @DeleteMapping("/{id}")
    public void deleteLog(@PathVariable Long id) {
        service.deleteLog(id);
    }
}
