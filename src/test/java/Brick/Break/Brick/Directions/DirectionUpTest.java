package Brick.Break.Brick.Directions;

import Brick.Break.Brick.Crack.Directions.DirectionUp;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DirectionUpTest {

    DirectionUp directionUp = new DirectionUp();

    @Test
    void getXStartLocationTest(){
        assertEquals(20, directionUp.setStartLocation(new Point(), new Rectangle(20,30, 4, 5)).getX());
    }
    @Test
    void getYStartLocationTest(){
        assertEquals(35, directionUp.setStartLocation(new Point(), new Rectangle(20,30, 4, 5)).getY());
    }

    @Test
    void getXEndLocationTest(){
        assertEquals(24, directionUp.setEndLocation(new Point(), new Rectangle(20,30, 4, 5)).getX());
    }
    @Test
    void getYEndLocationTest(){
        assertEquals(35, directionUp.setEndLocation(new Point(), new Rectangle(20,30, 4, 5)).getY());
    }

}