package com.example.scenebuilderdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

/**
 *This is the main class which launches the application
 * @author Tedi Mengjezi
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainPage.fxml"))); // Loads the FXML file for the main page
        stage.setTitle("Hydro Heroes: The Quest for Clean Water"); // Sets the stage properties
        stage.setResizable(false);
        Scene scene = new Scene(root); // Creates and sets the scene
        stage.setScene(scene);
        stage.show(); // Shows the stage
    }
    public static void main(String[] args) { // Method which launches the main application
        launch(args);
    }
}