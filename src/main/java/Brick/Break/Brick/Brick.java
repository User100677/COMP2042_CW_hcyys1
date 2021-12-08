package Brick.Break.Brick;

import Brick.Break.Attribute.Colour;



import java.awt.*;
import java.awt.Point;



/**
 * Created by filippo on 04/09/16.
 *
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


    public Brick(String name, Point pos,Dimension size,Color border,Color inner,int strength){
        broken = false;
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

    public String getName(){
        return name;
    }



}





