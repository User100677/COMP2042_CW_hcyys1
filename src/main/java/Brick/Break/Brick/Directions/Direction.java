package Brick.Break.Brick.Directions;

import java.awt.*;

public interface Direction {

    public Point startLocation(Point start, Rectangle bounds);
    public Point endLocation(Point end, Rectangle bounds);

}
