package com.example.scenebuilderdemo;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *This class is responsible for generating the menu page for level five
 * @author Tedi Mengjezi
 */
public class LevelFiveMenuController {
    @FXML
    private Button playInfoFiveButton;
    @FXML
    private Button playQuizFiveButton;
    @FXML
    private void initialize() {
        setupButtonAnimation(playInfoFiveButton); // Sets up the animation for buttons
        setupButtonAnimation(playQuizFiveButton);
        playInfoFiveButton.setOnAction(this::handleInfoButton); // Action event for Info Button
        playQuizFiveButton.setOnAction(this::handleQuizButton); // Action event for Quiz Button
    }
    private void handleInfoButton(ActionEvent event) { // Method to handle Info Button
        try {
            closeCurrentStage(event); // Method to close current stage
            loadNewStage("levelFiveInfo.fxml", "Hydro Heroes: The Quest for Clean Water"); // Method to load new stage
        } catch (Exception e) {
            e.printStackTrace();
            Alert error = new Alert(Alert.AlertType.ERROR); // Displays an error dialog to the user
            error.setTitle("Error");
            error.setHeaderText("An error has occurred");
            error.setContentText("Unable to load the Information for Level One");
            error.showAndWait();
        }
    }
    private void handleQuizButton(ActionEvent event) { // Method to handle Quiz Button
        try {
            closeCurrentStage(event); // Method to close current stage
            loadNewStage("levelFiveQuiz.fxml", "Hydro Heroes: The Quest for Clean Water"); // Method to load new stage
        } catch (Exception e) {
            e.printStackTrace();
            Alert error = new Alert(Alert.AlertType.ERROR); // Displays an error dialog to the user
            error.setTitle("Error");
            error.setHeaderText("An error has occurred");
            error.setContentText("Unable to load the Quiz for Level One");
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
    private void setupButtonAnimation(Button button) { // Method which sets up button animation
        ScaleTransition st = new ScaleTransition(Duration.millis(200), button); // Creates a ScaleTransition for the button
        st.setToX(1.1); // Scales transition to X
        st.setToY(1.1); // Scales transition to Y
        st.setCycleCount(2); // Sets the number of cycles
        st.setAutoReverse(true); // Auto-reverses the animation

        button.setOnMouseEntered(e -> st.playFromStart()); // Plays animation once mouse enter is detected
        button.setOnMouseExited(e -> st.stop()); // Stops the animation once mouse exit is detected
    }
}
