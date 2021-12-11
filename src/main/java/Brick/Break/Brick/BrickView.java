package Brick.Break.Brick;

import java.awt.*;

/**
 * This is the View of Model class(Brick class) in the Brick MVC Design Pattern.
 */
public class BrickView {
    private BrickController brickController;

    /**
     * This is the constructor of "BrickView" class.
     * This constructor get the data from the controller class(BrickController class).
     * @param brickController This parameter is the object of controller class(BrickController class).
     */
    public BrickView(BrickController brickController){
        this.brickController = brickController;
    }

    /**
     * This method draw out the bricks.
     */
    public void drawBrick( Graphics2D g2d){
        Color tmp = g2d.getColor();

        g2d.setColor(brickController.getINNERColour());
        g2d.fill(brickController.getBrick());

        g2d.setColor(brickController.getBORDERColour());
        g2d.draw(brickController.getBrick());


        g2d.setColor(tmp);
    }
}
