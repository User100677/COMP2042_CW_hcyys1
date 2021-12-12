package Brick.Break.Brick.ClayBrick;


import org.junit.jupiter.api.Test;
import java.awt.*;



import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains all the unit testing for ClayBrickController class.
 */
class ClayBrickControllerTest {

    ClayBrickController clayBrickController = new ClayBrickController(new ClayBrick(new Point(300, 430), new Dimension(15, 10)));

    /**
     * This test case is used to test if the "makeBrickFace()" method can create clay brick or not.
     */
    @Test
    void makeBrickTest_CanCreateBrick(){
        assertNotNull(clayBrickController.makeBrickFace(new Point(200, 300), new Dimension(15, 10)));
    }

    /**
     * This test case is used to test the expected "setImpact()" method output when the clay brick have received impact.
     */
    @Test
    void setClayImpactTest_HaveImpact(){
        clayBrickController.setBROKEN(false);
        assertEquals(true, clayBrickController.setImpact(new Point(200, 300), 10));
    }

    /**
     * This test case is used to test the expected "setImpact()" method output when the cement brick did not receive any  impact.
     */

    @Test
    void setClayImpactTest_NoImpact(){
        clayBrickController.setBROKEN(true);
        assertEquals(false, clayBrickController.setImpact(new Point(200, 300), 10));
    }

    /**
     * This test case is used to test if the broken clay brick is repaired after the "repair()" method.
     */
    @Test
    void getBrokenTest_AfterRepair(){
        clayBrickController.repair();
        assertEquals(false, clayBrickController.isBroken());
    }

    /**
     * This test case is used to test if the strength of the clay brick is reset after the "repair()" method.
     */
    @Test
    void getStrengthTest_AfterRepair(){
        clayBrickController.repair();
        assertEquals(1,clayBrickController.getSTRENGTH());
    }

    /**
     * This test case is used to test the strength of the clay brick after one impact from the ball.
     */
    @Test
    void getStrengthTest_AfterImpact(){
        clayBrickController.impact();
        assertEquals(0, clayBrickController.getSTRENGTH());
    }

    /**
     * This test case is used to test if the brick break after one impact from the ball.
     */
    @Test
    void getBrokenTest_AfterImpact(){
        clayBrickController.impact();
        assertEquals(true, clayBrickController.isBroken());
    }


}