package Brick.Break.Player.BallTest;

import Brick.Break.Ball.BallController;
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

}