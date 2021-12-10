package Brick.Break.Brick.Crack.Directions;

import java.awt.*;

public interface Direction {

    public Point setStartLocation(Point start, Rectangle bounds);
    public Point getStartLocation();
    public Point setEndLocation(Point end, Rectangle bounds);
    public Point getEndLocation();

}
