package Brick.Break.Brick.GoldBrick;

import Brick.Break.Brick.SteelBrick.SteelBrick;
import Brick.Break.Brick.SteelBrick.SteelBrickController;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GoldBrickControllerTest {

    GoldBrickController GoldBrickController = new GoldBrickController(new GoldBrick(new Point(200, 300), new Dimension(15, 10)));

    @Test
    void makeColdBrickTest_CanCreateBrick(){
        assertNotNull(GoldBrickController.makeBrickFace(new Point(200, 300), new Dimension(15, 10)));
    }
    @Test
    void setGoldImpactTest_HaveImpact(){
        GoldBrickController.setIsBroken(false);
        GoldBrickController.impact();
        GoldBrickController.impact();
        GoldBrickController.impact();
        assertEquals(true, GoldBrickController.setImpact(new Point(200, 300), 10));
    }
    @Test
    void setGoldImpactTest_NoImpact(){
        GoldBrickController.setIsBroken(true);
        assertEquals(false, GoldBrickController.setImpact(new Point(200, 300), 10));
    }
    @Test
    void getBrokenTest_AfterRepair(){
        GoldBrickController.repair();
        assertEquals(false, GoldBrickController.isBroken());
    }
    @Test
    void getStrengthTest_AfterRepair(){
        GoldBrickController.repair();
        assertEquals(4,GoldBrickController.getSTRENGTH());
    }
    @Test
    void getStrengthTest_AfterImpact(){
        GoldBrickController.impact();
        assertEquals(3, GoldBrickController.getSTRENGTH());
    }
    @Test
    void getStrengthTest_AfterFourImpact(){
        GoldBrickController.impact();
        GoldBrickController.impact();
        GoldBrickController.impact();
        GoldBrickController.impact();
        assertEquals(0, GoldBrickController.getSTRENGTH());
    }
    @Test
    void getBrokenTest_AfterImpact(){
        GoldBrickController.impact();
        assertEquals(false, GoldBrickController.isBroken());
    }
    @Test
    void getBrokenText_AfterFourImpact(){
        GoldBrickController.impact();
        GoldBrickController.impact();
        GoldBrickController.impact();
        GoldBrickController.impact();
        assertEquals(true, GoldBrickController.isBroken());
    }

}