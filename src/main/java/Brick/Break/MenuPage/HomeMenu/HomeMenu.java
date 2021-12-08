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
package Brick.Break.MenuPage.HomeMenu;

import Brick.Break.GameBoard.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;


public class HomeMenu {


    private Rectangle menuFace;
    private Rectangle startButton;
    private Rectangle instructionButton;
    private Rectangle menuButton;



    private GameFrame owner;
    private Dimension area;

    private boolean startClicked;
    private boolean instructionClicked;
    private boolean menuClicked;


    public HomeMenu(GameFrame owner,Dimension area){

        this.owner = owner;
        this.area = area;


    }
    public Rectangle getMenuFace(){
        return menuFace;
    }
    public void setMenuFace(Rectangle menuFace){
        this.menuFace=menuFace;
    }

    public Rectangle getStartButton(){
        return startButton;
    }
    public void setStartButton(Rectangle startButton){
        this.startButton = startButton;
    }

    public Rectangle getInstructionButton(){
        return instructionButton;
    }
    public void setInstructionButton(Rectangle instructionButton){
        this.instructionButton = instructionButton;
    }
    public Rectangle getMenuButton(){
        return menuButton;
    }
    public void setMenuButton(Rectangle menuButton){
        this.menuButton = menuButton;
    }

    public GameFrame getOwner(){
        return owner;
    }
    public Dimension getArea(){
        return area;
    }
    public boolean getStartClicked(){
        return startClicked;
    }
    public void setStartClicked(boolean startClicked){
        this.startClicked = startClicked;
    }
    public boolean getInstructionClicked(){
        return instructionClicked;
    }
    public void setInstructionClicked(boolean instructionClicked){
        this.instructionClicked = instructionClicked;
    }
    public boolean getMenuClicked(){
        return menuClicked;
    }
    public void setMenuClicked(boolean menuClicked){
        this.menuClicked = menuClicked;
    }








}
