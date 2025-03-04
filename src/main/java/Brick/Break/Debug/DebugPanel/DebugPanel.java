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
package Brick.Break.Debug.DebugPanel;
import Brick.Break.Wall.WallController;

import javax.swing.*;
import java.awt.*;

/**
 *This is the Model of DebugPanel in the DebugPanel MVC design pattern.
 */
public class DebugPanel extends JPanel {

    private static final Color DEF_BKG = Color.WHITE;


    private JButton skipLevel;
    private JButton resetBalls;

    private JSlider ballXSpeed;
    private JSlider ballYSpeed;

    private WallController wallController;

    /**
     * This is the constructor of "DebugPanel" class.
     * This constructor holds the data that required initialization once its object is created.
     * @param wallController This parameter is the object of  "WallController" class.
     */
    public DebugPanel(WallController wallController) {
        this.wallController = wallController;

    }

    public void setSkipLevel(JButton skipLevel) {
        this.skipLevel = skipLevel;

    }

    public JButton getSkipLevel() {
        return skipLevel;
    }

    public void setResetBalls(JButton resetBalls) {
        this.resetBalls = resetBalls;

    }

    public JButton getResetBalls() {
        return resetBalls;

    }

    public void setBallXSpeed(JSlider ballXSpeed){
        this.ballXSpeed = ballXSpeed;
    }

    public JSlider getBallXSpeed(){
        return ballXSpeed;
    }
    public void setBallYSpeed(JSlider ballYSpeed){
        this.ballYSpeed = ballYSpeed;
    }

    public JSlider getBallYSpeed(){
        return ballYSpeed;
    }

    public WallController getWallController(){
        return wallController;
    }

    public Color getBackGroundColour(){
        return DEF_BKG;
    }
}
