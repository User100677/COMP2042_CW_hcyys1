package Brick.Break.Brick.Directions;

import Brick.Break.Brick.Crack.Directions.DirectionLeft;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DirectionLeftTest {
    DirectionLeft directionLeft = new DirectionLeft();

    @Test
    void getXStartLocationTest(){
        assertEquals(24, directionLeft.setStartLocation(new Point(), new Rectangle(20,30, 4, 5)).getX());
    }
    @Test
    void getYStartLocationTest(){
        assertEquals(30, directionLeft.setStartLocation(new Point(), new Rectangle(20,30, 4, 5)).getY());
    }

    @Test
    void getXEndLocationTest(){
        assertEquals(0, directionLeft.setEndLocation(new Point(), new Rectangle(20,30, 4, 5)).getX());
    }
    @Test
    void getYEndLocationTest(){
        assertEquals(0, directionLeft.setEndLocation(new Point(), new Rectangle(20,30, 4, 5)).getY());
    }

}