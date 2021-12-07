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
package Brick.Break.GameBoard;

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
import java.util.Random;


public class Wall implements Move {

    private static final int LEVELS_COUNT = 6;
    private static final int CLAY = 1;
    private static final int STEEL = 2;
    private static final int CEMENT = 3;
    private static final int GOLD = 4;

    private Random rnd;
    private Rectangle area;

    BrickController[] bricks;
    public BallController ballController;
    PlayerController playerController;
    private BrickController[][] levels;
    private int level;
    public BallAmount ballAmount;



    private Point startPoint;
    private int brickCount;
    private int ballCount;
    private boolean ballLost;
    BrickAmount brickAmount;


    public Wall(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio, Point ballPos){

        this.startPoint = new Point(ballPos);

        levels = makeLevels(drawArea,brickCount,lineCount,brickDimensionRatio);
        level = 0;

        ballAmount = new BallAmount(ballCount, ballLost);
        ballAmount.setBallCount(3);
        ballAmount.setBallLost(false);

        brickAmount = new BrickAmount(brickCount);

        rnd = new Random();

        makeBall(ballPos);
        int speedX,speedY;
        do{
            speedX = 3;
        }while(speedX == 0);
        do{
            speedY = -3;
        }while(speedY == 0);

        ballController.setSPEED(speedX,speedY);

        playerController = new PlayerController(new Player((Point) ballPos.clone(),150,10, drawArea));

        area = drawArea;



    }

    private BrickController[] makeSingleTypeLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, int type){
        /*
          if brickCount is not divisible by line count,brickCount is adjusted to the biggest
          multiple of lineCount smaller then brickCount
         */
        brickCnt -= brickCnt % lineCnt;

        int brickOnLine = brickCnt / lineCnt;

        double brickLen = drawArea.getWidth() / brickOnLine;
        double brickHgt = brickLen / brickSizeRatio;

        brickCnt += lineCnt / 2;

        BrickController[] tmp  = new BrickController[brickCnt];

        Dimension brickSize = new Dimension((int) brickLen,(int) brickHgt);
        Point p = new Point();

        int i;
        for(i = 0; i < tmp.length; i++){
            int line = i / brickOnLine;
            if(line == lineCnt)
                break;
            double x = (i % brickOnLine) * brickLen;
            x =(line % 2 == 0) ? x : (x - (brickLen / 2));
            double y = (line) * brickHgt;
            p.setLocation(x,y);
            tmp[i] = makeBrick(p,brickSize,type);
        }

        for(double y = brickHgt;i < tmp.length;i++, y += 2*brickHgt){
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p.setLocation(x,y);
            tmp[i] = new ClayBrickController(new ClayBrick(p,brickSize));
        }
        return tmp;

    }

    private BrickController[] makeChessboardLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, int typeA, int typeB){
        /*
          if brickCount is not divisible by line count,brickCount is adjusted to the biggest
          multiple of lineCount smaller then brickCount
         */
        brickCnt -= brickCnt % lineCnt;

        int brickOnLine = brickCnt / lineCnt;

        int centerLeft = brickOnLine / 2 - 1;
        int centerRight = brickOnLine / 2 + 1;

        double brickLen = drawArea.getWidth() / brickOnLine;
        double brickHgt = brickLen / brickSizeRatio;

        brickCnt += lineCnt / 2;

        BrickController[] tmp  = new BrickController[brickCnt];

        Dimension brickSize = new Dimension((int) brickLen,(int) brickHgt);
        Point p = new Point();

        int i;
        for(i = 0; i < tmp.length; i++){
            int line = i / brickOnLine;
            if(line == lineCnt)
                break;
            int posX = i % brickOnLine;
            double x = posX * brickLen;
            x =(line % 2 == 0) ? x : (x - (brickLen / 2));
            double y = (line) * brickHgt;
            p.setLocation(x,y);

            boolean b = ((line % 2 == 0 && i % 2 == 0) || (line % 2 != 0 && posX > centerLeft && posX <= centerRight));
            tmp[i] = b ?  makeBrick(p,brickSize,typeA) : makeBrick(p,brickSize,typeB);
        }

        for(double y = brickHgt;i < tmp.length;i++, y += 2*brickHgt){
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p.setLocation(x,y);
            tmp[i] = makeBrick(p,brickSize,typeA);
        }
        return tmp;
    }

    private void makeBall(Point2D ballPos){
        ballController = new RubberBallController(new RubberBall(ballPos));
    }

    private BrickController[][] makeLevels(Rectangle drawArea,int brickCount,int lineCount,double brickDimensionRatio){
        BrickController[][] tmp = new BrickController[LEVELS_COUNT][];
        tmp[0] = makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY);
        tmp[1] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY,CEMENT);
        tmp[2] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY,STEEL);
        tmp[3] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,STEEL,CEMENT);
        tmp[4] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,STEEL,STEEL);
        tmp[5] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,GOLD,STEEL);
        return tmp;
    }

    @Override
    public void move(){
        playerController.move();
        ballController.move();
    }

    public void findImpacts(){
        if(playerController.impact(ballController)){
            ballController.ReverseY();
        }
        else if(impactWall()){
            /*for efficiency reverse is done into method impactWall
            * because for every brick program checks for horizontal and vertical impacts
            */
            brickAmount.setBrickCount(brickAmount.getBrickCount() - 1);
        }
        else if(impactBorder()) {
           ballController.ReverseX();
        }
        else if(ballController.getBallPosition().getY() < area.getY()){
            ballController.ReverseY();
        }
        else if(ballController.getBallPosition().getY() > area.getY() + area.getHeight()){
            ballAmount.setBallCount(ballAmount.getBallCount() - 1);
           ballAmount.setBallLost(true);
        }
    }

    private boolean impactWall(){
        for(BrickController b : bricks){
            switch(b.findImpact(ballController)) {
                //Vertical Impact
                case Brick.UP_IMPACT:
                    ballController.ReverseY();
                    return b.setImpact(ballController.getBallDown(), CrackController.getUP());
                case Brick.DOWN_IMPACT:
                    ballController.ReverseY();
                    return b.setImpact(ballController.getBallUp(), CrackController.getDOWN());

                //Horizontal Impact
                case Brick.LEFT_IMPACT:
                    ballController.ReverseX();
                    return b.setImpact(ballController.getBallRight(), CrackController.getLEFT());
                case Brick.RIGHT_IMPACT:
                    ballController.ReverseX();
                    return b.setImpact(ballController.getBallLeft(), CrackController.getCrackRIGHT());
            }
        }
        return false;
    }

    private boolean impactBorder(){
        Point2D p = ballController.getBallPosition();
        return ((p.getX() < area.getX()) ||(p.getX() > (area.getX() + area.getWidth())));
    }



    public void ballReset(){
        playerController.moveTo(startPoint);
        ballController.moveTo(startPoint);
        int speedX,speedY;
        do{
            speedX = 3;
        }while(speedX == 0);
        do{
            speedY = -3;
        }while(speedY == 0);

        ballController.setSPEED(speedX,speedY);
       ballAmount.setBallLost(false);
    }

    public void wallReset(){
        for(BrickController b : bricks)
            b.repair();
        brickCount = bricks.length;
        ballAmount.setBallCount(3);
    }



    public void nextLevel(){
        bricks = levels[level++];
        brickAmount.setBrickCount(bricks.length);
    }

    public boolean hasLevel(){
        return level < levels.length;
    }

    public void setBallXSpeed(int s){
        ballController.setSpeedX(s);
    }

    public void setBallYSpeed(int s){
        ballController.setSpeedY(s);
    }


    private BrickController makeBrick(Point point, Dimension size, int type){
        BrickController out;
        switch(type){
            case CLAY:
                out = new ClayBrickController(new ClayBrick(point,size));
                break;
            case STEEL:
                out = new SteelBrickController(new SteelBrick(point,size));
                break;
            case CEMENT:
                out = new CementBrickController(new CementBrick(point, size));
                break;
            case GOLD:
                out = new GoldBrickController(new GoldBrick(point, size));
                break;
            default:
                throw  new IllegalArgumentException(String.format("Unknown Type:%d\n",type));
        }
        return  out;
    }

}
