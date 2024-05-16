package com.example.scenebuilderdemo;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *This class is responsible for generating the information page for level one
 * @author Tedi Mengjezi
 * @author Joshua Tite
 */
public class LevelOneInfoController {
    @FXML
    public TextArea infoText;
    @FXML
    private Button backButton;
    @FXML
    private void initialize() {
        loadInfo(); // Loads the information into the TextArea
        setupButtonAnimation(backButton); // Sets up the animation for buttons
        backButton.setOnAction(this::handleBackButton); // Action event for backButton
    }
    private void handleBackButton(ActionEvent event) { // Method for the Back Button
        try {
            closeCurrentStage(event); // Method to close current stage
            loadNewStage("levelOneMenu.fxml", "Hydro Heroes: The Quest for Clean Water"); // Method to load new stage
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
        infoText.setText(
                "Ethiopia is grappling with significant challenges in its water, sanitation, and hygiene (WASH) sector\n" +
                "due to rapid population growth and urbanization.Only 7% of the population has access to basic\n" +
                "sanitation services, with a stark contrast between rural (4%) and urban areas (20%). Open defecation,\n" +
                "although reduced from 79% to 22%, remains prevalent, particularly in rural regions (38%). Poor hygiene\n" +
                "and fecal contamination are major contributors to child mortality, illness, under nutrition, and\n" +
                "stunting. Diarrhea is the second leading cause of under-five mortality, responsible for over 25,000\n" +
                "deaths annually. Overall, 60-80% of health problems in Ethiopia are related to communicable diseases\n" +
                "stemming from unsafe water and poor sanitation, with 50% of under nutrition consequences linked to these\n" +
                "environmental factors.\n" +
                "\n" +
                "To address these issues, UNICEF is collaborating with the Government of Ethiopia through the ONEWASH\n" +
                "National Programme. This initiative focuses on enhancing sanitation and hygiene promotion,\n" +
                "particularly in areas with high stunting and diarrhea rates, and improving water supplies in\n" +
                "water-insecure districts. Efforts include the promotion of sustainable deep boreholes and\n" +
                "multi-village supply systems to strengthen climate resilience. Urban sanitation is being expanded\n" +
                "through a newly developed National Urban Sanitation Strategy. In emergencies, UNICEF prioritizes\n" +
                "life-saving interventions, enhances sector coordination, and supports technical responses.\n" +
                "Capacity building through evidence-based planning, data generation, and improved policy-making is also\n" +
                "a key focus, ensuring sustainable access to water and sanitation services and better health outcomes\n" +
                "for Ethiopia's population.\n" +
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
