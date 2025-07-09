package com.cgproject.tourguide;

import com.cgproject.tourguide.viewModels.TourViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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
    private Runnable reloadToursCallback;

    @FXML
    private void initialize() {}

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setReloadToursCallback(Runnable callback) {
        this.reloadToursCallback = callback;
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
            // send tourViewModel data to backend (create or update)
            boolean success = saveTourToBackend();
            if (success) {
                okClicked = true;
                if (reloadToursCallback != null) {
                    reloadToursCallback.run();
                }
                dialogStage.close();
            }

            // if not successful, error is already shown
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    public void setReadOnly() {
        nameField.setDisable(true);
        descriptionField.setDisable(true);
        fromField.setDisable(true);
        toField.setDisable(true);
        transportTypeField.setDisable(true);
        tourDistanceField.setDisable(true);
        estimatedTimeField.setDisable(true);
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
            errorMessage += "Please enter a valid to!!\n";
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

    // helper to escape quotes for JSON
    private String escapeJson(String s) {
        return s == null ? "" : s.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    // call backend to save/update tour
    private boolean saveTourToBackend() {
        try {
            // build JSON from the edited TourViewModel
            // if you have tour id, use PUT, otherwise POST
            boolean isNew = tourViewModel.getId() == 0; // or check for null/negative
            String json =
                    (isNew ? "" : "\"id\":" + tourViewModel.getId() + ",") +
                            "\"name\":\"" + escapeJson(tourViewModel.getName()) + "\"," +
                            "\"description\":\"" + escapeJson(tourViewModel.getTourDescription()) + "\"," +
                            "\"fromLocation\":\"" + escapeJson(tourViewModel.getFrom()) + "\"," +
                            "\"toLocation\":\"" + escapeJson(tourViewModel.getTo()) + "\"," +
                            "\"transportType\":\"" + escapeJson(tourViewModel.getTransportType()) + "\"," +
                            "\"distance\":" + tourViewModel.getTourDistance() + "," +
                            "\"estimatedTime\":" + tourViewModel.getEstimatedTime();

            json = "{" + json + "}";


            URL url = isNew
                    ? new URL("http://localhost:8080/api/tours")
                    : new URL("http://localhost:8080/api/tours/" + tourViewModel.getId());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(isNew ? "POST" : "PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();
            if (code == 200 || code == 201) {
                return true;
            } else {
                showError("Failed to save tour (HTTP " + code + ")");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            showError("Error saving tour: " + e.getMessage());
            return false;
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Save Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
