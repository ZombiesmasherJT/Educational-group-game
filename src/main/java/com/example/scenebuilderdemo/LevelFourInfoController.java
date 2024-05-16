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
 *This class is responsible for generating the information page for level four
 * @author Tom Sammon
 * @author Jordan Meecham
 */
public class LevelFourInfoController {
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
            loadNewStage("levelFourMenu.fxml", "Hydro Heroes: The Quest for Clean Water"); // Method to load new stage
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
        infoText.setText("The Democratic Republic of Congo (DRC) holds over 50% of Africa’s water reserves, yet 33 million people\n" +
                "in rural areas still lack access to quality water. Currently, only 52% of the population has access to an\n" +
                "improved water source, and merely 29% have improved sanitation facilities. Chronic malnutrition affects\n" +
                "43% of children under five, largely due to inadequate access to safe drinking water, sanitation, and\n" +
                "hygiene practices. Access to safe water and proper sanitation can prevent many waterborne diseases.\n" +
                " However, ongoing conflicts in several provinces exacerbate the spread of such diseases as large\n" +
                "movements of displaced populations increase the pressure on limited water \n" +
                "resources in host communities. \n" +
                "\n" +
                "Despite sustained efforts, the lack of access to quality water and sanitation services continues\n" +
                "to impact the health and well-being of the population. UNICEF is working to improve these conditions\n" +
                "by supporting initiatives that provide safe drinking water, improved sanitation facilities,\n" +
                "and promote basic hygiene practices. The arrival of displaced people in areas with already low access\n" +
                "to drinking water further strains available resources, necessitating coordinated efforts to enhance\n" +
                "water and sanitation infrastructure. By addressing these critical needs, UNICEF aims to reduce the\n" +
                "incidence of waterborne diseases and improve the overall health and nutritional status of children\n" +
                "in the DRC.\n" +
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
