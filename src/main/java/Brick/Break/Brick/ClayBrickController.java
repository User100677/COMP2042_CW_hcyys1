package Brick.Break.Brick;

import java.awt.*;

public class ClayBrickController extends BrickController{
    private ClayBrick clayModel;

    ClayBrickController(ClayBrick clayModel){
        super(clayModel);
        this.clayModel = clayModel;

    }


    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    @Override
    public Shape getBrick(){
        return super.getBRICKFace();
    }
}
