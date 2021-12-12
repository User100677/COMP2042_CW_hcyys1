package Brick.Break.Brick.CementBrick;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains all the unit testing for CementBrickController class.
 */
class CementBrickControllerTest {

    CementBrickController cementBrickController = new CementBrickController(new CementBrick(new Point(200, 300), new Dimension(15, 10)));

    /**
     * This test case is used to test if the "makeBrickFace()" method can create cement brick or not.
     */
    @Test
    void makeCementBrickTest_CanCreateBrick(){
        assertNotNull(cementBrickController.makeBrickFace(new Point(200, 300), new Dimension(15, 10)));
    }

    /**
     * This test case is used to test the expected "setImpact()" method output when the cement brick have received impact.
     */
    @Test
    void setCementImpactTest_HaveImpact(){
        cementBrickController.setBROKEN(false);
        cementBrickController.impact();
        assertEquals(true, cementBrickController.setImpact(new Point(200, 300), 10));
    }

    /**
     * This test case is used to test the expected "setImpact()" method output when the cement brick did not receive any  impact.
     */
    @Test
    void setCementImpactTest_NoImpact(){
        cementBrickController.setBROKEN(true);
        assertEquals(false, cementBrickController.setImpact(new Point(200, 300), 10));
    }

    /**
     * This test case is used to test if the broken cement brick is repaired after the "repair()" method.
     */
    @Test
    void getBrokenTest_AfterRepair(){
        cementBrickController.repair();
        assertEquals(false, cementBrickController.isBroken());
    }

    /**
     * This test case is used to test if the strength of the cement brick is reset after the "repair()" method.
     */
    @Test
    void getStrengthTest_AfterRepair(){
        cementBrickController.repair();
        assertEquals(2,cementBrickController.getSTRENGTH());
    }

    /**
     * This test case is used to test the strength of the cement brick after one impact from the ball.
     */
    @Test
    void getStrengthTest_AfterImpact(){
        cementBrickController.impact();
        assertEquals(1, cementBrickController.getSTRENGTH());
    }

    /**
     * This test case is used to test the strength of the cement brick after two impact from the ball.
     */
    @Test
    void getStrengthTest_AfterTwoImpact(){
        cementBrickController.impact();
        cementBrickController.impact();
        assertEquals(0, cementBrickController.getSTRENGTH());
    }

    /**
     * This test case is used to test if the brick break after one impact from the ball.
     */
    @Test
    void getBrokenTest_AfterImpact(){
        cementBrickController.impact();
        assertEquals(false, cementBrickController.isBroken());
    }

    /**
     * This test case is used to test if the brick break after two impact from the ball.
     */
    @Test
    void getBrokenTest_AfterTwoImpact(){
        cementBrickController.impact();
        cementBrickController.impact();
        assertEquals(true, cementBrickController.isBroken());
    }

}