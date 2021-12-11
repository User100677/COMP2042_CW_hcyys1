package Brick.Break.Brick.ClayBrick;

import Brick.Break.Brick.Brick;
import java.awt.*;
import java.awt.Point;


/**
 *This is the Model of ClayBrick in the ClayBrick MVC design pattern.
 * This class extends from "Brick" class.
 */
public class ClayBrick extends Brick {

    private static final String NAME = "Clay Brick";
    private static final Color DEF_INNER = new Color(178, 34, 34).darker();
    private static final Color DEF_BORDER = Color.GRAY;
    private static final int CLAY_STRENGTH = 1;


    /**
     * This is the constructor of "ClayBrick" class.
     * This constructor holds the data that required initialization once its object is created.
     * @param point This parameter is the position of the clay brick.
     * @param size This parameter is the size of the brick.
     */
    public ClayBrick(Point point, Dimension size){
        super(NAME,point,size,DEF_BORDER,DEF_INNER,CLAY_STRENGTH);
    }




}
