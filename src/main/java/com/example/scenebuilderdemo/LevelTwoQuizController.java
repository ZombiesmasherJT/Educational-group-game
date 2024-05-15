package com.example.scenebuilderdemo;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
/**
 *This class is responsible for generating the quiz page and handling all the logic for level two
 * @author Tedi Mengjezi
 */
public class LevelTwoQuizController {
    @FXML
    public Label question; // Label which displays the question
    @FXML
    public Button optionOneButton, optionTwoButton, optionThreeButton, optionFourButton; // Buttons for answer options
    static int counter = 0; // Counter which tracks the current question
    static int correct = 0; // Counter which tracks the number of correct answers
    @FXML
    private void initialize() {
        counter = 0; // Restarts the counter to start from the first question
        correct = 0; // Restarts the counter for correct questions
        loadQuestions(); //Method which loads questions
        setupButtonAnimation(optionOneButton); // Sets up the animation for buttons
        setupButtonAnimation(optionTwoButton);
        setupButtonAnimation(optionThreeButton);
        setupButtonAnimation(optionFourButton);
    }
    private void loadQuestions() { //Method which stores and loads the correct question and answer prompts
        String[] questions = { // Array storing Questions
                "What percentage of people in Somalia have access to clean water?",
                "How are most families forced to retrieve water?",
                "What diseases can you contract from unsafe water?",
                "Why is it a challenge to get clean water?",
        };
        String[][] options = { // Array storing answers
                {"62%", "52%", "12%", "100%"},
                {"Travelling to far and \n" +"unsafe wells", "Purifying river water", "Travelling to shops", "Collecting rainwater"},
                {"Hepatitis and Measles", "Tapeworms and Lyme \n" +"disease", "Diarrhoea and Cholera", "Respiratory infections \n" +"and Ebola"},
                {"There is not enough \n" +"water", "It isn't a challenge to \n" +"get clean water", "The distance to the \n" +"source is too far", "There isn't safe access \n" +"to get water"},
        };
        question.setText(questions[counter]); // Sets the current question and its answers
        optionOneButton.setText(options[counter][0]);
        optionTwoButton.setText(options[counter][1]);
        optionThreeButton.setText(options[counter][2]);
        optionFourButton.setText(options[counter][3]);
    }

    @FXML
    public void optionOneButtonClicked(ActionEvent event) { // Method which handles option one button
        String selectedAnswer = optionOneButton.getText(); // Gets the selected answer
        boolean isAnswerCorrect = checkAnswer(selectedAnswer); // Checks if the selected answer is correct
        if (isAnswerCorrect) { // Adds to the counters based on if the answer is correct or not
            correct++;
        }
        if (counter == 3) { // Checks if all questions have been answered and changes scene to results page
            try {
                closeCurrentStage(event);
                loadNewStage("levelTwoResults.fxml", "Hydro Heroes: The Quest for Clean Water");
            } catch (Exception e) {
                e.printStackTrace();
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("An error has occurred");
                error.setContentText("Unable to load Results Page");
                error.showAndWait();
            }
        } else { // Moves onto the next question
            counter++;
            loadQuestions();
        }
    }

    @FXML
    public void optionTwoButtonClicked(ActionEvent event) {
        String selectedAnswer = optionTwoButton.getText();
        boolean isAnswerCorrect = checkAnswer(selectedAnswer);
        if (isAnswerCorrect) {
            correct++;
        }
        if (counter == 3) {
            try {
                closeCurrentStage(event);
                loadNewStage("levelTwoResults.fxml", "Hydro Heroes: The Quest for Clean Water");
            } catch (Exception e) {
                e.printStackTrace();
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("An error has occurred");
                error.setContentText("Unable to load Results Page");
                error.showAndWait();
            }
        } else {
            counter++;
            loadQuestions();
        }
    }
    @FXML
    public void optionThreeButtonClicked(ActionEvent event) {
        String selectedAnswer = optionThreeButton.getText();
        boolean isAnswerCorrect = checkAnswer(selectedAnswer);
        if (isAnswerCorrect) {
            correct++;
        }
        if (counter == 3) {
            try {
                closeCurrentStage(event);
                loadNewStage("levelTwoResults.fxml", "Hydro Heroes: The Quest for Clean Water");
            } catch (Exception e) {
                e.printStackTrace();
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("An error has occurred");
                error.setContentText("Unable to load Results Page");
                error.showAndWait();
            }
        } else {
            counter++;
            loadQuestions();
        }
    }
    @FXML
    public void optionFourButtonClicked(ActionEvent event) {
        String selectedAnswer = optionFourButton.getText();
        boolean isAnswerCorrect = checkAnswer(selectedAnswer);
        if (isAnswerCorrect) {
            correct++;
        }
        if (counter == 3) {
            try {
                closeCurrentStage(event);
                loadNewStage("levelTwoResults.fxml", "Hydro Heroes: The Quest for Clean Water");
            } catch (Exception e) {
                e.printStackTrace();
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("An error has occurred");
                error.setContentText("Unable to load Results Page");
                error.showAndWait();
            }
        } else {
            counter++;
            loadQuestions();
        }
    }
    private boolean checkAnswer(String answer) { // Method which checks if the selected answer is correct
        String[] correctAnswers = {"52%", "Travelling to far and \n" +"unsafe wells", "Diarrhoea and Cholera", "There isn't safe access \n" +"to get water"}; // Array containing the correct answers for each question
        return answer.equals(correctAnswers[counter]); // Compares the selected answer to see if the answer is correct
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

