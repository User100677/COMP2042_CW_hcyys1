package Brick.Break.Ball;

import java.awt.*;

public class BallView {
    private Ball ballModel;

    BallView(Ball ballModel){
        this.ballModel = ballModel;
    }

    public void drawBall(Ball ballModel, Graphics2D g2d){
        Color tmp = g2d.getColor();

        Shape s = ballModel.getBallFace();;

        g2d.setColor(ballModel.getInnerColour());
        g2d.fill(s);

        g2d.setColor(ballModel.getBorderColour());
        g2d.draw(s);

        g2d.setColor(tmp);
    }
}
