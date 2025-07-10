package com.cgproject.tourguide.viewModels;

import com.cgproject.tourguide.models.Tour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TourViewModelTest {
    private TourViewModel viewModel;
    private Tour tour;
    private static final Integer ID = 1;
    private static final String NAME = "Test Tour";
    private static final String DESCRIPTION = "Test Description";
    private static final String FROM = "Vienna";
    private static final String TO = "Salzburg";
    private static final String TRANSPORT = "Train";
    private static final double DISTANCE = 250.0;
    private static final double TIME = 2.5;
    private static final String ROUTE = "Via Linz";

    @BeforeEach
    void setUp() {
        tour = new Tour(ID, NAME, DESCRIPTION, FROM, TO, TRANSPORT, DISTANCE, TIME, ROUTE);
        viewModel = new TourViewModel(tour);
    }


    @Test
    void testToModel() {
        Tour convertedTour = viewModel.toModel();
        assertEquals(tour.getId(), convertedTour.getId());
        assertEquals(tour.getName(), convertedTour.getName());
        assertEquals(tour.getTourDescription(), convertedTour.getTourDescription());
        assertEquals(tour.getFrom(), convertedTour.getFrom());
        assertEquals(tour.getTo(), convertedTour.getTo());
        assertEquals(tour.getTransportType(), convertedTour.getTransportType());
        assertEquals(tour.getTourDistance(), convertedTour.getTourDistance());
        assertEquals(tour.getEstimatedTime(), convertedTour.getEstimatedTime());
        assertEquals(tour.getRouteInformation(), convertedTour.getRouteInformation());
    }

    @Test
    void testSetters() {
        String newName = "Updated Tour";
        viewModel.setName(newName);
        assertEquals(newName, viewModel.getName());
        assertEquals(newName, viewModel.nameProperty().get());

        String newDescription = "Updated Description";
        viewModel.setTourDescription(newDescription);
        assertEquals(newDescription, viewModel.getTourDescription());

        double newDistance = 300.0;
        viewModel.setTourDistance(newDistance);
        assertEquals(newDistance, viewModel.getTourDistance());
    }

    @Test
    void testConstructorWithNullTourId() {
        Tour tourWithNullId = new Tour(null, NAME, DESCRIPTION, FROM, TO, TRANSPORT, DISTANCE, TIME, ROUTE);
        TourViewModel viewModelWithNullId = new TourViewModel(tourWithNullId);
        assertEquals(0, viewModelWithNullId.getId());
    }
}