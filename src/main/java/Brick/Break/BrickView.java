package Brick.Break;

import Brick.Break.Brick.BrickController;

import java.awt.*;

public class BrickView {
    private BrickController brickController;

    public BrickView(BrickController brickController){
        this.brickController = brickController;
    }

    public void drawBrick( Graphics2D g2d){
        Color tmp = g2d.getColor();

        g2d.setColor(brickController.getINNERColour());
        g2d.fill(brickController.getBrick());

        g2d.setColor(brickController.getBORDERColour());
        g2d.draw(brickController.getBrick());


        g2d.setColor(tmp);
    }
}
