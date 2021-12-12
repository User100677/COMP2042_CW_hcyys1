package Brick.Break.Brick.Crack.Directions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains all the unit testing for DirectionFactory class.
 */
class DirectionFactoryTest {

    DirectionFactory directionFactory = new DirectionFactory();

    /**
     * This test case is used to test if the instance of "DirectionLeft" class can be produce.
     */
    @Test
    void ableToProduceLeftDirectionTest(){
        assertNotNull(directionFactory.getDirection(10));
    }

    /**
     * This test case is used to test if the instance of "DirectionRight" class can be produce.
     */
    @Test
    void ableToProduceRightDirectionTest(){
        assertNotNull(directionFactory.getDirection(20));
    }

    /**
     * This test case is used to test if the instance of "DirectionUp" class can be produce.
     */
    @Test
    void ableToProduceUpDirectionTest(){
        assertNotNull(directionFactory.getDirection(30));
    }

    /**
     * This test case is used to test if the instance of "DirectionDown" class can be produce.
     */
    @Test
    void ableToProduceDownDirectionTest(){
        assertNotNull(directionFactory.getDirection(40));
    }

}