package Brick.Break.Brick.Directions;

import java.awt.*;

public class DirectionRight implements Direction {
    @Override
    public Point startLocation(Point start, Rectangle bounds){
        start.setLocation(bounds.getLocation());
        return start;


    }

    @Override
    public Point endLocation(Point end, Rectangle bounds){
        end.setLocation(bounds.x, bounds.y + bounds.height);
        return end;
    }
}
