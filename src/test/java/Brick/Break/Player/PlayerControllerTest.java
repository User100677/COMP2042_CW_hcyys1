package Brick.Break.Player;


import Brick.Break.Ball.BallController;
import Brick.Break.Ball.RubberBall.RubberBall;
import Brick.Break.Ball.RubberBall.RubberBallController;
import org.junit.jupiter.api.Test;
import org.testng.Assert;


import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerControllerTest {

    PlayerController  playerController = new PlayerController(new Player(new Point(300, 430), 150, 10, new Rectangle(0, 0, 600, 450)));
    BallController ballController = new RubberBallController(new RubberBall(new Point(300,430)));

    @Test
    public void makePlayerRectangleTest_XValue(){
        assertEquals(225 ,playerController.makeRectangle(150, 10).getX());
    }
    @Test
    public void makePlayerRectangleTest_YValue(){
        assertEquals(430 ,playerController.makeRectangle(150, 10).getY() );
    }
    @Test
    public void makePlayerRectangleTest_WidthValue(){
        assertEquals(150 ,playerController.makeRectangle(150, 10).getWidth() );
    }
    @Test
    public void makePlayerRectangleTest_HeightValue(){
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
}