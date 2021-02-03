package entites;

import utils.Cell;
import utils.Constant;

import java.awt.*;

public class NoticeZone extends Zone{
    public NoticeZone(){
        init();
    }
    public void init(){
        body = new int[Constant.NOTICE_ZONE_HEIGHT][Constant.NOTICE_ZONE_WIDTH];
        super.clearBody();
        backGroundColor = Constant.COLOR_LIGHTGRAY;
        gridColor = Constant.COLOR_BLACK;
        locationX = Constant.NOTICE_ZONE_X;
        locationY = Constant.NOTICE_ZONE_Y;
        width = Constant.NOTICE_ZONE_WIDTH;
        height = Constant.NOTICE_ZONE_HEIGHT;
    }

    @Override
    public void drawZone(Graphics graphics){
        drawZoneBackgroundColor(graphics);
        for(int y = 0; y < body.length; y++){
            for(int x = 0; x < body[y].length; x++){
                graphics.setColor(gridColor);
                Cell.drawGrid(
                        graphics,
                        locationX + x * Constant.CELL_WIDTH,
                        locationY + y * Constant.CELL_HEIGHT,
                        gridColor);
            }
        }
    }
}
