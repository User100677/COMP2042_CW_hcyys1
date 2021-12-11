package Brick.Break.Brick.ClayBrick;

import Brick.Break.Brick.BrickController;

import java.awt.*;

/**
 * This is the Controller of Model class(ClayBrick Class) in ClayBrick MVC design pattern
 * This class extends from "BrickController" class.
 */
public class ClayBrickController extends BrickController{
    private ClayBrick clayModel;

    /**
     * This is the constructor of "ClayBrickController" class.
     * This constructor will set the default value for the data in model class(ClayBrick class) once it is called by another class.
     * @param clayModel This parameter is the object of model class(ClayBrick class).
     */
    public ClayBrickController(ClayBrick clayModel){
        super(clayModel);
        this.clayModel = clayModel;
    }

    /**
     * This method is used to create clay brick.
     * @param pos  This parameter is the position of the clay brick.
     * @param size This parameter is the size of the clay brick.
     * @return new Rectangle(x,y,width,height)
     */
    @Override
    protected Shape makeBrickFace(Point pos, Dimension size){
        return new Rectangle(pos,size);
    }

    /**
     *This getter method get the clay brick.
     */
    @Override
    public Shape getBrick(){
        return getBRICKFace();
    }
}
