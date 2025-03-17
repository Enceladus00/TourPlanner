package com.cgproject.tourguide.viewModels;
import com.cgproject.tourguide.models.Tour;
import javafx.beans.property.*;

public class TourViewModel {
    private final StringProperty name;
    private final StringProperty tourDescription;
    private final StringProperty from;
    private final StringProperty to;
    private final StringProperty transportType;
    private final DoubleProperty tourDistance;
    private final DoubleProperty estimatedTime;
    private final StringProperty routeInformation;

    public TourViewModel(Tour tour) {
        this.name = new SimpleStringProperty(tour.getName());
        this.tourDescription = new SimpleStringProperty(tour.getTourDescription());
        this.from = new SimpleStringProperty(tour.getFrom());
        this.to = new SimpleStringProperty(tour.getTo());
        this.transportType = new SimpleStringProperty(tour.getTransportType());
        this.tourDistance = new SimpleDoubleProperty(tour.getTourDistance());
        this.estimatedTime = new SimpleDoubleProperty(tour.getEstimatedTime());
        this.routeInformation = new SimpleStringProperty(tour.getRouteInformation());
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty tourDescriptionProperty() {
        return tourDescription;
    }

    public StringProperty fromProperty() {
        return from;
    }

    public StringProperty toProperty() {
        return to;
    }

    public StringProperty transportTypeProperty() {
        return transportType;
    }

    public DoubleProperty tourDistanceProperty() {
        return tourDistance;
    }

    public DoubleProperty estimatedTimeProperty() {
        return estimatedTime;
    }

    public StringProperty routeInformationProperty() {
        return routeInformation;
    }
}