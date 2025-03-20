package com.cgproject.tourguide;

import com.cgproject.tourguide.viewModels.TourLogViewModel;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class TourLogEditController {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private GridPane gridPane;
    @FXML
    private TextField dateTimeField;
    @FXML
    private TextField totalTimeField;
    @FXML
    private TextField totalDistanceField;
    @FXML
    private TextField difficultyField;
    @FXML
    private TextField ratingField;
    @FXML
    private TextField commentField;

    private Stage dialogStage;
    private TourLogViewModel tourLogViewModel;
    private boolean okClicked = false;

    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setTourLogViewModel(TourLogViewModel tourLogViewModel) {
        this.tourLogViewModel = tourLogViewModel;
        NumberStringConverter converter = new NumberStringConverter();
        dateTimeField.textProperty().bindBidirectional(tourLogViewModel.dateTimeProperty(), converter);
        totalTimeField.textProperty().bindBidirectional(tourLogViewModel.totalTimeProperty(), converter);
        totalDistanceField.textProperty().bindBidirectional(tourLogViewModel.totalDistanceProperty(), converter);
        difficultyField.textProperty().bindBidirectional(tourLogViewModel.difficultyProperty(), converter);
        ratingField.textProperty().bindBidirectional(tourLogViewModel.ratingProperty(), converter);
        commentField.textProperty().bindBidirectional(tourLogViewModel.commentProperty());
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

    public void setReadOnly(){
        dateTimeField.setDisable(true);
        totalTimeField.setDisable(true);
        totalDistanceField.setDisable(true);
        difficultyField.setDisable(true);
        ratingField.setDisable(true);
        commentField.setDisable(true);
    }


    private boolean isInputValid() {
        String errorMessage = "";
        if (dateTimeField.getText() == null || dateTimeField.getText().length() == 0) {
            errorMessage += "No valid date and time!\n";
        }
        if (totalTimeField.getText() == null || totalTimeField.getText().length() == 0) {
            errorMessage += "No valid total time!\n";
        }
        if (totalDistanceField.getText() == null || totalDistanceField.getText().length() == 0) {
            errorMessage += "No valid total distance!\n";
        }
        if (difficultyField.getText() == null || difficultyField.getText().length() == 0) {
            errorMessage += "No valid difficulty!\n";
        }
        if (ratingField.getText() == null || ratingField.getText().length() == 0) {
            errorMessage += "No valid rating!\n";
        }
        if (commentField.getText() == null || commentField.getText().length() == 0) {
            errorMessage += "No valid comment!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
}
