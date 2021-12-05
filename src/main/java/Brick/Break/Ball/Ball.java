package Brick.Break.Ball;
import Brick.Break.Attribute.Move;
import Brick.Break.Attribute.Speed;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

/**
 * Created by filippo on 04/09/16.
 *
 */
public abstract class Ball extends Speed{

    private Shape ballFace;

    private Point2D center;

    private Point2D up;
    private Point2D down;
    private Point2D left;
    private Point2D right;

    private int speedX  = 0;
    private int speedY = 0;




    /**
     * This constructor is to initialize the default ball placement.
     */
    public Ball(Point2D center,int radiusA,int radiusB,Color inner,Color border){
        this.center = center;

        up = new Point2D.Double();
        down = new Point2D.Double();
        left = new Point2D.Double();
        right = new Point2D.Double();

        up.setLocation(center.getX(),center.getY()-(radiusB / 2));
        down.setLocation(center.getX(),center.getY()+(radiusB / 2));

        left.setLocation(center.getX()-(radiusA /2),center.getY());
        right.setLocation(center.getX()+(radiusA /2),center.getY());

        ballFace = makeBall(center,radiusA,radiusB);

        setBorderColour(border);
        setInnerColour(inner);
        setXSpeed(speedX);
        setXSpeed(speedY);
    }


    public abstract Shape makeBall(Point2D center, int radiusA, int radiusB);




    public Point2D getPosition(){
        return center;
    }

    public Shape getBallFace()  {
        return ballFace;
    }

    public void setBallFace(Shape ballFace){
        this.ballFace = ballFace;
    }

    public Point2D getUp(){
        return up;
    }

    public Point2D getDown(){
        return down;
    }
    public Point2D getLeft(){
        return left;
    }
    public Point2D getRight(){
        return right;
    }



}
