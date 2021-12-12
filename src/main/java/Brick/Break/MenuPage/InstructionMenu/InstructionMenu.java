package Brick.Break.MenuPage.InstructionMenu;

import Brick.Break.GameFrame.GameFrame;
import Brick.Break.GameFrame.GameFrameController;

import java.awt.*;

/**
 *This is the Model of InstructionMenu in the InstructionMenu MVC design pattern.
 * This is a new addition I added. This class show the player on how to play the game.
 */
public class InstructionMenu {

    private Rectangle instructionMenuFace;
    private Rectangle backButton;

    private boolean backClicked;

    private GameFrameController owner;
    private Dimension area;

    /**
     * This is the constructor of "InstructionMenu" class.
     * This constructor holds the data that required initialization once its object is created.
     * @param owner This parameter is the object of "GameFrameController" class.
     * @param area This parameter is the frame of the instruction menu screen.
     */
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