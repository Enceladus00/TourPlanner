package com.cgproject.tourguide.viewModels;
import com.cgproject.tourguide.models.TourLog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TourLogTableViewModel {
    private final ObservableList<TourLogViewModel> tourLogs =
            FXCollections.observableArrayList(
                    new TourLogViewModel(new TourLog(9.30, "Comment 1", 1.0, 1.0, 1.0, 1.0)),
                    new TourLogViewModel(new TourLog(10.30, "Comment 2", 2.0, 2.0, 2.0, 2.0))
            );

    public ObservableList<TourLogViewModel> getTourLogs() {
        return tourLogs;
    }
    public void addTourLog(TourLogViewModel tlvm){
        tourLogs.add(tlvm);
    }
    public void editTourLog(TourLogViewModel tlvm){
        System.out.println("Edit TourLog");
    }
    public void removeTourLog(TourLogViewModel tlvm){
        tourLogs.remove(tlvm);
    }
}
