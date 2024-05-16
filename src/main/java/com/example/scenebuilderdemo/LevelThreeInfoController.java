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
 *This class is responsible for generating the information page for level three
 * @author Tedi Mengjezi
 * @author Jordan Meecham
 */
public class LevelThreeInfoController {
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
            loadNewStage("levelThreeMenu.fxml", "Hydro Heroes: The Quest for Clean Water"); // Method to load new stage
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
    private void loadInfo() { // Method which loads the information into the TextArea
        infoText.setText("In Chad, access to basic drinking water services is only at 43%, and access to sanitation is even lower at 10%.\n" +
                "Less than half of the children have access to safe drinking water, and only one in ten has access to \n" +
                "improved sanitation. Additionally,only one in 17 children wash their hands with soap and water.\n" +
                "The national open defecation rate stands at a staggering 68%. The lack of adequate water\n" +
                ",sanitation, and hygiene services results in frequent diarrheal diseases and malnutrition, particularly\n" +
                "chronic malnutrition among young children. To combat these issues, the Government of Chad adopted the\n" +
                "National Strategy for Sanitation (NSS) in 2017 and the roadmap for a Chad free from open defecation by\n" +
                "2030. The national roadmap aims to target 9.5 million Chadians at a cost of $160 million, with the first\n" +
                "phase costing $17 million.\n" +
                "\n" +
                "UNICEF has been pivotal in supporting Chad's progress in creating a more enabling environment for Community\n" +
                "Led Total Sanitation (CLTS). The initial phase targeted 3 million people in 8 priority provinces, and 68,000\n" +
                "people have already been supported to live in open defecation-free (ODF) communities. Due to slow progress\n" +
                "from a lack of a common approach, a district-wide approach has been adopted, integrating CLTS with\n" +
                "nutrition and education sectors. UNICEF supports the Directorate of Sanitation with a monitoring mechanism\n" +
                "to inform decision-making and maintain behavior change post-ODF. UNICEF aims to directly support an\n" +
                "additional 1.4 million people by 2021. Alongside WASH initiatives,UNICEF has implemented child\n" +
                "protection measures\n" +
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
