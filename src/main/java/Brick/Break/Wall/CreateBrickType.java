package Brick.Break.Wall;

import Brick.Break.Brick.BrickController;
import Brick.Break.Brick.CementBrick.CementBrick;
import Brick.Break.Brick.CementBrick.CementBrickController;
import Brick.Break.Brick.ClayBrick.ClayBrick;
import Brick.Break.Brick.ClayBrick.ClayBrickController;
import Brick.Break.Brick.GoldBrick.GoldBrick;
import Brick.Break.Brick.GoldBrick.GoldBrickController;
import Brick.Break.Brick.SteelBrick.SteelBrick;
import Brick.Break.Brick.SteelBrick.SteelBrickController;

import java.awt.*;

public class CreateBrickType {

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
