package com.example.scenebuilderdemo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;

import java.util.Objects;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

    // Buttons that may have animations
    @FXML
    private Button startButton;
    @FXML
    private Button helpButton;
    @FXML
    private Button exitButton;

    // Initialize method to set up animations
    @FXML
    private void initialize() {
        setupButtonAnimation(startButton);
        setupButtonAnimation(helpButton);
        setupButtonAnimation(exitButton);
    }

    // Method to add hover animations
    private void setupButtonAnimation(Button button) {
        ScaleTransition st = new ScaleTransition(Duration.millis(200), button);
        st.setToX(1.1);
        st.setToY(1.1);
        st.setCycleCount(2);
        st.setAutoReverse(true);

        button.setOnMouseEntered(e -> st.playFromStart());
        button.setOnMouseExited(e -> st.stop());
    }

    private void switchToFirstLevel(ActionEvent event) throws Exception {
        switchPage(event, "firstLevelFile.fxml");
    }

    public void switchToHelpPage(ActionEvent event) throws Exception {
        System.out.println("SWITCH TEST");
        switchPage(event, "helpFile.fxml");
    }

    public void switchToMainPage(ActionEvent event) throws Exception {
        switchPage(event, "mainFile.fxml");
    }

    public void switchToWorkInProgress(ActionEvent event) throws Exception {
        switchPage(event, "workInProgressFile.fxml");
    }

    private void switchPage(ActionEvent event, String fxmlFile) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleExitButtonAction(ActionEvent event) {
        Platform.exit();
    }
}
