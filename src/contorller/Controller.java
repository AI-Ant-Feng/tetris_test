package contorller;

import entites.Pattern;
import entites.GameZone;
import entites.NoticeZone;
import entites.PatternFactory;
import listener.GameZoneListener;
import listener.KeyboardListener;
import listener.ScoreListener;
import utils.Behavior;
import utils.Constant;
import utils.GameState;
import view.GameZonePanel;
import view.NoticeZonePanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter implements KeyboardListener, GameZoneListener, Runnable{


    private GameZonePanel gameZonePanel;
    private NoticeZonePanel noticeZonePanel;

    public Controller(NoticeZonePanel noticeZonePanel, GameZonePanel gameZonePanel) {
        this.gameZonePanel = gameZonePanel;
        this.noticeZonePanel = noticeZonePanel;
        init();
    }

    public static GameState gameState;
    private GameZone gameZone;
    private NoticeZone noticeZone;

    private void init(){
        noticeZone = new NoticeZone();
        gameZone = new GameZone();
        gameZone.setGameZoneListener(this);
        gameState = GameState.INIT;
        new Thread(this).start();
    }

    private Pattern gameZonePattern;
    private Pattern noticeZonePattern;
    private void clear(){
        gameZonePattern = null;
        noticeZonePattern = null;
    }

    public void startGame(){
        clear();
        gameZonePattern = PatternFactory.creatBlockPattern();
        noticeZonePattern = PatternFactory.creatBlockPattern();
        noticeZone.init();
        gameZone.init();
        gameState = GameState.PLAYING;
    }
    //暂停游戏
    public void pauseGame()
    {
        gameState = GameState.PAUSE;
    }
    //继续游戏
    public void continueGame()
    {
        gameState = GameState.PLAYING;
    }
    //结束游戏
    public void endGame()
    {
        clear();
        gameState = GameState.INIT;
    }

    private void proNewPattern(){
        gameZonePattern = noticeZonePattern;
        noticeZonePattern = PatternFactory.creatBlockPattern();
    }

    private int speed = 0;
    private void flush(){
        switch (gameState){
            case INIT:
            case PAUSE:
                gameZonePanel.redisplay(gameZonePattern,gameZone);
                gameZonePanel.repaint();
                noticeZonePanel.redisplay(noticeZonePattern, noticeZone);
                noticeZonePanel.repaint();
                break;
            case PLAYING:
                if(speed == Constant.DOWN_SPEED - 1){
                    if(gameZone.isMoveAble(gameZonePattern, Behavior.DOWN)){
                        gameZonePattern.moveDown();
                    }else {
                        gameZone.setBarrier(gameZonePattern);
                        if(!gameZone.isFull()){
                            proNewPattern();
                        }
                    }
                }
                speed = (++speed) % Constant.DOWN_SPEED;
                gameZonePanel.redisplay(gameZonePattern, gameZone);
                gameZonePanel.repaint();
                noticeZonePanel.redisplay(noticeZonePattern, noticeZone);
                noticeZonePanel.repaint();
                break;
            case FAIL:
                gameZonePanel.redisplay(null, gameZone);
                gameZonePanel.repaint();
                noticeZonePanel.redisplay(noticeZonePattern, noticeZone);
                noticeZonePanel.repaint();
                break;
        }
    }

    @Override
    public void gameZoneIsFull() {
        gameState = GameState.FAIL;
    }

    private ScoreListener scoreListener;
    @Override
    public void removeFullLine(int score) {
        scoreListener.addScore(score);
    }

    @Override
    public void run() {
        while(true){
            flush();
            try{
                Thread.sleep(Constant.SLEEP_TIME);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(gameState == GameState.PLAYING){
            switch (e.getKeyCode()){
                case KeyEvent.VK_UP :
                    if(gameZone.isMoveAble(gameZonePattern, Behavior.ROTATE)){
                        gameZonePattern.rotatePattern();
                    }
                    break;
                case KeyEvent.VK_DOWN :
                    if(gameZone.isMoveAble(gameZonePattern, Behavior.DOWN)){
                        gameZonePattern.moveDown();
                    }
                    break;
                case KeyEvent.VK_LEFT :
                    if(gameZone.isMoveAble(gameZonePattern, Behavior.LEFT)){
                        gameZonePattern.moveLeft();
                    }
                    break;
                case KeyEvent.VK_RIGHT :
                    if(gameZone.isMoveAble(gameZonePattern, Behavior.RIGHT)){
                        gameZonePattern.moveRight();
                    }
                    break;
            }
        }
    }

    public void addListener(ScoreListener scoreListener){
        this.scoreListener = scoreListener;
    }
}
