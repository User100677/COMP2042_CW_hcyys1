package Brick.Break.Ball;

import Brick.Break.Attribute.Move;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

public abstract class BallController implements Move {
    private Ball ballModel;
    private BallView ballView;

    public BallController(Ball ballModel){
        this.ballModel = ballModel;
        ballView = new BallView(this);
        ballModel.setUp(new Point2D.Double());
        ballModel.setDown(new Point2D.Double());
        ballModel.setLeft(new Point2D.Double());
        ballModel.setRight(new Point2D.Double());

        ballModel.getUp().setLocation(ballModel.getCenter().getX(), ballModel.getCenter().getY()-(ballModel.getRadiusB()/2) );
        ballModel.getDown().setLocation(ballModel.getCenter().getX(), ballModel.getCenter().getY()+(ballModel.getRadiusB()/2) );
        ballModel.getLeft().setLocation(ballModel.getCenter().getX() - (ballModel.getRadiusA())/2, ballModel.getCenter().getY() );
        ballModel.getRight().setLocation(ballModel.getCenter().getX() + (ballModel.getRadiusA())/2, ballModel.getCenter().getY());

        ballModel.setBallFace(makeBall(ballModel.getCenter(), ballModel.getRadiusA(), ballModel.getRadiusB()));
        ballModel.setInnerColour(ballModel.getInColour());
        ballModel.setBorderColour(ballModel.getOutColour());

        ballModel.setXSpeed(ballModel.getXS());
        ballModel.setYSpeed(ballModel.getYS());

    }

    public abstract Shape makeBall(Point2D center, int radiusA, int radiusB);


    @Override
    public void move(){
        RectangularShape tmp = (RectangularShape) ballModel.getBallFace();
        ballModel.getPosition().setLocation((ballModel.getPosition().getX() + ballModel.getSpeedX()),(ballModel.getPosition().getY() + ballModel.getSpeedY()));
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((ballModel.getPosition().getX() -(w / 2)),(ballModel.getPosition().getY() - (h / 2)),w,h);
        setPoints(w,h);


        ballModel.setBallFace(tmp);
    }

    public void moveTo(Point p){
        ballModel.getPosition().setLocation(p);

        RectangularShape tmp = (RectangularShape) ballModel.getBallFace();
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((ballModel.getPosition().getX() -(w / 2)),(ballModel.getPosition().getY() - (h / 2)),w,h);
        ballModel.setBallFace(tmp);
    }

    public   void setPoints(double width,double height){
        ballModel.getUp().setLocation(ballModel.getPosition().getX(),ballModel.getPosition().getY()-(height / 2));
        ballModel.getDown().setLocation(ballModel.getPosition().getX(),ballModel.getPosition().getY()+(height / 2));

        ballModel.getLeft().setLocation(ballModel.getPosition().getX()-(width / 2),ballModel.getPosition().getY());
        ballModel.getRight().setLocation(ballModel.getPosition().getX()+(width / 2),ballModel.getPosition().getY());
    }

    public Point2D getBallPosition(){
        return ballModel.getPosition();
    }

    public Shape getFaceBall()  {
        return ballModel.getBallFace();
    }

    public Point2D getBallUp(){
        return ballModel.getUp();
    }

    public Point2D getBallDown(){
        return ballModel.getDown();
    }
    public Point2D getBallLeft(){
        return ballModel.getLeft();
    }
    public Point2D getBallRight(){
        return ballModel.getRight();
    }

    public void ReverseY(){
        ballModel.reverseY();
    }

    public void ReverseX(){
        ballModel.reverseX();
    }

    public void setSPEED(int x, int y){
        ballModel.setSpeed(x,y);
    }

    public void setSpeedX(int x){
        ballModel.setXSpeed(x);
    }

    public void setSpeedY(int y){
        ballModel.setYSpeed(y);
    }

    public int getXSpeed(){
        return ballModel.getSpeedX();
    }

    public int getYSpeed(){
        return ballModel.getSpeedY();
    }

    public Color getBallInnerColour(){
        return ballModel.getInnerColour();
    }

    public Color getBallBorderColour(){
        return ballModel.getBorderColour();
    }

    public void renderBall(Graphics2D g2d){

        ballView.drawBall(g2d);

    }
}
