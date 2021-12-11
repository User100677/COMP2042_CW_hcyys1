package Brick.Break.Ball.RubberBall;

import Brick.Break.Ball.BallController;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * This is the Controller of Model class(Rubber Ball Class) in RubberBall MVC design pattern
 * This class extends from "Ball" class.
 */
public class RubberBallController extends BallController {

    private RubberBall rubberBallModel;


    /**
     * This is the constructor of "RubberBallController" class.
     * This constructor will set the default value for the data in model class(RubberBall class) once it is called by another class.
     * @param rubberBallModel This parameter is the object of model class(RubberBall class).
     */
    public RubberBallController(RubberBall rubberBallModel){
        super(rubberBallModel);
        this.rubberBallModel = rubberBallModel;
    }


    /**
     * This method is used to create the rubber ball.
     * This method come from the super class and is implemented here.
     * @param center  This parameter is the position of the rubber ball.
     * @param radiusA This parameter is the radius of the rubber ball.
     * @param radiusB This parameter is the radius of the rubber ball.
     * @return
     */
    @Override
    public Shape makeBall(Point2D center, int radiusA, int radiusB) {

        double x = center.getX() - (radiusA / 2);
        double y = center.getY() - (radiusB / 2);
        return new Ellipse2D.Double(x,y,radiusA,radiusB);

    }


}
