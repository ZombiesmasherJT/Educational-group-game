package com.example.scenebuilderdemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ScoreController {
    @FXML
    private Label scoreLabel;

    public void setScore(int score) {
        scoreLabel.setText(Integer.toString(score));
    }
}
