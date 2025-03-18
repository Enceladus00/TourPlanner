package com.cgproject.tourguide.viewModels;
import com.cgproject.tourguide.models.Tour;
import javafx.collections.FXCollections;
import com.cgproject.tourguide.viewModels.TourViewModel;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TourListViewModel {
    private final ObservableList<TourViewModel> tours =
                FXCollections.observableArrayList(
                        new TourViewModel(new Tour("Tour 1", "Tour 1 Description", "From 1", "To 1", "Transport 1", 1.0, 1.0, "Route 1")),
                        new TourViewModel(new Tour("Tour 2", "Tour 2 Description", "From 2", "To 2", "Transport 2", 2.0, 2.0, "Route 2"))
                );


    public ObservableList<TourViewModel> getTours() {
        return tours;
    }

    public void addTour(TourViewModel tvm){
        tours.add(tvm);
    }

    public void editTour(TourViewModel tvm) {
        for (TourViewModel tour : tours) {
            if (tour.nameProperty().get().equals(tvm.nameProperty().get())){
                tour.descriptionProperty().set(tvm.descriptionProperty().get());
                tour.fromProperty().set(tvm.fromProperty().get());
                tour.toProperty().set(tvm.toProperty().get());
                tour.transportTypeProperty().set(tvm.transportTypeProperty().get());
                tour.tourDistanceProperty().set(tvm.tourDistanceProperty().get());
                tour.estimatedTimeProperty().set(tvm.estimatedTimeProperty().get());
                tour.routeInformationProperty().set(tvm.routeInformationProperty().get());
            }
        }
    }

    public void deleteTour(int index) {
        if (index >= 0 && index < tours.size()) {
            tours.remove(index);
        }
    }
}