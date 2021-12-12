package Brick.Break.Wall;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains all the unit testing for BallAmount class.
 */
class BallAmountTest {
    BallAmount ballAmount = new BallAmount(3, true);

    /**
     * This test case is used to test the expected output when the ball is lost.
     */
    @Test
    void ballGotLostTest(){
        ballAmount.setBallLost(true);
        assertTrue(ballAmount.isBallLost());
    }

    /**
     * This test case is used to test the expected output when the ball is not lost.
     */
    @Test
    void ballNoLostTest(){
        ballAmount.setBallLost(false);
        assertFalse(ballAmount.isBallLost());
    }

    /**
     * This test case is used to test the expected output when the all ball is lost.
     */
    @Test
    void allBallLostTest(){
        ballAmount.setBallCount(0);
        assertTrue(ballAmount.ballEnd());
    }

    /**
     * This test case is used to test the expected output when the all ball is not lost.
     */
    @Test
    void notAllBallLostTest(){
        ballAmount.setBallCount(2);
        assertFalse(ballAmount.ballEnd());
    }

    /**
     * This test case is used to test the expected output when the amount of balls is reset.
     */
    @Test
    void resetBallTest(){
        ballAmount.resetBallCount();
        assertEquals(3, ballAmount.getBallCount());
    }
}