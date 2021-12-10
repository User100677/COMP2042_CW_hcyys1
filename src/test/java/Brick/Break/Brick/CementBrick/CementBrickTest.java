package Brick.Break.Brick.CementBrick;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CementBrickTest {

    CementBrickController cementBrickController = new CementBrickController(new CementBrick(new Point(200, 300), new Dimension(15, 10)));

    @Test
    void makeCementBrickTest_CanCreateBrick(){
        assertNotNull(cementBrickController.makeBrickFace(new Point(200, 300), new Dimension(15, 10)));
    }
    @Test
    void setCementImpactTest_HaveImpact(){
        cementBrickController.setIsBroken(false);
        cementBrickController.impact();
        assertEquals(true, cementBrickController.setImpact(new Point(200, 300), 10));
    }
    @Test
    void setCementImpactTest_NoImpact(){
        cementBrickController.setIsBroken(true);
        assertEquals(false, cementBrickController.setImpact(new Point(200, 300), 10));
    }
    @Test
    void getBrokenTest_AfterRepair(){
        cementBrickController.repair();
        assertEquals(false, cementBrickController.isBroken());
    }
    @Test
    void getStrengthTest_AfterRepair(){
        cementBrickController.repair();
        assertEquals(2,cementBrickController.getSTRENGTH());
    }
    @Test
    void getStrengthTest_AfterImpact(){
        cementBrickController.impact();
        assertEquals(1, cementBrickController.getSTRENGTH());
    }
    @Test
    void getStrengthTest_AfterTwoImpact(){
        cementBrickController.impact();
        cementBrickController.impact();
        assertEquals(0, cementBrickController.getSTRENGTH());
    }
    @Test
    void getBrokenTest_AfterImpact(){
        cementBrickController.impact();
        assertEquals(false, cementBrickController.isBroken());
    }
    @Test
    void getBrokenTest_AfterTwoImpact(){
        cementBrickController.impact();
        cementBrickController.impact();
        assertEquals(true, cementBrickController.isBroken());
    }

}