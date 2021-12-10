package Brick.Break.Brick.Crack;

import java.awt.geom.GeneralPath;

public class CrackView {
    private CrackController crackController;

    CrackView(CrackController crackController){
        this.crackController = crackController;
    }
    public GeneralPath drawCrack() {

        return crackController.getControllerCrack();
    }
}
