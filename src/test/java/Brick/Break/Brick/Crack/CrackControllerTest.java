package Brick.Break.Brick.Crack;

import Brick.Break.Brick.CementBrick.CementBrick;
import Brick.Break.Brick.CementBrick.CementBrickController;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains all the unit testing for CrackController class.
 */
class CrackControllerTest {

    CrackController crackController = new CrackController(new Crack(new CementBrickController(new CementBrick(new Point(200, 300), new Dimension(15, 10))), 10, 35));

    /**
     * This test case is used to test if the crack can be reset or not.
     */
    @Test
    void resetTest_CanRest() {
        crackController.reset();
        assertNotNull(crackController.getControllerCrack());

    }

    /**
     * This test case is used to test the expected output of jump probability after the "makeCrack" method.
     */
    @Test
    void getJumpProbabilityTest_AfterMakeCrack() {
        crackController.makeCrack(new Point(10,20), new Point (20,30));
        assertEquals(0.7, crackController.getControllerJumpProbability());
    }

    /**
     * This test case is used to test if the game able to make crack after the "makeCrack()" method.
     */
    @Test
    void makeCrackTest_AbleToMakeCrack() {
        crackController.makeCrack(new Point(10,20), new Point (20,30));
        assertNotNull(crackController.getControllerCrack());
    }

    /**
     * This test case is used to test the expected "inMiddle()" method output if it is in the middle.
     */
    @Test
    void inMiddleTest(){
        assertEquals(true, crackController.inMiddle(5, 10, 5));
    }

    /**
     * This test case is used to test the expected "inMiddle()" method output if it is not in the middle.
     */
    @Test
    void notInMiddleTest(){
        assertEquals(false, crackController.inMiddle(1, 10, 5));
    }
}