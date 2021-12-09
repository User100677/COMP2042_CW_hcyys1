package Brick.Break.UnitTest.PlayerTest;


import Brick.Break.Ball.BallController;
import Brick.Break.Ball.RubberBall.RubberBall;
import Brick.Break.Ball.RubberBall.RubberBallController;
import Brick.Break.UnitTest.Player;
import Brick.Break.UnitTest.PlayerController;
import org.junit.jupiter.api.Test;


import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerControllerTest {

    PlayerController playerController = new PlayerController(new Player(new Point(300, 430), 150, 10, new Rectangle(0, 0, 600, 450)));
    BallController ballController = new RubberBallController(new RubberBall(new Point(300,430)));

    @Test
     void makePlayerRectangleTest_XValue(){
        assertEquals(225 ,playerController.makeRectangle(150, 10).getX());
    }
    @Test
     void makePlayerRectangleTest_YValue(){
        assertEquals(430 ,playerController.makeRectangle(150, 10).getY() );
    }
    @Test
     void makePlayerRectangleTest_WidthValue(){
        assertEquals(150 ,playerController.makeRectangle(150, 10).getWidth() );
    }
    @Test
     void makePlayerRectangleTest_HeightValue(){
        assertEquals(10 ,playerController.makeRectangle(150, 10).getHeight() );
    }


    @Test
    void impactTest_GotImpact() {
        assertTrue(playerController.getPlayerControllerFace().contains(300, 430) == playerController.impact(ballController));
    }

    @Test
    void impactTest_NoImpact() {
        assertFalse(playerController.getPlayerControllerFace().contains(20, 430) == playerController.impact(ballController));
    }


    @Test
    void getMoveAmountTest(){
        assertEquals(0, playerController.getControllerMoveAmount() );
    }
    @Test
    void getMinimumTest(){
        assertEquals(75 , playerController.getControllerMinimum());
    }

    @Test
    void getMaximumTest(){
        assertEquals(525, playerController.getControllerMaximum());
    }

    @Test
    void getMoveAmountTest_AfterMoveLeft(){
        playerController.moveLeft();
        assertEquals(-5 , playerController.getControllerMoveAmount());
    }
    @Test
    void getMoveAmountTest_AfterMoveRight(){
        playerController.moveRight();
        assertEquals(5 , playerController.getControllerMoveAmount());
    }
    @Test
    void getMoveAmountTest_StopMoving(){
        playerController.stop();
        assertEquals(0, playerController.getControllerMoveAmount());
    }
}