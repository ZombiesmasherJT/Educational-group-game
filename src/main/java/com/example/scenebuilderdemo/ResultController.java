package com.example.scenebuilderdemo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class ResultController {

    @FXML
    public Label remark, marks, markstext, correcttext, wrongtext;

    @FXML
    public ProgressIndicator correct_progress, wrong_progress;

    int correct;
    int wrong;

    @FXML
    private void initialize() {
        correct = QuizController.correct;
        wrong = QuizController.wrong;

        correcttext.setText("Correct Answers : " + correct);
        wrongtext.setText("Incorrect Answers : " + String.valueOf(QuizController.wrong));

        marks.setText(correct + "/5");
        float correctf = (float) correct/5;
        correct_progress.setProgress(correctf);

        float wrongf = (float) wrong/5;
        wrong_progress.setProgress(wrongf);


        markstext.setText(correct + " Marks Scored");

        if (correct<2) {
            remark.setText("1 OUT OF 5");
        } else if (correct==2) {
            remark.setText("2 OUT OF 5");
        } else if (correct==3) {
            remark.setText("3 OUT OF 5");
        } else if (correct==4) {
            remark.setText("4 OUT OF 5");
        } else if (correct==5) {
            remark.setText("FULL MARKS");
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




