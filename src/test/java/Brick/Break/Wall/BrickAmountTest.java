package Brick.Break.Wall;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains all the unit testing for BrickAmount class.
 */
class BrickAmountTest {
    BrickAmount brickAmount = new BrickAmount(4);

    /**
     * This test case is used to test the expected output if all bricks are broken.
     */
    @Test
    void isDoneTest_AllBricksBroken(){
        brickAmount.setBrickCount(0);
        assertTrue(brickAmount.isDone());
    }

    /**
     * This test case is used to test the expected output if all bricks are not broken.
     */
    @Test
    void isDoneTest_AllBricksAreNotBroken(){
        brickAmount.setBrickCount(4);
        assertFalse(brickAmount.isDone());
    }

}