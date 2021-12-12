package Brick.Break.Ball;

import Brick.Break.Ball.RubberBall.RubberBall;
import Brick.Break.Ball.RubberBall.RubberBallController;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains all the unit testing for RubberBallController class.
 */
class RubberBallControllerTest{

    BallController rubberBallController = new RubberBallController(new RubberBall(new Point2D.Double(300,430)));


    /**
     * This test case is used to test if the "makeBall()" method can create ball or not.
     */
    @Test
    void makeBallTest_CanCreateBall(){
        assertNotNull(rubberBallController.makeBall(new Point2D.Double(300,430 ), 10, 10));
    }

    /**
     * This test case is used to test if the face of the ball can be created after the "move" method.
     */
    @Test
    void canCreateBallFaceTest_AfterMoveMethod(){
        rubberBallController.move();
        assertNotNull(rubberBallController.getFaceBall());
    }

    /**
     * This test case is used to test if the face of the ball can be created after the move to a point(moveTo method).
     */
    @Test
    void canCreateBallFaceTest_AfterMoveToMethod(){
        rubberBallController.moveTo(new Point(200, 300));
        assertNotNull(rubberBallController.getFaceBall());
    }

    /**
     * This test case is used to test the expected value of the ball up X location.
     */
    @Test
    void getXBallUPTest(){
        assertEquals(300, rubberBallController.getBallUp().getX());
    }

    /**
     * This test case is used to test the expected value of the ball up Y location.
     */
    @Test
    void getYBallUPTest(){
        assertEquals(425, rubberBallController.getBallUp().getY());
    }

    /**
     * This test case is used to test the expected value of the ball Down X location.
     */
    @Test
    void getXBallDownTest(){
        assertEquals(300, rubberBallController.getBallDown().getX());
    }

    /**
     * This test case is used to test the expected value of the ball Down Y location.
     */
    @Test
    void getYBallDownTest(){
        assertEquals(435, rubberBallController.getBallDown().getY());
    }

    /**
     * This test case is used to test the expected value of the ball right X location.
     */
    @Test
    void getXBallRightTest(){
        assertEquals(305, rubberBallController.getBallRight().getX());
    }

    /**
     * This test case is used to test the expected value of the ball right Y location.
     */
    @Test
    void getYBallRightTest(){
        assertEquals(430, rubberBallController.getBallRight().getY());
    }

    /**
     * This test case is used to test the expected value of the ball left X location.
     */
    @Test
    void getXBallLeftTest(){
        assertEquals(295, rubberBallController.getBallLeft().getX());
    }

    /**
     * This test case is used to test the expected value of the ball left Y location.
     */
    @Test
    void getYBallLeftTest(){
        assertEquals(430, rubberBallController.getBallLeft().getY());
    }

    /**
     * This test case is used to test the expected value of the ball up X location after the "setPoints()" method.
     */
    @Test
    void getXBallUpTest_AfterSetPointsMethod(){
        rubberBallController.setPoints(300,425);
        assertEquals(300, rubberBallController.getBallUp().getX());
    }

    /**
     * This test case is used to test the expected value of the ball up Y location after the "setPoints()" method.
     */
    @Test
    void getYBallUpTest_AfterSetPointsMethod(){
        rubberBallController.setPoints(300,425);
        assertEquals(217.5, rubberBallController.getBallUp().getY());
    }

    /**
     * This test case is used to test the expected value of the ball down X location after the "setPoints()" method.
     */
    @Test
    void getXBallDownTest_AfterSetPointsMethod(){
        rubberBallController.setPoints(300,425);
        assertEquals(300, rubberBallController.getBallDown().getX());
    }

    /**
     * This test case is used to test the expected value of the ball down Y location after the "setPoints()" method..
     */
    @Test
    void getYBallDownTest_AfterSetPointsMethod(){
        rubberBallController.setPoints(300,425);
        assertEquals(642.5, rubberBallController.getBallDown().getY());
    }

    /**
     * This test case is used to test the expected value of the ball left X location after the "setPoints()" method.
     */
    @Test
    void getXBallLeftTest_AfterSetPointsMethod(){
        rubberBallController.setPoints(300,425);
        assertEquals(150, rubberBallController.getBallLeft().getX());
    }

    /**
     * This test case is used to test the expected value of the ball left Y location after the "setPoints()" method.
     */
    @Test
    void getYBallLeftTest_AfterSetPointsMethod(){
        rubberBallController.setPoints(300,425);
        assertEquals(430, rubberBallController.getBallLeft().getY());
    }

    /**
     * This test case is used to test the expected value of the ball right X location after the "setPoints()" method.
     */
    @Test
    void getXBallRightTest_AfterSetPointsMethod(){
        rubberBallController.setPoints(300,425);
        assertEquals(450, rubberBallController.getBallRight().getX());
    }

    /**
     * This test case is used to test the expected value of the ball right Y location after the "setPoints()" method.
     */
    @Test
    void getYBallRightTest_AfterSetPointsMethod(){
        rubberBallController.setPoints(300,425);
        assertEquals(430, rubberBallController.getBallRight().getY());
    }



}