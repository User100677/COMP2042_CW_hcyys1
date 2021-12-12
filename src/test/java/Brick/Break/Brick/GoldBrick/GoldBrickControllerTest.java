package Brick.Break.Brick.GoldBrick;

import org.junit.jupiter.api.Test;

import java.awt.*;

/**
 * This class contains all the unit testing for GoldBrickController class.
 */
import static org.junit.jupiter.api.Assertions.*;

class GoldBrickControllerTest {

    GoldBrickController GoldBrickController = new GoldBrickController(new GoldBrick(new Point(200, 300), new Dimension(15, 10)));

    /**
     * This test case is used to test if the "makeBrickFace()" method can create gold brick or not.
     */
    @Test
    void makeColdBrickTest_CanCreateBrick(){
        assertNotNull(GoldBrickController.makeBrickFace(new Point(200, 300), new Dimension(15, 10)));
    }

    /**
     * This test case is used to test the expected "setImpact()" method output when the gold brick have received impact.
     */
    @Test
    void setGoldImpactTest_HaveImpact(){
        GoldBrickController.setBROKEN(false);
        GoldBrickController.impact();
        GoldBrickController.impact();
        GoldBrickController.impact();
        assertEquals(true, GoldBrickController.setImpact(new Point(200, 300), 10));
    }

    /**
     * This test case is used to test the expected "setImpact()" method output when the gold brick did not receive any  impact.
     */
    @Test
    void setGoldImpactTest_NoImpact(){
        GoldBrickController.setBROKEN(true);
        assertEquals(false, GoldBrickController.setImpact(new Point(200, 300), 10));
    }

    /**
     * This test case is used to test if the broken gold brick is repaired after the "repair()" method.
     */
    @Test
    void getBrokenTest_AfterRepair(){
        GoldBrickController.repair();
        assertEquals(false, GoldBrickController.isBroken());
    }

    /**
     * This test case is used to test if the strength of the gold brick is reset after the "repair()" method.
     */
    @Test
    void getStrengthTest_AfterRepair(){
        GoldBrickController.repair();
        assertEquals(4,GoldBrickController.getSTRENGTH());
    }

    /**
     * This test case is used to test the strength of the gold brick after one impact from the ball.
     */
    @Test
    void getStrengthTest_AfterImpact(){
        GoldBrickController.impact();
        assertEquals(3, GoldBrickController.getSTRENGTH());
    }

    /**
     * This test case is used to test the strength of the gold brick after four impact from the ball.
     */
    @Test
    void getStrengthTest_AfterFourImpact(){
        GoldBrickController.impact();
        GoldBrickController.impact();
        GoldBrickController.impact();
        GoldBrickController.impact();
        assertEquals(0, GoldBrickController.getSTRENGTH());
    }

    /**
     * This test case is used to test if the brick break after one impact from the ball.
     */
    @Test
    void getBrokenTest_AfterImpact(){
        GoldBrickController.impact();
        assertEquals(false, GoldBrickController.isBroken());
    }

    /**
     * This test case is used to test if the brick break after four impact from the ball.
     */
    @Test
    void getBrokenText_AfterFourImpact(){
        GoldBrickController.impact();
        GoldBrickController.impact();
        GoldBrickController.impact();
        GoldBrickController.impact();
        assertEquals(true, GoldBrickController.isBroken());
    }

}