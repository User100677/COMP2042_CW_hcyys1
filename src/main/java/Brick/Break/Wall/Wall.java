/*
 *  Brick Destroy - A simple Arcade video game
 *   Copyright (C) 2017  Filippo Ranza
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Brick.Break.Wall;

import Brick.Break.Attribute.Move;
import Brick.Break.Ball.BallController;
import Brick.Break.Ball.RubberBall.RubberBall;
import Brick.Break.Ball.RubberBall.RubberBallController;
import Brick.Break.Brick.*;
import Brick.Break.Brick.CementBrick.CementBrick;
import Brick.Break.Brick.CementBrick.CementBrickController;
import Brick.Break.Brick.ClayBrick.ClayBrick;
import Brick.Break.Brick.ClayBrick.ClayBrickController;
import Brick.Break.Brick.Crack.CrackController;
import Brick.Break.Brick.GoldBrick.GoldBrick;
import Brick.Break.Brick.GoldBrick.GoldBrickController;
import Brick.Break.Brick.SteelBrick.SteelBrick;
import Brick.Break.Brick.SteelBrick.SteelBrickController;
import Brick.Break.Player.Player;
import Brick.Break.Player.PlayerController;

import java.awt.*;
import java.awt.geom.Point2D;




public class Wall{

    private static final int LEVELS_COUNT = 6;
    private static final int CLAY = 1;
    private static final int STEEL = 2;
    private static final int CEMENT = 3;
    private static final int GOLD = 4;


    private Rectangle area;

    private BrickController[] bricks;
    private BallController ballController;
    private PlayerController playerController;
    private BrickController[][] levels;
    private int level;
    private BallAmount ballAmount;
    private BrickAmount brickAmount;
    private int lineCount;
    private double brickDimensionRatio;
    private Point ballPos;
    private Rectangle drawArea;



    private Point startPoint;
    private int brickCount;
    private int ballCount;
    private boolean ballLost;



    public Wall(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio, Point ballPos){
       this.drawArea = drawArea;
        this.brickCount = brickCount;
        this.lineCount = lineCount;
        this.brickDimensionRatio = brickDimensionRatio;
        this.ballPos = ballPos;


        ballAmount = new BallAmount(ballCount, ballLost);
        ballAmount.setBallCount(3);
        ballAmount.setBallLost(false);

        brickAmount = new BrickAmount(brickCount);



    }
    public int getBallCount(){
        return ballCount;
    }
    public boolean getBallLost(){
        return ballLost;
    }

    public  static int getLevelsCount(){
        return LEVELS_COUNT;
    }
    public static  int getClay(){
        return CLAY;
    }
    public static int getSteel(){
        return STEEL;
    }
    public static int getCement(){
        return CEMENT;
    }
    public static int getGold(){
        return GOLD;
    }

    public Rectangle getArea(){
        return area;
    }
    public void setArea(Rectangle area){
        this.area = area;
    }
    public BrickController[][] getLevels(){
        return levels;
    }
    public void setLevels(BrickController[][] levels){
        this.levels = levels;
    }

    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level= level;
    }

    public int getLineCount(){
        return lineCount;
    }
    public double getBrickDimensionRatio(){
        return brickDimensionRatio;
    }
    public Point getBallPos(){
        return ballPos;

    }
    public int getBrickCount(){
        return brickCount;
    }
    public Rectangle getDrawArea(){
        return drawArea;
    }
    public Point getStartPoint(){
        return startPoint;
    }
    public void setStartPoint(Point startPoint){
        this.startPoint = startPoint;
    }
    public void setBricks(BrickController[] bricks){
        this.bricks = bricks;
    }


    public BrickController[] getBricks(){
        return bricks;
    }
    public BallController getBallController(){
        return ballController;
    }
    public void setBallController(BallController ballController){
        this.ballController = ballController;
    }

    public PlayerController getPlayerController(){
        return playerController;
    }
    public void setPlayerController(PlayerController playerController){
        this.playerController = playerController;
    }

    public BrickAmount getBrickAmount(){
        return brickAmount;
    }
    public void setBrickAmount(BrickAmount brickAmount){
        this.brickAmount = brickAmount;
    }

    public BallAmount getBallAmount(){
        return ballAmount;
    }
    public void setBallAmount(BallAmount ballAmount){
        this.ballAmount = ballAmount;
    }

}
