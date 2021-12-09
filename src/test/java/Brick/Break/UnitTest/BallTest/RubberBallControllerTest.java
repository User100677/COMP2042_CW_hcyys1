package Brick.Break.UnitTest.BallTest;

import Brick.Break.Ball.BallController;
import Brick.Break.Ball.RubberBall.RubberBall;
import Brick.Break.Ball.RubberBall.RubberBallController;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import static org.junit.jupiter.api.Assertions.*;

class RubberBallControllerTest {

    BallController rubberBallController = new RubberBallController(new RubberBall(new Point(300 , 430)));
    Ellipse2D rubberBall = new Ellipse2D.Double(295,435,10,10);
}