package com.example.scenebuilderdemo;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *This class is responsible for controlling the main menu
 * @author Joshua Tite
 */

public class MainMenuController {
    @FXML
    private Button startButton;
    @FXML
    private Button helpButton;
    @FXML
    private Button quitButton;
    @FXML
    private void initialize() {
        setupButtonAnimation(startButton); // Sets up the animation for buttons
        setupButtonAnimation(helpButton);
        setupButtonAnimation(quitButton);
        startButton.setOnAction(this::handleStartButton); // Action event for Back Button
        helpButton.setOnAction(this::handleHelpButton); // Action event for Help Button
        quitButton.setOnAction(this::closeCurrentStage); // this is an action for the quit button for the application
    }

    private void handleStartButton(ActionEvent event) { // Method for the Back Button
        try {
            closeCurrentStage(event); // Method to close current stage
            loadNewStage("levelSelect.fxml", "Hydro Heroes: The Quest for Clean Water"); // Method to load new stage
        } catch (Exception e) {
            e.printStackTrace(); // Prints the stack trace for debugging purposes
            Alert error = new Alert(Alert.AlertType.ERROR); // Displays an error dialog to the user
            error.setTitle("Error");
            error.setHeaderText("An error has occurred");
            error.setContentText("Unable to load the Main Menu");
            error.showAndWait();
        }
    }

    private void handleHelpButton(ActionEvent event) { // Method for the Back Button
        try {
            closeCurrentStage(event); // Method to close current stage
            loadNewStage("helpPage.fxml", "Hydro Heroes: The Quest for Clean Water"); // Method to load new stage
        } catch (Exception e) {
            e.printStackTrace(); // Prints the stack trace for debugging purposes
            Alert error = new Alert(Alert.AlertType.ERROR); // Displays an error dialog to the user
            error.setTitle("Error");
            error.setHeaderText("An error has occurred");
            error.setContentText("Unable to load the Main Menu");
            error.showAndWait();
        }
    }

    private void closeCurrentStage(ActionEvent event) { // Method to close current stage
        Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
    private void loadNewStage(String fxmlFileName, String title) throws Exception { // Method to load new stage
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }
    private void setupButtonAnimation(Button button) {
        ScaleTransition st = new ScaleTransition(Duration.millis(200), button);
        st.setToX(1.1);
        st.setToY(1.1);
        st.setCycleCount(2);
        st.setAutoReverse(true);

        button.setOnMouseEntered(e -> st.playFromStart());
        button.setOnMouseExited(e -> st.stop());
    }

}