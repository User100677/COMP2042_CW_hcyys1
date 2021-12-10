package Brick.Break.Wall;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WallControllerTest {
    WallController wallController = new WallController(new Wall(new Rectangle(0,0,600,450),30,3,6/2,new Point(300,430)));

    @Test
    void makeBallTest_CanCreateBall(){
        wallController.makeBall(new Point(300,430));
        assertNotNull( wallController.getWallBallController());
    }
    @Test
    void impactBorderTest_NoHitBorder(){
        assertFalse(wallController.impactBorder());
    }
    @Test
    void impactBorderTest_HaveHitBorder(){
        WallController wallController = new WallController(new Wall(new Rectangle(0,0,600,450),30,3,6/2,new Point(-1,430)));
        assertTrue(wallController.impactBorder());
    }

    @Test
    void BallXSpeedTest_afterBallRest(){
        wallController.ballReset();

        assertEquals(3, wallController.getBallXSpeed());
    }

    @Test
    void BallYSpeedTest_afterBallRest(){
        wallController.ballReset();

        assertEquals(-3, wallController.getBallYSpeed());
    }

    @Test
    void BallLostTest_afterBallRest(){
        wallController.ballReset();

        assertFalse( wallController.getWallBallAmount().isBallLost());
    }



}