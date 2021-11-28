package Brick.Break;
import java.awt.*;
public class Colour {
    private Color inner;
    private Color border;

    public void setInnerColour(Color inner){
        this.inner = inner;

    }

    public Color getInnerColour(){
        return inner;
    }

    public void setBorderColour(Color border){
        this.border=border;
    }

    public Color getBorderColour(){
        return border;
    }
}
