package Brick.Break.Brick.Directions;

import Brick.Break.Brick.Directions.Direction;

import java.awt.*;

public class DirectionDown implements Direction {

    @Override
    public Point startLocation(Point start, Rectangle bounds){
        start.setLocation(bounds.getLocation());
        return start;

    }

    @Override
    public Point endLocation(Point end, Rectangle bounds){
        end.setLocation(bounds.x + bounds.width, bounds.y);
        return end;
    }
}
