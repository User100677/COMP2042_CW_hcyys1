package Brick.Break.Brick.ClayBrick;

import Brick.Break.Ball.RubberBall.RubberBall;
import Brick.Break.Ball.RubberBall.RubberBallController;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;


import static org.junit.jupiter.api.Assertions.*;

class ClayBrickTest {

    ClayBrickController clayBrickController = new ClayBrickController(new ClayBrick(new Point(300, 430), new Dimension(15, 10)));

    @Test
    void makeBrickTest_CanCreateBrick(){
        assertNotNull(clayBrickController.makeBrickFace(new Point(200, 300), new Dimension(15, 10)));
    }
    @Test
    void setClayImpactTest_HaveImpact(){
        clayBrickController.setIsBroken(false);
        assertEquals(true, clayBrickController.setImpact(new Point(200, 300), 10));
    }
    @Test
    void setClayImpactTest_NoImpact(){
        clayBrickController.setIsBroken(true);
        assertEquals(false, clayBrickController.setImpact(new Point(200, 300), 10));
    }
    @Test
    void getBrokenTest_AfterRepair(){
        clayBrickController.repair();
        assertEquals(false, clayBrickController.isBroken());
    }
    @Test
    void getStrengthTest_AfterRepair(){
        clayBrickController.repair();
        assertEquals(1,clayBrickController.getSTRENGTH());
    }
    @Test
    void getStrengthTest_AfterImpact(){
        clayBrickController.impact();
        assertEquals(0, clayBrickController.getSTRENGTH());
    }
    @Test
    void getBrokenTest_AfterImpact(){
        clayBrickController.impact();
        assertEquals(true, clayBrickController.isBroken());
    }


}