package utils;

import java.awt.*;
import java.util.Random;

public class Constant {

    public static final Color COLOR_RED = new Color(0xFF0000);//红色
    public static final Color COLOR_ORANGE = new Color(0xFFA500);//橙色
    public static final Color COLOR_YELLOW= new Color(0xFFFF00);//黄色
    public static final Color COLOR_GREEN = new Color(0x008000);//绿色
    public static final Color COLOR_YELLOWGREEN  = new Color(0x9ACD32);//黄绿
    public static final Color COLOR_BLUE = new Color(0x0000FF);//蓝色
    public static final Color COLOR_PURPLE= new Color(0x800080);//紫色
    public static final Color COLOR_BROWN = new Color(0xA52A2A);//棕色
    public static final Color COLOR_PINK = new Color(0xFFC0CB);//粉红
    public static final Color COLOR_DEEPPINK  = new Color(0xFF1493);//深粉红
    public static final Color COLOR_GRAY = new Color(0x808080);//灰色
    public static final Color COLOR_LIGHTGRAY = new Color(0xDCDCDC);//浅灰色
    public static final Color COLOR_DIMGRAY = new Color(0x696969);//暗灰色
    public static final Color COLOR_WHITE = new Color(0xFFFFFF);//白色
    public static final Color COLOR_BLACK = new Color(0x000000);//黑色
    public static final Color NOTICE_OF_SCORE_FONT_COLOR = COLOR_RED;
    public static final Color COLOR_OF_WELCOM_INFO = COLOR_RED;
    public static final long SLEEP_TIME = 100;

    private static Random random = new Random();
    private static final Color[] Block_COLORS = {
            COLOR_RED,
            COLOR_YELLOW,
            COLOR_PINK,
            COLOR_ORANGE,
            COLOR_GREEN,
            COLOR_BLUE,
            COLOR_PURPLE,
            COLOR_YELLOWGREEN,
            COLOR_DEEPPINK,
            COLOR_BROWN
    };
    public static Color getRandomColor() {
        int colorIndex = random.nextInt(10);
        return Block_COLORS[colorIndex];
    }

    public static final int GAME_ZONE_WIDTH = 15;
    public static final int GAME_ZONE_HEIGHT = 20;
    public static final int GAME_ZONE_X = 0;
    public static final int GAME_ZONE_Y = 0;
    public static final int GAME_ZONE_LOCATION_X_ON_GAME_MAIN_FRAME = 105;
    public static final int GAME_ZONE_LOCATION_Y_ON_GAME_MAIN_FRAME = 10;
    public static final int NOTICE_ZONE_WIDTH = 4;
    public static final int NOTICE_ZONE_HEIGHT = 4;
    public static final int NOTICE_ZONE_X = 0;
    public static final int NOTICE_ZONE_Y = 0;
    public static final int NOTICE_ZONE_LOCATION_X_ON_GAME_MAIN_FRAME = 10;
    public static final int NOTICE_ZONE_LOCATION_Y_ON_GAME_MAIN_FRAME = 10;
    public static final int CELL_WIDTH = 20;
    public static final int CELL_HEIGHT = 20;
    public static final int GAME_ZONE_TOP = 0;
    public static final int DOWN_SPEED = 6;
    public static final int HOW_LONG_NOTICE_SCORE = 7;//得分以后通知显示的时长
    public static final int SCORE_OF_PRE_FULL_LINE = 100;

    public static final String WELCOME_INFO = "欢迎来到俄罗斯方块世界！";
    public static final Font FONT_OF_WELCOME_INFO = new Font("黑体",Font.PLAIN,15);
    public static final int WELCOME_INFO_LOCATION_X_BLANK = 20;
    public static final int WELCOME_INFO_LOCATION_X_STEP = 6;
    public static final int WELCOME_INFO_LOCATION_Y = 100;

    public static final int GAME_FRAME_WIDTH = 422;
    public static final int GAME_FRAME_HEIGHT = 450;
}
