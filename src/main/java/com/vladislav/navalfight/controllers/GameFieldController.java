package com.vladislav.navalfight.controllers;

import com.vladislav.navalfight.view.FieldCell;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class GameFieldController {
    @FXML
    private Button menuButton;
    @FXML
    private VBox gridContainer;
    @FXML
    private TilePane gameTiles;
    @FXML
    private Label shotsLeft, shipsShot;

    private static int size = 10;
    private static final int gap = 1;
    private static final double cellDim = 20;

    public static void setSize(int size) {
        GameFieldController.size = size;
    }

    private final Rectangle[][] tilesArray = new Rectangle[size][size];

    public void initialize(){
        /*gameGrid.setWidth(300);
        gameGrid.setHeight(300);

        gameGrid.setStyle("-fx-border-color: black; -fx-border-width: 3;");
        gridContainer.setMaxWidth(300);
        var gc = gameGrid.getGraphicsContext2D();
        doDrawing(gc);*/
        gameTiles.setPrefColumns(size);
        gameTiles.setPrefColumns(size);
        gameTiles.setVgap(gap);
        gameTiles.setHgap(gap);

        gridContainer.setMaxWidth((size+1)*(cellDim + gap));
        gridContainer.setPrefHeight((size+1)*(cellDim + gap));

        for (int i = 0; i < tilesArray.length; i++){
            for (int j = 0; j < tilesArray[i].length; j++){
                tilesArray[i][j] = new FieldCell(cellDim, cellDim, Color.GRAY.darker(), i, j);
                gameTiles.getChildren().add(tilesArray[i][j]);
            }
        }
    }

    /*private void doDrawing(GraphicsContext gc) {
        //Круги
        *//*gc.setStroke(Color.FORESTGREEN.brighter());
        gc.setLineWidth(5);
        gc.strokeOval(30, 30, 80, 80);
        gc.setFill(Color.FORESTGREEN);
        gc.fillOval(130, 30, 80, 80);*//*
        gc.setFill(Color.GRAY);
        gc.setStroke(Color.FORESTGREEN.brighter());
        gc.setLineWidth(2);
        gc.beginPath();
        gc.moveTo(30.5, 30.5);
        gc.lineTo(150.5, 30.5);
        gc.lineTo(150.5, 150.5);
        gc.lineTo(30.5, 30.5);
        gc.stroke();
    }

    private void drawGrid(GraphicsContext gc) {

    }*/

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
