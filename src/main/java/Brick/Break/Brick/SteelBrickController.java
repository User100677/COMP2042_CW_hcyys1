package Brick.Break.Brick;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

public class SteelBrickController extends BrickController{
    private SteelBrick steelModel;

    public SteelBrickController(SteelBrick steelModel){
        super(steelModel);
        this.steelModel = steelModel;
        steelModel.setSteelBrickFace(super.getBRICKFace());
    }

    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    @Override
    public Shape getBrick() {
        return steelModel.getSteelBrickFace();
    }

    public  boolean setImpact(Point2D point , int dir){
        if(super.isBroken())
            return false;
        super.impact();
        if(!super.isBroken()){
            steelModel.getCrackController().makeCrack(point,dir);
            updateBrick();
            return false;
        }
        return true;
    }

    private void updateBrick(){
        if(!super.isBroken()){
            GeneralPath gp = steelModel.getCrackController().renderCrack();
            gp.append(super.getBRICKFace(),false);
            steelModel.setSteelBrickFace(gp);
        }
    }

    public void repair(){
        super.repair();
        steelModel.getCrackController().reset();
       steelModel.setSteelBrickFace(super.getBRICKFace());
    }
}
