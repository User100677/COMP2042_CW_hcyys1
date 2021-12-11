package Brick.Break.Brick.GoldBrick;

import Brick.Break.Brick.BrickController;
import Brick.Break.Brick.Crack.Crack;
import Brick.Break.Brick.Crack.CrackController;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

/**
 * This is the Controller of Model class(GoldBrick Class) in GoldBrick MVC design pattern
 * This class extends from "BrickController" class.
 */
public class GoldBrickController extends BrickController {

    private GoldBrick goldBrickModel;

    /**
     * This is the constructor of "GoldBrickController" class.
     * This constructor will set the default value for the data in model class(goldBrick class) once it is called by another class.
     * @param goldBrickModel This parameter is the object of model class(GoldBrick class).
     */
    public GoldBrickController(GoldBrick goldBrickModel){
        super(goldBrickModel);
        this.goldBrickModel = goldBrickModel;
        goldBrickModel.setCrackController(new CrackController( new Crack(this, GoldBrick.getDefCrackDepth(),GoldBrick.getDefSteps())));
        goldBrickModel.setGoldBrickFace(super.getBRICKFace());
    }

    /**
     * This method is used to create gold brick.
     * @param pos  This parameter is the position of the gold brick.
     * @param size This parameter is the size of the gold brick.
     * @return new Rectangle(x,y,width,height)
     */
    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    /**
     * This method is to see if the gold brick have impact from the ball or not.
     * If the gold brick have impact then the cement brick strength will be deducted by 1 and a crack will appear on the brick.
     * If the gold brick have impact and the cement brick strength is 1, the brick strength will be deducted to 0 and the brick will break
     * and no crack will appear.
     * @return either "true" or "false"
     */
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

    /**
     *This getter method get the gold brick.
     */
    @Override
    public Shape getBrick() {
        return goldBrickModel.getGoldBrickFace();
    }

    /**
     * This method update the gold brick condition.
     * If the brick have impact, this method will update the gold brick to show cracks.
     */
    private void updateBrick(){
        if(!super.isBroken()){
            GeneralPath gp = goldBrickModel.getCrackController().renderCrack();
            gp.append(super.getBRICKFace(),false);
            goldBrickModel.setGoldBrickFace(gp);
        }
    }

    /**
     * This method repair the gold brick to it original condition.
     */
    public void repair(){
        super.repair();
        goldBrickModel.getCrackController().reset();
        goldBrickModel.setGoldBrickFace(super.getBRICKFace());
    }

}
