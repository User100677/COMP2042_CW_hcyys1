package Brick.Break.Brick.SteelBrick;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains all the unit testing for SteelBrickController class.
 */
class SteelBrickControllerTest {

    SteelBrickController steelBrickController = new SteelBrickController(new SteelBrick(new Point(200, 300), new Dimension(15, 10)));

    /**
     * This test case is used to test if the "makeBrickFace()" method can create steel brick or not.
     */
    @Test
    void makeSteelBrickTest_CanCreateBrick(){
        assertNotNull(steelBrickController.makeBrickFace(new Point(200, 300), new Dimension(15, 10)));
    }

    /**
     * This test case is used to test the expected "setImpact()" method output when the steel brick have received impact.
     */
    @Test
    void setSteelImpactTest_HaveImpact(){
        steelBrickController.setBROKEN(false);
        steelBrickController.impact();
        steelBrickController.impact();
        assertEquals(true, steelBrickController.setImpact(new Point(200, 300), 10));
    }

    /**
     * This test case is used to test the expected "setImpact()" method output when the steel brick did not receive any  impact.
     */
    @Test
    void setSteelImpactTest_NoImpact(){
        steelBrickController.setBROKEN(true);
        assertEquals(false, steelBrickController.setImpact(new Point(200, 300), 10));
    }

    /**
     * This test case is used to test if the broken steel brick is repaired after the "repair()" method.
     */
    @Test
    void getBrokenTest_AfterRepair(){
        steelBrickController.repair();
        assertEquals(false, steelBrickController.isBroken());
    }

    /**
     * This test case is used to test if the strength of the steel brick is reset after the "repair()" method.
     */
    @Test
    void getStrengthTest_AfterRepair(){
        steelBrickController.repair();
        assertEquals(3,steelBrickController.getSTRENGTH());
    }

    /**
     * This test case is used to test the strength of the steel brick after one impact from the ball.
     */
    @Test
    void getStrengthTest_AfterImpact(){
        steelBrickController.impact();
        assertEquals(2, steelBrickController.getSTRENGTH());
    }

    /**
     * This test case is used to test the strength of the steel brick after three impact from the ball.
     */
    @Test
    void getStrengthTest_AfterThreeImpact(){
        steelBrickController.impact();
        steelBrickController.impact();
        steelBrickController.impact();
        assertEquals(0, steelBrickController.getSTRENGTH());
    }

    /**
     * This test case is used to test if the brick break after one impact from the ball.
     */
    @Test
    void getBrokenTest_AfterImpact(){
        steelBrickController.impact();
        assertEquals(false, steelBrickController.isBroken());
    }

    /**
     * This test case is used to test if the brick break after three impact from the ball.
     */
    @Test
    void getBrokenText_AfterThreeImpact(){
        steelBrickController.impact();
        steelBrickController.impact();
        steelBrickController.impact();
        assertEquals(true, steelBrickController.isBroken());
    }


}