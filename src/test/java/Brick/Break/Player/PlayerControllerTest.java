package Brick.Break.Player;


import Brick.Break.Ball.BallController;
import Brick.Break.Ball.RubberBall.RubberBall;
import Brick.Break.Ball.RubberBall.RubberBallController;
import org.junit.jupiter.api.Test;


import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains all the unit testing for PlayerController class.
 */
public class PlayerControllerTest {

    PlayerController playerController = new PlayerController(new Player(new Point(300, 430), 150, 10, new Rectangle(0, 0, 600, 450)));
    BallController ballController = new RubberBallController(new RubberBall(new Point(300,430)));

    /**
     * This test case is used to test the expected x value of the rectangle(Player) after the "makeRectangle" method.
     */
    @Test
     void makePlayerRectangleTest_XValue(){
        assertEquals(225 ,playerController.makeRectangle(150, 10).getX());
    }

    /**
     * This test case is used to test the expected Y value of the rectangle(Player) after the "makeRectangle" method.
     */
    @Test
     void makePlayerRectangleTest_YValue(){
        assertEquals(430 ,playerController.makeRectangle(150, 10).getY() );
    }

    /**
     * This test case is used to test the expected width value of the rectangle(Player) after the "makeRectangle" method.
     */
    @Test
     void makePlayerRectangleTest_WidthValue(){
        assertEquals(150 ,playerController.makeRectangle(150, 10).getWidth() );
    }

    /**
     * This test case is used to test the expected height value of the rectangle(Player) after the "makeRectangle" method.
     */
    @Test
     void makePlayerRectangleTest_HeightValue(){
        assertEquals(10 ,playerController.makeRectangle(150, 10).getHeight() );
    }


    /**
     * This test case is used to test the impact the rectangle(Player)  receive from the ball.
     */
    @Test
    void impactTest_GotImpact() {
        assertTrue(playerController.getPlayerControllerFace().contains(300, 430) == playerController.impact(ballController));
    }


    /**
     * This test case is used to test the impact the rectangle(Player) did not receive from the ball.
     */
    @Test
    void impactTest_NoImpact() {
        assertFalse(playerController.getPlayerControllerFace().contains(20, 430) == playerController.impact(ballController));
    }


    /**
     * This test case is used to test the expected move amount value.
     */
    @Test
    void getMoveAmountTest(){
        assertEquals(0, playerController.getControllerMoveAmount() );
    }

    /**
     * This test case is used to test the expected minimum value.
     */
    @Test
    void getMinimumTest(){
        assertEquals(75 , playerController.getControllerMinimum());
    }

    /**
     * This test case is used to test the expected maximum value.
     */
    @Test
    void getMaximumTest(){
        assertEquals(525, playerController.getControllerMaximum());
    }

    /**
     * This test case is used to test the expected move amount value after the "moveLeft()" method.
     */
    @Test
    void getMoveAmountTest_AfterMoveLeft(){
        playerController.moveLeft();
        assertEquals(-5 , playerController.getControllerMoveAmount());
    }

    /**
     * This test case is used to test the expected move amount value after the "moveRight()" method.
     */
    @Test
    void getMoveAmountTest_AfterMoveRight(){
        playerController.moveRight();
        assertEquals(5 , playerController.getControllerMoveAmount());
    }

    /**
     * This test case is used to test the expected move amount value after the "stop()" method.
     */
    @Test
    void getMoveAmountTest_StopMoving(){
        playerController.stop();
        assertEquals(0, playerController.getControllerMoveAmount());
    }

    /**
     * This test case is used to test the expected X position of the ball after the "move()" method.
     */
    @Test
    void getBallXPositionTest_AfterMoveMethod(){
        playerController.move();
        assertEquals(300, playerController.getControllerBallPoint().getX());
    }

    /**
     * This test case is used to test the expected Y position of the ball after the "move()" method.
     */
    @Test
    void getBallYPositionTest_AfterMoveMethod(){
        playerController.move();
        assertEquals(430, playerController.getControllerBallPoint().getY());
    }

    /**
     * This test case is used to test the expected X value of the face of the player after the "move()" method.
     */
    @Test
    void getPlayerFaceXTest_AfterMoveMethod(){
        playerController.move();
        assertEquals(225, playerController.getPlayerControllerFace().getX());

    }

    /**
     * This test case is used to test the expected Y value of the face of the player after the "move()" method.
     */
    @Test
    void getPlayerFaceYTest_AfterMoveMethod(){
        playerController.move();
        assertEquals(430, playerController.getPlayerControllerFace().getY());

    }

    /**
     * This test case is used to test the expected X position of the ball after the ball move to a point(moveTo method).
     */
    @Test
    void getBallXPositionTest_AfterMoveToAPosition(){
        playerController.moveTo(new Point(100,150));
        assertEquals(100, playerController.getControllerBallPoint().getX());
    }

    /**
     * This test case is used to test the expected Y position of the ball after the ball move to a point(moveTo method).
     */
    @Test
    void getBallYPositionTest_AfterMoveToAPosition(){
        playerController.moveTo(new Point(100,150));
        assertEquals(150, playerController.getControllerBallPoint().getY());
    }

    /**
     * This test case is used to test the expected X value of the face of the player after the player move to a point(moveTo method).
     */
    @Test
    void getPlayerFaceXTest_AfterMoveToAPosition(){
        playerController.moveTo(new Point(100,150));
        assertEquals(25, playerController.getPlayerControllerFace().getX());

    }

    /**
     * This test case is used to test the expected Y value of the face of the player after the player move to a point(moveTo method).
     */
    @Test
    void getPlayerFaceYTest_AfterMoveToAPosition(){
        playerController.moveTo(new Point(100,150));
        assertEquals(150, playerController.getPlayerControllerFace().getY());

    }
}