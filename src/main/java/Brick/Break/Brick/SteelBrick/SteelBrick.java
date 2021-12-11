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
package Brick.Break.Brick.SteelBrick;

import Brick.Break.Brick.Brick;
import java.awt.*;


/**
 *This is the Model of SteelBrick in the SteelBrick MVC design pattern.
 * This class extends from "Brick" class.
 */
public class SteelBrick extends Brick {

    private static final String NAME = "Steel Brick";
    private static final Color DEF_INNER = new Color(203, 203, 201);
    private static final Color DEF_BORDER = Color.BLACK;
    private static final int STEEL_STRENGTH = 3;
    public static final int DEF_CRACK_DEPTH = 2;
    public static final int DEF_STEPS = 35;


    private Shape brickFace;

    /**
     * This is the constructor of "SteelBrick" class.
     * This constructor holds the data that required initialization once its object is created.
     * @param point This parameter is the position of the steel brick.
     * @param size This parameter is the size of the brick.
     */
    public SteelBrick(Point point, Dimension size){
        super(NAME,point,size,DEF_BORDER,DEF_INNER,STEEL_STRENGTH);
    }





    public Shape getSteelBrickFace(){
        return brickFace;
    }

    public void setSteelBrickFace(Shape brickFace){
        this.brickFace = brickFace;
    }
    public static int getDefCrackDepth(){
        return DEF_CRACK_DEPTH;
    }
    public static int getDefSteps(){
        return DEF_STEPS;
    }








}
