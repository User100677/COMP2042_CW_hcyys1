package Brick.Break.Player;
import Brick.Break.Attribute.Move;
import Brick.Break.Ball.BallController;

import java.awt.*;


/**
 * This is the Controller of Model class(Player Class) in Player MVC design pattern.
 * This class implement the methods from "Move" interface class.
 */
public class PlayerController implements Move{

    private Player playerModel;
    private PlayerView playerView;

    /**
     * This is the constructor of "PlayerController" class.
     * This constructor will set the default value for the data in model class(Player class) once it is called by another class.
     * @param playerModel This parameter is the object of model class(Player class).
     */
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


    /**
     * This method is used to create the player which is the long green rectangle holding the ball in the games.
     * @param width This parameter determined the width of the rectangle.
     * @param height This parameter determined the height of the rectangle.
     * @return new Rectangle(x,y,width,height)
     */
     public Rectangle makeRectangle(int width,int height){
        Point p = new Point((int)(playerModel.getBallPoint().getX() - (width / 2)),(int)playerModel.getBallPoint().getY());
        return  new Rectangle(p,new Dimension(width,height));
    }


    /**
     * This method is used to determined if the ball have or have not hit the rectangle(Player).
     * @param b this parameter is the object of "BallController" class.
     * @return either false or true.
     */
    public boolean impact(BallController b){
        return playerModel.getPlayerFace().contains(b.getBallPosition()) && playerModel.getPlayerFace().contains(b.getBallDown()) ;
    }

    /**
     * This method is used to make the ball move whenever the player start the game.
     */
    @Override
    public void move(){
        double x = playerModel.getBallPoint().getX() + playerModel.getMoveAmount();
        if(x < playerModel.getMinimum() || x > playerModel.getMaximum())
            return;
        playerModel.getBallPoint().setLocation(x,playerModel.getBallPoint().getY());
        playerModel.getPlayerFace().setLocation(playerModel.getBallPoint().x - (int)playerModel.getPlayerFace().getWidth()/2,playerModel.getBallPoint().y);
    }

    /**
     * This method is used to move the rectangle(Player) to the left.
     * This method move the rectangle(Player) to the left by setting the move amount of the rectangle(Player) to -5 everytime it moves.
     */
    public void moveLeft(){
        playerModel.setMoveAmount(-playerModel.getDefMoveAmount());
    }

    /**
     * This method is used to move the rectangle(Player) to the right.
     * This method move the rectangle(Player) to the right by setting the move amount of the rectangle(Player) to 5 everytime it moves.
     */
    public void moveRight(){
        playerModel.setMoveAmount(playerModel.getDefMoveAmount());
    }

    /**
     * This method is used to make the rectangle(Rectangle) stop moving.
     * When the rectangle(Player) stop moving, the move amount of the rectangle(Player) will be set to 0;
     */
    public void stop(){
       playerModel.setMoveAmount(0);
    }

    /**
     * This method is used to move the rectangle(Player) and the ball to a specific place.
     * @param p This parameter is the point where the ball and rectangle(Player) should move to.
     */
    public void moveTo(Point p){
        playerModel.getBallPoint().setLocation(p);
        playerModel.getPlayerFace().setLocation( playerModel.getBallPoint().x - (int)playerModel.getPlayerFace().getWidth()/2, playerModel.getBallPoint().y);
    }

    /**
     * This method get the "drawPlayer" method from "PlayerView" class and draw out the rectangle(Player) to the screen.
     */
    public void renderPlayer(Graphics2D g2d){
        playerView.drawPlayer(g2d);

    }

    /**
     * This is a getter method which get the inner colour of the player from the model class(Player class).
     * @return "INNER_COLOR" from model class (Player class)
     */
    public Color getPlayerInnerColour(){
        return playerModel.getInnerColour();
    }

    /**
     * This is a getter method which get the border colour of the player from the model class(Player class).
     * @return "BORDER_CLASS" from model class (Player class)
     */
    public Color getPlayerBorderColour(){
        return playerModel.getBorderColour();
    }

    /**
     * This is a getter method which get the rectangle of the player from the model class(Player class).
     * @return "playerFace" from model class (Player class)
     */
    public Rectangle getPlayerControllerFace(){
        return playerModel.getPlayerFace();
    }

    /**
     * This is a getter method which get the amount of movement of the player from the model class(Player class).
     * @return "BORDER_CLASS" from model class (Player class)
     */
    public int getControllerMoveAmount() {
        return playerModel.getMoveAmount();
    }

    /**
     * This is a getter method which get minimum from the model class(Player class).
     * @return "min" from model class (Player class)
     */
    public int getControllerMinimum(){
        return playerModel.getMinimum();
    }

    /**
     * This is a getter method which get maximum from the model class(Player class).
     * @return "max" from model class (Player class)
     */
    public int getControllerMaximum(){
        return playerModel.getMaximum();
    }

    /**
     * This is a getter method which get the ball position from the model class(Player class).
     * @return "ballPoint" from model class (Player class)
     */
    public Point getControllerBallPoint(){
        return playerModel.getBallPoint();
    }

}
