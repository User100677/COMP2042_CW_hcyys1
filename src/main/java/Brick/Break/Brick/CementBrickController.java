package Brick.Break.Brick;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

public class CementBrickController extends BrickController{
    private CementBrick cementModel;

    CementBrickController(CementBrick cementModel){
        super(cementModel);
        this.cementModel = cementModel;
        cementModel.setCementBrickFace(super.getBRICKFace());
    }


    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }


    @Override
    public boolean setImpact(Point2D point, int dir) {
        if(super.isBroken())
            return false;
        super.impact();
        if(!super.isBroken()){
            cementModel.getCrackController().makeCrack(point,dir);
            updateBrick();
            return false;
        }
        return true;
    }


    @Override
    public Shape getBrick() {
        return cementModel.getCementBrickFace();
    }

    private void updateBrick(){
        if(!super.isBroken()){
            GeneralPath gp = cementModel.getCrackController().renderCrack();
            gp.append(super.getBRICKFace(),false);
            cementModel.setCementBrickFace(gp);
        }
    }

    public void repair(){
        super.repair();
        cementModel.getCrackController().reset();
        cementModel.setCementBrickFace(super.getBRICKFace());
    }


}
