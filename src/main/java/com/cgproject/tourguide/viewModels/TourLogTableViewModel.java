package com.cgproject.tourguide.viewModels;
import com.cgproject.tourguide.models.TourLog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TourLogTableViewModel {
    private final ObservableList<TourLogViewModel> tourLogs =
            FXCollections.observableArrayList(
                    new TourLogViewModel(new TourLog(17.03, 12 ,"Comment 1", 9.30, 1.0, 1.0, 1.0), "Tour 1"),
                    new TourLogViewModel(new TourLog(21.03, 12 ,"Comment 2", 10.30, 2.0, 2.0, 2.0), "Tour 2")
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

    public ObservableList<TourLogViewModel> getTourLogsForParent(String tourName) {
        ObservableList<TourLogViewModel> filteredLogs = FXCollections.observableArrayList();
        for (TourLogViewModel tlvm : tourLogs) {
            if (tlvm.getParent().equals(tourName)) {
                filteredLogs.add(tlvm);
            }
        }
        return filteredLogs;
    }
}
