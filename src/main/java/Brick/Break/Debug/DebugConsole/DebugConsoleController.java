package Brick.Break.Debug.DebugConsole;

import Brick.Break.Ball.BallController;
import Brick.Break.Debug.DebugPanel.DebugPanel;
import Brick.Break.Debug.DebugPanel.DebugPanelController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * This is the Controller of Model class(DebugConsole Class) in DebugConsole MVC design pattern
 */
public class DebugConsoleController extends JDialog implements WindowListener {
    DebugConsole debugConsole;

    /**
     * This is the constructor of "DebugConsoleController" class.
     * This constructor will set the default value for the data in model class(DebugPanel class) once it is called by another class.
     * @param debugConsole This parameter is the object of model class(DebugConsole class).
     */
    public DebugConsoleController(DebugConsole debugConsole){
        this.debugConsole = debugConsole;
        initialize();

        debugConsole.setDebugPanelController(new DebugPanelController(new DebugPanel(debugConsole.getWallController())));
        this.add(debugConsole.getDebugPanelController(),BorderLayout.CENTER);
        this.pack();
    }

    /**
     * This method is to initialize the design of the Debug Console Window.
     */
    private void initialize(){
        this.setModal(true);
        this.setTitle(DebugConsole.getTITLE());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.addWindowListener(this);
        this.setFocusable(true);
    }

    /**
     * This method is used to set up the pop-up location of the debug console window in the game.
     */
    private void setLocation(){
        int x = ((debugConsole.getFrameOwner().getWidth() - this.getWidth()) / 2) + debugConsole.getFrameOwner().getX();
        int y = ((debugConsole.getFrameOwner().getHeight() - this.getHeight()) / 2) + debugConsole.getFrameOwner().getY();
        this.setLocation(x,y);
    }


    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    /**
     * This method is when the debug console is closed, the system will redraw out the game.
     * @param windowEvent
     */
    @Override
    public void windowClosing(WindowEvent windowEvent) {
        debugConsole.getGameBoardController().repaint();
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {}

    /**
     * The method activate the debug console.
     */
    @Override
    public void windowActivated(WindowEvent windowEvent) {
        setLocation();
        BallController b = debugConsole.getWallController().getWallBallController();
        debugConsole.getDebugPanelController().setValues(b.getXSpeed(),b.getYSpeed());
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}
