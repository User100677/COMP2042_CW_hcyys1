package Brick.Break.Wall.Levels;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains all the unit testing for LevelCreation class.
 */
class LevelsCreationTest {

    LevelsCreation levelsCreation = new LevelsCreation();

    /**
     * This test case is used to test the total amount of bricks in a single type level.
     */
    @Test
    void totalBricksInSingleTypeLevelTest(){
        assertEquals(31, levelsCreation.makeSingleTypeLevel(new Rectangle(0,0,600,450),30,3,6/2, 1).length);
    }

    /**
     * This test case is used to test the total amount of bricks in a chessboard type level.
     */
    @Test
    void totalBricksInChessboardTypeLevelTest(){
        assertEquals(31, levelsCreation.makeChessboardLevel(new Rectangle(0,0,600,450),30,3,6/2, 2, 3).length);
    }

    /**
     * This test case is used to test the total amount of levels in the game.
     */
    @Test
    void makeLevelsMethodTest_TotalLevels(){
        assertEquals(7, levelsCreation.makeLevels(new Rectangle(0,0,600,450),30,3,6/2).length);
    }

    /**
     * This test case is used to test the total amount of bricks in the last chessboard type level.
     */
    @Test
    void totalBricksInChessboardTypeInLastLevelTest(){
        assertEquals(52, levelsCreation.makeChessboardLevel(new Rectangle(0,0,600,450),50,5,6/2, 4, 4).length);
    }

}