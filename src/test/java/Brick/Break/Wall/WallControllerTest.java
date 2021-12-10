package Brick.Break.Wall;

import Brick.Break.Brick.BrickController;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WallControllerTest {
    BrickController b;
    WallController wallController = new WallController(new Wall(new Rectangle(0,0,600,450),30,3,6/2,new Point(300,430)));

    @Test
    void firstInitializeStartPointTest_XPosition(){
        assertEquals(300,wallController.getWallStartPoint().getX());
    }
    @Test
    void firstInitializeStartPointTest_YPosition(){
        assertEquals(430,wallController.getWallStartPoint().getY());
    }
    @Test
    void firstInitializeValueOfBallCountTest(){
        assertEquals(3, wallController.getWallBallAmount().getBallCount());
    }
    @Test
    void firstInitializeValueOfBallLostTest(){
        assertFalse(wallController.getWallBallAmount().isBallLost());
    }
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
    void ballXSpeedTest_afterBallReset(){
        wallController.ballReset();

        assertEquals(3, wallController.getBallXSpeed());
    }

    @Test
    void ballYSpeedTest_afterBallReset(){
        wallController.ballReset();

        assertEquals(-3, wallController.getBallYSpeed());
    }

    @Test
    void ballLostTest_afterBallReset(){
        wallController.ballReset();

        assertFalse( wallController.getWallBallAmount().isBallLost());
    }

    @Test
    void playerXPositionTest_AfterMoveMethod(){
        wallController.move();
        assertEquals(225,wallController.getWallPlayerController().getPlayerControllerFace().getX());
    }

    @Test
    void playerYPositionTest_AfterMoveMethod(){
        wallController.move();
        assertEquals(430,wallController.getWallPlayerController().getPlayerControllerFace().getY());
    }


}