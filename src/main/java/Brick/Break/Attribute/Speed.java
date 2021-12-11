package Brick.Break.Attribute;


/**
 * This class is an abstract class which contains the method related to the speed of ball class.
 * The methods in this class was extracted from "Ball" class.
 * This class is extended by "Ball" class.
 */
public abstract class Speed extends Colour {
    private int speedX;
    private int speedY;

    /**
     * This method set the X speed and Y speed at the same time
     * @param x This parameter is the X speed.
     * @param y This parameter is the Y speed.
     */
    public void setSpeed(int x, int y){
        speedX = x;
        speedY = y;
    }

    /**
     * This method set X speed
     * @param s This parameter is the value for  X speed
     */
    public void setXSpeed(int s){
        speedX = s;
    }

    /**
     * This method set Y speed
     * @param s This parameter is the value for  Y speed
     */
    public void setYSpeed(int s){
        speedY = s;
    }

    /**
     * This method reverse the X speed by multiplying -1.
     */
    public void reverseX(){
        speedX *= -1;
    }


    /**
     * This method reverse the Y speed by multiplying -1.
     */
    public void reverseY(){
        speedY *= -1;
    }


    /**
     * This method get the X speed.
     * @return "speedX"
     */
    public int getSpeedX(){
        return speedX;
    }

    /**
     * This method get the Y speed.
     * @return  "speedY"
     */
    public int getSpeedY(){
        return speedY;
    }


}
