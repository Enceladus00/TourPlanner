package com.cgproject.tourguide;

import com.cgproject.tourguide.models.Tour;
import com.cgproject.tourguide.viewModels.TourViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class TourEditController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField nameField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField fromField;
    @FXML
    private TextField toField;
    @FXML
    private TextField transportTypeField;
    @FXML
    private TextField tourDistanceField;
    @FXML
    private TextField estimatedTimeField;

    private Stage dialogStage;
    private TourViewModel tourViewModel;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setTourViewModel(TourViewModel tourViewModel) {
        this.tourViewModel = tourViewModel;
        nameField.textProperty().bindBidirectional(tourViewModel.nameProperty());
        descriptionField.textProperty().bindBidirectional(tourViewModel.descriptionProperty());
        fromField.textProperty().bindBidirectional(tourViewModel.fromProperty());
        toField.textProperty().bindBidirectional(tourViewModel.toProperty());
        transportTypeField.textProperty().bindBidirectional(tourViewModel.transportTypeProperty());
        NumberStringConverter converter = new NumberStringConverter();
        tourDistanceField.textProperty().bindBidirectional(tourViewModel.tourDistanceProperty(), converter);
        estimatedTimeField.textProperty().bindBidirectional(tourViewModel.estimatedTimeProperty(), converter);
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().isEmpty()) {
            errorMessage += "Please enter a valid name!!\n";
        }
        if (descriptionField.getText() == null || descriptionField.getText().isEmpty()) {
            errorMessage += "Please enter a valid description!!\n";
        }
        if (fromField.getText() == null || fromField.getText().isEmpty()) {
            errorMessage += "Please enter a valid from!!\n";
        }
        if (toField.getText() == null || toField.getText().isEmpty()) {
            errorMessage += "Please enter a valid to !!\n";
        }
        if (transportTypeField.getText() == null || transportTypeField.getText().isEmpty()) {
            errorMessage += "Please enter a valid transport type!!\n";
        }
        if (errorMessage.isEmpty()) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
        }
        return false;
    }


}
