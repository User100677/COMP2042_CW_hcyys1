package Brick.Break.Brick;

import java.awt.*;

public class CementBrickController extends BrickController{
    private CementBrick cementModel;

    CementBrickController(CementBrick cementModel){
        super(cementModel);
        this.cementModel = cementModel;
    }


    public Shape getBRICK(){
        return cementModel.getBrick();
    }


}
