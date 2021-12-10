package Brick.Break.Wall;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallAmountTest {
    BallAmount ballAmount = new BallAmount(3, true);

    @Test
    void ballGotLostTest(){
        ballAmount.setBallLost(true);
        assertTrue(ballAmount.isBallLost());
    }
    @Test
    void ballNoLostTest(){
        ballAmount.setBallLost(false);
        assertFalse(ballAmount.isBallLost());
    }

    @Test
    void allBallLostTest(){
        ballAmount.setBallCount(0);
        assertTrue(ballAmount.ballEnd());
    }
    @Test
    void notAllBallLostTest(){
        ballAmount.setBallCount(2);
        assertFalse(ballAmount.ballEnd());
    }
    @Test
    void resetBallTest(){
        ballAmount.resetBallCount();
        assertEquals(3, ballAmount.getBallCount());
    }
}