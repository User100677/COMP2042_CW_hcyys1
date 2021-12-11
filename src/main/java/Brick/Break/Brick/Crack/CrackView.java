package Brick.Break.Brick.Crack;
import java.awt.geom.GeneralPath;



/**
 * This is the View of Model class(Crack class) in the Crack MVC Design Pattern.
 */
public class CrackView {
    private CrackController crackController;

    /**
     * This is the constructor of "CrackView" class.
     * This constructor get the data from the controller class(CrackController class).
     * @param crackController This parameter is the object of controller class(CrackController class).
     */
    CrackView(CrackController crackController){
        this.crackController = crackController;
    }

    /**
     * This method draw out the crack.
     */
    public GeneralPath drawCrack() {

        return crackController.getControllerCrack();
    }
}
