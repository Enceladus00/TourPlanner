package com.cgproject.tourguide.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TourLogTest {
    private TourLog tourLog;
    private final double DATE = 20240315.0;
    private final double TIME = 1430.0;
    private final String COMMENT = "Test comment";
    private final double DIFFICULTY = 3.5;
    private final double TOTAL_DISTANCE = 10.5;
    private final double TOTAL_TIME = 2.5;
    private final double RATING = 4.0;
    private final Integer TOUR_ID = 1;

    @BeforeEach
    void setUp() {
        tourLog = new TourLog(DATE, TIME, COMMENT, DIFFICULTY, TOTAL_DISTANCE, TOTAL_TIME, RATING);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals(DATE, tourLog.getDate());
        assertEquals(TIME, tourLog.getTime());
        assertEquals(COMMENT, tourLog.getComment());
        assertEquals(DIFFICULTY, tourLog.getDifficulty());
        assertEquals(TOTAL_DISTANCE, tourLog.getTotalDistance());
        assertEquals(TOTAL_TIME, tourLog.getTotalTime());
        assertEquals(RATING, tourLog.getRating());
    }

    @Test
    void testSetDate() {
        double newDate = 20240316.0;
        tourLog.setDate(newDate);
        assertEquals(newDate, tourLog.getDate());
    }

    @Test
    void testSetTime() {
        double newTime = 1530.0;
        tourLog.setTime(newTime);
        assertEquals(newTime, tourLog.getTime());
    }

    @Test
    void testSetComment() {
        String newComment = "Updated comment";
        tourLog.setComment(newComment);
        assertEquals(newComment, tourLog.getComment());
    }

    @Test
    void testSetDifficulty() {
        double newDifficulty = 4.5;
        tourLog.setDifficulty(newDifficulty);
        assertEquals(newDifficulty, tourLog.getDifficulty());
    }

    @Test
    void testSetTotalDistance() {
        double newDistance = 15.5;
        tourLog.setTotalDistance(newDistance);
        assertEquals(newDistance, tourLog.getTotalDistance());
    }

    @Test
    void testSetTotalTime() {
        double newTotalTime = 3.5;
        tourLog.setTotalTime(newTotalTime);
        assertEquals(newTotalTime, tourLog.getTotalTime());
    }

    @Test
    void testSetRating() {
        double newRating = 4.5;
        tourLog.setRating(newRating);
        assertEquals(newRating, tourLog.getRating());
    }

    @Test
    void testSetTourId() {
        tourLog.setTourId(TOUR_ID);
        assertEquals(TOUR_ID, tourLog.getTourId());
    }
}