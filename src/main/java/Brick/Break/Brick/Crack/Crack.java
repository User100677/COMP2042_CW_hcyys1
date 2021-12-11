package Brick.Break.Brick.Crack;


import Brick.Break.Brick.BrickController;
import java.awt.geom.GeneralPath;
import java.util.Random;

/**
 *This is the Model of Crack in the Crack MVC design pattern.
 * This class was extracted from the "Brick" class.
 */
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
    private final BrickController brickController;
    private GeneralPath crack;

    private int crackDepth;
    private int steps;

    /**
     * This is the constructor of "Crack" class.
     * This constructor holds the data that required initialization once its object is created.
     * @param brickController This parameter is the object  of "BrickController" class.
     * @param crackDepth This parameter is the depth of the crack.
     * @param steps This parameter is the steps of the crack.
     */
    public Crack(BrickController brickController, int crackDepth, int steps) {
        rnd = new Random();
        this.brickController = brickController;

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

   public BrickController getCrackBrick(){
        return brickController;
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
