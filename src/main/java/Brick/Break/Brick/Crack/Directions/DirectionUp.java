package Brick.Break.Brick.Crack.Directions;

import java.awt.*;
import java.awt.Point;


public class DirectionUp implements Direction {
    private Point start = new Point();
    private Point end = new Point();

    @Override
    public Point setStartLocation(Point start, Rectangle bounds){
        start.setLocation(bounds.x, bounds.y + bounds.height);
        return start;


    }

    @Override
    public Point setEndLocation(Point end, Rectangle bounds){
        end.setLocation(bounds.x + bounds.width, bounds.y + bounds.height);
        return end;
    }

    @Override
    public Point getStartLocation(){
        return start;
    }
    @Override
    public Point getEndLocation() {
        return end;
    }

}
