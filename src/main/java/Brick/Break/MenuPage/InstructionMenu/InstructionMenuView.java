package Brick.Break.MenuPage.InstructionMenu;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * This is the View of Model class(InstructionMenu class) in the InstructionMenu MVC Design Pattern.
 */
public class InstructionMenuView {

    private static final String moveLeft = "a : Move left";
    private static final String moveRight = "d : Move Right";
    private static final String pause = "SpaceBar : Pause";
    private static final String pauseMenu = "ESC Button : Open Pause Menu";
    private static final String debugConsole = "Alt + Shift + F1 : Open Debug Console";
    private static final String back = "Back";

    private static final float[] DASHES = {12, 6};
    private static final int BORDER_SIZE = 5;

    private static final Color TEXT_COLOR = new Color(96, 89, 203, 255);
    private static final Color BG_COLOR = Color.GREEN.darker();
    private static final Color BORDER_COLOR = new Color(200, 8, 21);
    private static final Color DASH_BORDER_COLOR = new Color(255, 216, 0);
    private static final Color CLICKED_BUTTON_COLOR = BG_COLOR.brighter();
    private static final Color CLICKED_TEXT = Color.WHITE;

    private Font instructionFont;
    private Font buttonFont;

    private BasicStroke borderStoke;
    private BasicStroke borderStoke_noDashes;

    private InstructionMenuController instructionMenuController;

    /**
     * This is the constructor of "InstructionMenuView" class.
     * This constructor get the data from the controller class(InstructionMenuController class).
     * @param instructionMenuController This parameter is the object of controller class(instructionMenuController class).
     */
    InstructionMenuView(InstructionMenuController instructionMenuController){
        this.instructionMenuController = instructionMenuController;

        borderStoke = new BasicStroke(BORDER_SIZE, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, DASHES, 0);
        borderStoke_noDashes = new BasicStroke(BORDER_SIZE, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        instructionFont = new Font("Noto Mono", Font.PLAIN, 25);
        buttonFont = new Font("Monospaced", Font.PLAIN, instructionMenuController.getControllerBackButton().height - 2);
    }


    /**
     * This method draw out the whole instruction menu screen.
     */
    public void drawInstructionMenu(Graphics2D g2d) {

        drawContainer(g2d);

        Color prevColor = g2d.getColor();
        Font prevFont = g2d.getFont();

        double x = instructionMenuController.getControllerInstructionMenuFace().getX();
        double y = instructionMenuController.getControllerInstructionMenuFace().getY();

        g2d.translate(x, y);

        //methods calls
        drawText(g2d);
        drawButton(g2d);
        //end of methods calls

        g2d.translate(-x, -y);
        g2d.setFont(prevFont);
        g2d.setColor(prevColor);
    }

    /**
     * This method draw out the frame of the instruction menu screen.
     */
    private void drawContainer(Graphics2D g2d) {
        Color prev = g2d.getColor();

        g2d.setColor(BG_COLOR);
        g2d.fill(instructionMenuController.getControllerInstructionMenuFace());

        Stroke tmp = g2d.getStroke();

        g2d.setStroke(borderStoke_noDashes);
        g2d.setColor(DASH_BORDER_COLOR);
        g2d.draw(instructionMenuController.getControllerInstructionMenuFace());

        g2d.setStroke(borderStoke);
        g2d.setColor(BORDER_COLOR);
        g2d.draw(instructionMenuController.getControllerInstructionMenuFace());

        g2d.setStroke(tmp);

        g2d.setColor(prev);
    }

    /**
     * This method draw out the text onto the instruction menu screen.
     */
    private void drawText(Graphics2D g2d) {

        g2d.setColor(TEXT_COLOR);

        FontRenderContext frc = g2d.getFontRenderContext();

        Rectangle2D moveLeftRect = instructionFont.getStringBounds(moveLeft, frc);
        Rectangle2D moveRightRect = instructionFont.getStringBounds(moveRight, frc);
        Rectangle2D pauseRect = instructionFont.getStringBounds(pause, frc);
        Rectangle2D pauseMenuRect = instructionFont.getStringBounds(pauseMenu, frc);
        Rectangle2D debugConsoleRect = instructionFont.getStringBounds(debugConsole, frc);

        int sX, sY;

        sX = (int) (moveLeftRect.getWidth() * 1.25);
        sY = (int) (instructionMenuController.getControllerInstructionMenuFace().getHeight() / 10);

        g2d.setFont(instructionFont);
        g2d.drawString(moveLeft, sX, sY);

        sX = (int) (moveRightRect.getWidth() / 0.95);
        sY += (int) moveRightRect.getHeight() * 1.1;//add 10% of String height between the two strings

        g2d.setFont(instructionFont);
        g2d.drawString(moveRight, sX, sY);

        sX = (int) (pauseRect.getWidth() / 2.7);
        sY += (int) pauseRect.getHeight() * 1.1;

        g2d.setFont(instructionFont);
        g2d.drawString(pause, sX, sY);

        sX = (int) (pauseMenuRect.getWidth() / 7);
        sY += (int) pauseMenuRect.getHeight() * 1.1;

        g2d.setFont(instructionFont);
        g2d.drawString(pauseMenu, sX, sY);

        sX = (int) (instructionMenuController.getControllerInstructionMenuFace().getWidth() - debugConsoleRect.getWidth()) / 2;
        sY += (int) debugConsoleRect.getHeight() * 1.1;

        g2d.setFont(instructionFont);
        g2d.drawString(debugConsole, sX, sY);


    }

    /**
     * This method draw out the button onto the instruction menu screen.
     */
    private void drawButton(Graphics2D g2d) {

        FontRenderContext frc = g2d.getFontRenderContext();

        Rectangle2D buttonTxtRect = buttonFont.getStringBounds(back, frc);

        g2d.setFont(buttonFont);

        int x = (instructionMenuController.getControllerInstructionMenuFace().width - instructionMenuController.getControllerBackButton().width) / 2;
        int y = (int) ((instructionMenuController.getControllerInstructionMenuFace().height - instructionMenuController.getControllerBackButton().height) * 0.8);

        instructionMenuController.getControllerBackButton().setLocation(x, y);

        x = (int) (instructionMenuController.getControllerBackButton().getWidth() - buttonTxtRect.getWidth()) / 2;
        y = (int) (instructionMenuController.getControllerBackButton().getHeight() - buttonTxtRect.getHeight()) / 2;

        x += instructionMenuController.getControllerBackButton().x;
        y += instructionMenuController.getControllerBackButton().y + (instructionMenuController.getControllerBackButton().height * 0.9);


        if (instructionMenuController.getControllerBackClicked()) {
            Color tmp = g2d.getColor();
            g2d.setColor(CLICKED_BUTTON_COLOR);
            g2d.draw(instructionMenuController.getControllerBackButton());
            g2d.setColor(CLICKED_TEXT);
            g2d.drawString(back, x, y);
            g2d.setColor(tmp);
        } else {
            g2d.draw(instructionMenuController.getControllerBackButton());
            g2d.drawString(back, x, y);
        }

    }

}
