package Brick.Break.Brick;

import Brick.Break.Brick.Crack.Crack;
import Brick.Break.Brick.Crack.CrackController;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;


public class CementBrick extends Brick {


    private static final String NAME = "Cement Brick";
    private static final Color DEF_INNER = new Color(147, 147, 147);
    private static final Color DEF_BORDER = new Color(217, 199, 175);
    private static final int CEMENT_STRENGTH = 2;

    private CrackController crackController;
    private Shape brickFace;

    public static final int DEF_CRACK_DEPTH = 1;
    public static final int DEF_STEPS = 35;

    public CementBrick(Point point, Dimension size){
        super(NAME,point,size,DEF_BORDER,DEF_INNER,CEMENT_STRENGTH);
        crackController = new CrackController(new Crack(this, DEF_CRACK_DEPTH,DEF_STEPS));
        brickFace = super.brickFace;
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
            crackController.makeCrack(point,dir);
            updateBrick();
            return false;
        }
        return true;
    }


    @Override
    public Shape getBrick() {
        return brickFace;
    }

    private void updateBrick(){
        if(!super.isBroken()){
            GeneralPath gp = crackController.renderCrack();
            gp.append(super.brickFace,false);
            brickFace = gp;
        }
    }

    public void repair(){
        super.repair();
        crackController.reset();
        brickFace = super.brickFace;
    }
}
