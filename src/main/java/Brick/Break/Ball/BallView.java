package Brick.Break.Ball;

import java.awt.*;

public class BallView {
    private BallController ballController;

    BallView(BallController ballController){
        this.ballController = ballController;
    }

    public void drawBall( Graphics2D g2d){
        Color tmp = g2d.getColor();

        Shape s = ballController.getFaceBall();

        g2d.setColor(ballController.getBallInnerColour());
        g2d.fill(s);

        g2d.setColor(ballController.getBallBorderColour());
        g2d.draw(s);

        g2d.setColor(tmp);
    }
}
