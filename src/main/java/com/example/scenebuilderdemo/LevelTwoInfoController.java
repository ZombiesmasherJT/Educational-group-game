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
 *This class is responsible for generating the information page for level two
 * @author Tedi Mengjezi
 * @author Joshua Tite
 */
public class LevelTwoInfoController {
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
            loadNewStage("levelTwoMenu.fxml", "Hydro Heroes: The Quest for Clean Water"); // Method to load new stage
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
        infoText.setText("In Somalia, only 52% of the population has access to basic water supply,due to the unregulated\n" +
                " and expensive services of private water suppliers. This forces many families to rely  \n" +
                "on distant and unsafe open wells. Open defecation is practiced by 28% of the population, significantly\n" +
                "increasing the risk of contracting preventable diseases such as diarrhea, cholera, and respiratory\n" +
                "infections. In the past three years, over 900 people, mostly children under five, have died from\n" +
                "cholera. Poor water, sanitation, and hygiene conditions also endanger maternal and infant health \n" +
                "during childbirth.\n" +
                "\n" +
                "Access to safe water is further compromised in conflict-affected areas and camps for displaced\n" +
                "people, where damaged infrastructure and poor pipeline conditions prevail. Overcrowded camps\n" +
                "without safe water exacerbate the spread of diseases and malnutrition. UNICEF supports the \n" +
                "Government of Somalia in developing sustainable water supply systems and improving access\n" +
                "to toilets to promote hygiene practices and end open defecation. Efforts are also\n" +
                "made to connect schools to water supplies, ensuring a healthy learning environment.\n" +
                "In health centers, UNICEF ensures the availability of facilities for\n" +
                "hand hygiene and safe disposal of healthcare waste to prevent infections.Through \n" +
                "public-private partnerships, community-led sanitation programs, and emergency responses,\n" +
                "UNICEF works to provide safe drinking water, sanitation services, and hygiene education \n" +
                "to improve the overal health and well-being of the Somali population.\n");
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
