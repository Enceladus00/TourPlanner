package com.cgproject.tourguide.backend.repository;

import com.cgproject.tourguide.backend.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {
}
