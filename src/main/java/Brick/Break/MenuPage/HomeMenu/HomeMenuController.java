package Brick.Break.MenuPage.HomeMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class HomeMenuController extends JComponent implements MouseListener, MouseMotionListener {
    private HomeMenu homeMenuModel;
    private HomeMenuView homeMenuView;

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
    public void paint(Graphics g){
        homeMenuView.drawMenu((Graphics2D)g);
    }
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

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(homeMenuModel.getStartButton().contains(p) || homeMenuModel.getMenuButton().contains(p) || homeMenuModel.getInstructionButton().contains(p))
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        else
            this.setCursor(Cursor.getDefaultCursor());

    }

    public Rectangle getControllerStartButton(){
        return homeMenuModel.getStartButton();
    }
    public Rectangle getControllerMenuFace(){
        return homeMenuModel.getMenuFace();
    }
    public Rectangle getControllerInstructionButton(){
        return homeMenuModel.getInstructionButton();
    }
    public Rectangle getControllerMenuButton(){
        return homeMenuModel.getMenuButton();
    }
    public boolean getControllerStartClicked(){
        return homeMenuModel.getStartClicked();
    }
    public boolean getControllerInstructionClicked(){
        return homeMenuModel.getInstructionClicked();
    }
    public boolean getControllerMenuClicked(){
        return homeMenuModel.getMenuClicked();
    }
}
