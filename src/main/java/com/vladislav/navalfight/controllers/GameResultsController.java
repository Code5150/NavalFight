package com.vladislav.navalfight.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.rmi.RemoteException;

public class GameResultsController {
    @FXML
    private Label title, shotsValue, targetsValue, hitMissValue;

    public void initialize() throws RemoteException {
        var calc = RmiController.getServerMethods();
        if (calc.allTargetsHit()) {
            title.setText("Вы победили!");
        }
        else {
            title.setText("Вы проиграли!");
        }
        shotsValue.setText(Integer.toString(calc.shotsTotal()));
        targetsValue.setText(Integer.toString(calc.targetsDestroyed()));
        hitMissValue.setText(calc.hitMissPercent() + "%");
    }

    @FXML
    public void menuButtonClicked() {
        System.out.println("Menu Button clicked!");
        try {
            SceneController.toMainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
