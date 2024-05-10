package com.example.scenebuilderdemo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class LevelOneResultsController {
    @FXML
    public Label remark, markProgress, markText;
    int correct;
    int wrong;
    @FXML
    private void initialize() {
        correct = LevelOneQuizController.correct;
        wrong = LevelOneQuizController.wrong;

        markProgress.setText(correct + "/5");

        markText.setText(correct + " Marks Scored");

        if (correct<2) {
            remark.setText("1 OUT OF 5");
        } else if (correct==2) {
            remark.setText("2 OUT OF 5");
        } else if (correct==3) {
            remark.setText("3 OUT OF 5");
        } else if (correct==4) {
            remark.setText("4 OUT OF 5");
        } else if (correct==5) {
            remark.setText("5 OUT OF 5");
        }

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), evt -> {
            try {
                switchToLevelSelectPage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
        timeline.play();
    }
    private void switchToLevelSelectPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("levelSelect.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) remark.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}




