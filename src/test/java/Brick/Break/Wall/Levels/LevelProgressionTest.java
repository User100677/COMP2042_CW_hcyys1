package Brick.Break.Wall.Levels;

import Brick.Break.GameBoard.GameBoard;
import Brick.Break.Wall.Wall;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class LevelProgressionTest {
    LevelProgression levelProgression = new LevelProgression(new Wall(new Rectangle(0,0,600,450),30,3,6/2,new Point(300,430)));

    @Test
    void getTotalLevelsTest(){
        assertEquals( 6, levelProgression.getLevels().length);
    }
    @Test
    void hasLevelTest(){
        levelProgression.setLevel(3);
        assertTrue(levelProgression.hasLevel());
    }
    @Test
    void NoLevelTest(){
        levelProgression.setLevel(6);
        assertFalse(levelProgression.hasLevel());
    }


}