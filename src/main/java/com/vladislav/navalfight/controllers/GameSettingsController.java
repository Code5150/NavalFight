package com.vladislav.navalfight.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.io.IOException;

public class GameSettingsController {
    @FXML
    private Button gameButton, menuButton;
    @FXML
    private Slider sizeSlider, shotsSlider;
    @FXML
    private Label sizeValue, shotsValue;

    public void initialize() {
        sizeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            sizeValue.setText(Integer.toString(newValue.intValue()));
        });
        shotsSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            shotsValue.setText(Integer.toString(newValue.intValue()));
        });
        shotsSlider.setBlockIncrement(1d);
    }

    @FXML
    public void gameButtonClicked() {
        System.out.println("Game Button clicked!");
        try {
            SceneController.toGameField();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void menuButtonClicked() {
        System.out.println("Menu Button clicked!");
        try {
            SceneController.toMainMenu();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
