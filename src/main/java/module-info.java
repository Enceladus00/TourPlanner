module com.cgproject.tourguide {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    requires com.almasb.fxgl.all;
    requires kernel;
    requires layout;


    opens com.cgproject.tourguide to javafx.fxml;
    exports com.cgproject.tourguide;
    opens com.cgproject.tourguide.components to javafx.fxml;
}