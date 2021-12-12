package Brick.Break.Debug.DebugPanel;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This is the Controller of Model class(DebugPanel Class) in DebugPanel MVC design pattern
 */
public class DebugPanelController extends JPanel {

    private DebugPanel debugModel;

    /**
     * This is the constructor of "DebugPanelController" class.
     * This constructor will set the default value for the data in model class(DebugPanel class) once it is called by another class.
     * This constructor will set the buttons and sliders jobs once it is called by another class.
     * @param debugModel This parameter is the object of model class(DebugPanel class).
     */
    public DebugPanelController(DebugPanel debugModel){
        this.debugModel = debugModel;


        initialize();
        debugModel.setSkipLevel(makeButton("Skip Level", e -> debugModel.getWallController().getWallLeveProgress().nextLevel()));
        debugModel.setResetBalls(makeButton("Reset Balls", e ->  debugModel.getWallController().getWallBallAmount().resetBallCount()));

        debugModel.setBallXSpeed(makeSlider(-4, 4, e -> debugModel.getWallController().setBallXSpeed(debugModel.getBallXSpeed().getValue())));
        debugModel.setBallYSpeed(makeSlider(-4, 4, e -> debugModel.getWallController().setBallYSpeed(debugModel.getBallYSpeed().getValue())));

        this.add(debugModel.getSkipLevel());
        this.add(debugModel.getResetBalls());

        this.add(debugModel.getBallXSpeed());
        this.add(debugModel.getBallYSpeed());
    }

    /**
     * This method is to initialize the design of the Panel.
     */
    private void initialize() {
        this.setBackground(debugModel.getBackGroundColour());
        this.setLayout(new GridLayout(2, 2));
    }

    /**
     * This method is used to create button for the debug panel.
     * @param title Name of the button
     * @param e Function of the button.
     */
    private JButton makeButton(String title, ActionListener e) {
        JButton out = new JButton(title);
        out.addActionListener(e);
        return out;
    }

    /**
     * This method is used to create slider for the debug panel.
     * @param min minimum speed.
     * @param max maximum speed.
     * @param e Function of the button.
     */
    private JSlider makeSlider(int min, int max, ChangeListener e) {
        JSlider out = new JSlider(min, max);
        out.setMajorTickSpacing(1);
        out.setSnapToTicks(true);
        out.setPaintTicks(true);
        out.addChangeListener(e);
        return out;
    }

    /**
     * This method is used to set the speed of the ball.
     * @param x ball X speed.
     * @param y ball Y speed.
     */
    public void setValues(int x, int y) {
        debugModel.getBallXSpeed().setValue(x);
        debugModel.getBallYSpeed().setValue(y);
    }



}
