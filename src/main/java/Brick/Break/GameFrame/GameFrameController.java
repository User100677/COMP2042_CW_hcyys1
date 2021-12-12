package Brick.Break.GameFrame;

import Brick.Break.GameBoard.GameBoard;
import Brick.Break.GameBoard.GameBoardController;
import Brick.Break.MenuPage.HomeMenu.HomeMenu;
import Brick.Break.MenuPage.HomeMenu.HomeMenuController;
import Brick.Break.MenuPage.InstructionMenu.InstructionMenu;
import Brick.Break.MenuPage.InstructionMenu.InstructionMenuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

/**
 * This is the Controller of Model class(GameFrame Class) in GameFrame MVC design pattern
 */
public class GameFrameController extends JFrame implements WindowFocusListener {
    private GameFrame gameFrameModel;

    /**
     * This is the constructor of "GameFrameController" class.
     * This constructor will set the default value for the data in model class(GameFrame class) once it is called by another class.
     * @param gameFrameModel This parameter is the object of model class(GameFrame class).
     */
    public GameFrameController(GameFrame gameFrameModel){
        super();
        this.gameFrameModel = gameFrameModel;

        gameFrameModel.setGaming(false);
        this.setLayout(new BorderLayout());

        gameFrameModel.setGameBoardController(new GameBoardController(new GameBoard(this)));
        gameFrameModel.setHomeMenuController(new HomeMenuController(new HomeMenu(this,new Dimension(450,300))));
        gameFrameModel.setInstructionMenuController(new InstructionMenuController( new InstructionMenu(this, new Dimension(450,300))));
        this.add(gameFrameModel.getHomeMenuController(),BorderLayout.CENTER);

        this.setUndecorated(true);

    }


    /**
     * This method initialize the function and design of the frame of the game.
     */
    public void initialize(){
        this.setTitle(GameFrame.getDefTitle());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.autoLocate();
        this.setVisible(true);
    }

    /**
     * This method is used to open the game screen when the player clicked the start button in the home menu screen.
     */
    public void enableGameBoard(){
        this.dispose();
        this.remove(gameFrameModel.getHomeMenuController());
        this.add(gameFrameModel.getGameBoardController(), BorderLayout.CENTER);
        this.setUndecorated(false);
        initialize();
        /*to avoid problems with graphics focus controller is added here*/
        this.addWindowFocusListener(this);

    }

    /**
     * This method is used to open the instruction menu screen when the player clicked the instruction button in the home menu screen.
     */
    public void openInstructionMenu(){
        this.dispose();
        this.remove(gameFrameModel.getHomeMenuController());
        this.add(gameFrameModel.getInstructionMenuController(),BorderLayout.CENTER);
        this.setUndecorated(false);
        initialize();
        this.addWindowFocusListener(this);

    }

    /**
     * This method is used to open the home menu screen when the player clicked the back button in the instruction menu screen.
     */
    public void openMainMenu(){
        this.dispose();
        this.remove(gameFrameModel.getInstructionMenuController());
        this.add(gameFrameModel.getHomeMenuController(),BorderLayout.CENTER);
        this.setUndecorated(false);
        initialize();
        this.addWindowFocusListener(this);

    }

    /**
     * This method set the location of the game window in your computer.
     */
    private void autoLocate(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (size.width - this.getWidth()) / 2;
        int y = (size.height - this.getHeight()) / 2;
        this.setLocation(x,y);
    }


    /**
     * This method is make window gain focus when the player clicked inside the game window.
     */
    @Override
    public void windowGainedFocus(WindowEvent windowEvent) {
        /*
            the first time the frame loses focus is because
            it has been disposed to install the GameBoard,
            so went it regains the focus it's ready to play.
            of course calling a method such as 'onLostFocus'
            is useful only if the GameBoard as been displayed
            at least once
         */
        gameFrameModel.setGaming(true);
    }

    /**
     * This method is make window lose focus and print out "Lost focus" message when the player clicked outside the game window.
     */
    @Override
    public void windowLostFocus(WindowEvent windowEvent) {
        if(gameFrameModel.getGaming())
            gameFrameModel.getGameBoardController().onLostFocus();

    }
}
