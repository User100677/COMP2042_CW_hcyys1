package Brick.Break.Brick.GoldBrick;

import Brick.Break.Brick.BrickController;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

public class GoldBrickController extends BrickController {

    private GoldBrick goldBrickModel;

    public GoldBrickController(GoldBrick goldBrickModel){
        super(goldBrickModel);
        this.goldBrickModel = goldBrickModel;
        goldBrickModel.setGoldBrickFace(super.getBRICKFace());
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
            goldBrickModel.getCrackController().makeCrack(point,dir);
            updateBrick();
            return false;
        }
        return true;
    }


    @Override
    public Shape getBrick() {
        return goldBrickModel.getGoldBrickFace();
    }

    private void updateBrick(){
        if(!super.isBroken()){
            GeneralPath gp = goldBrickModel.getCrackController().renderCrack();
            gp.append(super.getBRICKFace(),false);
            goldBrickModel.setGoldBrickFace(gp);
        }
    }

    public void repair(){
        super.repair();
        goldBrickModel.getCrackController().reset();
        goldBrickModel.setGoldBrickFace(super.getBRICKFace());
    }
}
