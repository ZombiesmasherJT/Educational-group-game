package com.example.scenebuilderdemo;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *This class is responsible for generating the quiz page and handling all the logic for level three
 * @author Tedi Mengjezi
 * @author Jordan Meecham
 */
public class LevelThreeQuizController {
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
                "How many people in Chad can access clean water?",
                "How many children have access clean water?",
                "How many children wash there hands?",
                "What age group is most at risk?",
        };
        String[][] options = { // Array storing answers
                {"46%", "2%", "79%", "43%"},
                {"9 in 50", "1 in 2", "3 in 7", "1 in 5"},
                {"7", "5 in 26", "1 in 17", "1 in 9"},
                {"Children", "Young Adults", "The Elderly", "All of them"},
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
                loadNewStage("levelThreeResults.fxml", "Hydro Heroes: The Quest for Clean Water");
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
                loadNewStage("levelThreeResults.fxml", "Hydro Heroes: The Quest for Clean Water");
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
                loadNewStage("levelThreeResults.fxml", "Hydro Heroes: The Quest for Clean Water");
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
                loadNewStage("levelThreeResults.fxml", "Hydro Heroes: The Quest for Clean Water");
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
        String[] correctAnswers = {"43%", "1 in 2", "1 in 17", "Children"}; // Array containing the correct answers for each question
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
        Image icon = new Image("/HydroHarry.png"); // Set the application icon
        stage.getIcons().add(icon);
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

