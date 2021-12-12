package Brick.Break.Wall;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This class contains all the unit testing for WallController class.
 */
class WallControllerTest {
    WallController wallController = new WallController(new Wall(new Rectangle(0,0,600,450),30,3,6/2,new Point(300,430)));

    /**
     * This test case is used to test the expected output of first initialize x start location.
     */
    @Test
    void firstInitializeStartPointTest_XPosition(){
        assertEquals(300,wallController.getWallStartPoint().getX());
    }

    /**
     * This test case is used to test the expected output of first initialize Y start location.
     */
    @Test
    void firstInitializeStartPointTest_YPosition(){
        assertEquals(430,wallController.getWallStartPoint().getY());
    }

    /**
     * This test case is used to test the expected output of first initialize total amount of ball.
     */
    @Test
    void firstInitializeValueOfBallCountTest(){
        assertEquals(3, wallController.getWallBallAmount().getBallCount());
    }

    /**
     * This test case is used to test the expected output of first initialize value of ball lost.
     */
    @Test
    void firstInitializeValueOfBallLostTest(){
        assertFalse(wallController.getWallBallAmount().isBallLost());
    }

    /**
     * This test case is used to test if the rubber ball can be created.
     */
    @Test
    void makeBallTest_CanCreateBall(){
        wallController.makeBall(new Point(300,430));
        assertNotNull( wallController.getWallBallController());
    }

    /**
     * This test case is used to test if the sides of the border receive impact from the ball.
     */
    @Test
    void impactBorderTest_NoHitBorder(){
        assertFalse(wallController.impactBorder());
    }

    /**
     * This test case is used to test if the sides of the border did not receive impact from the ball.
     */
    @Test
    void impactBorderTest_HaveHitBorder(){
        WallController wallController = new WallController(new Wall(new Rectangle(0,0,600,450),30,3,6/2,new Point(-1,430)));
        assertTrue(wallController.impactBorder());
    }

    /**
     * This test case is used to test if the X speed of the ball is reset after the "ballReset()" method.
     */
    @Test
    void ballXSpeedTest_afterBallReset(){
        wallController.ballReset();

        assertEquals(3, wallController.getBallXSpeed());
    }

    /**
     * This test case is used to test if the Y speed of the ball is reset after the "ballReset()" method.
     */
    @Test
    void ballYSpeedTest_afterBallReset(){
        wallController.ballReset();

        assertEquals(-3, wallController.getBallYSpeed());
    }

    /**
     * This test case is used to test if the ball is lost after "ballReset()" method.
     */
    @Test
    void ballLostTest_afterBallReset(){
        wallController.ballReset();

        assertFalse( wallController.getWallBallAmount().isBallLost());
    }

    /**
     * This test case is used to test the expected output of player X position after the "Move" method.
     */
    @Test
    void playerXPositionTest_AfterMoveMethod(){
        wallController.move();
        assertEquals(225,wallController.getWallPlayerController().getPlayerControllerFace().getX());
    }

    /**
     * This test case is used to test the expected output of player Y position after the "Move" method.
     */
    @Test
    void playerYPositionTest_AfterMoveMethod(){
        wallController.move();
        assertEquals(430,wallController.getWallPlayerController().getPlayerControllerFace().getY());
    }


}