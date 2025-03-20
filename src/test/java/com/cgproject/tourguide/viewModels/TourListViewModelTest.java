package com.cgproject.tourguide.viewModels;

import com.cgproject.tourguide.models.Tour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TourListViewModelTest {

    private TourListViewModel viewModel;

    @BeforeEach
    void setUp() {
        viewModel = new TourListViewModel();
        viewModel.getTours().clear(); // Ensure it's empty before each test
    }

    @Test
    void testAddTour() {
        Tour tour = new Tour("Test Tour", "Description", "Start", "End", "Car", 100.0, 2.0, "Route Info");
        TourViewModel tourViewModel = new TourViewModel(tour);

        int initialSize = viewModel.getTours().size();
        viewModel.addTour(tourViewModel);
        assertEquals(initialSize + 1, viewModel.getTours().size());
    }

    @Test
    void testRemoveTour() {
        Tour tour = new Tour("To be deleted", "Desc", "From", "To", "Train", 50.0, 1.5, "Info");
        TourViewModel tourViewModel = new TourViewModel(tour);

        viewModel.addTour(tourViewModel);
        int sizeAfterAdd = viewModel.getTours().size();
        viewModel.removeTour(tourViewModel);
        assertEquals(sizeAfterAdd - 1, viewModel.getTours().size());
    }

    @Test
    void testEmptyList() {
        assertTrue(viewModel.getTours().isEmpty());
    }

    @Test
    void testGetToursReturnsCorrectSize() {
        Tour tour1 = new Tour("Tour 1", "Desc", "A", "B", "Bike", 30.0, 1.0, "Info");
        Tour tour2 = new Tour("Tour 2", "Desc", "C", "D", "Walk", 5.0, 0.5, "Info");

        viewModel.addTour(new TourViewModel(tour1));
        viewModel.addTour(new TourViewModel(tour2));

        assertEquals(2, viewModel.getTours().size());
    }

    @Test
    void testTourNamesAreUnique() {
        Tour tour1 = new Tour("Unique Tour", "Desc", "X", "Y", "Bus", 60.0, 2.5, "Info");
        Tour tour2 = new Tour("Unique Tour", "Desc", "X", "Y", "Bus", 60.0, 2.5, "Info");

        viewModel.addTour(new TourViewModel(tour1));
        viewModel.addTour(new TourViewModel(tour2));

        long uniqueNamesCount = viewModel.getTours().stream()
                .map(TourViewModel::getName)
                .distinct()
                .count();

        assertEquals(1, uniqueNamesCount); // Ensure names are not duplicated
    }
}
