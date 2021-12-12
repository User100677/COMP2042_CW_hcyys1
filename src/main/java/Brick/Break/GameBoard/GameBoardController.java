package Brick.Break.GameBoard;

import Brick.Break.Debug.DebugConsole.DebugConsole;
import Brick.Break.Debug.DebugConsole.DebugConsoleController;
import Brick.Break.Wall.Wall;
import Brick.Break.Wall.WallController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBoardController extends JComponent implements KeyListener, MouseListener, MouseMotionListener {
    private GameBoard gameBoardModel;
    private GameBoardView gameBoardView;

    public GameBoardController(GameBoard gameBoardModel){
        super();
        this.gameBoardModel = gameBoardModel;
        gameBoardView = new GameBoardView(this);

        gameBoardModel.setShowPauseMenu(false);
        this.initialize();
        gameBoardModel.setMessage("");
        gameBoardModel.setWallController(new WallController( new Wall(new Rectangle(0,0,GameBoard.getDefWidth(),GameBoard.getDefHeight()),30,3,6/2,new Point(300,430))));
        gameBoardModel.setDebugConsoleController(new DebugConsoleController (new DebugConsole(gameBoardModel.getOwner(), gameBoardModel.getWallController(), this)));

        //initialize the first level
        gameBoardModel.getWallController().getWallLeveProgress().nextLevel();
        gameBoardModel.setGameTimer(new Timer(10,e ->{
            gameBoardModel.getWallController().move();
            gameBoardModel.getWallController().findImpacts();
            gameBoardModel.setMessage(String.format("Bricks: %d Balls %d",gameBoardModel.getWallController().getWallBrickAmount().getBrickCount(),gameBoardModel.getWallController().getWallBallAmount().getBallCount()));
            if(gameBoardModel.getWallController().getWallBallAmount().isBallLost()){
                if(gameBoardModel.getWallController().getWallBallAmount().ballEnd()){
                    gameBoardModel.getWallController().wallReset();
                    gameBoardModel.setMessage( "Game over");
                }
                gameBoardModel.getWallController().ballReset();
                gameBoardModel.getGameTimer().stop();
            }
            else if(gameBoardModel.getWallController().getWallBrickAmount().isDone()){
                if(gameBoardModel.getWallController().getWallLeveProgress().hasLevel()){
                    gameBoardModel.setMessage( "Go to Next Level");
                    gameBoardModel.getGameTimer().stop();
                    gameBoardModel.getWallController().ballReset();
                    gameBoardModel.getWallController().wallReset();
                    gameBoardModel.getWallController().getWallLeveProgress().nextLevel();
                }
                else{
                   gameBoardModel.setMessage("ALL WALLS DESTROYED");
                   gameBoardModel.getGameTimer().stop();
                }
            }

            repaint();
        }));
    }

    private void initialize(){
        this.setPreferredSize(new Dimension(GameBoard.getDefWidth(),GameBoard.getDefHeight()));
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void paint(Graphics g){
        gameBoardView.paint(g);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch(keyEvent.getKeyCode()){
            case KeyEvent.VK_A:
                gameBoardModel.getWallController().getWallPlayerController().moveLeft();
                break;
            case KeyEvent.VK_D:
                gameBoardModel.getWallController().getWallPlayerController().moveRight();
                break;
            case KeyEvent.VK_ESCAPE:
                gameBoardModel.setShowPauseMenu(!gameBoardModel.getShowPauseMenu());
                repaint();
                gameBoardModel.getGameTimer().stop();
                break;
            case KeyEvent.VK_SPACE:
                if(!gameBoardModel.getShowPauseMenu())
                    if(gameBoardModel.getGameTimer().isRunning())
                        gameBoardModel.getGameTimer().stop();
                    else
                        gameBoardModel.getGameTimer().start();
                break;
            case KeyEvent.VK_F1:
                if(keyEvent.isAltDown() && keyEvent.isShiftDown())
                    gameBoardModel.getDebugConsoleController().setVisible(true);
            default:
                gameBoardModel.getWallController().getWallPlayerController().stop();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        gameBoardModel.getWallController().getWallPlayerController().stop();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(!gameBoardModel.getShowPauseMenu())
            return;
        if(gameBoardView.getContinueButton().contains(p)){
            gameBoardModel.setShowPauseMenu(false);
            repaint();
        }
        else if(gameBoardView.getRestartButton().contains(p)){
            gameBoardModel.setMessage("Restarting Game...");
            gameBoardModel.getWallController().ballReset();
            gameBoardModel.getWallController().wallReset();
            gameBoardModel.setShowPauseMenu(false);
            repaint();
        }
        else if(gameBoardView.getExitButton().contains(p)){
            System.exit(0);
        }

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(gameBoardView.getExitButton() != null && gameBoardModel.getShowPauseMenu()) {
            if (gameBoardView.getExitButton().contains(p) || gameBoardView.getRestartButton().contains(p) ||gameBoardView.getContinueButton().contains(p))
                this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            else
                this.setCursor(Cursor.getDefaultCursor());
        }
        else{
            this.setCursor(Cursor.getDefaultCursor());
        }
    }

    public void onLostFocus(){
        gameBoardModel.getGameTimer().stop();
        gameBoardModel.setMessage("Focus Lost");
        repaint();
    }
    public String getControllerMessage(){
        return gameBoardModel.getMessage();
    }
    public WallController getControllerWallController(){
        return gameBoardModel.getWallController();
    }
    public boolean getControllerShowPauseMenu(){
        return gameBoardModel.getShowPauseMenu();
    }
    public static Color getBGColour(){
        return GameBoard.getBackGroundColour();
    }



}

