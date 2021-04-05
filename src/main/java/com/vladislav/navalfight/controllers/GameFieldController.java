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
import java.rmi.RemoteException;

public class GameFieldController {
    @FXML
    private VBox gridContainer;
    @FXML
    private TilePane gameTiles;
    @FXML
    private Label shotsNum, targetsHitNum;

    private static int size = 10;
    private static final int gap = 1;
    private static final double cellDim = 20;

    public static void setSize(int size) {
        GameFieldController.size = size;
    }

    private final Rectangle[][] tilesArray = new Rectangle[size][size];

    public void initialize() throws RemoteException {
        gameTiles.setPrefColumns(size);
        gameTiles.setPrefColumns(size);
        gameTiles.setVgap(gap);
        gameTiles.setHgap(gap);

        double dim = (size+1)*(cellDim + gap);

        gridContainer.setMaxWidth(dim);
        gridContainer.setPrefHeight(dim);

        System.out.println(dim + 100);

        SceneController.getAppStage().setWidth(dim + 200);
        SceneController.getAppStage().setHeight(dim + 150);

        FieldCell.setShots(shotsNum);
        FieldCell.setTargets(targetsHitNum);

        shotsNum.setText(Integer.toString(RmiController.getServerMethods().shotsNum()));
        targetsHitNum.setText("0");

        for (int i = 0; i < tilesArray.length; i++){
            for (int j = 0; j < tilesArray[i].length; j++){
                tilesArray[i][j] = new FieldCell(cellDim, cellDim, Color.GRAY.darker(), i, j);
                gameTiles.getChildren().add(tilesArray[i][j]);
            }
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
