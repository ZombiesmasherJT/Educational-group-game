package com.example.scenebuilderdemo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * This class is responsible for generating the results page for level three.
 * @author Tedi Mengjezi
 */
public class LevelThreeResultsController {
    @FXML
    public Label markTotal, markProgressDisplay, markResponse;
    int correct;
    int wrong;
    @FXML
    private void initialize() {
        correct = LevelThreeQuizController.correct;
        wrong = LevelThreeQuizController.wrong;

        markProgressDisplay.setText(correct + "/4"); // Displays the user's score
        markResponse.setText(correct + " Marks Scored");

        if (correct < 2) { // Sets the response based on the number of correct answers
            markTotal.setText("Great Effort! Read over the info again in order to help Hydro Harry bring water development to this region");
        } else if (correct == 2) {
            markTotal.setText("Halfway there! Try again and see what else could be done to spread water development");
        } else if (correct == 3) {
            markTotal.setText("So close! Just one more try and you can become a true Hydro Hero");
        } else if (correct == 4) {
            markTotal.setText("Bravo! You truly are a Hydro Hero");
        }

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), evt -> { // Sets up a timeline to switch to the level select page after a certain duration
            try {
                switchToLevelSelectPage();
            } catch (IOException e) {
                e.printStackTrace();
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("An error has occurred");
                error.setContentText("Unable to load Level Select Page");
                error.showAndWait();
            }
        }));
        timeline.play();
    }
    private void switchToLevelSelectPage() throws IOException { // Method to switch back to the level select page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("levelSelect.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) markTotal.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
