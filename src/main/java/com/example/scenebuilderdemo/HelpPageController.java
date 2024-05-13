package com.example.scenebuilderdemo;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *This class is responsible for generating the help page for the main menu
 * @author Joshua Tite
 */
public class HelpPageController {
    @FXML
    public TextArea infoText;
    @FXML
    private Button backButton;
    @FXML
    private void initialize() {
        loadInfo(); // Loads the information into the TextField
        setupButtonAnimation(backButton); // Sets up the animation for buttons
        backButton.setOnAction(this::handleBackButton); // Action event for backButton
    }
    private void handleBackButton(ActionEvent event) { // Method for the Back Button
        try {
            closeCurrentStage(event); // Method to close current stage
            loadNewStage("mainMenu.fxml", "Hydro Heroes: The Quest for Clean Water"); // Method to load new stage
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
    private void loadInfo() { //Method which loads the information into the TextField
        infoText.setText("ATTENTION HYDRO HEROS!!!\n" +
                "Hydro Harry needs your help! Help Hydro Harry to introduce water development across Africa\n" +
                "and be the change children need! There are millions of children across Africa\n" +
                        "without access to clean, healthy water, YOU can be the change!\n" +
                        "Team up with the Hydro Heroes and join Hydro Harry \n" +
                "on his journey to provide clean drinking water to developing countries. \n" +
                "Stage 1: Select the country! There are multiple countries in Africa to choose from,\n" +
                        "the more countries you finish, the more lives you save!\n" +
                "Stage 2: Complete the quiz, save the kids!\n" +
                "Stage 3: Get a high score! Get your own personal score on the leaderboard!\n" +
                "Stage 4: Take a well deserved rest! You can finish anytime by just pressing the quit button,\n" +
                "or closing the tab!\n" +
                "Stage 5: Good luck!\n" +
                "Remember heroes, learning saves lives! ");
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