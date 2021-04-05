package com.vladislav.navalfight.view;

import com.vladislav.navalfight.controllers.RmiController;
import com.vladislav.navalfight.controllers.SceneController;
import com.vladislav.navalfight.server.FightCalculations;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

@EqualsAndHashCode(callSuper = true)
public class FieldCell extends Rectangle {
    private boolean hit;
    private final int coordX;
    private final int coordY;
    private static final FightCalculations fightCalculations = RmiController.getServerMethods();

    @Getter
    @Setter
    private static Label shots, targets;

    public FieldCell(double w, double h, Paint p, int x, int y){
        super(w, h, p);
        this.hit = false;
        this.coordX = x;
        this.coordY = y;
        setOnMouseClicked(e -> {
            System.out.println("Tile " + coordX + ", " + coordY + " clicked");
            if(!this.hit) {
                makeTurn();
            }
        });
        setOnMouseEntered(e -> setFill(((Color) getFill()).brighter()));
        setOnMouseExited(e -> setFill(((Color) getFill()).darker()));
    }

    private void makeTurn() {
        if(!this.hit) {
            this.hit = true;
            try {
                boolean targetHit = fightCalculations.makeTurn(coordX, coordY);
                if(targetHit) {
                    setFill(Color.RED);
                } else {
                    setFill(Color.BLUE);
                }
                shots.setText(Integer.toString(fightCalculations.shotsNum()));
                targets.setText(Integer.toString(fightCalculations.targetsDestroyed()));
                if (fightCalculations.shotsNum() == 0 || fightCalculations.allTargetsHit()) {
                    var timer = new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {
                            Thread.sleep(500);
                            return null;
                        }
                    };
                    timer.setOnSucceeded((event) -> {
                        try {
                            SceneController.toGameResults();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    new Thread(timer).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
