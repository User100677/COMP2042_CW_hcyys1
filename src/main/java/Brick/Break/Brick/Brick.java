package Brick.Break.Brick;

import Brick.Break.Attribute.Colour;
import Brick.Break.Brick.Crack.CrackController;


import java.awt.*;
import java.awt.Point;



/**
 *This is the Model of Brick in the Brick MVC design pattern.
 * This class extends from "Colour" abstract class.
 * Originally, there was a crack inner class in this class, but I extracted it into it own class.
 */
public class Brick extends Colour {

    private static final int UP_IMPACT = 100;
    private static final int DOWN_IMPACT = 200;
    private static final int LEFT_IMPACT = 300;
    private static final int RIGHT_IMPACT = 400;




    private String name;
    protected Shape brickFace;
    private Point pos;
    private Dimension size;

    private int fullStrength;
    private int strength;

    private boolean broken;
    private CrackController crackController;


    /**
     * This is the constructor of "Brick" class.
     * This constructor holds the data that required initialization once its object is created.
     * @param name This parameter is the name of the brick
     * @param pos This parameter is the position of the bricks.
     * @param size This parameter is the size of the bricks.
     * @param inner This parameter is the inner colour of the brick.
     * @param border This parameter is the border colour of the brick.
     * @param strength This parameter is the strength of the bricks.
     */
    public Brick(String name, Point pos,Dimension size,Color border,Color inner,int strength){
        this.name = name;
        this.pos = pos;
        this.size = size;
        setInnerColour(inner);
        setBorderColour(border);
        this.fullStrength = this.strength = strength;

    }



    public Shape getBrickFace(){
        return brickFace;
    }

    public void setBrickFace(Shape brickFace){
        this.brickFace = brickFace;

    }
    public static int getUpImpact(){
        return UP_IMPACT;
    }

    public static int getDownImpact(){
        return DOWN_IMPACT;
    }

    public static int getLeftImpact(){
        return LEFT_IMPACT;
    }

    public static int getRightImpact(){
        return RIGHT_IMPACT;
    }

    public void setBroken(boolean broken){
        this.broken = broken;
    }

    public boolean getBroken(){
        return broken;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }


    public int getStrength(){
        return strength;
    }

    public int getFullStrength(){
        return fullStrength;
    }

    public Point getPos(){
        return pos;
    }
    public Dimension getSize(){
        return size;
    }

    public void setCrackController(CrackController crackController){
        this.crackController = crackController;
    }
    public CrackController getCrackController(){
        return crackController;
    }




}





