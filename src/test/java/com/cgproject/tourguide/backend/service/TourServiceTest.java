package com.cgproject.tourguide.backend.service;

import com.cgproject.tourguide.backend.entity.Tour;
import com.cgproject.tourguide.backend.repository.TourRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class TourServiceTest {
    @Test
    void testGetAllTours() {
        TourRepository repo = Mockito.mock(TourRepository.class);
        Mockito.when(repo.findAll()).thenReturn(Collections.emptyList());
        TourService service = new TourService(repo);
        assertEquals(0, service.getAllTours().size());
    }
}
