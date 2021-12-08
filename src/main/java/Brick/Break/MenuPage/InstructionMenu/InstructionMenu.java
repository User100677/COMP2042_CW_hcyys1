package Brick.Break.MenuPage.InstructionMenu;

import Brick.Break.GameBoard.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
/**
 * This the class where I create the Instruction Menu page
 */
public class InstructionMenu {




    private Rectangle instructionMenuFace;
    private Rectangle backButton;


    private boolean backClicked;


    private GameFrame owner;
    private Dimension area;


    public InstructionMenu(GameFrame owner, Dimension area) {


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

    public GameFrame getOwner(){
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