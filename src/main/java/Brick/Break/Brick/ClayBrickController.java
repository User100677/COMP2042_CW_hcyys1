package Brick.Break.Brick;

import java.awt.*;

public class ClayBrickController {
    private ClayBrick clayModel;

    ClayBrickController(ClayBrick clayModel){
       
        this.clayModel = clayModel;

    }

    public Shape BRICK(){
        return clayModel.getBrick();
    }
}
