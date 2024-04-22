package com.example.scenebuilderdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller {

    private Stage stage;

    // Method to set the Stage
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    private void start(ActionEvent event) {
        System.out.println("Start");
    }
    @FXML
    private void help(ActionEvent event) {
        System.out.println("Help");
    }
    @FXML
    private void release(ActionEvent event) {
        stage.close();
    }
}