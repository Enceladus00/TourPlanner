package com.cgproject.tourguide.viewModels;
import com.cgproject.tourguide.models.Tour;
import com.cgproject.tourguide.models.TourLog;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TourViewModel {
    private final StringProperty name;
    private final StringProperty tourDescription;
    private final StringProperty from;
    private final StringProperty to;
    private final StringProperty transportType;
    private final DoubleProperty tourDistance;
    private final DoubleProperty estimatedTime;
    private final StringProperty routeInformation;
    private final ObservableList<TourLogViewModel> tourLogViewModels;



    public String getName() {
        return name.get();
    }
    public String getTourDescription() {
        return tourDescription.get();
    }

    public String getFrom() {
        return from.get();
    }

    public String getTo() {
        return to.get();
    }

    public String getTransportType() {
        return transportType.get();
    }

    public double getTourDistance() {
        return tourDistance.get();
    }

    public double getEstimatedTime() {
        return estimatedTime.get();
    }

    public String getRouteInformation() {
        return routeInformation.get();
    }
    public TourViewModel(Tour tour) {
        this.name = new SimpleStringProperty(tour.getName());
        this.tourDescription = new SimpleStringProperty(tour.getTourDescription());
        this.from = new SimpleStringProperty(tour.getFrom());
        this.to = new SimpleStringProperty(tour.getTo());
        this.transportType = new SimpleStringProperty(tour.getTransportType());
        this.tourDistance = new SimpleDoubleProperty(tour.getTourDistance());
        this.estimatedTime = new SimpleDoubleProperty(tour.getEstimatedTime());
        this.routeInformation = new SimpleStringProperty(tour.getRouteInformation());
        this.tourLogViewModels = FXCollections.observableArrayList();
        for (TourLog tourLog : tour.getTourLogs()) {
            this.tourLogViewModels.add(new TourLogViewModel(tourLog));
        }

    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty descriptionProperty() {
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
    public ObservableList<TourLogViewModel> getTourLogViewModels() {
        return tourLogViewModels;
    }
}