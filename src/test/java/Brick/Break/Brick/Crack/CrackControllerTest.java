package Brick.Break.Brick.Crack;

import Brick.Break.Brick.CementBrick.CementBrick;
import Brick.Break.Brick.CementBrick.CementBrickController;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class CrackControllerTest {

    CrackController crackController = new CrackController(new Crack(new CementBrickController(new CementBrick(new Point(200, 300), new Dimension(15, 10))), 10, 35));

    @Test
    void resetTest_CanRest() {
        crackController.reset();
        assertNotNull(crackController.getControllerCrack());

    }

    @Test
    void getJumpProbabilityTest_AfterMakeCrack() {
        crackController.makeCrack(new Point(10,20), new Point (20,30));
        assertEquals(0.7, crackController.getControllerJumpProbability());
    }

    @Test
    void makeCrackTest_AbleToMakeLeftCrack() {
        crackController.makeCrack(new Point(10,20), new Point (20,30));
        assertNotNull(crackController.getControllerCrack());
    }

    @Test
    void inMiddleTest(){
        assertEquals(true, crackController.inMiddle(5, 10, 5));
    }
    @Test
    void notInMiddleTest(){
        assertEquals(false, crackController.inMiddle(1, 10, 5));
    }
}