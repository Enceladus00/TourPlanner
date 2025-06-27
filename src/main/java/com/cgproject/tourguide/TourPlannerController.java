package com.cgproject.tourguide;
import com.cgproject.tourguide.components.ButtonBarController;
import com.cgproject.tourguide.models.Tour;
import com.cgproject.tourguide.models.TourLog;
import com.cgproject.tourguide.util.PdfGenerator;
import com.cgproject.tourguide.viewModels.TourListViewModel;
import com.cgproject.tourguide.viewModels.TourLogTableViewModel;
import com.cgproject.tourguide.viewModels.TourLogViewModel;
import com.cgproject.tourguide.viewModels.TourViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.collections.ObservableList;


import java.io.IOException;
import java.net.URL;
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
    private TableColumn<TourLogViewModel, Number> dateColumn;
    @FXML
    private TableColumn<TourLogViewModel, Number> durationColumn;
    @FXML
    private TableColumn<TourLogViewModel, Number> distanceColumn;

    @FXML
    private ListView<TourViewModel> tourListView;

    @FXML
    private TableView<TourLogViewModel> tourLogTableView;

    @FXML
    private ButtonBar buttonBar;

    @FXML
    private TourListViewModel tourListViewAdd;

    @FXML
    private ButtonBarController buttonBarController;

    @FXML
    private void onGeneratePdf(ActionEvent event) {
        TourViewModel selectedTour = tourListView.getSelectionModel().getSelectedItem();
        if (selectedTour != null) {
            PdfGenerator pdfGenerator = new PdfGenerator();
            String filePath = "Tour_" + selectedTour.getName() + ".pdf"; // Define the file path
            try {
                pdfGenerator.generateTourPdf(
                        filePath,
                        selectedTour.getName(),
                        selectedTour.getFrom(),
                        selectedTour.getTo(),
                        selectedTour.getTransportType(),
                        selectedTour.getEstimatedTime(),
                        selectedTour.getTourDistance(),
                        selectedTour.getTourDescription()
                );
                System.out.println("PDF generated successfully: " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to generate PDF.");
            }
        } else {
            System.out.println("No tour selected for PDF generation.");
        }
    }
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
        TourViewModel selectedTour = tourListView.getSelectionModel().getSelectedItem();
        if (selectedTour != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("tourEditWindow.fxml"));
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Edit Tour");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(tourListView.getScene().getWindow());
                Scene scene = new Scene(loader.load());
                dialogStage.setScene(scene);

                TourEditController controller = loader.getController();
                controller.setDialogStage(dialogStage);
                controller.setTourViewModel(selectedTour);

                dialogStage.showAndWait();

                if (controller.isOkClicked()) {
                    // Handle the case when OK is clicked
                    tourListView.refresh();
                    System.out.println("Tour edited successfully");
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    private void onDeleteTour(ActionEvent event) {
        TourViewModel selectedTour = tourListView.getSelectionModel().getSelectedItem();
        if (selectedTour != null) {
            tourListViewAdd.removeTour(selectedTour);
            tourListView.getSelectionModel().clearSelection();
            tourListView.refresh();
            System.out.println("Tour deleted successfully");
        } else {
            System.out.println("No tour selected for deletion");
        }
    }

    @FXML
    private void onDetails(ActionEvent event) {
        TourViewModel selectedTour = tourListView.getSelectionModel().getSelectedItem();
        if (selectedTour != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("tourEditWindow.fxml"));
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Tour Details");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(tourListView.getScene().getWindow());
                Scene scene = new Scene(loader.load());
                dialogStage.setScene(scene);

                TourEditController controller = loader.getController();
                controller.setDialogStage(dialogStage);
                controller.setTourViewModel(selectedTour);
                controller.setReadOnly();

                dialogStage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void onAddTourLog(ActionEvent event) {
        TourLog tourLog = new TourLog(0, 0, "comment", 0, 0, 0, 0);
        TourLogViewModel tlvm = new TourLogViewModel(tourLog);
        tourLogTableView.getItems().add(tlvm);
        tourLogTableView.getSelectionModel().clearSelection();
        tourLogTableView.getSelectionModel().select(tlvm);
        this.onEditTourLog(new ActionEvent());
        System.out.println("Add Tour Log button clicked");
    }
    @FXML
    public void onEditTourLog(ActionEvent event) {
        TourLogViewModel selectedTourLog = tourLogTableView.getSelectionModel().getSelectedItem();
        if (selectedTourLog != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("tourLogEditWindow.fxml"));
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Edit Tour Log");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(tourLogTableView.getScene().getWindow());
                Scene scene = new Scene(loader.load());
                dialogStage.setScene(scene);

                TourLogEditController controller = loader.getController();
                controller.setDialogStage(dialogStage);
                controller.setTourLogViewModel(selectedTourLog);

                dialogStage.showAndWait();

                if (controller.isOkClicked()) {
                    // Handle the case when OK is clicked
                    tourLogTableView.refresh();
                    System.out.println("Tour Log edited successfully");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No tour log selected for editing");
        }
    }
    public void onDeleteTourLog(ActionEvent event) {
        TourLogViewModel selectedTourLog = tourLogTableView.getSelectionModel().getSelectedItem();
        if (selectedTourLog != null) {
            tourLogTableView.getItems().remove(selectedTourLog);
            tourLogTableView.getSelectionModel().clearSelection();
            tourLogTableView.refresh();
            System.out.println("Tour Log deleted successfully");
        } else {
            System.out.println("No tour log selected for deletion");
        }


        System.out.println("Delete Tour Log button clicked");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tourListViewAdd = new TourListViewModel();
        tourListView.setItems(tourListViewAdd.getTours());

        // Set custom cell factory to display tour names
        tourListView.setCellFactory(listView -> new ListCell<TourViewModel>() {
            @Override
            protected void updateItem(TourViewModel item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getName());
                }
            }
        });

        // Bind columns to TourLogViewModel properties
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        durationColumn.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
        distanceColumn.setCellValueFactory(cellData -> cellData.getValue().totalDistanceProperty());

        // Listen for selection changes in the tour list
        tourListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                tourLogTableView.setItems(newSelection.getTourLogViewModels());
            } else {
                tourLogTableView.setItems(null);
            }
        });

        buttonBarController = (ButtonBarController) buttonBar.getProperties().get("ButtonBarController");
        buttonBarController.setOnNewAction(() -> onAddTour(new ActionEvent()));
        buttonBarController.setOnEditAction(() -> onEditTour(new ActionEvent()));
        buttonBarController.setOnDeleteAction(() -> onDeleteTour(new ActionEvent()));
        buttonBarController.setOnDetailsAction(() -> onDetails(new ActionEvent()));
        System.out.println("ButtonBar actions are set!");
    }
}
