package Brick.Break.Ball.RubberBall;

import Brick.Break.Ball.Ball;
import Brick.Break.Ball.BallController;
import Brick.Break.Ball.RubberBall.RubberBall;

public class RubberBallController extends BallController {

    private RubberBall rubberBallModel;
    private Ball ballModel;

    public RubberBallController(RubberBall rubberBallModel){
        super(rubberBallModel);
        this.rubberBallModel = rubberBallModel;
    }



}
