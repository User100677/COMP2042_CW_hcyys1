package Brick.Break.Attribute;

import Brick.Break.Attribute.Colour;

/**
 * This class is the speed of ball class
 */
public abstract class Speed extends Colour {
    private int speedX;
    private int speedY;

    public void setSpeed(int x, int y){
        speedX = x;
        speedY = y;
    }

    public void setXSpeed(int s){
        speedX = s;
    }

    public void setYSpeed(int s){
        speedY = s;
    }
    public void reverseX(){
        speedX *= -1;
    }

    public void reverseY(){
        speedY *= -1;
    }


    public int getSpeedX(){
        return speedX;
    }

    public int getSpeedY(){
        return speedY;
    }


}
