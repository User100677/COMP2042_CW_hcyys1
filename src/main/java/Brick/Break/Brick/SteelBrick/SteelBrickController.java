package Brick.Break.Brick.SteelBrick;

import Brick.Break.Brick.BrickController;
import Brick.Break.Brick.Crack.Crack;
import Brick.Break.Brick.Crack.CrackController;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

/**
 * This is the Controller of Model class(SteelBrick Class) in SteelBrick MVC design pattern
 * This class extends from "BrickController" class.
 * In this class I modify the "setImpact()" method, deleted "impact()" method and added "updateBrick()" and "repair()" method.
 */
public class SteelBrickController extends BrickController {
    private SteelBrick steelModel;

    /**
     * This is the constructor of "SteelBrickController" class.
     * This constructor will set the default value for the data in model class(SteelBrick class) once it is called by another class.
     * @param steelModel This parameter is the object of model class(SteelBrick class).
     */
    public SteelBrickController(SteelBrick steelModel){
        super(steelModel);
        this.steelModel = steelModel;
        steelModel.setCrackController(new CrackController( new Crack(this, SteelBrick.getDefCrackDepth(),SteelBrick.getDefSteps())));
        steelModel.setSteelBrickFace(super.getBRICKFace());
    }

    /**
     * This method is used to create steel brick.
     * @param pos  This parameter is the position of the steel brick.
     * @param size This parameter is the size of the steel brick.
     * @return new Rectangle(x,y,width,height)
     */
    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    /**
     *This getter method get the steel brick.
     */
    @Override
    public Shape getBrick() {
        return steelModel.getSteelBrickFace();
    }

    /**
     * This method is to see if the steel brick have impact from the ball or not.
     * If the steel brick have impact then the cement brick strength will be deducted by 1 and a crack will appear on the brick.
     * If the steel brick have impact and the cement brick strength is 1, the brick strength will be deducted to 0 and the brick will break
     * and no crack will appear.
     * In the original code, this method doesn't update the brick to show crack when ball hit it, the brick will not have different appearance
     * once the ball hit it but the strength of the brick will get deducted. Therefore, I change the code to make the brick show crack.
     * @return either "true" or "false"
     */
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


    /**
     * This method update the steel brick condition.
     * If the brick have impact, this method will update the steel brick to show cracks.
     * the original code doesn't have this method, I added this method to make the crack appear onto the brick.
     */
    private void updateBrick(){
        if(!super.isBroken()){
            GeneralPath gp = steelModel.getCrackController().renderCrack();
            gp.append(super.getBRICKFace(),false);
            steelModel.setSteelBrickFace(gp);
        }
    }

    /**
     * This method repair the steel brick to it original conditiona.
     * I also added this method to reset the brick.
     */
    public void repair(){
        super.repair();
        steelModel.getCrackController().reset();
       steelModel.setSteelBrickFace(super.getBRICKFace());
    }
}
