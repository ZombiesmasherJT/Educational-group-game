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
 * This class is responsible for generating the results page for level Two.
 * @author Tedi Mengjezi
 */
public class LevelTwoResultsController {
    @FXML
    public Label remark, markProgress, markText;
    int correct;
    int wrong;
    @FXML
    private void initialize() {
        correct = LevelTwoQuizController.correct;
        wrong = LevelTwoQuizController.wrong;

        markProgress.setText(correct + "/5"); // Displays the user's score
        markText.setText(correct + " Marks Scored");

        if (correct < 2) { // Sets the response based on the number of correct answers
            remark.setText("1 OUT OF 5");
        } else if (correct == 2) {
            remark.setText("2 OUT OF 5");
        } else if (correct == 3) {
            remark.setText("3 OUT OF 5");
        } else if (correct == 4) {
            remark.setText("4 OUT OF 5");
        } else if (correct == 5) {
            remark.setText("5 OUT OF 5");
        }

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), evt -> { // Sets up a timeline to switch to the level select page after a certain duration
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
        Stage stage = (Stage) remark.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
