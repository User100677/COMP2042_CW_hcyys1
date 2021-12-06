package Brick.Break.Brick.Directions;



import java.awt.*;

public class DirectionDown implements Direction {
    private Point start = new Point();
    private Point end = new Point();

    @Override
    public void setStartLocation(Point start, Rectangle bounds){
        start.setLocation(bounds.getLocation());

    }

    @Override
    public void setEndLocation(Point end, Rectangle bounds){
        end.setLocation(bounds.x + bounds.width, bounds.y);


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
