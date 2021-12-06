package Brick.Break.Brick.Directions;

import java.awt.*;

public interface Direction {

    public void setStartLocation(Point start, Rectangle bounds);
    public Point getStartLocation();
    public void setEndLocation(Point end, Rectangle bounds);
    public Point getEndLocation();

}
