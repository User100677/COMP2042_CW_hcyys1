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
package Brick.Break.Debug.DebugConsole;

import Brick.Break.Debug.DebugPanel.DebugPanel;
import Brick.Break.Debug.DebugPanel.DebugPanelController;
import Brick.Break.GameBoard.GameBoardController;
import Brick.Break.Wall.WallController;

import javax.swing.*;

/**
 *This is the Model of DebugConsole in the DebugConsole MVC design pattern.
 */
public class DebugConsole{

    private static final String TITLE = "Debug Console";


    private JFrame owner;
    private DebugPanelController debugPanelController;
    private GameBoardController gameBoardController;
    private WallController wallController;

    /**
     * This is the constructor of "DebugConsole" class.
     * This constructor holds the data that required initialization once its object is created.
     * @param wallController This parameter is the object of  "WallController" class.
     * @param owner This parameter is the object of "JFrame" class.
     * @param gameBoardController This parameter is the object of "gameBoardController" class.
     */
    public DebugConsole(JFrame owner,WallController wallController,GameBoardController gameBoardController){

        this.wallController = wallController;
        this.owner = owner;
        this.gameBoardController = gameBoardController;


        debugPanelController =new DebugPanelController(new DebugPanel(wallController));


    }

    public DebugPanelController getDebugPanelController(){
        return debugPanelController;
    }
    public void setDebugPanelController(DebugPanelController debugPanelController){
        this.debugPanelController =debugPanelController;
    }
    public GameBoardController getGameBoardController(){
        return gameBoardController;
    }
    public WallController getWallController(){
        return wallController;
    }
    public static String getTITLE(){
        return TITLE;
    }


    public JFrame getFrameOwner(){
        return owner;
    }

}

