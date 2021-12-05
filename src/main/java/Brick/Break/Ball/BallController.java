package Brick.Break.Ball;

import Brick.Break.Attribute.Move;

import java.awt.*;
import java.awt.geom.RectangularShape;

public class BallController implements Move {

    private Ball ball;

    BallController(Ball ball){
        this.ball = ball;
    }

    @Override
    public void move(){
        RectangularShape tmp = (RectangularShape) ball.getBallFace();
        ball.getPosition().setLocation((ball.getPosition().getX() + ball.getSpeedX()),(ball.getPosition().getY() + ball.getSpeedY()));
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((ball.getPosition().getX() -(w / 2)),(ball.getPosition().getY() - (h / 2)),w,h);
        setPoints(w,h);


        ball.setBallFace(tmp) ;
    }

    public void moveTo(Point p){
        ball.getPosition().setLocation(p);

        RectangularShape tmp = (RectangularShape) ball.getBallFace();
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame(( ball.getPosition().getX() -(w / 2)),( ball.getPosition().getY() - (h / 2)),w,h);
        ball.setBallFace(tmp);
    }

    private void setPoints(double width,double height){
        ball.getUp().setLocation(ball.getPosition().getX(),ball.getPosition().getY()-(height / 2));
        ball.getDown().setLocation(ball.getPosition().getX(),ball.getPosition().getY()+(height / 2));

        ball.getLeft().setLocation(ball.getPosition().getX()-(width / 2),ball.getPosition().getY());
        ball.getRight().setLocation(ball.getPosition().getX()+(width / 2),ball.getPosition().getY());
    }
}
