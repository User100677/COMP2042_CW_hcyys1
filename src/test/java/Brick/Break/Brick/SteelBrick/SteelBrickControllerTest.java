package Brick.Break.Brick.SteelBrick;

import Brick.Break.Brick.CementBrick.CementBrick;
import Brick.Break.Brick.CementBrick.CementBrickController;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SteelBrickControllerTest {

    SteelBrickController steelBrickController = new SteelBrickController(new SteelBrick(new Point(200, 300), new Dimension(15, 10)));

    @Test
    void makeCementBrickTest_CanCreateBrick(){
        assertNotNull(steelBrickController.makeBrickFace(new Point(200, 300), new Dimension(15, 10)));
    }
    @Test
    void setImpactTest(){
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