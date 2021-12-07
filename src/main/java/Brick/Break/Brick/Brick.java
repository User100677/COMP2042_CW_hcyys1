package Brick.Break.Brick;

import Brick.Break.Attribute.Colour;
import Brick.Break.Ball.BallController;


import java.awt.*;
import java.awt.Point;
import java.awt.geom.Point2D;


/**
 * Created by filippo on 04/09/16.
 *
 */
public class Brick extends Colour {




    public static final int UP_IMPACT = 100;
    public static final int DOWN_IMPACT = 200;
    public static final int LEFT_IMPACT = 300;
    public static final int RIGHT_IMPACT = 400;




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
    public int getUpImpact(){
        return UP_IMPACT;
    }

    public int getDownImpact(){
        return DOWN_IMPACT;
    }

    public int getLeftImpact(){
        return LEFT_IMPACT;
    }

    public int getRightImpact(){
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





