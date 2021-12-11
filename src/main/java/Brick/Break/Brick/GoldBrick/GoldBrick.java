package Brick.Break.Brick.GoldBrick;
import Brick.Break.Brick.Brick;

import java.awt.*;

/**
 *This is the Model of GoldBrick in the Goldbrick MVC design pattern.
 * This class extends from "Brick" class.
 * This is the new Brick type I created.
 */
public class GoldBrick extends Brick{

    private static final String NAME = "Gold Brick";
    private static final Color DEF_INNER = new Color(245, 237, 4, 255);
    private static final Color DEF_BORDER = DEF_INNER.darker().darker().darker();
    private static final int CEMENT_STRENGTH = 4;

    private Shape brickFace;

    private static final int DEF_CRACK_DEPTH = 3;
    private static final int DEF_STEPS = 35;

    /**
     * This is the constructor of "GoldBrick" class.
     * This constructor holds the data that required initialization once its object is created.
     * @param point This parameter is the position of the gold brick.
     * @param size This parameter is the size of the brick.
     */
    public GoldBrick(Point point, Dimension size) {
        super(NAME, point, size, DEF_BORDER, DEF_INNER, CEMENT_STRENGTH);
    }

    public Shape getGoldBrickFace(){
        return brickFace;
    }

    public void setGoldBrickFace(Shape brickFace){
        this.brickFace = brickFace;
    }
    public static int getDefCrackDepth(){
        return DEF_CRACK_DEPTH;
    }
    public static int getDefSteps(){
        return DEF_STEPS;
    }

}
