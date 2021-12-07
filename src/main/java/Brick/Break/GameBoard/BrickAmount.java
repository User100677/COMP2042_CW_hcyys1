package Brick.Break.GameBoard;

public class BrickAmount {

    private int brickCount;

    BrickAmount(int brickCount){
        this.brickCount = brickCount;

    }

    public void setBrickCount(int brickCount){
        this.brickCount = brickCount;
    }

    public int getBrickCount(){
        return brickCount;
    }

    public boolean isDone(){
        return brickCount == 0;
    }
}
