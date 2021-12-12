package Brick.Break.Wall;

/**
 * This class is used to set the total amount of the bricks in a level and check if all bricks are broken.
 * The methods in this class were extracted from the "Wall" class.
 */
public class BrickAmount {

    private int brickCount;

    /**
     * This is the constructor of "BrickAmount" class.
     * @param brickCount Number of bricks.
     */
    BrickAmount(int brickCount){
        this.brickCount = brickCount;

    }

    /**
     * This method is to set the total number of bricks.
     * @param brickCount Number of bricks.
     */
    public void setBrickCount(int brickCount){
        this.brickCount = brickCount;
    }

    /**
     * This getter method is used to get the total number of bricks.
     * @return (int) Total number of bricks.
     */
    public int getBrickCount(){
        return brickCount;
    }

    /**
     * This method is used to check if all bricks is broken or not.
     * @return "true" or "false"
     */
    public boolean isDone(){
        return brickCount == 0;
    }
}
