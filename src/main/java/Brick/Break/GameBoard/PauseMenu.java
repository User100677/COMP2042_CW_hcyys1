package Brick.Break.GameBoard;

import java.awt.*;
import java.awt.font.FontRenderContext;

/**
 * This class draw out the pause menu page.
 * The method in this class was extracted from the "GameBoard" class.
 */
public class PauseMenu {
    private static final String CONTINUE = "Continue";
    private static final String RESTART = "Restart";
    private static final String EXIT = "Exit";
    private static final String PAUSE = "Pause Menu";
    private static final int TEXT_SIZE = 30;
    private static final Color MENU_COLOR = new Color(0,255,0);

    private Font menuFont;

    private Rectangle continueButtonRect;
    private Rectangle exitButtonRect;
    private Rectangle restartButtonRect;
    private int strLen;

    private GameBoardController gameBoardController;

    /**
     * This is the constructor of "PauseMenu" class.
     * This constructor initializes the font of the text in the pause menu screen when it is called by another class.
     * @param gameBoardController This parameter is the object of "gameBoardController" class.
     */
    PauseMenu (GameBoardController gameBoardController){
        this.gameBoardController = gameBoardController;
        menuFont = new Font("Monospaced",Font.PLAIN,TEXT_SIZE);
        strLen = 0;
    }

    /**
     * This method draw out the whole pause menu screen.
     */
    public void drawMenu(Graphics2D g2d){
        obscureGameBoard(g2d);
        drawPauseMenu(g2d);
    }

    /**
     * This method shade the background of the pause menu to black.
     */
    private void obscureGameBoard(Graphics2D g2d){

        Composite tmp = g2d.getComposite();
        Color tmpColor = g2d.getColor();

        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.55f);
        g2d.setComposite(ac);

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,600,450);

        g2d.setComposite(tmp);
        g2d.setColor(tmpColor);
    }

    /**
     * This method draw out the text and button to the pause menu screen.
     */
    private void drawPauseMenu(Graphics2D g2d){
        Font tmpFont = g2d.getFont();
        Color tmpColor = g2d.getColor();


        g2d.setFont(menuFont);
        g2d.setColor(MENU_COLOR);

        if(strLen == 0){
            FontRenderContext frc = g2d.getFontRenderContext();
            strLen = menuFont.getStringBounds(PAUSE,frc).getBounds().width;
        }

        int x = (gameBoardController.getWidth() - strLen) / 2;
        int y = gameBoardController.getHeight() / 10;

        g2d.drawString(PAUSE,x,y);

        x = gameBoardController.getWidth() / 8;
        y = gameBoardController.getHeight() / 4;


        if(continueButtonRect == null){
            FontRenderContext frc = g2d.getFontRenderContext();
            continueButtonRect = menuFont.getStringBounds(CONTINUE,frc).getBounds();
            continueButtonRect.setLocation(x,y-continueButtonRect.height);
        }

        g2d.drawString(CONTINUE,x,y);

        y *= 2;

        if(restartButtonRect == null){
            restartButtonRect = (Rectangle) continueButtonRect.clone();
            restartButtonRect.setLocation(x,y-restartButtonRect.height);
        }

        g2d.drawString(RESTART,x,y);

        y *= 3.0/2;

        if(exitButtonRect == null){
            exitButtonRect = (Rectangle) continueButtonRect.clone();
            exitButtonRect.setLocation(x,y-exitButtonRect.height);
        }

        g2d.drawString(EXIT,x,y);



        g2d.setFont(tmpFont);
        g2d.setColor(tmpColor);
    }


    public Rectangle getContinueButtonRect(){
        return continueButtonRect;
    }
    public Rectangle getExitButtonRect(){
        return exitButtonRect;
    }
    public Rectangle getRestartButtonRect(){
        return restartButtonRect;
    }
}
