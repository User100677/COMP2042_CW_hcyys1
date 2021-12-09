package Brick.Break.Wall.Levels;


import org.junit.jupiter.api.Test;


import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CreateBrickTypeTest {
    CreateBrickType createBrickType = new CreateBrickType();
    Point p = new Point(2, 4);
    Dimension d = new Dimension(4, 5);
    ;



    @Test
    void makeClayBrickTest_CanCreateNewClayBrickObject(){
        assertNotNull(createBrickType.makeBrick(p,d, 1));
    }

    @Test
    void makeSteelBrickTest_CanCreateNewSteelBrickObject(){
        assertNotNull(createBrickType.makeBrick(p,d, 2));
    }
    @Test
    void makeCementBrickTest_CanCreateNewCementBrickObject(){
        assertNotNull(createBrickType.makeBrick(p,d, 3));
    }
    @Test
    void makeGoldBrickTest_CanCreateNewGoldBrickObject(){
        assertNotNull(createBrickType.makeBrick(p,d, 4));
    }
    @Test
    void makeBrickTest_AllObjectCreationIsDifferent(){
        assertTrue(createBrickType.makeBrick(p,d, 1) != createBrickType.makeBrick(p,d, 2) && createBrickType.makeBrick(p,d, 2) != createBrickType.makeBrick(p,d, 3) &&
                createBrickType.makeBrick(p,d, 3) != createBrickType.makeBrick(p,d, 4) && createBrickType.makeBrick(p,d, 4) != createBrickType.makeBrick(p,d, 1));
    }

}
