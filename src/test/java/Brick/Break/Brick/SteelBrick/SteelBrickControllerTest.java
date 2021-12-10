package Brick.Break.Brick.SteelBrick;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SteelBrickControllerTest {

    SteelBrickController steelBrickController = new SteelBrickController(new SteelBrick(new Point(200, 300), new Dimension(15, 10)));

    @Test
    void makeSteelBrickTest_CanCreateBrick(){
        assertNotNull(steelBrickController.makeBrickFace(new Point(200, 300), new Dimension(15, 10)));
    }
    @Test
    void setSteelImpactTest_HaveImpact(){
        steelBrickController.setIsBroken(false);
        steelBrickController.impact();
        steelBrickController.impact();
        assertEquals(true, steelBrickController.setImpact(new Point(200, 300), 10));
    }
    @Test
    void setSteelImpactTest_NoImpact(){
        steelBrickController.setIsBroken(true);
        assertEquals(false, steelBrickController.setImpact(new Point(200, 300), 10));
    }
    @Test
    void getBrokenTest_AfterRepair(){
        steelBrickController.repair();
        assertEquals(false, steelBrickController.isBroken());
    }
    @Test
    void getStrengthTest_AfterRepair(){
        steelBrickController.repair();
        assertEquals(3,steelBrickController.getSTRENGTH());
    }
    @Test
    void getStrengthTest_AfterImpact(){
        steelBrickController.impact();
        assertEquals(2, steelBrickController.getSTRENGTH());
    }
    @Test
    void getStrengthTest_AfterThreeImpact(){
        steelBrickController.impact();
        steelBrickController.impact();
        steelBrickController.impact();
        assertEquals(0, steelBrickController.getSTRENGTH());
    }
    @Test
    void getBrokenTest_AfterImpact(){
        steelBrickController.impact();
        assertEquals(false, steelBrickController.isBroken());
    }
    @Test
    void getBrokenText_AfterThreeImpact(){
        steelBrickController.impact();
        steelBrickController.impact();
        steelBrickController.impact();
        assertEquals(true, steelBrickController.isBroken());
    }


}