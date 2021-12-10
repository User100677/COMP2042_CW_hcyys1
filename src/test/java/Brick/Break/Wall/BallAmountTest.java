package Brick.Break.Wall;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallAmountTest {
    BallAmount ballAmount = new BallAmount(3, true);

    @Test
    void BallGotLostTest(){
        ballAmount.setBallLost(true);
        assertTrue(ballAmount.isBallLost());
    }
    @Test
    void BallNoLostTest(){
        ballAmount.setBallLost(false);
        assertFalse(ballAmount.isBallLost());
    }

    @Test
    void AllBallLostTest(){
        ballAmount.setBallCount(0);
        assertTrue(ballAmount.ballEnd());
    }
    @Test
    void NotAllBallLostTest(){
        ballAmount.setBallCount(2);
        assertFalse(ballAmount.ballEnd());
    }
    @Test
    void ResetBallTest(){
        ballAmount.resetBallCount();
        assertEquals(3, ballAmount.getBallCount());
    }
}