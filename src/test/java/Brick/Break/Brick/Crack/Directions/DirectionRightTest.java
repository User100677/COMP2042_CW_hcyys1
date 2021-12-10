package Brick.Break.Brick.Crack.Directions;

import Brick.Break.Brick.Crack.Directions.DirectionRight;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DirectionRightTest {

    DirectionRight directionRight = new DirectionRight();

    @Test
    void getXStartLocationTest(){
        assertEquals(20, directionRight.setStartLocation(new Point(), new Rectangle(20,30, 4, 5)).getX());
    }
    @Test
    void getYStartLocationTest(){
        assertEquals(30, directionRight.setStartLocation(new Point(), new Rectangle(20,30, 4, 5)).getY());
    }

    @Test
    void getXEndLocationTest(){
        assertEquals(20, directionRight.setEndLocation(new Point(), new Rectangle(20,30, 4, 5)).getX());
    }
    @Test
    void getYEndLocationTest(){
        assertEquals(35, directionRight.setEndLocation(new Point(), new Rectangle(20,30, 4, 5)).getY());
    }

}