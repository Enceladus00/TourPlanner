package com.cgproject.tourguide.viewModels;
import com.cgproject.tourguide.models.TourLog;
import javafx.beans.property.*;

public class TourLogViewModel {
    private final DoubleProperty date;
    private final DoubleProperty time;
    private final StringProperty comment;
    private final DoubleProperty difficulty;
    private final DoubleProperty totalDistance;
    private final DoubleProperty totalTime;
    private final DoubleProperty rating;
    private final StringProperty parent;

    public TourLogViewModel(TourLog tourLog, String parent) {
        this.date = new SimpleDoubleProperty(tourLog.getDate());
        this.time = new SimpleDoubleProperty(tourLog.getTime());
        this.comment = new SimpleStringProperty(tourLog.getComment());
        this.difficulty = new SimpleDoubleProperty(tourLog.getDifficulty());
        this.totalDistance = new SimpleDoubleProperty(tourLog.getTotalDistance());
        this.totalTime = new SimpleDoubleProperty(tourLog.getTotalTime());
        this.rating = new SimpleDoubleProperty(tourLog.getRating());
        this.parent = new SimpleStringProperty(parent);
    }

    public TourLogViewModel(TourLog tourLog) {
        this(tourLog, "");
    }

    // Getters for properties
    public DoubleProperty dateProperty() {
        return date;
    }

    public DoubleProperty timeProperty() {
        return time;
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

    public StringProperty parentProperty() {
        return parent;
    }

    // getters for table view binding
    public String getComment() {
        return comment.get();
    }

    public double getRating() {
        return rating.get();
    }

    public String getParent() {
        return parent.get();
    }

    public TourLog toTourLog() {
        TourLog log = new TourLog(
                date.get(),
                time.get(),
                comment.get(),
                difficulty.get(),
                totalDistance.get(),
                totalTime.get(),
                rating.get()
        );
        return log;
    }


}
