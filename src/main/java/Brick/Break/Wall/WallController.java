package Brick.Break.Wall;

import Brick.Break.Attribute.Move;
import Brick.Break.Ball.BallController;
import Brick.Break.Ball.RubberBall.RubberBall;
import Brick.Break.Ball.RubberBall.RubberBallController;
import Brick.Break.Brick.BrickController;
import Brick.Break.Brick.Crack.CrackController;
import Brick.Break.Player.Player;
import Brick.Break.Player.PlayerController;
import Brick.Break.Wall.Levels.LevelProgression;
import Brick.Break.Wall.Levels.LevelsCreation;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * This is the Controller of Model class(Wall Class) in Wall MVC design pattern
 * This class implement the methods from "Move" interface class.
 */

public class WallController implements Move {
    private Wall wallModel;

    /**
     * This is the constructor of "WallController" class.
     * This constructor will set the default value for the data in model class(wall class) once it is called by another class.
     * this constructor set the starting speed of the ball.
     * In the original code, the starting speed of the ball is set to random everytime the player open the game.
     * I changed the starting speed of the ball to a fixed value which is (3, 3).
     * @param wallModel This parameter is the object of model class(Wall class).
     */
    public WallController(Wall wallModel){
        this.wallModel = wallModel;

        wallModel.setLevelsCreation(new LevelsCreation());
        wallModel.setLevelProgress(new LevelProgression(wallModel));
        wallModel.setScore(0);
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


    /**
     * This method create the rubber ball.
     * @param ballPos The position of the ball.
     */
    public void makeBall(Point2D ballPos){
        wallModel.setBallController(new RubberBallController(new RubberBall(ballPos)));
    }


    /**
     * This method move the ball automatically when the game start.
     * This method comes from "Move" interface class and is implemented here.
     */
    @Override
    public void move(){
        wallModel.getPlayerController().move();
        wallModel.getBallController().move();
    }

    /**
     * This method checks where the ball hit in the game and determined what the game should do after the impact from the ball.
     * If the ball hit the rectangle(Player), the ball will bounce off the rectangle and back to the top.
     * If it hit the bottom of the border, the ball will reappear on the rectangle and the ball count will be deducted by 1.
     * If it hit the sides of the border, the ball will bounce from it.
     */
    public void findImpacts(){
        if(wallModel.getPlayerController().impact( wallModel.getBallController())){
            wallModel.getBallController().ReverseY();
        }
        else if(impactWall()){
            /*for efficiency reverse is done into method impactWall
             * because for every brick program checks for horizontal and vertical impacts
             */
            wallModel.getBrickAmount().setBrickCount(wallModel.getBrickAmount().getBrickCount() - 1);
            wallModel.setScore(wallModel.getScore() + 10);
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

    /**
     * This method checks if the ball hit the bottom of the border of the game.
     * @return "true" or "false"
     */
    public boolean impactWall(){
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

    /**
     * This method check if the ball hit the left and right side of the border.
     * @return "true" or "false"
     */
    public boolean impactBorder(){
        Point2D p =  wallModel.getBallController().getBallPosition();
        return ((p.getX() < wallModel.getArea().getX()) ||(p.getX() > (wallModel.getArea().getX() + wallModel.getArea().getWidth())));
    }


    /**
     * This method reset the ball to it original amount and reset the ball speed to (3, -3).
     * In the original code, the reset ball speed is randomize. I changed the reset to a fix value which is (3, 13).
     */
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

    /**
     * This method reset the ball amount to 3 and make all the broken bricks reappear in the game.
     */
    public void wallReset(){
        for(BrickController b : wallModel.getBricks())
            b.repair();
        wallModel.getBrickAmount().setBrickCount(wallModel.getBricks().length);
        wallModel.getBallAmount().setBallCount(3);
    }

    /**
     * This is a setter method which set the ball X speed from the model class(Wall class).
     */
    public void setBallXSpeed(int s){
        wallModel.getBallController().setSpeedX(s);
    }

    /**
     * This is a setter method which set the ball Y speed from the model class(Wall class).
     */
    public void setBallYSpeed(int s){
        wallModel.getBallController().setSpeedY(s);
    }

    /**
     * This is a getter method which get the ball X speed from the model class(Wall class).
     * @return "X speed" from model class (Wall class)
     */
    public int getBallXSpeed(){
        return wallModel.getBallController().getXSpeed();
    }

    /**
     * This is a getter method which get the ball Y speed from the model class(Wall class).
     * @return "Y speed" from model class (Wall class)
     */
    public int getBallYSpeed(){
        return wallModel.getBallController().getYSpeed();
    }



    /**
     * This is a getter method which get the ball controller from the model class(Wall class).
     * @return "ballController" from model class (Wall class)
     */
    public BallController getWallBallController(){
        return wallModel.getBallController();
    }

    /**
     * This is a getter method which get the player controller from the model class(Wall class).
     * @return "playerController" from model class (Wall class)
     */
    public PlayerController getWallPlayerController(){
        return wallModel.getPlayerController();
    }

    /**
     * This is a getter method which get the object of "BrickAmount" class from the model class(Wall class).
     * @return "brickAmount" from model class (Wall class)
     */
    public BrickAmount getWallBrickAmount(){
        return wallModel.getBrickAmount();
    }

    /**
     * This is a getter method which get the object of "BallAmount" class from the model class(Wall class).
     * @return "ballAmount" from model class (Wall class)
     */
    public BallAmount getWallBallAmount(){
        return wallModel.getBallAmount();
    }

    /**
     * This is a getter method which get the bricks from the model class(Wall class).
     * @return "bricks" from model class (Wall class)
     */
    public BrickController[] getWallBricks(){
        return wallModel.getBricks();
    }

    /**
     * This is a getter method which get the object of "LevelProgression" class from the model class(Wall class).
     * @return "levelProgression" from model class (Wall class)
     */
    public LevelProgression getWallLeveProgress(){
        return wallModel.getLevelProgress();
    }

    /**
     * This is a getter method which get the starting position from the model class(Wall class).
     * @return "startPoint" from model class (Wall class)
     */
    public Point getWallStartPoint(){
        return wallModel.getStartPoint();
    }

    /**
     * This is a getter method which get the score from the model class(Wall class).
     * @return "score" from model class (Wall class)
     */
    public int getControllerScore(){
        return wallModel.getScore();
    }

}
