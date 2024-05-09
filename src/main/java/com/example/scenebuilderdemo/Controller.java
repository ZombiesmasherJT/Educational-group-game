package com.example.scenebuilderdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Controller {
    private Stage stage;
    private Scene scene;
    private int score;

    public void switchToLevelSelectPage(ActionEvent event) throws IOException {
        loadFXML("levelSelect.fxml", event);
    }

    public void switchToHelpPage(ActionEvent event) throws IOException {
        loadFXML("helpPage.fxml", event);
    }

    public void switchToMainPage(ActionEvent event) throws IOException {
        loadFXML("mainPage.fxml", event);
    }

    public void switchToLevelOneMenu(ActionEvent event) throws IOException {
        loadFXML("levelOneMenu.fxml", event);
    }

    public void switchToWorkInProgress(ActionEvent event) throws IOException {
        loadFXML("workInProgressFile.fxml", event);
    }

    public void switchToLevelOneInfo(ActionEvent event) throws IOException {
        loadFXML("levelOneInfo.fxml", event);
    }

    public void switchToLevelOneQuestion1(ActionEvent event) throws IOException {
        loadFXML("levelOneQuiz.fxml", event);
    }

    public void switchToLevelOneQuestion2(ActionEvent event) throws IOException {
        loadFXML("levelOneQ2.fxml", event);
    }

    public void switchToLevelOneQuestion3(ActionEvent event) throws IOException {
        loadFXML("levelOneQ3.fxml", event);
    }

    public void switchToLevelOneQuestion4(ActionEvent event) throws IOException {
        loadFXML("levelOneQ4.fxml", event);
    }

    public void switchToLevelOneQuestion5(ActionEvent event) throws IOException {
        loadFXML("levelOneQ5.fxml", event);
    }

    public void checkAnswer(ActionEvent event) throws IOException {
        System.out.println("checkAnswer method called."); // Print statement for debugging

        Button buttonClicked = (Button) event.getSource();
        String buttonText = buttonClicked.getText();

        // Assuming correct answers are hardcoded here for simplicity
        String correctAnswer = getCorrectAnswer();

        if (buttonText.equals(correctAnswer)) {
            score++;
        }

        // If it's the last question, display the score
        if (score == 5) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Quiz Complete");
            alert.setHeaderText(null);
            alert.setContentText("Congratulations! You scored " + score + " out of 5.");
            alert.showAndWait();
        } else {
            // Otherwise, move to the next question
            switchToNextQuestion(event);
        }
    }

    private String getCorrectAnswer() {
        // Hardcoding correct answers for each question
        // In a real application, this information would likely come from a database or other source
        return "B";
    }

    private void switchToNextQuestion(ActionEvent event) throws IOException {
        if (score == 1) {
            switchToLevelOneQuestion2(event);
        } else if (score == 2) {
            switchToLevelOneQuestion3(event);
        } else if (score == 3) {
            switchToLevelOneQuestion4(event);
        } else if (score == 4) {
            switchToLevelOneQuestion5(event);
        }
    }

    private void loadFXML(String fxmlFileName, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFileName)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
