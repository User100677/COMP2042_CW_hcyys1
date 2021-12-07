package Brick.Break.Ball.RubberBall;

import Brick.Break.Ball.Ball;
import Brick.Break.Ball.BallController;
import Brick.Break.Ball.RubberBall.RubberBall;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class RubberBallController extends BallController {

    private RubberBall rubberBallModel;

    public RubberBallController(RubberBall rubberBallModel){
        super(rubberBallModel);
        this.rubberBallModel = rubberBallModel;
    }

    @Override
    public Shape makeBall(Point2D center, int radiusA, int radiusB) {

        double x = center.getX() - (radiusA / 2);
        double y = center.getY() - (radiusB / 2);

        return new Ellipse2D.Double(x,y,radiusA,radiusB);
    }


}
