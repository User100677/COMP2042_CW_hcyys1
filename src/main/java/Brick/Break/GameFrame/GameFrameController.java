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

public class GameFrameController extends JFrame implements WindowFocusListener {
    private GameFrame gameFrameModel;

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

    public void initialize(){
        this.setTitle(GameFrame.getDefTitle());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.autoLocate();
        this.setVisible(true);
    }

    public void enableGameBoard(){
        this.dispose();
        this.remove(gameFrameModel.getHomeMenuController());
        this.add(gameFrameModel.getGameBoardController(), BorderLayout.CENTER);
        this.setUndecorated(false);
        initialize();
        /*to avoid problems with graphics focus controller is added here*/
        this.addWindowFocusListener(this);

    }

    public void openInstructionMenu(){
        this.dispose();
        this.remove(gameFrameModel.getHomeMenuController());
        this.add(gameFrameModel.getInstructionMenuController(),BorderLayout.CENTER);
        this.setUndecorated(false);
        initialize();
        this.addWindowFocusListener(this);

    }
    public void openMainMenu(){
        this.dispose();
        this.remove(gameFrameModel.getInstructionMenuController());
        this.add(gameFrameModel.getHomeMenuController(),BorderLayout.CENTER);
        this.setUndecorated(false);
        initialize();
        this.addWindowFocusListener(this);

    }

    private void autoLocate(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (size.width - this.getWidth()) / 2;
        int y = (size.height - this.getHeight()) / 2;
        this.setLocation(x,y);
    }


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

    @Override
    public void windowLostFocus(WindowEvent windowEvent) {
        if(gameFrameModel.getGaming())
            gameFrameModel.getGameBoardController().onLostFocus();

    }
}
