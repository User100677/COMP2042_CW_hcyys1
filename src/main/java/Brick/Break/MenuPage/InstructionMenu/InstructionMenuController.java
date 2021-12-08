package Brick.Break.MenuPage.InstructionMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InstructionMenuController extends JComponent implements MouseListener, MouseMotionListener {
    private InstructionMenu instructionMenuModel;
    private InstructionMenuView instructionMenuView;

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

    public void paint(Graphics g) {
        instructionMenuView.drawInstructionMenu((Graphics2D) g);
    }


    public void mouseClicked(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(instructionMenuModel.getBackButton().contains(p)){
            instructionMenuModel.getOwner().openMainMenu();

        }

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(instructionMenuModel.getBackButton().contains(p)){
            instructionMenuModel.setBackClicked(true);
            repaint(instructionMenuModel.getBackButton().x,instructionMenuModel.getBackButton().y,instructionMenuModel.getBackButton().width+1,instructionMenuModel.getBackButton().height+1);

        }
    }

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

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(instructionMenuModel.getBackButton().contains(p) )
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        else
            this.setCursor(Cursor.getDefaultCursor());

    }
    public Rectangle getControllerInstructionMenuFace(){
        return instructionMenuModel.getInstructionMenuFace();
    }

    public Rectangle getControllerBackButton(){
        return instructionMenuModel.getBackButton();
    }
    public boolean getControllerBackClicked(){
        return instructionMenuModel.getBackClicked();
    }
}
