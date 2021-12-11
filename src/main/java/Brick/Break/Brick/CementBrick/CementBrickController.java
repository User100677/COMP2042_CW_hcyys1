package Brick.Break.Brick.CementBrick;

import Brick.Break.Brick.BrickController;
import Brick.Break.Brick.Crack.Crack;
import Brick.Break.Brick.Crack.CrackController;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

/**
 * This is the Controller of Model class(CementBrick Class) in CementBrick MVC design pattern
 * This class extends from "BrickController" class.
 */
public class CementBrickController extends BrickController {
    private CementBrick cementModel;


    /**
     * This is the constructor of "CementBrickController" class.
     * This constructor will set the default value for the data in model class(CementBrick class) once it is called by another class.
     * @param cementModel This parameter is the object of model class(CementBrick class).
     */
    public CementBrickController(CementBrick cementModel){
        super(cementModel);
        this.cementModel = cementModel;
        cementModel.setCrackController(new CrackController( new Crack(this, CementBrick.getDefCrackDepth(),CementBrick.getDefSteps())));
        cementModel.setCementBrickFace(super.getBRICKFace());
    }


    /**
     * This method is used to create cement brick.
     * @param pos  This parameter is the position of the cement brick.
     * @param size This parameter is the size of the cement brick.
     * @return new Rectangle(x,y,width,height)
     */
    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }


     /**
     * This method is to see if the cement brick have impact from the ball or not.
      * If the cement brick have impact then the cement brick strength will be deducted by 1 and a crack will appear on the brick.
      * If the cement brick have impact and the cement brick strength is 1, the brick strength will be deducted to 0 and the brick will break
      * and no crack will appear.
     * @return either "true" or "false"
     */
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


    /**
     *This getter method get the cement brick.
     */
    @Override
    public Shape getBrick() {
        return cementModel.getCementBrickFace();
    }

    /**
     * This method update the cement brick condition.
     * If the brick have impact, this method will update the cement brick to show cracks.
     */
    private void updateBrick(){
        if(!super.isBroken()){
            GeneralPath gp = cementModel.getCrackController().renderCrack();
            gp.append(super.getBRICKFace(),false);
            cementModel.setCementBrickFace(gp);
        }
    }

    /**
     * This method repair the cement brick to it original conditiona.
     */
    public void repair(){
        super.repair();
        cementModel.getCrackController().reset();
        cementModel.setCementBrickFace(super.getBRICKFace());
    }


}
