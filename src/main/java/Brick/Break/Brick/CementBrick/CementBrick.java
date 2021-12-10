package Brick.Break.Brick.CementBrick;

import Brick.Break.Brick.Brick;
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


    private Shape brickFace;

    private static final int DEF_CRACK_DEPTH = 1;
    private static final int DEF_STEPS = 35;

    public CementBrick(Point point, Dimension size){
        super(NAME,point,size,DEF_BORDER,DEF_INNER,CEMENT_STRENGTH);


    }



    public Shape getCementBrickFace(){
        return brickFace;
    }

    public void setCementBrickFace(Shape brickFace){
        this.brickFace = brickFace;
    }

    public static int getDefSteps(){
        return DEF_STEPS;
    }
    public static int getDefCrackDepth(){
        return DEF_CRACK_DEPTH;
    }
}
