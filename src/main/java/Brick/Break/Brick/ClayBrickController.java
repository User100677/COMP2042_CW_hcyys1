package Brick.Break.Brick;

import java.awt.*;

public class ClayBrickController extends BrickController{
    private ClayBrick clayModel;

    ClayBrickController(ClayBrick clayModel){
        super(clayModel);
        this.clayModel = clayModel;

    }

    public Shape BRICK(){
        return clayModel.getBrick();
    }
}
