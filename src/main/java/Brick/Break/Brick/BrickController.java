package Brick.Break.Brick;

import Brick.Break.Ball.BallController;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class BrickController{
    private Brick brickModel;
    private BrickView brickView;

    public BrickController(Brick brickModel){
        this.brickModel = brickModel;
        brickView = new BrickView(this);
        brickModel.setBrickFace(makeBrickFace(brickModel.getPos(), brickModel.getSize()));
    }


    public  boolean setImpact(Point2D point , int dir){
        if(brickModel.getBroken()) {
            return false;
        }
        impact();
        return  brickModel.getBroken();
    }
    protected abstract Shape makeBrickFace(Point pos, Dimension size);
    public abstract Shape getBrick();


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

    public final boolean isBroken(){
        return brickModel.getBroken();
    }

    public void repair() {
        brickModel.setBroken(false) ;
       brickModel.setStrength(brickModel.getFullStrength());
    }

    public void impact(){
        brickModel.setStrength(brickModel.getStrength() - 1);
        brickModel.setBroken(brickModel.getStrength() == 0);
    }
    public Shape getBRICKFace(){
        return brickModel.getBrickFace();
    }

    public Color getINNERColour(){
        return brickModel.getInnerColour();
    }
    public Color getBORDERColour(){
        return brickModel.getBorderColour();
    }

    public void renderBrick( Graphics2D g2d){
        brickView.drawBrick(g2d);

    }

    public static int getImpactUp(){
        return Brick.getUpImpact();
    }
    public static int getImpactDown(){
        return Brick.getDownImpact();
    }

    public static int getImpactRight(){
        return Brick.getRightImpact();
    }

    public static int getImpactLeft(){
        return Brick.getLeftImpact();
    }

}