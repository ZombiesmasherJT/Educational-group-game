package com.example.scenebuilderdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.IOException;

/**
 *This class is responsible launching the application
 * @author Joshua Tite
 * @author Tedi Mengjezi
 */

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainMenu.fxml")); // Loads the FXML file for the main menu
        Scene scene = new Scene(fxmlLoader.load()); // Creates a scene and loads the FXML content into it
        stage.setScene(scene); // Sets the scene for the stage
        stage.setTitle("Hydro Heroes: The Quest for Clean Water"); // Sets the title of the stage
        stage.setResizable(false); // Makes the stage non-resizable
        scene.setFill(Color.TRANSPARENT); // Makes the scene background transparent
        Image icon = new Image("/HydroHarry.png"); // Set the application icon
        stage.getIcons().add(icon);
        stage.show();  // Shows the stage

        String filepath = "gamemusic.wav"; // Plays background music
        Music musicObject = new Music();
        musicObject.playMusic(filepath);
    }

    public static void main(String[] args) {
        launch(); // Launch the JavaFX application


    }
}
