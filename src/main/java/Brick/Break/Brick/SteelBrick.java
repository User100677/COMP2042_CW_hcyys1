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
package Brick.Break.Brick;

import Brick.Break.Brick.Crack.Crack;
import Brick.Break.Brick.Crack.CrackController;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.Random;


public class SteelBrick extends Brick {

    private static final String NAME = "Steel Brick";
    private static final Color DEF_INNER = new Color(203, 203, 201);
    private static final Color DEF_BORDER = Color.BLACK;
    private static final int STEEL_STRENGTH = 3;
    public static final int DEF_CRACK_DEPTH = 2;
    public static final int DEF_STEPS = 35;

    private CrackController crackController;
    private Shape brickFace;

    public SteelBrick(Point point, Dimension size){
        super(NAME,point,size,DEF_BORDER,DEF_INNER,STEEL_STRENGTH);
        crackController = new CrackController(new Crack(this, DEF_CRACK_DEPTH, DEF_STEPS));
        brickFace = super.brickFace;
    }


    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    @Override
    public Shape getBrick() {
        return brickFace;
    }

    public  boolean setImpact(Point2D point , int dir){
        if(super.isBroken())
            return false;
        super.impact();
        if(!super.isBroken()){
            crackController.makeCrack(point,dir);
            updateBrick();
            return false;
        }
        return true;
    }

    private void updateBrick(){
        if(!super.isBroken()){
            GeneralPath gp = crackController.renderCrack();
            gp.append(super.brickFace,false);
            brickFace = gp;
        }
    }

    public void repair(){
        super.repair();
        crackController.reset();
        brickFace = super.brickFace;
    }

    public CrackController getCrackController(){
        return crackController;
    }

    public Shape getSteelBrickFace(){
        return brickFace;
    }

    public void setSteelBrickFace(Shape brickFace){
        this.brickFace = brickFace;
    }






}
