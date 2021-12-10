package Brick.Break.Brick.Crack.Directions;

import Brick.Break.Brick.Crack.Directions.DirectionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionFactoryTest {

    DirectionFactory directionFactory = new DirectionFactory();

    @Test
    void ableToProduceLeftDirectionTest(){
        assertNotNull(directionFactory.getDirection(10));
    }
    @Test
    void ableToProduceRightDirectionTest(){
        assertNotNull(directionFactory.getDirection(20));
    }
    @Test
    void ableToProduceUpDirectionTest(){
        assertNotNull(directionFactory.getDirection(30));
    }
    @Test
    void ableToProduceDownDirectionTest(){
        assertNotNull(directionFactory.getDirection(40));
    }

}