package Brick.Break.GameBoard;

import Brick.Break.Brick.BrickController;

import java.awt.*;

public class GameBoardView {
    private GameBoardController gameBoardController;
    private PauseMenu pauseMenu;

    GameBoardView(GameBoardController gameBoardController){
        this.gameBoardController = gameBoardController;
        pauseMenu = new PauseMenu(gameBoardController);
    }

    public void paint(Graphics g){

        Graphics2D g2d = (Graphics2D) g;

        clear(g2d);

        g2d.setColor(Color.BLUE);
        g2d.drawString( gameBoardController.getControllerMessage(),250,225);

        gameBoardController.getControllerWallController().getWallBallController().renderBall(g2d);

        for(BrickController b :  gameBoardController.getControllerWallController().getWallBricks())
            if(!b.isBroken())
                b.renderBrick(g2d);

        gameBoardController.getControllerWallController().getWallPlayerController().renderPlayer(g2d);

        if(gameBoardController.getControllerShowPauseMenu())
            pauseMenu.drawMenu(g2d);

        Toolkit.getDefaultToolkit().sync();
    }

    private void clear(Graphics2D g2d){
        Color tmp = g2d.getColor();
        g2d.setColor(GameBoardController.getBGColour());
        g2d.fillRect(0,0,gameBoardController.getWidth(),gameBoardController.getHeight());
        g2d.setColor(tmp);
    }

    public Rectangle getContinueButton(){
        return pauseMenu.getContinueButtonRect();
    }
    public Rectangle getExitButton(){
        return pauseMenu.getExitButtonRect();
    }
    public Rectangle getRestartButton(){
        return pauseMenu.getRestartButtonRect();
    }
}
