package com.example.scenebuilderdemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

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


    }

}
