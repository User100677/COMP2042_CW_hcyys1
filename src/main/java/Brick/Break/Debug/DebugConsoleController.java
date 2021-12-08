package Brick.Break.Debug;

import Brick.Break.Ball.BallController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DebugConsoleController extends JDialog implements WindowListener {
    DebugConsole debugConsole;
    public DebugConsoleController(DebugConsole debugConsole){
        this.debugConsole = debugConsole;
        initialize();

        debugConsole.setDebugPanelController(new DebugPanelController(new DebugPanel(debugConsole.getWallController())));
        this.add(debugConsole.getDebugPanelController(),BorderLayout.CENTER);
        this.pack();
    }

    private void initialize(){
        this.setModal(true);
        this.setTitle(DebugConsole.getTITLE());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.addWindowListener(this);
        this.setFocusable(true);
    }

    private void setLocation(){
        int x = ((debugConsole.getFrameOwner().getWidth() - this.getWidth()) / 2) + debugConsole.getFrameOwner().getX();
        int y = ((debugConsole.getFrameOwner().getHeight() - this.getHeight()) / 2) + debugConsole.getFrameOwner().getY();
        this.setLocation(x,y);
    }


    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

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
