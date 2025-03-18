package com.cgproject.tourguide;
import com.cgproject.tourguide.models.Tour;
import com.cgproject.tourguide.viewModels.TourListViewModel;
import com.cgproject.tourguide.viewModels.TourViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TourPlannerController implements Initializable {

    @FXML
    private VBox vbox;
    @FXML
    private MenuBar menuBar;

    @FXML
    private TextField searchField;

    @FXML
    private GridPane gridPane;

    @FXML
    private ImageView imageView;

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn<?, ?> column1;

    @FXML
    private TableColumn<?, ?> column2;

    @FXML
    private ListView<TourViewModel> tourListView;

    @FXML
    private Button addTourButton;

    @FXML
    private Button editTourButton;

    @FXML
    private Button deleteTourButton;

    private TourListViewModel tourListViewAdd;


    @FXML
    private void onAddTour(ActionEvent event) {
        Tour tour = new Tour("New Tour", "", "", "", "", 0, 0, "");
        TourViewModel tvm = new TourViewModel(tour);
        tourListViewAdd.addTour(tvm);
        tourListView.getSelectionModel().clearSelection();
        tourListView.getSelectionModel().select(tvm);
        this.onEditTour(new ActionEvent());
        System.out.println("Add Tour button clicked");
    }
    @FXML
    private void onEditTour(ActionEvent event) {

        System.out.println("Edit Tour button clicked");
    }
    @FXML
    private void onDeleteTour(ActionEvent event) {

        System.out.println("Delete Tour button clicked");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tourListViewAdd = new TourListViewModel();
        tourListView.setItems(tourListViewAdd.getTours());

        // Set custom cell factory to display tour names
        tourListView.setCellFactory(new Callback<ListView<TourViewModel>, ListCell<TourViewModel>>() {
            @Override
            public ListCell<TourViewModel> call(ListView<TourViewModel> listView) {
                return new ListCell<TourViewModel>() {
                    @Override
                    protected void updateItem(TourViewModel item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.getName());
                        }
                    }
                };
            }
        });
    }
}
