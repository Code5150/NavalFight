package com.vladislav.navalfight.view;

import com.vladislav.navalfight.controllers.SceneController;
import com.vladislav.navalfight.rmi.TurnData;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.rmi.RemoteException;

@EqualsAndHashCode(callSuper = true)
@Data
public class FieldCell extends Rectangle {
    private boolean target;
    private boolean hit;
    private int coordX;
    private int coordY;

    public FieldCell(double w, double h, Paint p, int x, int y){
        super(w, h, p);
        this.hit = false;
        this.coordX = x;
        this.coordY = y;
        setOnMouseClicked(e -> {
            System.out.println("Tile " + coordX + ", " + coordY + " clicked");
        });
        setOnMouseEntered(e -> {
            setFill(((Color) getFill()).brighter());
        });
        setOnMouseExited(e -> {
            setFill(((Color) getFill()).darker());
        });
    }

    private void makeTurn() {
        var turnData = new TurnData(coordX, coordY, target, hit);
        try {
            var result = SceneController.getServerMethods().makeTurn(turnData);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
