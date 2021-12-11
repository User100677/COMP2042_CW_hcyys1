package Brick.Break.Ball;

import Brick.Break.Attribute.Move;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

/**
 * This is the Controller of Model class(Ball Class) in Ball MVC design pattern
 * This is an abstract class.
 * This class implement the methods from "Move" interface class.
 */
public abstract class BallController implements Move {
    private Ball ballModel;
    private BallView ballView;

    /**
     * This is the constructor of "BallController" class.
     * This constructor will set the default value for the data in Ball model once it is called by another class.
     * @param ballModel This parameter is the object of model class(Ball class).
     */
    public BallController(Ball ballModel){
        this.ballModel = ballModel;
        ballView = new BallView(this);
        ballModel.setUp(new Point2D.Double());
        ballModel.setDown(new Point2D.Double());
        ballModel.setLeft(new Point2D.Double());
        ballModel.setRight(new Point2D.Double());

        ballModel.getUp().setLocation(ballModel.getPosition().getX(), ballModel.getPosition().getY()-(ballModel.getRadiusB()/2));
        ballModel.getDown().setLocation(ballModel.getPosition().getX(), ballModel.getPosition().getY()+(ballModel.getRadiusB()/2));
        ballModel.getLeft().setLocation(ballModel.getPosition().getX() - (ballModel.getRadiusA())/2, ballModel.getPosition().getY());
        ballModel.getRight().setLocation(ballModel.getPosition().getX() + (ballModel.getRadiusA())/2, ballModel.getPosition().getY());

        ballModel.setBallFace(makeBall(ballModel.getPosition(), ballModel.getRadiusA(), ballModel.getRadiusB()));
        ballModel.setInnerColour(ballModel.getInColour());
        ballModel.setBorderColour(ballModel.getOutColour());

        ballModel.setXSpeed(ballModel.getXS());
        ballModel.setYSpeed(ballModel.getYS());

    }

    /**
     * This is an abstract method which is used to create the ball.
     * This method will be implemented by the child class.
     * @param center This parameter is the position of the ball.
     * @param radiusA This parameter is the radius of the ball.
     * @param radiusB This parameter is the radius of the ball.
     */
    public abstract Shape makeBall(Point2D center, int radiusA, int radiusB);


    /**
     * This method is used to make the ball start moving whenever the player start the game.
     */
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

    /**
     * This method is used to move the ball to a specific place.
     * @param p This parameter is the point where the ball should move to.
     */
    public void moveTo(Point p){
        ballModel.getPosition().setLocation(p);

        RectangularShape tmp = (RectangularShape) ballModel.getBallFace();
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((ballModel.getPosition().getX() -(w / 2)),(ballModel.getPosition().getY() - (h / 2)),w,h);
        ballModel.setBallFace(tmp);
    }

    /**
     * This method set the position of the ball's directions toward or away from the rectangle(Player).
     * @param width This parameter is the width of the rectangle.
     * @param height This parameter is the height of the rectangle.
     */
    public void setPoints(double width,double height){
        ballModel.getUp().setLocation(ballModel.getPosition().getX(),ballModel.getPosition().getY()-(height / 2));
        ballModel.getDown().setLocation(ballModel.getPosition().getX(),ballModel.getPosition().getY()+(height / 2));

        ballModel.getLeft().setLocation(ballModel.getPosition().getX()-(width / 2),ballModel.getPosition().getY());
        ballModel.getRight().setLocation(ballModel.getPosition().getX()+(width / 2),ballModel.getPosition().getY());
    }
    /**
     * This method get the "drawBall" method from "BallView" class and draw out the ball to the screen.
     */
    public void renderBall(Graphics2D g2d){
        ballView.drawBall(g2d);
    }

    /**
     * This is a getter method which get the ball position from the model class(Ball class).
     * @return "center" from model class (Ball class)
     */
    public Point2D getBallPosition(){
        return ballModel.getPosition();
    }

    /**
     * This is a getter method which get the face of the ball from the model class(Ball class).
     * @return "ballFace" from model class (Ball class)
     */
    public Shape getFaceBall()  {
        return ballModel.getBallFace();
    }

    /**
     * This is a getter method which get the up direction of the ball from the model class(Ball class).
     * @return "up" from model class (Ball class)
     */
    public Point2D getBallUp(){
        return ballModel.getUp();
    }

    /**
     * This is a getter method which  get the down direction of the ball from the model class(Ball class).
     * @return "down" from model class (Ball class)
     */
    public Point2D getBallDown(){
        return ballModel.getDown();
    }

    /**
     * This is a getter method which get the left direction of the ball from the model class(Ball class).
     * @return "left" from model class (Ball class)
     */
    public Point2D getBallLeft(){
        return ballModel.getLeft();
    }

    /**
     * This is a getter method which get the right direction of the ball from the model class(Ball class).
     * @return "right" from model class (Ball class)
     */
    public Point2D getBallRight(){
        return ballModel.getRight();
    }

    /**
     * This is a getter method which get the reverse speed of y of the ball from the model class(Ball class).
     * @return "speedY *= -1" from model class (Ball class)
     */
    public void ReverseY(){
        ballModel.reverseY();
    }

    /**
     * This is a getter method which get reverse speed of x of the ball from the model class(Ball class).
     * @return "speedX *= -1" from model class (Ball class)
     */
    public void ReverseX(){
        ballModel.reverseX();
    }

    /**
     * This is a setter method which set the ball x and y speed from the model class(Ball class).
     */
    public void setSPEED(int x, int y){
        ballModel.setSpeed(x,y);
    }

    /**
     * This is a setter method which set the ball x speed from the model class(Ball class).
     */
    public void setSpeedX(int x){
        ballModel.setXSpeed(x);
    }

    /**
     * This is a setter method which set the ball y speed from the model class(Ball class).
     */
    public void setSpeedY(int y){
        ballModel.setYSpeed(y);
    }

    /**
     * This is a getter method which get the ball x speed from the model class(Ball class).
     * @return "speedX" from model class (Ball class)
     */
    public int getXSpeed(){
        return ballModel.getSpeedX();
    }

    /**
     * This is a getter method which get the ball y speed from the model class(Ball class).
     * @return "speedY" from model class (Ball class)
     */
    public int getYSpeed(){
        return ballModel.getSpeedY();
    }

    /**
     * This is a getter method which get the inner colour of the ball from the model class(Ball class).
     * @return "inner" from model class (Ball class)
     */
    public Color getBallInnerColour(){
        return ballModel.getInnerColour();
    }
    /**
     * This is a getter method which get the border colour of the ball from the model class(Ball class).
     * @return "border" from model class (Ball class)
     */
    public Color getBallBorderColour(){
        return ballModel.getBorderColour();
    }


}
