package Brick.Break.Wall.Levels;

import Brick.Break.Brick.BrickController;
import Brick.Break.Brick.CementBrick.CementBrick;
import Brick.Break.Brick.CementBrick.CementBrickController;
import Brick.Break.Brick.ClayBrick.ClayBrick;
import Brick.Break.Brick.ClayBrick.ClayBrickController;
import Brick.Break.Brick.GoldBrick.GoldBrick;
import Brick.Break.Brick.GoldBrick.GoldBrickController;
import Brick.Break.Brick.SteelBrick.SteelBrick;
import Brick.Break.Brick.SteelBrick.SteelBrickController;
import Brick.Break.Wall.Wall;

import java.awt.*;

/**
 * This class is used to create the bricks type that the level need(produce instances of the brick type class).
 * The method in this class was extracted from "Wall" class.
 */
public class CreateBrickType {

    /**
     * This method is used to create any types of bricks from the "Brick" class(produce instances of the brick type class).
     * @param point This is the position of the bricks.
     * @param size This parameter is the size of the bricks.
     * @param type This parameter is the type of brick that the level want.
     * @return any instances from "Brick" child classes.
     */
    protected BrickController makeBrick(Point point, Dimension size, int type){
        BrickController out;
        if (type == Wall.getClay()) {
            out = new ClayBrickController(new ClayBrick(point, size));
        }
        else if (type == Wall.getSteel()) {
            out = new SteelBrickController(new SteelBrick(point, size));
        }
        else if (type == Wall.getCement()) {
            out = new CementBrickController(new CementBrick(point, size));
        }
        else if (type == Wall.getGold()) {
            out = new GoldBrickController(new GoldBrick(point, size));
        }
        else{
            throw  new IllegalArgumentException(String.format("Unknown Type:%d\n",type));
        }
        return  out;
    }
}
