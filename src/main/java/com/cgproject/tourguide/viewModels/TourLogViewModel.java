package com.cgproject.tourguide.viewModels;

import com.cgproject.tourguide.models.TourLog;
import javafx.beans.property.*;

import java.time.LocalDateTime;

public class TourLogViewModel {
    private final DoubleProperty dateTime;
    private final StringProperty comment;
    private final DoubleProperty difficulty;
    private final DoubleProperty totalDistance;
    private final DoubleProperty totalTime;
    private final DoubleProperty rating;

    public TourLogViewModel(TourLog tourLog) {
        this.dateTime = new SimpleDoubleProperty(tourLog.getDateTime());
        this.comment = new SimpleStringProperty(tourLog.getComment());
        this.difficulty = new SimpleDoubleProperty(tourLog.getDifficulty());
        this.totalDistance = new SimpleDoubleProperty(tourLog.getTotalDistance());
        this.totalTime = new SimpleDoubleProperty(tourLog.getTotalTime());
        this.rating = new SimpleDoubleProperty(tourLog.getRating());
    }

    // Getters for properties
    public DoubleProperty dateTimeProperty() {
        return dateTime;
    }

    public StringProperty commentProperty() {
        return comment;
    }

    public DoubleProperty difficultyProperty() {
        return difficulty;
    }

    public DoubleProperty totalDistanceProperty() {
        return totalDistance;
    }

    public DoubleProperty totalTimeProperty() {
        return totalTime;
    }

    public DoubleProperty ratingProperty() {
        return rating;
    }
}