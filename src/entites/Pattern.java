package entites;

import utils.Cell;
import utils.Constant;

import java.awt.*;

public class Pattern {

    private int[][][] blockPattern;
    private Color color;
    private int direction;

    public Pattern(int[][][] blockPattern, int direction, Color color) {
        this.blockPattern = blockPattern;
        this.direction = direction;
        this.color = color;
        init();
    }

    private int gameZonePatternLocationX;
    private int gameZonePatternLocationY;
    private int noticeZonePatternLocationX;
    private int noticeZonePatternLocationY;
    private int speed;
    private int patternWidth;
    private int patternHeight;

    private void setPatternWidthAndHeight(){
        patternHeight = 0;
        patternWidth = 0;
        int temp = 0;
        for(int y = 0; y < blockPattern[direction].length; y++){
            for(int x = 0; x < blockPattern[direction][y].length; x++){
                if(blockPattern[direction][y][x] == 1){
                    patternHeight = y + 1;
                    temp = x + 1;
                    patternWidth = Math.max(patternWidth, temp);
                }
            }

        }
    }

    private void init(){
        setPatternWidthAndHeight();
        gameZonePatternLocationX = Constant.GAME_ZONE_WIDTH / 2 - 2;
        gameZonePatternLocationY = Constant.GAME_ZONE_TOP - patternHeight;
        speed = Constant.DOWN_SPEED;
        noticeZonePatternLocationX = Constant.NOTICE_ZONE_X + (Constant.NOTICE_ZONE_WIDTH - patternWidth) / 2 * Constant.CELL_WIDTH;
        noticeZonePatternLocationY = Constant.NOTICE_ZONE_Y + (Constant.NOTICE_ZONE_HEIGHT - patternHeight) / 2 * Constant.CELL_HEIGHT;
    }

    public void rotatePattern(){
        direction = (direction + 1) % blockPattern.length;
        setPatternWidthAndHeight();
    }

    public void moveDown(){
        gameZonePatternLocationY++;
    }

    public void moveLeft(){
        gameZonePatternLocationX--;
    }

    public void moveRight(){
        gameZonePatternLocationX++;
    }

    public void drawGameZonePattern(Graphics graphics){
        for(int y = 0; y < blockPattern[direction].length; y++){
            for(int x = 0; x < blockPattern[direction][y].length; x++){
                if(blockPattern[direction][y][x] == 1){
                    Cell.drawCell(
                            graphics,
                            Constant.GAME_ZONE_X + (gameZonePatternLocationX + x) * Constant.CELL_WIDTH,
                            Constant.GAME_ZONE_Y  + (gameZonePatternLocationY + y) * Constant.CELL_HEIGHT,
                            color);
                }
            }
        }
    }

    public void drawNoticeZonePattern(Graphics graphics){
        for(int y = 0; y < blockPattern[direction].length; y++){
            for(int x = 0; x < blockPattern[direction][y].length; x++){
                if(blockPattern[direction][y][x] == 1){
                    Cell.drawCell(
                            graphics,
                             noticeZonePatternLocationX + x * Constant.CELL_WIDTH,
                             noticeZonePatternLocationY + y * Constant.CELL_HEIGHT,
                            color);
                }
            }
        }
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int[][][] getBlockPattern() {
        return blockPattern;
    }

    public void setBlockPattern(int[][][] blockPattern) {
        this.blockPattern = blockPattern;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getGameZonePatternLocationX() {
        return gameZonePatternLocationX;
    }

    public void setGameZonePatternLocationX(int gameZonePatternLocationX) {
        this.gameZonePatternLocationX = gameZonePatternLocationX;
    }

    public int getGameZonePatternLocationY() {
        return gameZonePatternLocationY;
    }

    public void setGameZonePatternLocationY(int gameZonePatternLocationY) {
        this.gameZonePatternLocationY = gameZonePatternLocationY;
    }

    public int getNoticeZonePatternLocationX() {
        return noticeZonePatternLocationX;
    }

    public void setNoticeZonePatternLocationX(int noticeZonePatternLocationX) {
        this.noticeZonePatternLocationX = noticeZonePatternLocationX;
    }

    public int getNoticeZonePatternLocationY() {
        return noticeZonePatternLocationY;
    }

    public void setNoticeZonePatternLocationY(int noticeZonePatternLocationY) {
        this.noticeZonePatternLocationY = noticeZonePatternLocationY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPatternWidth() {
        return patternWidth;
    }

    public void setPatternWidth(int patternWidth) {
        this.patternWidth = patternWidth;
    }

    public int getPatternHeight() {
        return patternHeight;
    }

    public void setPatternHeight(int patternHeight) {
        this.patternHeight = patternHeight;
    }
}
