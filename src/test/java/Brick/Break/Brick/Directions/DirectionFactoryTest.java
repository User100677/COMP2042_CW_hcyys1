package Brick.Break.Brick.Directions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionFactoryTest {

    DirectionFactory directionFactory = new DirectionFactory();

    @Test
    void AbleToProduceLeftDirectionTest(){
        assertNotNull(directionFactory.getDirection(10));
    }
    @Test
    void AbleToProduceRightDirectionTest(){
        assertNotNull(directionFactory.getDirection(20));
    }
    @Test
    void AbleToProduceUpDirectionTest(){
        assertNotNull(directionFactory.getDirection(30));
    }
    @Test
    void AbleToProduceDownDirectionTest(){
        assertNotNull(directionFactory.getDirection(40));
    }

}