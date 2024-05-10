package com.example.scenebuilderdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class LevelOneQuizController {
    @FXML
    public Label question;
    @FXML
    public Button optionOne, optionTwo, optionThree, optionFour;
    static int counter = 0;
    static int correct = 0;
    static int wrong = 0;

    @FXML
    private void initialize() {
        counter = 0; // Reset counter to start from the first question
        correct = 0; // Reset correct count
        wrong = 0;   // Reset wrong count
        loadQuestions();
    }

    private void loadQuestions() {

        if (counter == 0) { //Question 1
            question.setText("QUESTION 1");
            optionOne.setText("OPTION 1");
            optionTwo.setText("OPTION 2");
            optionThree.setText("OPTION 3");
            optionFour.setText("OPTION 4");
        }
        if (counter == 1) { //Question 2
            question.setText("QUESTION 2");
            optionOne.setText("OPTION 1");
            optionTwo.setText("OPTION 2");
            optionThree.setText("OPTION 3");
            optionFour.setText("OPTION 4");
        }
        if (counter == 2) { //Question 3
            question.setText("QUESTION 3");
            optionOne.setText("OPTION 1");
            optionTwo.setText("OPTION 2");
            optionThree.setText("OPTION 3");
            optionFour.setText("OPTION 4");
        }
        if (counter == 3) { //Question 4
            question.setText("QUESTION 4");
            optionOne.setText("OPTION 1");
            optionTwo.setText("OPTION 2");
            optionThree.setText("OPTION 3");
            optionFour.setText("OPTION 4");
        }
        if (counter == 4) {//Question 5
            question.setText("QUESTION 5");
            optionOne.setText("OPTION 1");
            optionTwo.setText("OPTION 2");
            optionThree.setText("OPTION 3");
            optionFour.setText("OPTION 4");
        }
    }
    @FXML
    public void optionOneClicked(ActionEvent event) {
        checkAnswer(optionOne.getText().toString());
        if (checkAnswer(optionOne.getText().toString())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (counter == 4) {
            try {
                System.out.println(correct);
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("levelOneResults.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.setTitle("Hydro Heroes: The Quest for Clean Water");
                quizstage.setResizable(false);
                quizstage.show();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }

    }

    boolean checkAnswer(String answer) {

        if (counter == 0) {
            if (answer.equals("OPTION 1")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 1) {
            if (answer.equals("OPTION 1")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 2) {
            if (answer.equals("OPTION 1")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 3) {
            if (answer.equals("OPTION 1")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 4) {
            if (answer.equals("OPTION 1")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    @FXML
    public void optionTwoClicked(ActionEvent event) {
        checkAnswer(optionTwo.getText().toString());
        if (checkAnswer(optionTwo.getText().toString())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (counter == 4) {
            try {
                System.out.println(correct);
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("levelOneResults.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.setTitle("Hydro Heroes: The Quest for Clean Water");
                quizstage.setResizable(false);
                quizstage.show();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }
    }

    @FXML
    public void optionThreeClicked(ActionEvent event) {
        checkAnswer(optionThree.getText().toString());
        if (checkAnswer(optionThree.getText().toString())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (counter == 4) {
            try {
                System.out.println(correct);
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("levelOneResults.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.setTitle("Hydro Heroes: The Quest for Clean Water");
                quizstage.setResizable(false);
                quizstage.show();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }
    }

    @FXML
    public void optionFourClicked(ActionEvent event) {
        checkAnswer(optionFour.getText().toString());
        if (checkAnswer(optionFour.getText().toString())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (counter == 4) {
            try {
                System.out.println(correct);
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("levelOneResults.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.setTitle("Hydro Heroes: The Quest for Clean Water");
                quizstage.setResizable(false);
                quizstage.show();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }
    }

}

