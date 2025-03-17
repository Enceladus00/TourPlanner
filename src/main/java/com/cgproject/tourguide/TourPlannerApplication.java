package com.cgproject.tourguide;

import com.cgproject.tourguide.viewModels.TourListViewModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class TourPlannerApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TourPlannerApplication.class.getResource("tourPlannerHome.fxml"));
        primaryStage.setTitle("HomeDemo");
        primaryStage.setScene(new Scene(fxmlLoader.load(), 600, 450));
        primaryStage.show();

        // Get the ListView from the FXML
        ListView<String> listView = (ListView<String>) primaryStage.getScene().lookup("#tourListView");

        // Create an instance of TourListViewModel and bind it to the ListView
        TourListViewModel tourListViewModel = new TourListViewModel();
        listView.setItems(tourListViewModel.getTours());
    }

    public static void main(String[] args) {
        launch();
    }
}