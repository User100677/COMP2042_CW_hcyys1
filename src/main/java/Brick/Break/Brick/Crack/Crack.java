package Brick.Break.Brick.Crack;

import Brick.Break.Brick.Brick;
import Brick.Break.Brick.Directions.*;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.Random;

public class Crack {


    private static final int CRACK_SECTIONS = 3;
    private static final double JUMP_PROBABILITY = 0.7;

    private static final int LEFT = 10;
    private static final int RIGHT = 20;
    private static final int UP = 30;
    private static final int DOWN = 40;
    private static final int VERTICAL = 100;
    private static final int HORIZONTAL = 200;

    private static Random rnd;
    private final Brick brick;
    private GeneralPath crack;

    private int crackDepth;
    private int steps;


    public Crack(Brick brick, int crackDepth, int steps) {
        rnd = new Random();
        this.brick = brick;

        crack = new GeneralPath();
        this.crackDepth = crackDepth;
        this.steps = steps;

    }


    public int getCrackSections(){
        return CRACK_SECTIONS;
    }

    public double getJumpProbability(){
        return JUMP_PROBABILITY;
    }

    protected static int getLeft(){
        return LEFT;
    }

    protected static int getRight(){
        return RIGHT;
    }

    protected  static int getUp(){
        return UP;
    }

    protected static int getDown(){
        return DOWN;
    }

    protected static int getVertical(){
        return VERTICAL;
   }

    protected static int getHorizontal(){
        return HORIZONTAL;
   }

   public Random getRnd(){
        return rnd;
   }

   public Brick getCrackBrick(){
        return brick;
   }

   public GeneralPath getCrack(){
        return crack;
   }

   public int getCrackDepth(){
        return crackDepth;
   }

   public int getSteps(){
        return steps;
   }



}
