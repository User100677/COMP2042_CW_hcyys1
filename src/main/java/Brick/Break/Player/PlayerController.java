package Brick.Break.Player;
import Brick.Break.Ball.Ball;
import Brick.Break.Attribute.Move;

import java.awt.*;

public class PlayerController implements Move{

    private Player playerModel;
    private PlayerView playerView;

    public PlayerController(Player playerModel){
        this.playerModel = playerModel;
        playerView = new PlayerView(playerModel);
    }

    public boolean impact(Ball b){
        return playerModel.getPlayerFace().contains(b.getPosition()) && playerModel.getPlayerFace().contains(b.down) ;
    }

    @Override
    public void move(){
        double x = playerModel.getBallPoint().getX() + playerModel.getMoveAmount();
        if(x < playerModel.getMinimum() || x > playerModel.getMaximum())
            return;
        playerModel.getBallPoint().setLocation(x,playerModel.getBallPoint().getY());
        playerModel.getPlayerFace().setLocation(playerModel.getBallPoint().x - (int)playerModel.getPlayerFace().getWidth()/2,playerModel.getBallPoint().y);
    }

    public void moveLeft(){
        playerModel.setMoveAmount(-playerModel.getDefMoveAmount());
    }

    public void moveRight(){
        playerModel.setMoveAmount(playerModel.getDefMoveAmount());
    }

    public void stop(){
       playerModel.setMoveAmount(0);
    }

    public void moveTo(Point p){
        playerModel.getBallPoint().setLocation(p);
        playerModel.getPlayerFace().setLocation( playerModel.getBallPoint().x - (int)playerModel.getPlayerFace().getWidth()/2, playerModel.getBallPoint().y);
    }

    public void renderPlayer(Graphics2D g2d){
        playerView.drawPlayer(g2d);

    }

}
