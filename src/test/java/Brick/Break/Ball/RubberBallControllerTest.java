package Brick.Break.Ball;

import Brick.Break.Ball.RubberBall.RubberBall;
import Brick.Break.Ball.RubberBall.RubberBallController;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class RubberBallControllerTest{

    BallController rubberBallController = new RubberBallController(new RubberBall(new Point2D.Double(300,430)));


    @Test
    void makeBallTest_CanCreateBall(){
        assertNotNull(rubberBallController.makeBall(new Point2D.Double(300,430 ), 10, 10));
    }
    @Test
    void canCreateBallFaceTest_AfterMoveMethod(){
        rubberBallController.move();
        assertNotNull(rubberBallController.getFaceBall());
    }
    @Test
    void canCreateBallFaceTest_AfterMoveToMethod(){
        rubberBallController.moveTo(new Point(200, 300));
        assertNotNull(rubberBallController.getFaceBall());
    }
    @Test
    void getXBallUPTest(){
        assertEquals(300, rubberBallController.getBallUp().getX());
    }
    @Test
    void getYBallUPTest(){
        assertEquals(425, rubberBallController.getBallUp().getY());
    }
    @Test
    void getXBallDownTest(){
        assertEquals(300, rubberBallController.getBallDown().getX());
    }
    @Test
    void getYBallDownTest(){
        assertEquals(435, rubberBallController.getBallDown().getY());
    }@Test
    void getXBallRightTest(){
        assertEquals(305, rubberBallController.getBallRight().getX());
    }
    @Test
    void getYBallRightTest(){
        assertEquals(430, rubberBallController.getBallRight().getY());
    }
    @Test
    void getXBallLeftTest(){
        assertEquals(295, rubberBallController.getBallLeft().getX());
    }
    @Test
    void getYBallLeftTest(){
        assertEquals(430, rubberBallController.getBallLeft().getY());
    }
    @Test
    void getXBallUpTest_AfterSetPointsMethod(){
        rubberBallController.setPoints(300,425);
        assertEquals(300, rubberBallController.getBallUp().getX());
    }
    @Test
    void getYBallUpTest_AfterSetPointsMethod(){
        rubberBallController.setPoints(300,425);
        assertEquals(217.5, rubberBallController.getBallUp().getY());
    }
    @Test
    void getXBallDownTest_AfterSetPointsMethod(){
        rubberBallController.setPoints(300,425);
        assertEquals(300, rubberBallController.getBallDown().getX());
    }
    @Test
    void getYBallDownTest_AfterSetPointsMethod(){
        rubberBallController.setPoints(300,425);
        assertEquals(642.5, rubberBallController.getBallDown().getY());
    }
    @Test
    void getXBallLeftTest_AfterSetPointsMethod(){
        rubberBallController.setPoints(300,425);
        assertEquals(150, rubberBallController.getBallLeft().getX());
    }
    @Test
    void getYBallLeftTest_AfterSetPointsMethod(){
        rubberBallController.setPoints(300,425);
        assertEquals(430, rubberBallController.getBallLeft().getY());
    }
    @Test
    void getXBallRightTest_AfterSetPointsMethod(){
        rubberBallController.setPoints(300,425);
        assertEquals(450, rubberBallController.getBallRight().getX());
    }
    @Test
    void getYBallRightTest_AfterSetPointsMethod(){
        rubberBallController.setPoints(300,425);
        assertEquals(430, rubberBallController.getBallRight().getY());
    }



}