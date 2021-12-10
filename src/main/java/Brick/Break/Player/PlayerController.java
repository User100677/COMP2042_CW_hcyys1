package Brick.Break.Player;
import Brick.Break.Attribute.Move;
import Brick.Break.Ball.BallController;

import java.awt.*;

public class PlayerController implements Move{

    private Player playerModel;
    private PlayerView playerView;

    public PlayerController(Player playerModel){
        this.playerModel = playerModel;
        playerView = new PlayerView(this);
        playerModel.setMoveAmount(0);
        playerModel.setPlayerFace(makeRectangle(playerModel.getWidth(), playerModel.getHeight()));
        playerModel.setMinimum(playerModel.getContainer().x + (playerModel.getWidth()/2) );
        playerModel.setMaximum(playerModel.getMinimum() + playerModel.getContainer().width - playerModel.getWidth());
        playerModel.setInnerColour(playerModel.getINNER_COLOR());
        playerModel.setBorderColour(playerModel.getBORDER_COLOR());


    }


     public Rectangle makeRectangle(int width,int height){
        Point p = new Point((int)(playerModel.getBallPoint().getX() - (width / 2)),(int)playerModel.getBallPoint().getY());
        return  new Rectangle(p,new Dimension(width,height));
    }

    public boolean impact(BallController b){
        return playerModel.getPlayerFace().contains(b.getBallPosition()) && playerModel.getPlayerFace().contains(b.getBallDown()) ;
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

    public Color getPlayerInnerColour(){
        return playerModel.getInnerColour();
    }

    public Color getPlayerBorderColour(){
        return playerModel.getBorderColour();
    }

    public Rectangle getPlayerControllerFace(){
        return playerModel.getPlayerFace();
    }


    public int getControllerMoveAmount() {
        return playerModel.getMoveAmount();
    }
    public int getControllerMinimum(){
        return playerModel.getMinimum();
    }
    public int getControllerMaximum(){
        return playerModel.getMaximum();
    }
    public Point getControllerBallPoint(){
        return playerModel.getBallPoint();
    }

}
