package utils;

import java.awt.*;

public class Cell {

    public static void drawCell(Graphics graphics, int px, int py, Color color){
        graphics.setColor(color);
        graphics.fillRect(
                px,
                py,
                Constant.CELL_WIDTH,
                Constant.CELL_HEIGHT);
        graphics.setColor(Constant.COLOR_WHITE);
        graphics.drawRect(
                px,
                py,
                Constant.CELL_WIDTH - 1,
                Constant.CELL_HEIGHT - 1);
    }

    public static void drawGrid(Graphics graphics, int px, int py, Color color){
        graphics.setColor(color);
        graphics.drawRect(
                px,
                py,
                Constant.CELL_WIDTH,
                Constant.CELL_HEIGHT);
    }
}
