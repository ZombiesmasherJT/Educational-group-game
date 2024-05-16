package com.example.scenebuilderdemo;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *This class is responsible for generating the information page for level five
 * @author Tom Sammon
 * @author Jordan Meecham
 */
public class LevelFiveInfoController {
    @FXML
    public TextArea infoText;
    @FXML
    private Button backButton;

    @FXML
    private void initialize() {
        loadInfo(); // Loads the information into the TextField
        setupButtonAnimation(backButton); // Sets up the animation for buttons
        backButton.setOnAction(this::handleBackButton); // Action event for backButton
    }

    private void handleBackButton(ActionEvent event) { // Method for the Back Button
        try {
            closeCurrentStage(event); // Method to close current stage
            loadNewStage("levelFiveMenu.fxml", "Hydro Heroes: The Quest for Clean Water"); // Method to load new stage
        } catch (Exception e) {
            e.printStackTrace(); // Prints the stack trace for debugging purposes
            Alert error = new Alert(Alert.AlertType.ERROR); // Displays an error dialog to the user
            error.setTitle("Error");
            error.setHeaderText("An error occurred");
            error.setContentText("Unable to load the menu for Level One");
            error.showAndWait();
        }
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

    private void loadInfo() { // Method which loads the information into the TextField
        infoText.setText("In Niger, water-related diseases and poor hygiene and sanitation practices are among the leading\n" +
                "causes of death in children under five. Access to drinking water and sanitation is critically low, with\n" +
                "significant disparities between urban and rural areas and among different regions. Only 56% of the population\n" +
                "has access to a drinking water source, with a 7% increase in service supply from 2012 to 2015. A mere 13%\n" +
                "of the population has access to basic sanitation services, and over practice open defecation, leading to\n" +
                "severe health, nutrition, education, and economic consequences. Access to drinking water and sanitation\n" +
                "facilities is limited in schools, with only 22.7% of schools having drinking water and 26.7% having\n" +
                "sanitation facilities.\n" +
                "\n" +
                "UNICEF supports the Government of Niger and partners in developing and implementing policies\n" +
                "and strategies to improve access to safe drinking water, hygiene, and sanitation. Actively involved\n" +
                "in political dialogue and sector coordination, UNICEF provides technical and financial support to\n" +
                "enhance water and sanitation services,promote good hygiene practices, and contribute to the\n" +
                "National WASH programme. Efforts focus on changing social norms and behaviors to end open\n" +
                "defecation and maintain good hygiene and sanitation\n" +
                "practices.\n" +
                "\n" +
                "This information was sourced from the UNICEF and Water Aid websites");
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
