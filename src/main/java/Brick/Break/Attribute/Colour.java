package Brick.Break.Attribute;
import java.awt.*;


/**
 * This an abstract class which contains the methods related to inner colour and border colour.
 * The methods in this class was extracted from "Player" class and "Brick" class.
 * This class is extended by "Speed" abstract class, "Brick" class  and "Player" class.
 */
public abstract class Colour {
    private Color inner;
    private Color border;

    /**
     * This method set the inner colour of an object.
     * @param inner This parameter is the value of inner colour.
     */
    public void setInnerColour(Color inner){
        this.inner = inner;

    }

    /**
     * This getter method get the inner colour of an object.
     * @return "inner"
     */
    public Color getInnerColour(){
        return inner;
    }

    /**
     * This setter method set the colour to the border of an object.
     * @param border This parameter is the value of the border colour.
     */
    public void setBorderColour(Color border){
        this.border=border;
    }

    /**
     * This getter method get the border colour of an object.
     * @return "border"
     */
    public Color getBorderColour(){
        return border;
    }
}
