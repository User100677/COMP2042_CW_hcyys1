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
abstract public class Brick extends Colour {

    public static final int MIN_CRACK = 1;
    public static final int DEF_CRACK_DEPTH = 1;
    public static final int DEF_STEPS = 35;


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
        brickFace = makeBrickFace(pos,size);
        setInnerColour(inner);
        setBorderColour(border);
        this.fullStrength = this.strength = strength;

    }

    protected abstract Shape makeBrickFace(Point pos,Dimension size);

    public  boolean setImpact(Point2D point , int dir){
        if(broken)
            return false;


        impact();
        return  broken;

    }

    public abstract Shape getBrick();



    public final int findImpact(BallController b){
        if(broken)
            return 0;
        int out  = 0;
        if(brickFace.contains(b.getBallRight()))
            out = LEFT_IMPACT;
        else if(brickFace.contains(b.getBallLeft()))
            out = RIGHT_IMPACT;
        else if(brickFace.contains(b.getBallUp()))
            out = DOWN_IMPACT;
        else if(brickFace.contains(b.getBallDown()))
            out = UP_IMPACT;
        return out;
    }

    public final boolean isBroken(){
        return broken;
    }

    public void repair() {
        broken = false;
        strength = fullStrength;
    }

    public void impact(){
        strength--;
        broken = (strength == 0);
    }

    public Shape getBRICKFace(){
        return brickFace;
    }

    public void setBRICKFace(Shape brickFace){
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


}





