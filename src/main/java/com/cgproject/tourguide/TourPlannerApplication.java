package com.cgproject.tourguide;

import com.cgproject.tourguide.models.Tour;
import com.cgproject.tourguide.viewModels.TourViewModel;
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


    }

    public static void main(String[] args) {
        launch();
    }
}