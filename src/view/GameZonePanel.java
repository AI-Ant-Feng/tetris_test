package view;

import contorller.Controller;
import entites.Pattern;
import entites.GameZone;
import utils.Constant;
import utils.GameState;
import utils.MessageDisplayEffect;

import javax.swing.*;
import java.awt.*;

public class GameZonePanel extends JPanel {
    private Image image;
    private Graphics graphics;

    public void redisplay(Pattern pattern, GameZone gameZone){
        if(image == null){
            image = createImage(getWidth(), getHeight());
        }else {
            graphics = image.getGraphics();
            if(gameZone != null){
                gameZone.drawZone(graphics);
            }
            if(pattern != null){
                pattern.drawGameZonePattern(graphics);
            }
            if(Controller.gameState == GameState.INIT){
                int flag = MessageDisplayEffect.sway();
                graphics.setColor(Constant.COLOR_OF_WELCOM_INFO);
                graphics.setFont(Constant.FONT_OF_WELCOME_INFO);
                graphics.drawString(Constant.WELCOME_INFO, flag * Constant.WELCOME_INFO_LOCATION_X_STEP + Constant.WELCOME_INFO_LOCATION_X_BLANK, Constant.WELCOME_INFO_LOCATION_Y);
            }
        }
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        if(image != null){
            graphics.drawImage(image, 0, 0 , this);
        }
    }
}
