package Brick.Break.Brick.Directions;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DirectionDownTest {

    DirectionDown directionDown = new DirectionDown();

    @Test
    void getXStartLocationTest(){
        assertEquals(20, directionDown.setStartLocation(new Point(), new Rectangle(20,30, 4, 5)).getX());
    }
    @Test
    void getYStartLocationTest(){
        assertEquals(30, directionDown.setStartLocation(new Point(), new Rectangle(20,30, 4, 5)).getY());
    }

    @Test
    void getXEndLocationTest(){
        assertEquals(24, directionDown.setEndLocation(new Point(), new Rectangle(20,30, 4, 5)).getX());
    }
    @Test
    void getYEndLocationTest(){
        assertEquals(30, directionDown.setEndLocation(new Point(), new Rectangle(20,30, 4, 5)).getY());
    }


}