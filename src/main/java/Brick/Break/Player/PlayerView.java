package Brick.Break.Player;

import java.awt.*;


/**
 * This is the View of Model class(Player class) in the Player MVC Design Pattern.
 */
public class PlayerView {

    private PlayerController playerController;

    /**
     * This is the constructor of "PlayerView" class.
     * This constructor get the data from the controller class(PlayerController class).
     * @param playerController This parameter is the object of controller class(PlayerController class).
     */
    public PlayerView(PlayerController playerController){
        this.playerController=playerController;

    }

    /**
     * This method draw out the rectangle(Player).
     */
    public void drawPlayer(Graphics2D g2d){
        Color tmp = g2d.getColor();

        Shape s = playerController.getPlayerControllerFace();
        g2d.setColor(playerController.getPlayerInnerColour());
        g2d.fill(s);

        g2d.setColor(playerController.getPlayerBorderColour());
        g2d.draw(s);

        g2d.setColor(tmp);

    }
}
