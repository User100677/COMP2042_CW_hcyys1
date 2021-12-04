package Brick.Break.Brick.Directions;

import java.awt.*;
import java.awt.Point;


public class DirectionUp implements Direction {

    @Override
    public Point startLocation(Point start, Rectangle bounds){
        start.setLocation(bounds.x, bounds.y + bounds.height);
        return start;

    }

    @Override
    public Point endLocation(Point end, Rectangle bounds){
        end.setLocation(bounds.x + bounds.width, bounds.y + bounds.height);
        return end;
    }

}
