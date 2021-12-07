package Brick.Break.Player;

import java.awt.*;


public class PlayerView {

    private PlayerController playerController;

    public PlayerView(PlayerController playerController){
        this.playerController=playerController;

    }

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
