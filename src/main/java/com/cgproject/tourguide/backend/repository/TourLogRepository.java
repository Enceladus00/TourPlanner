package com.cgproject.tourguide.backend.repository;

import com.cgproject.tourguide.backend.entity.TourLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TourLogRepository extends JpaRepository<TourLog, Long> {
    List<TourLog> findByTourId(Long tourId);
}