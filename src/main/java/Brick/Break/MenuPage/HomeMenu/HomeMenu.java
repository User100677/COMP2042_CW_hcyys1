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

import Brick.Break.GameFrame.GameFrameController;

import java.awt.*;

/**
 *This is the Model of HomeMenu in the HomeMenu MVC design pattern.
 */
public class HomeMenu {


    private Rectangle menuFace;
    private Rectangle startButton;
    private Rectangle instructionButton;
    private Rectangle menuButton;



    private GameFrameController owner;
    private Dimension area;

    private boolean startClicked;
    private boolean instructionClicked;
    private boolean menuClicked;


    /**
     * This is the constructor of "HomeMenu" class.
     * This constructor holds the data that required initialization once its object is created.
     * @param owner This parameter is the object of "GameFrameController" class.
     * @param area This parameter is the frame of the home menu screen.
     */
    public HomeMenu(GameFrameController owner, Dimension area){

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

    public GameFrameController getOwner(){
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
    public void setMenuClicked(boolean menuClicked) {
        this.menuClicked = menuClicked;
    }


}
