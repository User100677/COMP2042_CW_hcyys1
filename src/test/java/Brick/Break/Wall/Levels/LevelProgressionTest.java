package Brick.Break.Wall.Levels;

import Brick.Break.Wall.Wall;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains all the unit testing for LevelProgression class.
 */
class LevelProgressionTest {
    LevelProgression levelProgression = new LevelProgression(new Wall(new Rectangle(0,0,600,450),30,3,6/2,new Point(300,430)));

    /**
     * This test case is used to test the expected total amount of levels.
     */
    @Test
    void getTotalLevelsTest(){
        assertEquals( 7, levelProgression.getLevels().length);
    }

    /**
     * This test case is used to test if there is another level after the current level.
     */
    @Test
    void hasLevelTest(){
        levelProgression.setLevel(3);
        assertTrue(levelProgression.hasLevel());
    }

    /**
     * This test case is used to test if there is no another level after the current level.
     */
    @Test
    void noLevelTest(){
        levelProgression.setLevel(8);
        assertFalse(levelProgression.hasLevel());
    }


}