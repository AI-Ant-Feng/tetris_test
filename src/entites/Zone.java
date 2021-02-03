package entites;

import utils.Constant;

import java.awt.*;

public abstract class Zone {

    /**
     * 抽象出子类共有的成员变量,由子类去初始化(即由子类决定样式).
     */
    protected Color backGroundColor;
    protected int locationX;
    protected int locationY;
    protected int width;//单位：格.每格20像素.
    protected int height;//单位：格.每格20像素.
    protected int[][] body;
    protected Color gridColor;

    protected void drawZoneBackgroundColor(Graphics graphics){
        graphics.setColor(backGroundColor);
        graphics.fillRect(
                locationX,
                locationY,
                width * Constant.CELL_WIDTH,
                height * Constant.CELL_HEIGHT);
    }

    protected void clearBody(){
        for(int x = 0; x < body.length; x++){
            for(int y = 0; y < body[x].length; y++){
                body[x][y] = 0;
            }
        }
    }

    public abstract void drawZone(Graphics graphics);
}
