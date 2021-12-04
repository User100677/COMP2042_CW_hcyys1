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
package Brick.Break.Player;

import Brick.Break.Ball.Ball;


import java.awt.*;


public class Player {


    public static final Color BORDER_COLOR = Color.GREEN.darker().darker();
    public static final Color INNER_COLOR = Color.GREEN;

    private static final int DEF_MOVE_AMOUNT = 5;

    private Rectangle playerFace;
    private Point ballPoint;
    private int moveAmount;
    private int min;
    private int max;


    public Player(Point ballPoint,int width,int height,Rectangle container) {
        this.ballPoint = ballPoint;
        moveAmount = 0;
        playerFace = makeRectangle(width, height);
        min = container.x + (width / 2);
        max = min + container.width - width;

    }

    public int getDefMoveAmount(){
        return DEF_MOVE_AMOUNT;
    }

    public void setPlayerFace(Rectangle playerFace){
        this.playerFace = playerFace;
    }

    public Rectangle getPlayerFace(){
        return  playerFace;
    }


    public void setBallPoint(Point ballPoint){
        this.ballPoint = ballPoint;
    }

    public Point getBallPoint(){
        return ballPoint;
    }

    public void setMoveAmount(int moveAmount){
        this.moveAmount = moveAmount;
    }

    public int getMoveAmount(){
        return moveAmount;
    }

    public void setMinimum(int min){
        this.min = min;
    }

    public int getMinimum(){
        return min;
    }

    public void setMaximum(int max){
        this.max = max;
    }

    public int getMaximum(){
        return max;
    }
    private Rectangle makeRectangle(int width,int height){
        Point p = new Point((int)(ballPoint.getX() - (width / 2)),(int)ballPoint.getY());
        return  new Rectangle(p,new Dimension(width,height));
    }



}
