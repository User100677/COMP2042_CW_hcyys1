package Brick.Break.Brick.CementBrick;

import Brick.Break.Brick.Brick;
import java.awt.*;


/**
 *This the Model of CementBrick in the CementBrick MVC design pattern.
 * This class extends from "Brick" class.
 */
public class CementBrick extends Brick {


    private static final String NAME = "Cement Brick";
    private static final Color DEF_INNER = new Color(147, 147, 147);
    private static final Color DEF_BORDER = new Color(217, 199, 175);
    private static final int CEMENT_STRENGTH = 2;


    private Shape brickFace;

    private static final int DEF_CRACK_DEPTH = 1;
    private static final int DEF_STEPS = 35;

    /**
     * This is the constructor of "CementBrick" class.
     * This constructor holds the data that required initialization once its object is created.
     * @param point This parameter is the position of the cement brick.
     * @param size This parameter is the size of the brick.
     */
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
