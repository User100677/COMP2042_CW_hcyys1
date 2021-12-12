package Brick.Break.Wall;

/**
 * This class is used to set the total amount of the balls in a level and check if all balls are gone.
 * The methods in this class were extracted from the "Wall" class.
 */
public class BallAmount {

    private int ballCount;
    private boolean ballLost;

    /**
     * This is the constructor of "BallAmount" class.
     * @param ballCount Total balls
     * @param ballLost This parameter is the value for if the ball is lost or not.
     */
    BallAmount(int ballCount, boolean ballLost){
        this.ballCount = ballCount;
        this.ballLost = ballLost;
    }

    /**
     * This getter method is to get the total amount of balls.
     * @return "3".
     */
    public int getBallCount(){
        return ballCount;
    }

    /**
     * This method is used to check if the current ball the player is using went out of frame or not.
     * @return "true" or "false"
     */
    public boolean isBallLost(){
        return ballLost;
    }

    /**
     * This method is used to check if the player have used up all the balls or not.
     * @return "true" or "false"
     */
    public boolean ballEnd(){
        return ballCount == 0;
    }

    /**
     * This method is to reset the total amount of the ball.
     */
    public void resetBallCount(){
        ballCount = 3;
    }

    /**
     * This method is used to set the total amount of the ball.
     * @param ballCount Total amount of ball.
     */
    public void setBallCount(int ballCount){
        this.ballCount = ballCount;

    }

    /**
     * This method is used to set whether the ball is lost or not manually.
     * @param ballLost This parameter is the value for if the ball is lost or not.
     */
    public void setBallLost(boolean ballLost){
        this.ballLost = ballLost;
    }
}
