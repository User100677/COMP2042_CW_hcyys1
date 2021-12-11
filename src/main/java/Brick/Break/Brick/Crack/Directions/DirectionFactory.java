package Brick.Break.Brick.Crack.Directions;

/**
 * This class produce the instances of the Directions class.
 */
public class DirectionFactory {

    public static final int LEFT = 10;
    public static final int RIGHT = 20;
    public static final int UP = 30;
    public static final int DOWN = 40;


    /**
     * This method create and return a required object of the 'Directions' class.
     * @param direction This parameter is the direction that determined which object of the 'Directions' Class should be produce.
     * @return "new DirectionLeft()", "new DirectionRight()", "new DirectionUp()", "new DirectionDown()" or "null"
     */
    public Direction getDirection(int direction){
        if (direction == LEFT){
            return new DirectionLeft();
        }
        else if(direction == RIGHT){
            return new DirectionRight();
        }
        else if(direction == UP){
            return new DirectionUp();
        }
        else if(direction == DOWN){
            return new DirectionDown();
        }
        else{
            return null;
        }
    }
}
