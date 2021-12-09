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

import Brick.Break.Ball.BallController;
import Brick.Break.Brick.*;
import Brick.Break.UnitTest.PlayerController;
import Brick.Break.Wall.Levels.LevelProgression;
import Brick.Break.Wall.Levels.LevelsCreation;

import java.awt.*;




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
    private BallAmount ballAmount;
    private BrickAmount brickAmount;
    private int lineCount;
    private double brickDimensionRatio;
    private Point ballPos;
    private Rectangle drawArea;
    private LevelProgression levelProgress;



    private Point startPoint;
    private int brickCount;
    private int ballCount;
    private boolean ballLost;
    private LevelsCreation levelsCreate;



    public Wall(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio, Point ballPos){
       this.drawArea = drawArea;
        this.brickCount = brickCount;
        this.lineCount = lineCount;
        this.brickDimensionRatio = brickDimensionRatio;
        this.ballPos = ballPos;


    }
    public LevelProgression getLevelProgress(){
        return levelProgress;
    }
    public void setLevelProgress(LevelProgression levelProgress){
        this.levelProgress = levelProgress;
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

    public void setLevelsCreation(LevelsCreation levelsCreate){
        this.levelsCreate = levelsCreate;
    }

}
