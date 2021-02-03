package view;

import entites.Pattern;
import entites.NoticeZone;

import javax.swing.*;
import java.awt.*;

public class NoticeZonePanel extends JPanel {
    private Image image;
    private Graphics graphics;
    public void redisplay(Pattern nextPattern, NoticeZone noticeZone){
        if(image == null){
            image = createImage(getWidth(), getHeight());
        }else {
            graphics = image.getGraphics();
            if(noticeZone != null){
                noticeZone.drawZone(graphics);
            }
            if(nextPattern != null){
                nextPattern.drawNoticeZonePattern(graphics);
            }
        }
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        if(image != null){
            graphics.drawImage(image,0,0,this);
        }
    }
}
