package com.vladislav.navalfight.controllers;

import com.vladislav.navalfight.MainMenu;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController{

    @FXML
    private Button settingsButton;
    @FXML
    private Button exitButton;

    @FXML
    public void settingsButtonClicked() {
        System.out.println("Settings Button clicked!");
        try {
            SceneController.toGameSettings();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exitButtonClicked() {
        System.out.println("Exit Button clicked!");
        Platform.exit();
        System.exit(0);
    }
}
