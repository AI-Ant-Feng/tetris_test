package entites;

import listener.GameZoneListener;
import utils.Behavior;
import utils.Cell;
import utils.Constant;

import java.awt.*;

public class GameZone extends Zone {

    private boolean isFull;
    private int score;
    private int fullLineFlag = 0;
    private GameZoneListener gameZoneListener;
    private Color barrierColor;

    public GameZone (){
        init();
    }

    public void  init(){
        body = new int[Constant.GAME_ZONE_HEIGHT][Constant.GAME_ZONE_WIDTH];
        super.clearBody();
        isFull = false;
        backGroundColor = Constant.COLOR_LIGHTGRAY;
        gridColor = Constant.COLOR_BLACK;
        barrierColor = Constant.COLOR_DIMGRAY;
        locationX = Constant.GAME_ZONE_X;
        locationY = Constant.GAME_ZONE_Y;
        width = Constant.GAME_ZONE_WIDTH;
        height = Constant.GAME_ZONE_HEIGHT;
    }

    public void setBarrier(Pattern pattern){
        int[][] tmp = pattern.getBlockPattern()[pattern.getDirection()];
        for(int y = tmp.length - 1; y >= 0; y--){
            for(int x = 0; x < tmp[y].length; x++){
                if(tmp[y][x] == 1){
                    if(y + pattern.getGameZonePatternLocationY() < 0){
                        isFull = true;
                        gameZoneListener.gameZoneIsFull();
                        return;
                    }else {
                        this.body[y + pattern.getGameZonePatternLocationY()][x + pattern.getGameZonePatternLocationX()] = tmp[y][x];
                    }
                }
            }
        }
        deleteFullLine();
    }

    private void deleteFullLine() {
        score = 0;
        for(int y = body.length - 1; y >= 0; y--){
            boolean lineIsFull = true;

            for(int x = 0; x < body[y].length; x++){
                if (body[y][x] == 0) {
                    lineIsFull = false;
                    break;
                }
            }

            if(lineIsFull){
                if(fullLineFlag == 0){
                    fullLineFlag = Constant.HOW_LONG_NOTICE_SCORE;//得分以后通知显示的时长
                }
                deleteLine(y++);
                score = score + Constant.SCORE_OF_PRE_FULL_LINE;
            }
        }
        if(fullLineFlag > 0){
            gameZoneListener.removeFullLine(score);
        }
    }

    private void deleteLine(int line) {
//        for(int x = 0; x < body[line].length; x++){
//            body[line][x] = 0;
//        }
        for(int y = line; y >= 0; y--){
            for(int x = 0; x < body[y].length; x++){
                if(y == 0){
                    body[y][x] = 0;
                }else {
                    body[y][x] = body[y - 1][x];
                }
            }
        }
    }

    public boolean isMoveAble(Pattern pattern, Behavior behavior){
        int tmpGameZonePatternLocationX = pattern.getGameZonePatternLocationX();
        int tmpGameZonePatternLocationY = pattern.getGameZonePatternLocationY();
        int tmpDirection = pattern.getDirection();
        int[][][] blockPattern = pattern.getBlockPattern();
        switch (behavior){
            case DOWN:
                tmpGameZonePatternLocationY++;
                break;
            case LEFT:
                tmpGameZonePatternLocationX--;
                break;
            case RIGHT:
                tmpGameZonePatternLocationX++;
                break;
            case ROTATE:
                tmpDirection = (tmpDirection + 1) % blockPattern.length;
                break;
        }
        for(int y = 0; y < blockPattern[tmpDirection].length; y++){
            for(int x = 0; x < blockPattern[tmpDirection][y].length; x++){
                if(blockPattern[tmpDirection][y][x] == 1){
                    if(tmpGameZonePatternLocationX + x < 0 ||
                       tmpGameZonePatternLocationX + x > Constant.GAME_ZONE_WIDTH - 1 ||
                       tmpGameZonePatternLocationY + y > Constant.GAME_ZONE_HEIGHT - 1){
                       return false;
                    }else {
                        if(tmpGameZonePatternLocationY + y >= 0){
                            if(body[tmpGameZonePatternLocationY + y][tmpGameZonePatternLocationX + x] == 1){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void drawZone(Graphics graphics) {
        drawZoneBackgroundColor(graphics);
        for(int y = 0; y < body.length; y++){
            for(int x = 0; x < body[y].length; x++){
                graphics.setColor(gridColor);
                Cell.drawGrid(graphics,
                        locationX + x * Constant.CELL_WIDTH,
                        locationY + y * Constant.CELL_HEIGHT,
                        gridColor);
                if(body[y][x] == 1){
                    graphics.setColor(barrierColor);
                    Cell.drawCell(graphics,
                            locationX + x * Constant.CELL_WIDTH,
                            locationY + y * Constant.CELL_HEIGHT,
                            barrierColor);
                }
            }
        }
        if(fullLineFlag > 0){
            graphics.setColor(Constant.NOTICE_OF_SCORE_FONT_COLOR);
            String string = "恭喜您得分！ " + "+" + score;
            graphics.setFont(new Font("黑体", Font.BOLD, 15));
            FontMetrics fontMetrics = graphics.getFontMetrics();
            graphics.drawString(
                    string,
                    Constant.GAME_ZONE_X + Constant.GAME_ZONE_WIDTH / 2 * Constant.CELL_WIDTH - fontMetrics.stringWidth(string) / 2,
                    Constant.GAME_ZONE_Y  + Constant.GAME_ZONE_HEIGHT / 2 * Constant.CELL_HEIGHT + fullLineFlag * 3 + locationY);
            fullLineFlag-- ;
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public Color getBarrierColor() {
        return barrierColor;
    }

    public void setBarrierColor(Color barrierColor) {
        this.barrierColor = barrierColor;
    }

    public GameZoneListener getGameZoneListener() {
        return gameZoneListener;
    }

    public void setGameZoneListener(GameZoneListener gameZoneListener) {
        this.gameZoneListener = gameZoneListener;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getFullLineFlag() {
        return fullLineFlag;
    }

    public void setFullLineFlag(int fullLineFlag) {
        this.fullLineFlag = fullLineFlag;
    }
}
