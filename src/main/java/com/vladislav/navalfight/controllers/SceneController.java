package com.vladislav.navalfight.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SceneController {
    protected static Stage appStage;

    public static Stage getAppStage() {
        return appStage;
    }
    public static void setAppStage(Stage appStage) {
        SceneController.appStage = appStage;
    }

    public static void toMainMenu() throws IOException {
        var xmlUrl = SceneController.class.getResource("/scenes/MainMenu.fxml");
        loadScene(xmlUrl);
    }
    public static void toGameSettings() throws IOException {
        var xmlUrl = SceneController.class.getResource("/scenes/GameSettings.fxml");
        loadScene(xmlUrl);
    }

    public static void toGameField() throws IOException {}

    public static void toGameResults() throws IOException {}

    private static void loadScene(URL xmlUrl) throws IOException {
        var loader = new FXMLLoader();
        loader.setLocation(xmlUrl);
        Parent root = loader.load();
        appStage.setScene(new Scene(root));
        appStage.show();
    }
}
