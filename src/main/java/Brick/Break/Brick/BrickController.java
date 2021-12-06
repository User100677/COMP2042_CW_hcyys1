package Brick.Break.Brick;

import Brick.Break.Ball.BallController;

import java.awt.*;
import java.awt.geom.Point2D;

abstract class BrickController {
    private Brick brickModel;

    BrickController(Brick brickModel){
        this.brickModel = brickModel;
        brickModel.setBRICKFace(makeBrickFace(brickModel.getPos(), brickModel.getSize()));

    }

    protected abstract Shape makeBrickFace(Point pos, Dimension size);

    public  boolean setImpact(Point2D point , int dir){
        if(brickModel.getBroken()) {
            return false;
        }
        impact();
        return  brickModel.getBroken();
    }

    public final int findImpact(BallController b){
        if(brickModel.getBroken())
            return 0;
        int out  = 0;
        if(brickModel.getBRICKFace().contains(b.getBallRight()))
            out = brickModel.getLeftImpact();
        else if(brickModel.getBRICKFace().contains(b.getBallLeft()))
            out = brickModel.getRightImpact();
        else if(brickModel.getBRICKFace().contains(b.getBallUp()))
            out = brickModel.getDownImpact();
        else if(brickModel.getBrick().contains(b.getBallDown()))
            out = brickModel.getUpImpact();
        return out;
    }

    public abstract Shape getBrick();

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
}
