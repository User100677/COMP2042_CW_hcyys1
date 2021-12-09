package Brick.Break.Wall;

import Brick.Break.Attribute.Move;
import Brick.Break.Ball.BallController;
import Brick.Break.Ball.RubberBall.RubberBall;
import Brick.Break.Ball.RubberBall.RubberBallController;
import Brick.Break.Brick.BrickController;
import Brick.Break.Brick.Crack.CrackController;
import Brick.Break.UnitTest.Player;
import Brick.Break.UnitTest.PlayerController;
import Brick.Break.Wall.Levels.LevelProgression;
import Brick.Break.Wall.Levels.LevelsCreation;

import java.awt.*;
import java.awt.geom.Point2D;

public class WallController implements Move {
    private Wall wallModel;

    public WallController(Wall wallModel){
        this.wallModel = wallModel;
        wallModel.setLevelsCreation(new LevelsCreation());
        wallModel.setLevelProgress(new LevelProgression(wallModel));
        makeBall(wallModel.getBallPos());
        wallModel.setStartPoint(new Point(wallModel.getBallPos()));
        wallModel.setBallAmount(new BallAmount(wallModel.getBallCount(), wallModel.getBallLost()));
        wallModel.getBallAmount().setBallCount(3);
        wallModel.getBallAmount().setBallLost(false);

        wallModel.setBrickAmount(new BrickAmount(wallModel.getBrickCount()));

        int speedX,speedY;
        do{
            speedX = 3;
        }while(speedX == 0);
        do{
            speedY = -3;
        }while(speedY == 0);

        wallModel.getBallController().setSPEED(speedX,speedY);

        wallModel.setPlayerController(new PlayerController(new Player((Point) wallModel.getBallPos().clone(),150,10, wallModel.getDrawArea())));

       wallModel.setArea(wallModel.getDrawArea());
    }



    private void makeBall(Point2D ballPos){
        wallModel.setBallController(new RubberBallController(new RubberBall(ballPos)));
    }

    @Override
    public void move(){
        wallModel.getPlayerController().move();
        wallModel.getBallController().move();
    }

    public void findImpacts(){
        if(wallModel.getPlayerController().impact( wallModel.getBallController())){
            wallModel.getBallController().ReverseY();
        }
        else if(impactWall()){
            /*for efficiency reverse is done into method impactWall
             * because for every brick program checks for horizontal and vertical impacts
             */
            wallModel.getBrickAmount().setBrickCount(wallModel.getBrickAmount().getBrickCount() - 1);
        }
        else if(impactBorder()) {
            wallModel.getBallController().ReverseX();
        }
        else if( wallModel.getBallController().getBallPosition().getY() < wallModel.getArea().getY()){
            wallModel.getBallController().ReverseY();
        }
        else if( wallModel.getBallController().getBallPosition().getY() > wallModel.getArea().getY() + wallModel.getArea().getHeight()){
            wallModel.getBallAmount().setBallCount(wallModel.getBallAmount().getBallCount() - 1);
            wallModel.getBallAmount().setBallLost(true);
        }
    }

    private boolean impactWall(){
        for(BrickController b : wallModel.getBricks()){
            //Vertical Impact
            if (b.findImpact(wallModel.getBallController()) == BrickController.getImpactUp()){
                wallModel.getBallController().ReverseY();
                return b.setImpact( wallModel.getBallController().getBallDown(), CrackController.getUP());
            }
            else if(b.findImpact( wallModel.getBallController()) == BrickController.getImpactDown()){
                wallModel.getBallController().ReverseY();
                return b.setImpact( wallModel.getBallController().getBallUp(), CrackController.getDOWN());
            }//Horizontal Impact
            else if(b.findImpact( wallModel.getBallController()) == BrickController.getImpactLeft()){
                wallModel.getBallController().ReverseX();
                return b.setImpact( wallModel.getBallController().getBallRight(), CrackController.getLEFT());
            }
            else if(b.findImpact( wallModel.getBallController())== BrickController.getImpactRight()){
                wallModel.getBallController().ReverseX();
                return b.setImpact( wallModel.getBallController().getBallLeft(), CrackController.getCrackRIGHT());
            }
        }
        return false;
    }

    private boolean impactBorder(){
        Point2D p =  wallModel.getBallController().getBallPosition();
        return ((p.getX() < wallModel.getArea().getX()) ||(p.getX() > (wallModel.getArea().getX() + wallModel.getArea().getWidth())));
    }



    public void ballReset(){
        wallModel.getPlayerController().moveTo(wallModel.getStartPoint());
        wallModel.getBallController().moveTo(wallModel.getStartPoint());
        int speedX,speedY;
        do{
            speedX = 3;
        }while(speedX == 0);
        do{
            speedY = -3;
        }while(speedY == 0);

        wallModel.getBallController().setSPEED(speedX,speedY);
        wallModel.getBallAmount().setBallLost(false);
    }

    public void wallReset(){
        for(BrickController b : wallModel.getBricks())
            b.repair();
        wallModel.getBrickAmount().setBrickCount(wallModel.getBricks().length);
        wallModel.getBallAmount().setBallCount(3);
    }


    public void setBallXSpeed(int s){
        wallModel.getBallController().setSpeedX(s);
    }

    public void setBallYSpeed(int s){
        wallModel.getBallController().setSpeedY(s);
    }




    public BallController getWallBallController(){
        return wallModel.getBallController();
    }
    public PlayerController getWallPlayerController(){
        return wallModel.getPlayerController();
    }

    public BrickAmount getWallBrickAmount(){
        return wallModel.getBrickAmount();
    }
    public BallAmount getWallBallAmount(){
        return wallModel.getBallAmount();
    }
    public BrickController[] getWallBricks(){
        return wallModel.getBricks();
    }
    public LevelProgression getWallLeveProgress(){
        return wallModel.getLevelProgress();
    }

}
