package Brick.Break.Ball;

import java.awt.*;

/**
 * This is the View of Model class(Ball class) in the Ball MVC Design Pattern.
 */
public class BallView {
    private BallController ballController;

    /**
     * This is the constructor of "BallView" class.
     * This constructor get the data from the controller class(BallController class).
     * @param ballController This parameter is the object of controller class(BallController class).
     */
    BallView(BallController ballController){
        this.ballController = ballController;
    }

    /**
     * This method draw out the ball.
     */
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
