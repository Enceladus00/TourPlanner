package com.cgproject.tourguide.components;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonBar extends HBox {

    @FXML
    private Button newButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    public ButtonBar() {
    }

    public void setOnNewAction(Runnable action) {
        newButton.setOnAction(event -> action.run());
    }

    public void setOnEditAction(Runnable action) {
        editButton.setOnAction(event -> action.run());
    }

    public void setOnDeleteAction(Runnable action) {
        deleteButton.setOnAction(event -> action.run());
    }
}
