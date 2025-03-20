package com.cgproject.tourguide.components;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;

import java.net.URL;
import java.util.ResourceBundle;

public class ButtonBarController implements Initializable {
    @FXML private ButtonBar buttonBar;
    @FXML private Button newButton;
    @FXML private Button editButton;
    @FXML private Button deleteButton;
    @FXML private Button detailsButton;

    public ButtonBarController() {
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonBar.getProperties().put("ButtonBarController", this);
    }
    public void setOnNewAction(Runnable action) {
        if (newButton != null) {
            newButton.setOnAction(event -> action.run());
        } else {
            System.out.println("newButton is null");
        }
    }

    public void setOnEditAction(Runnable action) {
        if (editButton != null) {
            editButton.setOnAction(event -> action.run());
        } else {
            System.out.println("editButton is null");
        }
    }

    public void setOnDeleteAction(Runnable action) {
        if (deleteButton != null) {
            deleteButton.setOnAction(event -> action.run());
        } else {
            System.out.println("deleteButton is null");
        }
    }

    public void setOnDetailsAction(Runnable action) {
        if (detailsButton != null) {
            detailsButton.setOnAction(event -> action.run());
        } else {
            System.out.println("detailsButton is null");
        }
    }
}
