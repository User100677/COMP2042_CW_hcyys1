package Brick.Break.Wall.Levels;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class LevelsCreationTest {

    LevelsCreation levelsCreation = new LevelsCreation();

    @Test
    void totalBricksInSingleTypeLevelTest(){
        assertEquals(31, levelsCreation.makeSingleTypeLevel(new Rectangle(0,0,600,450),30,3,6/2, 1).length);
    }
    @Test
    void totalBricksInChessboardTypeLevelTest(){
        assertEquals(31, levelsCreation.makeChessboardLevel(new Rectangle(0,0,600,450),30,3,6/2, 2, 3).length);
    }
    @Test
    void makeLevelsMethodTest_TotalLevels(){
        assertEquals(6, levelsCreation.makeLevels(new Rectangle(0,0,600,450),30,3,6/2).length);
    }

}