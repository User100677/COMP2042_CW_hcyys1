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



import Brick.Break.Attribute.Colour;

import java.awt.*;


public class Player extends Colour {


    private static final Color BORDER_COLOR = Color.GREEN.darker().darker();
    private static final Color INNER_COLOR = Color.GREEN;

    private static final int DEF_MOVE_AMOUNT = 5;

    private Rectangle playerFace;
    private Point ballPoint;
    private int moveAmount;
    private int min;
    private int max;
    private Rectangle container;
    private int width;
    private int height;


    public Player(Point ballPoint,int width,int height,Rectangle container) {
        this.ballPoint = ballPoint;
        this.container = container;
        this.width = width;
        this.height = height;
        setInnerColour(INNER_COLOR);
        setBorderColour(BORDER_COLOR);


    }

    public int getDefMoveAmount(){
        return DEF_MOVE_AMOUNT;
    }



    public Rectangle getPlayerFace(){
        return  playerFace;
    }

    public void setPlayerFace(Rectangle playerFace){
        this.playerFace = playerFace;
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



    public int getMinimum(){
        return min;
    }
    public void setMinimum(int min){
        this.min = min;
    }



    public int getMaximum(){
        return max;
    }

    public void setMaximum(int max){
        this.max = max;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public Rectangle getContainer(){
        return container;
    }



}
