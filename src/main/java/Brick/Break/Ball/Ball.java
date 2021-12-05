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
public abstract class Ball extends Speed implements Move {

    private Shape ballFace;

    private Point2D center;

    public Point2D up;
    public Point2D down;
    public Point2D left;
    public Point2D right;

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


    abstract Shape makeBall(Point2D center,int radiusA,int radiusB);

    @Override
    public void move(){
        RectangularShape tmp = (RectangularShape) ballFace;
        center.setLocation((center.getX() + getSpeedX()),(center.getY() + getSpeedY()));
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((center.getX() -(w / 2)),(center.getY() - (h / 2)),w,h);
        setPoints(w,h);


        ballFace = tmp;
    }



    public Point2D getPosition(){
        return center;
    }

    public void setBallFace(Shape ballFace){
        this.ballFace = ballFace;
    }

    public Shape getBallFace()  {
        return ballFace;
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

    public void moveTo(Point p){
        center.setLocation(p);

        RectangularShape tmp = (RectangularShape) ballFace;
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((center.getX() -(w / 2)),(center.getY() - (h / 2)),w,h);
        ballFace = tmp;
    }

    private void setPoints(double width,double height){
        up.setLocation(center.getX(),center.getY()-(height / 2));
        down.setLocation(center.getX(),center.getY()+(height / 2));

        left.setLocation(center.getX()-(width / 2),center.getY());
        right.setLocation(center.getX()+(width / 2),center.getY());
    }

}
