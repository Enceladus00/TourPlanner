package com.cgproject.tourguide.viewModels;

import com.cgproject.tourguide.models.TourLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TourLogViewModelTest {
    private TourLogViewModel viewModel;
    private TourLog tourLog;
    private static final double TEST_DATE = 20240310;
    private static final double TEST_TIME = 1430;
    private static final String TEST_COMMENT = "Test comment";
    private static final double TEST_DIFFICULTY = 3.5;
    private static final double TEST_DISTANCE = 15.5;
    private static final double TEST_TOTAL_TIME = 120;
    private static final double TEST_RATING = 4.5;
    private static final String TEST_PARENT = "Test Parent";

    @BeforeEach
    void setUp() {
        tourLog = new TourLog(TEST_DATE, TEST_TIME, TEST_COMMENT, TEST_DIFFICULTY,
                TEST_DISTANCE, TEST_TOTAL_TIME, TEST_RATING);
        viewModel = new TourLogViewModel(tourLog, TEST_PARENT);
    }

    @Test
    void testProperties() {
        assertEquals(TEST_DATE, viewModel.dateProperty().get());
        assertEquals(TEST_TIME, viewModel.timeProperty().get());
        assertEquals(TEST_COMMENT, viewModel.commentProperty().get());
        assertEquals(TEST_DIFFICULTY, viewModel.difficultyProperty().get());
        assertEquals(TEST_DISTANCE, viewModel.totalDistanceProperty().get());
        assertEquals(TEST_TOTAL_TIME, viewModel.totalTimeProperty().get());
        assertEquals(TEST_RATING, viewModel.ratingProperty().get());
        assertEquals(TEST_PARENT, viewModel.parentProperty().get());
    }

    @Test
    void testDefaultConstructor() {
        TourLogViewModel defaultViewModel = new TourLogViewModel(tourLog);
        assertEquals("", defaultViewModel.parentProperty().get());
    }

    @Test
    void testGetters() {
        assertEquals(TEST_COMMENT, viewModel.getComment());
        assertEquals(TEST_RATING, viewModel.getRating());
        assertEquals(TEST_PARENT, viewModel.getParent());
    }

    @Test
    void testToTourLog() {
        TourLog converted = viewModel.toTourLog();

        assertEquals(TEST_DATE, converted.getDate());
        assertEquals(TEST_TIME, converted.getTime());
        assertEquals(TEST_COMMENT, converted.getComment());
        assertEquals(TEST_DIFFICULTY, converted.getDifficulty());
        assertEquals(TEST_DISTANCE, converted.getTotalDistance());
        assertEquals(TEST_TOTAL_TIME, converted.getTotalTime());
        assertEquals(TEST_RATING, converted.getRating());
    }
}