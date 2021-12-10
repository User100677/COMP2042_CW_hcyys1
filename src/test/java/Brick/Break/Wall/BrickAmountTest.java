package Brick.Break.Wall;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrickAmountTest {
    BrickAmount brickAmount = new BrickAmount(4);

    @Test
    void isDoneTest_AllBricksBroken(){
        brickAmount.setBrickCount(0);
        assertTrue(brickAmount.isDone());
    }
    @Test
    void isDoneTest_AllBricksAreNotBroken(){
        brickAmount.setBrickCount(4);
        assertFalse(brickAmount.isDone());
    }

}