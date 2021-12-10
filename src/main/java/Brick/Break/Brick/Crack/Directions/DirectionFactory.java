package Brick.Break.Brick.Crack.Directions;

public class DirectionFactory {

    public static final int LEFT = 10;
    public static final int RIGHT = 20;
    public static final int UP = 30;
    public static final int DOWN = 40;


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
