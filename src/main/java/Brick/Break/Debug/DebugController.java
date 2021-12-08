package Brick.Break.Debug;

import Brick.Break.Ball.BallController;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;


public class DebugController extends JPanel {

    private DebugPanel debugModel;


    public DebugController(DebugPanel debugModel){
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

    private void initialize() {
        this.setBackground(debugModel.getBackGroundColour());
        this.setLayout(new GridLayout(2, 2));
    }

    private JButton makeButton(String title, ActionListener e) {
        JButton out = new JButton(title);
        out.addActionListener(e);
        return out;
    }

    private JSlider makeSlider(int min, int max, ChangeListener e) {
        JSlider out = new JSlider(min, max);
        out.setMajorTickSpacing(1);
        out.setSnapToTicks(true);
        out.setPaintTicks(true);
        out.addChangeListener(e);
        return out;
    }

    public void setValues(int x, int y) {
        debugModel.getBallXSpeed().setValue(x);
        debugModel.getBallYSpeed().setValue(y);
    }



}
