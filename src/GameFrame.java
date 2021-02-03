import contorller.Controller;
import listener.ScoreListener;
import utils.Constant;
import view.GameZonePanel;
import view.NoticeZonePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener, ScoreListener {

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            GameFrame frame = new GameFrame();
            frame.setVisible(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private GameZonePanel gameZonePanel;
    private NoticeZonePanel noticeZonePanel;
    private Controller controller;
    private JButton buttonStart;
    private JButton buttonPause;
    private JButton buttonContinue;
    private JButton buttonEnd;
    private JLabel labelScore;
    private JLabel labelScoreValue;

    public GameFrame(){
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setLayout(null);
        this.setSize(Constant.GAME_FRAME_WIDTH, Constant.GAME_FRAME_HEIGHT);
        this.setLocationRelativeTo(null);

        noticeZonePanel = new NoticeZonePanel();
        noticeZonePanel.setLocation(
                Constant.NOTICE_ZONE_LOCATION_X_ON_GAME_MAIN_FRAME,
                Constant.NOTICE_ZONE_LOCATION_Y_ON_GAME_MAIN_FRAME);
        noticeZonePanel.setSize(
                Constant.NOTICE_ZONE_WIDTH * Constant.CELL_WIDTH + 5,
                Constant.NOTICE_ZONE_HEIGHT * Constant.CELL_HEIGHT + 5);
        this.getContentPane().add(noticeZonePanel);
        gameZonePanel = new GameZonePanel();
        gameZonePanel.setLocation(
                Constant.GAME_ZONE_LOCATION_X_ON_GAME_MAIN_FRAME,
                Constant.GAME_ZONE_LOCATION_Y_ON_GAME_MAIN_FRAME);
        gameZonePanel.setSize(
                Constant.GAME_ZONE_WIDTH * Constant.CELL_WIDTH + 5,
                Constant.GAME_ZONE_HEIGHT * Constant.CELL_HEIGHT + 5);
        this.getContentPane().add(gameZonePanel);

        controller = new Controller(noticeZonePanel,gameZonePanel);
        controller.addListener(this);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        this.getContentPane().add(jPanel);
        jPanel.setBounds(10,110,80,188);
        buttonStart = new JButton("开始游戏");
        buttonStart.setBounds(0,10,80,25);
        buttonStart.setFont(new Font("黑体", Font.PLAIN,12));
        buttonStart.addActionListener(this);
        buttonStart.setVisible(true);
        buttonStart.setEnabled(true);//这个button生效
        buttonStart.setFocusable(false);

        buttonPause = new JButton("暂停游戏");
        buttonPause.setBounds(0,45,80,25);
        buttonPause.setFont(new Font("黑体", Font.PLAIN,12));
        buttonPause.setVisible(true);
        buttonPause.addActionListener(this);
        buttonPause.setEnabled(false);//这个button生效
        buttonPause.setFocusable(false);

        buttonContinue = new JButton("继续游戏");
        buttonContinue.setBounds(0,45,80,25);
        buttonContinue.setFont(new Font("黑体", Font.PLAIN,12));
        buttonContinue.setVisible(false);
        buttonContinue.addActionListener(this);
        buttonContinue.setEnabled(false);//这个button生效
        buttonContinue.setFocusable(false);

        buttonEnd = new JButton("结束游戏");
        buttonEnd.setBounds(0,80,80,25);
        buttonEnd.setFont(new Font("黑体", Font.PLAIN,12));
        buttonEnd.setVisible(true);
        buttonEnd.addActionListener(this);
        buttonEnd.setEnabled(false);//这个button生效
        buttonEnd.setFocusable(false);

        labelScore = new JLabel("分数：");
        labelScore.setBounds(0,115,80,25);
        labelScoreValue = new JLabel("0");
        labelScoreValue.setForeground(Color.red);
        labelScoreValue.setBounds(0,150,80,25);

        jPanel.add(buttonStart);
        jPanel.add(buttonContinue);
        jPanel.add(buttonPause);
        jPanel.add(buttonEnd);
        jPanel.add(labelScore);
        jPanel.add(labelScoreValue);

        this.setVisible(true);
        this.setFocusable(true);
        this.addKeyListener(controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonStart){
            controller.startGame();
            buttonPause.setEnabled(true);
            buttonPause.setVisible(true);
            buttonContinue.setEnabled(true);
            buttonContinue.setVisible(false);
            buttonEnd.setEnabled(true);
        }else if(e.getSource() == buttonPause){
            controller.pauseGame();
            buttonPause.setVisible(false);
            buttonContinue.setVisible(true);
        }else if(e.getSource() == buttonContinue){
            controller.continueGame();
            buttonContinue.setVisible(false);
            buttonPause.setVisible(true);
        }else if(e.getSource() == buttonEnd){
            controller.endGame();
            buttonPause.setEnabled(false);
            buttonPause.setVisible(true);
            buttonContinue.setEnabled(false);
            buttonContinue.setVisible(false);
            buttonEnd.setEnabled(false);
            labelScoreValue.setText("0");
        }
    }

    @Override
    public void addScore(int score) {
        labelScoreValue.setText(Integer.valueOf(labelScoreValue.getText()) + score + "");
    }
}
