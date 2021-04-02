package com.vladislav.navalfight.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Rectangle;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NavalFightGrid extends Canvas {
    private double cellSize;
    private double borderWidth;
    private int cellNum;
    private Rectangle[][] cells;

    public NavalFightGrid(){
        super();
    }

    public NavalFightGrid(double width, double height, double cellSize, double borderWidth, int cellNum) {
        super(width, height);
        this.cellSize = cellSize;
        this.borderWidth = borderWidth;
        this.cellNum = cellNum;
        this.cells = new Rectangle[cellNum][cellNum];
    }

    public double getCanvasSize(){
        return cellSize*cellNum + borderWidth*(cellNum-1);
    }


}
