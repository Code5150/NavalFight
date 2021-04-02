package com.vladislav.navalfight.controllers;

import com.vladislav.navalfight.view.NavalFightGrid;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;

public class GameFieldController {
    @FXML
    private Button menuButton;
    @FXML
    private NavalFightGrid gameGrid;
    @FXML
    private VBox gridContainer;

    public void initialize(){
        gameGrid.setWidth(300);
        gameGrid.setHeight(300);

        gameGrid.setStyle("-fx-border-color: black; -fx-border-width: 3;");
        gridContainer.setMaxWidth(300);
        var gc = gameGrid.getGraphicsContext2D();
        doDrawing(gc);
    }

    private void doDrawing(GraphicsContext gc) {

        gc.setStroke(Color.FORESTGREEN.brighter());
        gc.setLineWidth(5);
        gc.strokeOval(30, 30, 80, 80);
        gc.setFill(Color.FORESTGREEN);
        gc.fillOval(130, 30, 80, 80);
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
