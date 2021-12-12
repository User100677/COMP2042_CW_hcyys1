package Brick.Break.MenuPage.InstructionMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * This is the Controller of Model class(InstructionMenu Class) in InstructionMenu MVC design pattern
 */
public class InstructionMenuController extends JComponent implements MouseListener, MouseMotionListener {
    private InstructionMenu instructionMenuModel;
    private InstructionMenuView instructionMenuView;

    /**
     * This is the constructor of "InstructionMenuController" class.
     * This constructor will set the default value for the data in model class(InstructionMenu class) once it is called by another class.
     * @param instructionMenuModel This parameter is the object of model class(InstructionMenu class).
     */
    public InstructionMenuController(InstructionMenu instructionMenuModel){
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.instructionMenuModel = instructionMenuModel;

        instructionMenuModel.setInstructionMenuFace(new Rectangle(new Point(0, 0), instructionMenuModel.getArea()));
        this.setPreferredSize(instructionMenuModel.getArea());

        Dimension btnDim = new Dimension(instructionMenuModel.getArea().width / 3, instructionMenuModel.getArea().height / 12);
        instructionMenuModel.setBackButton(new Rectangle(btnDim));

        instructionMenuView = new InstructionMenuView(this);
    }

    /**
     * This method get the "drawInstructionMenu" method from "InstructionMenuView" class and draw out the instruction menu screen.
     */
    public void paint(Graphics g) {
        instructionMenuView.drawInstructionMenu((Graphics2D) g);
    }

    /**
     * This method determined and show what should the button do when it is clicked.
     * In this case, when the instruction button is clicked the screen will change from home menu screen to instruction menu screen.
     */
    public void mouseClicked(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(instructionMenuModel.getBackButton().contains(p)){
            instructionMenuModel.getOwner().openMainMenu();

        }

    }

    /**
     * This method determined and show what should the button do when it is pressed.
     * In this case, if the instruction button is pressed without letting go, it doesn't do anything.
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(instructionMenuModel.getBackButton().contains(p)){
            instructionMenuModel.setBackClicked(true);
            repaint(instructionMenuModel.getBackButton().x,instructionMenuModel.getBackButton().y,instructionMenuModel.getBackButton().width+1,instructionMenuModel.getBackButton().height+1);

        }
    }

    /**
     * This method determined and show what should the button do when it is pressed and release.
     * For example, if the instruction button is pressed but was released outside the button, the button will not do anything.
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if(instructionMenuModel.getBackClicked() ){
            instructionMenuModel.setBackClicked(false);
            repaint(instructionMenuModel.getBackButton().x,instructionMenuModel.getBackButton().y,instructionMenuModel.getBackButton().width+1,instructionMenuModel.getBackButton().height+1);
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
        if(instructionMenuModel.getBackButton().contains(p) )
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        else
            this.setCursor(Cursor.getDefaultCursor());

    }
    /**
     * This is a getter method which get the face the of the instruction menu from the model class(InstructionMenu class).
     * @return "instructionMenuFace" from model class (InstructionMenu class)
     */
    public Rectangle getControllerInstructionMenuFace(){
        return instructionMenuModel.getInstructionMenuFace();
    }

    /**
     * This is a getter method which get the back button from the model class(InstructionMenu class).
     * @return "backButton" from model class (InstructionMenu class)
     */
    public Rectangle getControllerBackButton(){
        return instructionMenuModel.getBackButton();
    }

    /**
     * This is a getter method which get the back clicked from the model class(InstructionMenu class).
     * @return "backClicked" from model class (InstructionMenu class)
     */
    public boolean getControllerBackClicked(){
        return instructionMenuModel.getBackClicked();
    }
}
