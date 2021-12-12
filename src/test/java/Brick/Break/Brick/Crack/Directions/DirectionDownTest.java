package Brick.Break.Brick.Crack.Directions;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This class contains all the unit testing for DirectionDown class.
 */
class DirectionDownTest {

    DirectionDown directionDown = new DirectionDown();

    /**
     * This test case is used to test the expected X start location.
     */
    @Test
    void getXStartLocationTest(){
        assertEquals(20, directionDown.setStartLocation(new Point(), new Rectangle(20,30, 4, 5)).getX());
    }


    /**
     * This test case is used to test the expected Y start location.
     */
    @Test
    void getYStartLocationTest(){
        assertEquals(30, directionDown.setStartLocation(new Point(), new Rectangle(20,30, 4, 5)).getY());
    }

    /**
     * This test case is used to test the expected X end location.
     */
    @Test
    void getXEndLocationTest(){
        assertEquals(24, directionDown.setEndLocation(new Point(), new Rectangle(20,30, 4, 5)).getX());
    }

    /**
     * This test case is used to test the expected Y end location.
     */
    @Test
    void getYEndLocationTest(){
        assertEquals(30, directionDown.setEndLocation(new Point(), new Rectangle(20,30, 4, 5)).getY());
    }


}