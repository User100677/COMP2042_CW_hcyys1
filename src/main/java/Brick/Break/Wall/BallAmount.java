package Brick.Break.Wall;

public class BallAmount {

    private int ballCount;
    private boolean ballLost;

    BallAmount(int ballCount, boolean ballLost){
        this.ballCount = ballCount;
        this.ballLost = ballLost;
    }

    public int getBallCount(){
        return ballCount;
    }

    public boolean isBallLost(){
        return ballLost;
    }

    public boolean ballEnd(){
        return ballCount == 0;
    }

    public void resetBallCount(){
        ballCount = 3;
    }

    public void setBallCount(int ballCount){
        this.ballCount = ballCount;

    }

    public void setBallLost(boolean ballLost){
        this.ballLost = ballLost;
    }
}
