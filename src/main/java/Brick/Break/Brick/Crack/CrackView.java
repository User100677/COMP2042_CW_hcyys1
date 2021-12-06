package Brick.Break.Brick.Crack;

import java.awt.geom.GeneralPath;

public class CrackView {
    private Crack crackModel;

    CrackView(Crack crackModel){
        this.crackModel = crackModel;
    }
    public GeneralPath drawCrack() {

        return crackModel.getCrack();
    }
}
