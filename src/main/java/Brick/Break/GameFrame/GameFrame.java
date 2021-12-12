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
package Brick.Break.GameFrame;


import Brick.Break.GameBoard.GameBoardController;
import Brick.Break.MenuPage.HomeMenu.HomeMenuController;
import Brick.Break.MenuPage.InstructionMenu.InstructionMenuController;

/**
 *This is the Model of GameFrame in the GameFrame design pattern.
 */
public class GameFrame {

    private static final String DEF_TITLE = "Brick Destroy";

    private GameBoardController gameBoardController;
    private HomeMenuController homeMenuController;
    private InstructionMenuController instructionMenuController;

    private boolean gaming;

    /**
     * This is the constructor of "GameFrame" class.
     */
    public GameFrame(){}

    public GameBoardController getGameBoardController(){
        return gameBoardController;
    }
    public HomeMenuController getHomeMenuController(){
        return homeMenuController;
    }
    public InstructionMenuController getInstructionMenuController(){
        return instructionMenuController;
    }
    public void setGameBoardController(GameBoardController gameBoardController){
        this.gameBoardController = gameBoardController;
    }
    public void setHomeMenuController(HomeMenuController homeMenuController){
        this.homeMenuController = homeMenuController;
    }
    public void setInstructionMenuController(InstructionMenuController instructionMenuController){
        this.instructionMenuController =instructionMenuController;
    }
    public boolean getGaming(){
        return gaming;
    }
    public void setGaming(boolean gaming){
        this.gaming = gaming;
    }
    public static String getDefTitle(){
        return DEF_TITLE;
    }


}
