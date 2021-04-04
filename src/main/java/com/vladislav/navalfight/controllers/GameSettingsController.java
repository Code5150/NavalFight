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
    private Slider sizeSlider, shotsSlider, ships4Slider, ships3Slider, ships2Slider, ships1Slider;
    @FXML
    private Label sizeValue, shotsValue, ships4Value, ships3Value, ships2Value, ships1Value;

    private final int SMALL_SHIP1_NUM = 4;
    private final int SMALL_SHIP2_NUM = 3;
    private final int SMALL_SHIP3_NUM = 2;
    private final int SMALL_SHIP4_NUM = 1;

    private final int MID_FIELD_SIZE = 15;
    private final int MID_SHIP1_NUM = 5;
    private final int MID_SHIP2_NUM = 4;
    private final int MID_SHIP3_NUM = 3;
    private final int MID_SHIP4_NUM = 2;

    private final int LARGE_FIELD_SIZE = 25;
    private final int LARGE_SHIP1_NUM = 6;
    private final int LARGE_SHIP2_NUM = 5;
    private final int LARGE_SHIP3_NUM = 4;
    private final int LARGE_SHIP4_NUM = 3;

    public void initialize() {
        sizeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() >= LARGE_FIELD_SIZE) {
                ships4Slider.setMax(LARGE_SHIP4_NUM);
                ships3Slider.setMax(LARGE_SHIP3_NUM);
                ships2Slider.setMax(LARGE_SHIP2_NUM);
                ships1Slider.setMax(LARGE_SHIP1_NUM);
                shotsSlider.setMin(LARGE_SHIP1_NUM + LARGE_SHIP2_NUM*2 + LARGE_SHIP3_NUM*3 + LARGE_SHIP4_NUM*4);
            } else if (newValue.intValue() >= MID_FIELD_SIZE) {
                ships4Slider.setMax(MID_SHIP4_NUM);
                ships3Slider.setMax(MID_SHIP3_NUM);
                ships2Slider.setMax(MID_SHIP2_NUM);
                ships1Slider.setMax(MID_SHIP1_NUM);
                shotsSlider.setMin(MID_SHIP1_NUM + MID_SHIP2_NUM*2 + MID_SHIP3_NUM*3 + MID_SHIP4_NUM*4);
            } else {
                ships4Slider.setMax(SMALL_SHIP4_NUM);
                ships3Slider.setMax(SMALL_SHIP3_NUM);
                ships2Slider.setMax(SMALL_SHIP2_NUM);
                ships1Slider.setMax(SMALL_SHIP1_NUM);
                shotsSlider.setMin(SMALL_SHIP1_NUM + SMALL_SHIP2_NUM*2 + SMALL_SHIP3_NUM*3 + SMALL_SHIP4_NUM*4);
            }
            sizeValue.setText(Integer.toString(newValue.intValue()));
        });
        shotsSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            shotsValue.setText(Integer.toString(newValue.intValue()));
        });
        ships1Slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            ships1Value.setText(Integer.toString(newValue.intValue()));
        });
        ships2Slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            ships2Value.setText(Integer.toString(newValue.intValue()));
        });
        ships3Slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            ships3Value.setText(Integer.toString(newValue.intValue()));
        });
        ships4Slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (!(newValue.intValue() <= 0)) ships4Value.setText(Integer.toString(newValue.intValue()));
            else ships4Slider.setValue(ships4Slider.getMin());
        });
        //System.out.println(ships4Slider.getMin());
        shotsSlider.setBlockIncrement(1d);
    }

    @FXML
    public void gameButtonClicked() {
        System.out.println("Game Button clicked!");
        try {
            System.out.println("Ships4: " + ships4Slider.valueProperty().intValue());
            System.out.println("Ships3: " + ships3Slider.valueProperty().intValue());
            System.out.println("Ships2: " + ships2Slider.valueProperty().intValue());
            System.out.println("Ships1: " + ships1Slider.valueProperty().intValue());
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
