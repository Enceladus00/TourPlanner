package com.cgproject.tourguide.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TourTest {
    private Tour tour;
    private static final String NAME = "Vienna Tour";
    private static final String DESCRIPTION = "A beautiful tour through Vienna";
    private static final String FROM = "Stephansplatz";
    private static final String TO = "Schönbrunn";
    private static final String TRANSPORT = "Public Transport";
    private static final double DISTANCE = 5.5;
    private static final double TIME = 1.5;
    private static final String ROUTE = "Take U1 to Karlsplatz, then U4 to Schönbrunn";

    @BeforeEach
    void setUp() {
        tour = new Tour(NAME, DESCRIPTION, FROM, TO, TRANSPORT, DISTANCE, TIME, ROUTE);
    }


    @Test
    void testSettersAndGetters() {
        // Test setters
        String newName = "Updated Tour";
        tour.setName(newName);
        assertEquals(newName, tour.getName());

        String newDescription = "Updated Description";
        tour.setTourDescription(newDescription);
        assertEquals(newDescription, tour.getTourDescription());

        String newFrom = "New Start";
        tour.setFrom(newFrom);
        assertEquals(newFrom, tour.getFrom());

        String newTo = "New End";
        tour.setTo(newTo);
        assertEquals(newTo, tour.getTo());

        String newTransport = "Bicycle";
        tour.setTransportType(newTransport);
        assertEquals(newTransport, tour.getTransportType());

        double newDistance = 10.0;
        tour.setTourDistance(newDistance);
        assertEquals(newDistance, tour.getTourDistance());

        double newTime = 2.0;
        tour.setEstimatedTime(newTime);
        assertEquals(newTime, tour.getEstimatedTime());

        String newRoute = "Updated Route";
        tour.setRouteInformation(newRoute);
        assertEquals(newRoute, tour.getRouteInformation());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create an identical tour
        Tour identicalTour = new Tour(NAME, DESCRIPTION, FROM, TO, TRANSPORT, DISTANCE, TIME, ROUTE);

        // Test equality
        assertEquals(tour, identicalTour);
        assertEquals(tour.hashCode(), identicalTour.hashCode());

        // Test inequality
        Tour differentTour = new Tour("Different Tour", DESCRIPTION, FROM, TO, TRANSPORT, DISTANCE, TIME, ROUTE);
        assertNotEquals(tour, differentTour);
        assertNotEquals(tour.hashCode(), differentTour.hashCode());
    }

    @Test
    void testNullValues() {
        Tour tourWithNulls = new Tour(null, null, null, null, null, 0.0, 0.0, null);
        assertNotNull(tourWithNulls);
        assertNull(tourWithNulls.getName());
        assertNull(tourWithNulls.getTourDescription());
        assertNull(tourWithNulls.getFrom());
        assertNull(tourWithNulls.getTo());
        assertNull(tourWithNulls.getTransportType());
        assertEquals(0.0, tourWithNulls.getTourDistance());
        assertEquals(0.0, tourWithNulls.getEstimatedTime());
        assertNull(tourWithNulls.getRouteInformation());
    }

    @Test
    void testToString() {
        String expectedString = String.format("Tour[name='%s', from='%s', to='%s']", NAME, FROM, TO);
        assertEquals(expectedString, tour.toString());
    }

    @Test
    void testValidation() {
        // Test empty name
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Tour("", DESCRIPTION, FROM, TO, TRANSPORT, DISTANCE, TIME, ROUTE)
        );
        assertEquals("Tour name cannot be empty", exception.getMessage());

        // Test negative distance
        exception = assertThrows(IllegalArgumentException.class, () ->
                new Tour(NAME, DESCRIPTION, FROM, TO, TRANSPORT, -1.0, TIME, ROUTE)
        );
        assertEquals("Tour distance cannot be negative", exception.getMessage());

        // Test negative time
        exception = assertThrows(IllegalArgumentException.class, () ->
                new Tour(NAME, DESCRIPTION, FROM, TO, TRANSPORT, DISTANCE, -1.0, ROUTE)
        );
        assertEquals("Estimated time cannot be negative", exception.getMessage());
    }
}