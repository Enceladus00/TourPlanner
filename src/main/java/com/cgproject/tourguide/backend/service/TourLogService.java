package com.cgproject.tourguide.backend.service;

import com.cgproject.tourguide.backend.entity.TourLog;
import com.cgproject.tourguide.backend.repository.TourLogRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TourLogService {
    private final TourLogRepository logRepository;

    public TourLogService(TourLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<TourLog> getLogsByTour(Long tourId) { return logRepository.findByTourId(tourId); }
    public TourLog saveLog(TourLog log) { return logRepository.save(log); }
    public void deleteLog(Long id) { logRepository.deleteById(id); }
}
