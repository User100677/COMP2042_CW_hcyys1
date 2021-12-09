package Brick.Break.MenuPage.InstructionMenu;

import Brick.Break.GameFrame.GameFrame;
import Brick.Break.GameFrame.GameFrameController;

import java.awt.*;

/**
 * This the class where I create the Instruction Menu page
 */
public class InstructionMenu {

    private Rectangle instructionMenuFace;
    private Rectangle backButton;

    private boolean backClicked;

    private GameFrameController owner;
    private Dimension area;


    public InstructionMenu(GameFrameController owner, Dimension area) {


        this.owner = owner;
        this.area = area;

    }
    public Rectangle getInstructionMenuFace(){
        return instructionMenuFace;
    }
    public void setInstructionMenuFace(Rectangle instructionMenuFace){
        this.instructionMenuFace=instructionMenuFace;
    }

    public Rectangle getBackButton(){
        return backButton;
    }
    public void setBackButton(Rectangle backButton){
        this.backButton = backButton;
    }

    public GameFrameController getOwner(){
        return owner;
    }
    public Dimension getArea(){
        return area;
    }

    public boolean getBackClicked(){
        return backClicked;
    }
    public void setBackClicked(boolean backClicked){
        this.backClicked = backClicked;
    }






}