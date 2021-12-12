package Brick.Break.GameBoard;

import Brick.Break.Brick.BrickController;

import java.awt.*;

/**
 * This is the View of Model class(GameBoard class) in the GameBoard MVC Design Pattern.
 */
public class GameBoardView {
    private GameBoardController gameBoardController;
    private PauseMenu pauseMenu;

    /**
     * This is the constructor of "GameBoardView" class.
     * This constructor get the data from the controller class(GameBoardController class).
     * @param gameBoardController This parameter is the object of controller class(GameBoardController class).
     */
    GameBoardView(GameBoardController gameBoardController){
        this.gameBoardController = gameBoardController;
        pauseMenu = new PauseMenu(gameBoardController);
    }

    /**
     * This method draw out all the things to the screen such as the ball, bricks, player ,etc. to the screen
     */
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

    /**
     * This method fill out the background colour of the game.
     */
    private void clear(Graphics2D g2d){
        Color tmp = g2d.getColor();
        g2d.setColor(GameBoardController.getBGColour());
        g2d.fillRect(0,0,gameBoardController.getWidth(),gameBoardController.getHeight());
        g2d.setColor(tmp);
    }

    /**
     * This is a getter method which get the continue button from "PauseMenu" class.
     * @return "continueButtonRect" from "PauseMenu" class.
     */
    public Rectangle getContinueButton(){
        return pauseMenu.getContinueButtonRect();
    }

    /**
     * This is a getter method which get the exit button from "PauseMenu" class.
     * @return "exitButtonRect" from "PauseMenu" class.
     */
    public Rectangle getExitButton(){
        return pauseMenu.getExitButtonRect();
    }

    /**
     * This is a getter method which get the restart button from "PauseMenu" class.
     * @return "restartButtonRect" from "PauseMenu" class.
     */
    public Rectangle getRestartButton(){
        return pauseMenu.getRestartButtonRect();
    }
}
