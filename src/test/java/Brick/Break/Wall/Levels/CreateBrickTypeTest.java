package Brick.Break.Wall.Levels;


import org.junit.jupiter.api.Test;


import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains all the unit testing for CreateBrickType class.
 */
class CreateBrickTypeTest {
    CreateBrickType createBrickType = new CreateBrickType();
    Point p = new Point(2, 4);
    Dimension d = new Dimension(4, 5);
    ;


    /**
     * This test case is used to test if the clay brick can be created.
     */
    @Test
    void makeClayBrickTest_CanCreateNewClayBrickObject(){
        assertNotNull(createBrickType.makeBrick(p,d, 1));
    }

    /**
     * This test case is used to test if the steel brick can be created.
     */
    @Test
    void makeSteelBrickTest_CanCreateNewSteelBrickObject(){
        assertNotNull(createBrickType.makeBrick(p,d, 2));
    }

    /**
     * This test case is used to test if the cement brick can be created.
     */
    @Test
    void makeCementBrickTest_CanCreateNewCementBrickObject(){
        assertNotNull(createBrickType.makeBrick(p,d, 3));
    }

    /**
     * This test case is used to test if the gold brick can be created.
     */
    @Test
    void makeGoldBrickTest_CanCreateNewGoldBrickObject(){
        assertNotNull(createBrickType.makeBrick(p,d, 4));
    }

    /**
     * This test case is used to test if brick types are different.
     */
    @Test
    void makeBrickTest_AllObjectCreationIsDifferent(){
        assertTrue(createBrickType.makeBrick(p,d, 1) != createBrickType.makeBrick(p,d, 2) && createBrickType.makeBrick(p,d, 2) != createBrickType.makeBrick(p,d, 3) &&
                createBrickType.makeBrick(p,d, 3) != createBrickType.makeBrick(p,d, 4) && createBrickType.makeBrick(p,d, 4) != createBrickType.makeBrick(p,d, 1));
    }

}
