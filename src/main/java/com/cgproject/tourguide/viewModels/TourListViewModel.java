package com.cgproject.tourguide.viewModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TourListViewModel {
    private final ObservableList<String> tours;

    public TourListViewModel() {
        this.tours = FXCollections.observableArrayList(
                "Vienna City Tour",
                "Mountain Hike 01",
                "Prague Old Town Tour"
        );
    }

    public ObservableList<String> getTours() {
        return tours;
    }
}