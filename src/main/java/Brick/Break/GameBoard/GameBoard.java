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


import Brick.Break.Debug.DebugConsole.DebugConsoleController;
import Brick.Break.Wall.WallController;


import javax.swing.*;
import java.awt.*;

/**
 *This is the Model of GameBoard in the GameBoard MVC design pattern.
 */
public class GameBoard{




    private static final int DEF_WIDTH = 600;
    private static final int DEF_HEIGHT = 450;

    private static final Color BG_COLOR = Color.WHITE;

    private Timer gameTimer;

    private WallController wallController;

    private String message;

    private boolean showPauseMenu;

    private DebugConsoleController debugConsoleController;
    private JFrame owner;

    /**
     * This is the constructor of "Ball" class.
     * This constructor holds the data that required initialization once its object is created.
     * @param owner This parameter is the object of "JFrame" class.
     */
    public GameBoard(JFrame owner){
        super();
        this.owner = owner;

    }

    public static int getDefWidth(){
        return DEF_WIDTH;
    }
    public static int getDefHeight(){
        return DEF_HEIGHT;
    }
    public static Color getBackGroundColour(){
        return BG_COLOR;
    }
    public Timer getGameTimer(){
        return gameTimer;
    }
    public void setGameTimer(Timer gameTimer){
        this.gameTimer = gameTimer;
    }
    public WallController getWallController(){
        return wallController;
    }
    public void setWallController(WallController wallController){
        this.wallController = wallController;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public boolean getShowPauseMenu(){
        return showPauseMenu;
    }
    public  void setShowPauseMenu(boolean showPauseMenu){
        this.showPauseMenu = showPauseMenu;
    }
    public DebugConsoleController getDebugConsoleController(){
        return debugConsoleController;
    }
    public void setDebugConsoleController(DebugConsoleController debugConsoleController){
        this.debugConsoleController = debugConsoleController;
    }
    public JFrame getOwner(){
        return owner;
    }

}
