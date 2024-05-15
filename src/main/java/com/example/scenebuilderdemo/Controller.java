package com.example.scenebuilderdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Controller {
    private Stage stage;
    private Scene scene;

    public void switchToLevelSelectPage(ActionEvent event) throws IOException {
        loadFXML("levelSelect.fxml", event);
    }

    public void switchToHelpPage(ActionEvent event) throws IOException {
        loadFXML("helpPage.fxml", event);
    }

    public void switchToMainPage(ActionEvent event) throws IOException {
        loadFXML("mainPage.fxml", event);
    }

    public void switchToLevelOneMenu(ActionEvent event) throws IOException {
        loadFXML("levelOneMenu.fxml", event);
    }
    public void switchToLevelTwoMenu(ActionEvent event) throws IOException {
        loadFXML("levelTwoMenu.fxml", event);
    }
    public void switchToLevelThreeMenu(ActionEvent event) throws IOException {
        loadFXML("levelThreeMenu.fxml", event);
    }
    public void switchToWorkInProgress(ActionEvent event) throws IOException {
        loadFXML("workInProgressFile.fxml", event);
    }
    private void loadFXML(String fxmlFileName, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFileName)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
