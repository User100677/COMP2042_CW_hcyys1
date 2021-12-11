package Brick.Break.Ball;
import Brick.Break.Attribute.Speed;

import java.awt.*;
import java.awt.geom.Point2D;


/**
 *This the Model of Ball in the Ball MVC design pattern.
 * This class extends from "Speed" abstract class.
 */
public class Ball extends Speed{

    private Shape ballFace;

    private Point2D center;

    private Point2D up;
    private Point2D down;
    private Point2D left;
    private Point2D right;

    private int speedX  = 0;
    private int speedY = 0;
    private int radiusA;
    private int radiusB;
    private Color inner;
    private Color border;




    /**
     * This is the constructor of "Ball" class.
     * This constructor holds the data that required initialization once its object is created.
     * @param center This parameter is the position of the ball.
     * @param radiusA This parameter is the radius of the ball.
     * @param radiusB This parameter is the radius of the ball.
     * @param inner This parameter is the inner colour of the ball.
     * @param border This parameter is the border colour of the ball.
     */
    public Ball(Point2D center,int radiusA,int radiusB,Color inner,Color border){
        this.center = center;
        this.radiusA =radiusA;
        this.radiusB = radiusB;
        this.inner = inner;
        this.border = border;
    }






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

    public void setUp(Point2D up){
        this.up = up;
    }

    public Point2D getDown(){
        return down;
    }

    public void setDown(Point2D down){
        this.down = down;
    }
    public Point2D getLeft(){
        return left;
    }

    public void setLeft(Point2D left){
        this.left = left;
    }
    public Point2D getRight(){
        return right;
    }
    public void setRight(Point2D right){
        this.right = right;
    }

    public int getRadiusA(){
        return radiusA;
    }

    public int getRadiusB(){
        return radiusB;
    }

    public Color getInColour(){
        return inner;

    }

    public Color getOutColour(){
        return border;
    }

    public int getXS(){
        return speedX;
    }

    public int getYS(){
        return speedY;
    }



}
