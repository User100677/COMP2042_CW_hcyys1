package Brick.Break.Brick;

import Brick.Break.Ball.BallController;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * This is the Controller of Model class(Brick Class) in Brick MVC design pattern
 * This is an abstract class.
 */
public abstract class BrickController{
    private Brick brickModel;
    private BrickView brickView;

    /**
     * This is the constructor of "BrickController" class.
     * This constructor will set the default value for the data in model class(Brick class) once it is called by another class.
     * @param brickModel This parameter is the object of model class(Brick class).
     */
    public BrickController(Brick brickModel){
        this.brickModel = brickModel;
        brickView = new BrickView(this);
        brickModel.setBroken(false);
        brickModel.setBrickFace(makeBrickFace(brickModel.getPos(), brickModel.getSize()));
    }


    /**
     * This method is to see if the brick have impact from the ball or not, if had, the brick strength will deduct by 1.
     * @return either "true" or "false"
     */
    public  boolean setImpact(Point2D point , int dir){
        if(brickModel.getBroken()) {
            return false;
        }
        impact();
        return  brickModel.getBroken();
    }

    /**
     * This is an abstract method which is used to create bricks.
     * This method will be implemented by the child classes.
     * @param pos This parameter is the position of the brick.
     * @param size This parameter is the size of the brick.
     */
    protected abstract Shape makeBrickFace(Point pos, Dimension size);

    /**
     * This is an abstract method which is used to get the bricks.
     * This method will be implemented by the child classes.
     */
    public abstract Shape getBrick();


    /**
     * This method is to determined which position of the brick did the ball hit.
     * @param b This parameter is the object of the "BallController" class.
     * @return either "100", "200", "300" or "400"
     */
    public final int findImpact(BallController b){
        if(brickModel.getBroken())
            return 0;
        int out  = 0;
        if(brickModel.getBrickFace().contains(b.getBallRight()))
            out = Brick.getLeftImpact();
        else if(brickModel.getBrickFace().contains(b.getBallLeft()))
            out = Brick.getRightImpact();
        else if(brickModel.getBrickFace().contains(b.getBallUp()))
            out = Brick.getDownImpact();
        else if(brickModel.getBrickFace().contains(b.getBallDown()))
            out = Brick.getUpImpact();
        return out;
    }

    /**
     * This method is to determined if the bricks are broken.
     * @return "true"
     */
    public final boolean isBroken(){
        return brickModel.getBroken();
    }

    /**
     * This method is to repair the broken bricks.
     */
    public void repair() {
        brickModel.setBroken(false) ;
       brickModel.setStrength(brickModel.getFullStrength());
    }

    /**
     * This method is used to give impact to the brick.
     * Once the brick have impact, the brick's brick strength will either be deducted by 1 or the brick will straightaway break.
     */
    public void impact(){
        brickModel.setStrength(brickModel.getStrength() - 1);
        brickModel.setBroken(brickModel.getStrength() == 0);
    }

    /**
     * This method get the "drawBrick" method from "BrickView" class and draw out the bricks to the screen.
     */
    public void renderBrick( Graphics2D g2d){
        brickView.drawBrick(g2d);

    }


    /**
     * This is a getter method which get the face of brick from the model class(Brick class).
     * @return "brickFace" from model class (Brick class)
     */
    public Shape getBRICKFace(){
        return brickModel.getBrickFace();
    }

    /**
     * This is a getter method which get the inner colour of the brick from the model class(Brick class).
     * @return "Color inner colour" from model class (Brick class)
     */
    public Color getINNERColour(){
        return brickModel.getInnerColour();
    }

    /**
     * This is a getter method which get the border colour of the brick from the model class(Brick class).
     * @return "Color border colour" from model class (Brick class)
     */
    public Color getBORDERColour(){
        return brickModel.getBorderColour();
    }

    /**
     * This is a getter method which get the up impact value on the brick from the model class(Brick class).
     * @return "100" from model class (Brick class)
     */
    public static int getImpactUp(){
        return Brick.getUpImpact();
    }

    /**
     * This is a getter method which get the down impact value on the brick from the model class(Brick class).
     * @return "200" from model class (Brick class)
     */
    public static int getImpactDown(){
        return Brick.getDownImpact();
    }

    /**
     * This is a getter method which get the right impact value on the brick from the model class(Brick class).
     * @return "400" from model class (Brick class)
     */
    public static int getImpactRight(){
        return Brick.getRightImpact();
    }

    /**
     * This is a getter method which get the left impact value on the brick from the model class(Brick class).
     * @return "300" from model class (Brick class)
     */
    public static int getImpactLeft(){
        return Brick.getLeftImpact();
    }


    /**
     * This method is to set if the bricks is broken or not.
     * @param broken This parameter is to determined whether the brick is broken or not.
     */
    public void setBROKEN(boolean broken){
        brickModel.setBroken(broken);
    }

    /**
     * This is a getter method which get the strength of the brick from the model class(Brick class)
     * @return "strength" from model class (Brick class)
     */
    public int getSTRENGTH(){
        return brickModel.getStrength();
    }



}