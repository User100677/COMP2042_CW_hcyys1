package Brick.Break.Brick.ClayBrick;

import Brick.Break.Brick.BrickController;

import java.awt.*;

public class ClayBrickController extends BrickController{
    private ClayBrick clayModel;

    public ClayBrickController(ClayBrick clayModel){
        super(clayModel);
        this.clayModel = clayModel;
    }

    @Override
    protected Shape makeBrickFace(Point pos, Dimension size){
        return new Rectangle(pos,size);
    }

    @Override
    public Shape getBrick(){
        return getBRICKFace();
    }
}
