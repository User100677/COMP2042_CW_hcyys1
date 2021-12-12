package Brick.Break.MenuPage.HomeMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * This is the Controller of Model class(HomeMenu Class) in HomeMenu MVC design pattern
 */
public class HomeMenuController extends JComponent implements MouseListener, MouseMotionListener {
    private HomeMenu homeMenuModel;
    private HomeMenuView homeMenuView;

    /**
     * This is the constructor of "HouseMenuController" class.
     * This constructor will set the default value for the data in model class(HomeMenu class) once it is called by another class.
     * @param homeMenuModel This parameter is the object of model class(HomeMenu class).
     */

    public HomeMenuController(HomeMenu homeMenuModel){
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.homeMenuModel = homeMenuModel;

        homeMenuModel.setMenuFace(new Rectangle(new Point(0,0),homeMenuModel.getArea()));
        this.setPreferredSize(homeMenuModel.getArea());
        Dimension btnDim = new Dimension(homeMenuModel.getArea().width / 3, homeMenuModel.getArea().height / 12);
        homeMenuModel.setStartButton(new Rectangle(btnDim));
        homeMenuModel.setInstructionButton(new Rectangle(btnDim));
        homeMenuModel.setMenuButton(new Rectangle(btnDim));
        homeMenuView = new HomeMenuView(this);


    }

    /**
     * This method get the "drawMenu" method from "HomeMenuView" class and draw out the home menu screen.
     */
    public void paint(Graphics g){
        homeMenuView.drawMenu((Graphics2D)g);
    }


    /**
     * This method determined and show what should the button do when it is clicked.
     * For example, when the start button is clicked the screen will change from home menu screen to game screen.
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(homeMenuModel.getStartButton().contains(p)){
            homeMenuModel.getOwner().enableGameBoard();

        }
        else if(homeMenuModel.getInstructionButton().contains(p)){
            homeMenuModel.getOwner().openInstructionMenu();

        }
        else if(homeMenuModel.getMenuButton().contains(p)){
            System.out.println("Goodbye " + System.getProperty("user.name"));
            System.exit(0);
        }
    }

    /**
     * This method determined and show what should the button do when it is pressed.
     * For example, if the start button is pressed without letting go, it doesn't do anything.
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(homeMenuModel.getStartButton().contains(p)){
            homeMenuModel.setStartClicked(true);
            repaint(homeMenuModel.getStartButton().x,homeMenuModel.getStartButton().y,homeMenuModel.getStartButton().width+1,homeMenuModel.getStartButton().height+1);

        }
        else if(homeMenuModel.getInstructionButton().contains(p)){
            homeMenuModel.setInstructionClicked(true);
            repaint(homeMenuModel.getInstructionButton().x,homeMenuModel.getInstructionButton().y,homeMenuModel.getInstructionButton().width+1,homeMenuModel.getInstructionButton().height+1);

        }
        else if(homeMenuModel.getMenuButton().contains(p)){
           homeMenuModel.setMenuClicked(true);
            repaint(homeMenuModel.getMenuButton().x,homeMenuModel.getMenuButton().y,homeMenuModel.getMenuButton().width+1,homeMenuModel.getMenuButton().height+1);
        }
    }

    /**
     * This method determined and show what should the button do when it is pressed and release.
     * For example, if the start button is pressed but was released outside the button, the button will not do anything.
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if(homeMenuModel.getStartClicked() ){
           homeMenuModel.setStartClicked(false);
            repaint(homeMenuModel.getStartButton().x,homeMenuModel.getStartButton().y,homeMenuModel.getStartButton().width+1,homeMenuModel.getStartButton().height+1);
        }
        else if(homeMenuModel.getInstructionClicked()){
           homeMenuModel.setInstructionClicked(false);
            repaint(homeMenuModel.getInstructionButton().x,homeMenuModel.getInstructionButton().y,homeMenuModel.getInstructionButton().width+1,homeMenuModel.getInstructionButton().height+1);

        }
        else if(homeMenuModel.getMenuClicked()){
         homeMenuModel.setMenuClicked(false);
            repaint(homeMenuModel.getMenuButton().x,homeMenuModel.getMenuButton().y,homeMenuModel.getMenuButton().width+1,homeMenuModel.getMenuButton().height+1);
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }


    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    /**
     * This method determined what should the mouse do when it is moved to the button.
     * In this case, the mouse cursor will change to hand cursor when the mouse touches the button.
     */
    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(homeMenuModel.getStartButton().contains(p) || homeMenuModel.getMenuButton().contains(p) || homeMenuModel.getInstructionButton().contains(p))
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        else
            this.setCursor(Cursor.getDefaultCursor());

    }

    /**
     * This is a getter method which get the start button  from the model class(HomeMenu class).
     * @return "startButton" from model class (HomeMenu class)
     */
    public Rectangle getControllerStartButton(){
        return homeMenuModel.getStartButton();
    }

    /**
     * This is a getter method which get the face of the menu from the model class(HomeMenu class).
     * @return "menuFace" from model class (HomeMenu class)
     */
    public Rectangle getControllerMenuFace(){
        return homeMenuModel.getMenuFace();
    }

    /**
     * This is a getter method which get the instruction button  from the model class(HomeMenu class).
     * @return "instructionButton" from model class (HomeMenu class)
     */
    public Rectangle getControllerInstructionButton(){
        return homeMenuModel.getInstructionButton();
    }

    /**
     * This is a getter method which get the menu button  from the model class(HomeMenu class).
     * @return "menuButton" from model class (HomeMenu class)
     */
    public Rectangle getControllerMenuButton(){
        return homeMenuModel.getMenuButton();
    }

    /**
     * This is a getter method which get the start clicked  from the model class(HomeMenu class).
     * @return "startClicked" from model class (HomeMenu class)
     */
    public boolean getControllerStartClicked(){
        return homeMenuModel.getStartClicked();
    }

    /**
     * This is a getter method which get the instruction clicked  from the model class(HomeMenu class).
     * @return "instructionClicked" from model class (HomeMenu class)
     */
    public boolean getControllerInstructionClicked(){
        return homeMenuModel.getInstructionClicked();
    }

    /**
     * This is a getter method which get the menu clicked  from the model class(HomeMenu class).
     * @return "menuClicked" from model class (HomeMenu class)
     */
    public boolean getControllerMenuClicked(){
        return homeMenuModel.getMenuClicked();
    }
}
