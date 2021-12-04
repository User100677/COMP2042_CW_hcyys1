package Brick.Break.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;

public class PlayerView {

    private Player playerModel;

    PlayerView(Player playerModel){
        this.playerModel=playerModel;

    }

    public void drawPlayer(Graphics2D g2d){
        Color tmp = g2d.getColor();

        Shape s = playerModel.getPlayerFace();
        g2d.setColor(Player.INNER_COLOR);
        g2d.fill(s);

        g2d.setColor(Player.BORDER_COLOR);
        g2d.draw(s);

        g2d.setColor(tmp);

    }
}
