package Brick.Break.MenuPage.HomeMenu;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * This is the View of Model class(HomeMenu class) in the HomeMenu MVC Design Pattern.
 */
public class HomeMenuView {
    private static final String GREETINGS = "Welcome to:";
    private static final String GAME_TITLE = "Brick Destroy";
    private static final String CREDITS = "Version 0.1";
    private static final String START_TEXT = "Start";
    private static final String INSTRUCTION_TEXT = "Instruction";
    private static final String MENU_TEXT = "Exit";

    private static final Color BG_COLOR = Color.GREEN.darker();
    private static final Color BORDER_COLOR = new Color(200,8,21); //Venetian Red
    private static final Color DASH_BORDER_COLOR = new  Color(255, 216, 0);//school bus yellow
    private static final Color TEXT_COLOR = new Color(16, 52, 166);//egyptian blue
    private static final Color CLICKED_BUTTON_COLOR = BG_COLOR.brighter();
    private static final Color CLICKED_TEXT = Color.WHITE;


    private BasicStroke borderStoke;
    private BasicStroke borderStoke_noDashes;

    private Font greetingsFont;
    private Font gameTitleFont;
    private Font creditsFont;
    private Font buttonFont;
    private static final int BORDER_SIZE = 5;
    private static final float[] DASHES = {12,6};

    private HomeMenuController homeMenuController;

    /**
     * This is the constructor of "HomeMenuView" class.
     * This constructor get the data from the controller class(HomeMenuController class).
     * @param homeMenuController This parameter is the object of controller class(HomeMenuController class).
     */
    HomeMenuView(HomeMenuController homeMenuController){

        this.homeMenuController = homeMenuController;
        borderStoke = new BasicStroke(BORDER_SIZE,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,0,DASHES,0);
        borderStoke_noDashes = new BasicStroke(BORDER_SIZE,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
        greetingsFont = new Font("Noto Mono",Font.PLAIN,25);
        gameTitleFont = new Font("Noto Mono",Font.BOLD,40);
        creditsFont = new Font("Monospaced",Font.PLAIN,10);
        buttonFont = new Font("Monospaced",Font.PLAIN,homeMenuController.getControllerStartButton().height-2);
    }


    /**
     * This method draw out the whole home menu screen.
     */
    public void drawMenu(Graphics2D g2d){

        drawContainer(g2d);

        /*
        all the following method calls need a relative
        painting directly into the HomeMenu rectangle,
        so the translation is made here so the other methods do not do that.
         */
        Color prevColor = g2d.getColor();
        Font prevFont = g2d.getFont();

        double x = homeMenuController.getControllerMenuFace().getX();
        double y = homeMenuController.getControllerMenuFace().getY();

        g2d.translate(x,y);

        //methods calls
        drawText(g2d);
        drawButton(g2d);
        //end of methods calls

        g2d.translate(-x,-y);
        g2d.setFont(prevFont);
        g2d.setColor(prevColor);
    }

    /**
     * This method draw out the frame of the home menu screen.
     */
    private void drawContainer(Graphics2D g2d){
        Color prev = g2d.getColor();

        g2d.setColor(BG_COLOR);
        g2d.fill(homeMenuController.getControllerMenuFace());

        Stroke tmp = g2d.getStroke();

        g2d.setStroke(borderStoke_noDashes);
        g2d.setColor(DASH_BORDER_COLOR);
        g2d.draw(homeMenuController.getControllerMenuFace());

        g2d.setStroke(borderStoke);
        g2d.setColor(BORDER_COLOR);
        g2d.draw(homeMenuController.getControllerMenuFace());

        g2d.setStroke(tmp);

        g2d.setColor(prev);
    }

    /**
     * This method draw out the text onto the home menu screen.
     */
    private void drawText(Graphics2D g2d){

        g2d.setColor(TEXT_COLOR);

        FontRenderContext frc = g2d.getFontRenderContext();

        Rectangle2D greetingsRect = greetingsFont.getStringBounds(GREETINGS,frc);
        Rectangle2D gameTitleRect = gameTitleFont.getStringBounds(GAME_TITLE,frc);
        Rectangle2D creditsRect = creditsFont.getStringBounds(CREDITS,frc);

        int sX,sY;

        sX = (int)(homeMenuController.getControllerMenuFace().getWidth() - greetingsRect.getWidth()) / 2;
        sY = (int)(homeMenuController.getControllerMenuFace().getHeight() / 4);

        g2d.setFont(greetingsFont);
        g2d.drawString(GREETINGS,sX,sY);

        sX = (int)(homeMenuController.getControllerMenuFace().getWidth() - gameTitleRect.getWidth()) / 2;
        sY += (int) gameTitleRect.getHeight() * 1.1;//add 10% of String height between the two strings

        g2d.setFont(gameTitleFont);
        g2d.drawString(GAME_TITLE,sX,sY);

        sX = (int)(homeMenuController.getControllerMenuFace().getWidth() - creditsRect.getWidth()) / 2;
        sY += (int) creditsRect.getHeight() * 1.1;

        g2d.setFont(creditsFont);
        g2d.drawString(CREDITS,sX,sY);


    }

    /**
     * This method draw out the button onto the home menu screen.
     */
    private void drawButton(Graphics2D g2d){

        FontRenderContext frc = g2d.getFontRenderContext();

        Rectangle2D txtRect = buttonFont.getStringBounds(START_TEXT,frc);
        Rectangle2D instructTxtRect = buttonFont.getStringBounds(INSTRUCTION_TEXT,frc);
        Rectangle2D mTxtRect = buttonFont.getStringBounds(MENU_TEXT,frc);

        g2d.setFont(buttonFont);

        int x = (homeMenuController.getControllerMenuFace().width - homeMenuController.getControllerStartButton().width) / 2;
        int y =(int) ((homeMenuController.getControllerMenuFace().height -  homeMenuController.getControllerStartButton().height) * 0.6);

        homeMenuController.getControllerStartButton().setLocation(x,y);

        x = (int)( homeMenuController.getControllerStartButton().getWidth() - txtRect.getWidth()) / 2;
        y = (int)( homeMenuController.getControllerStartButton().getHeight() - txtRect.getHeight()) / 2;

        x +=  homeMenuController.getControllerStartButton().x;
        y +=  homeMenuController.getControllerStartButton().y + ( homeMenuController.getControllerStartButton().height * 0.9);


        if(homeMenuController.getControllerStartClicked()){
            Color tmp = g2d.getColor();
            g2d.setColor(CLICKED_BUTTON_COLOR);
            g2d.draw( homeMenuController.getControllerStartButton());
            g2d.setColor(CLICKED_TEXT);
            g2d.drawString(START_TEXT,x,y);
            g2d.setColor(tmp);
        }
        else{
            g2d.draw( homeMenuController.getControllerStartButton());
            g2d.drawString(START_TEXT,x,y);
        }

        x =  homeMenuController.getControllerStartButton().x;
        y =  homeMenuController.getControllerStartButton().y;

        y *= 1.2;

        homeMenuController.getControllerInstructionButton().setLocation(x,y);


        x = (int)(homeMenuController.getControllerInstructionButton().getWidth() - instructTxtRect.getWidth()) / 2;
        y = (int)(homeMenuController.getControllerInstructionButton().getHeight() - instructTxtRect.getHeight()) / 2;

        x += homeMenuController.getControllerInstructionButton().x;
        y += homeMenuController.getControllerInstructionButton().y + (homeMenuController.getControllerStartButton().height * 0.9);

        if(homeMenuController.getControllerInstructionClicked()){
            Color tmp = g2d.getColor();

            g2d.setColor(CLICKED_BUTTON_COLOR);
            g2d.draw(homeMenuController.getControllerInstructionButton());
            g2d.setColor(CLICKED_TEXT);
            g2d.drawString(INSTRUCTION_TEXT,x,y);
            g2d.setColor(tmp);
        }
        else{
            g2d.draw(homeMenuController.getControllerInstructionButton());
            g2d.drawString(INSTRUCTION_TEXT,x,y);
        }

        x = homeMenuController.getControllerInstructionButton().x;
        y = homeMenuController.getControllerInstructionButton().y;
        y *= 1.2;

        homeMenuController.getControllerMenuButton().setLocation(x,y);

        x = (int)(homeMenuController.getControllerMenuButton().getWidth() - mTxtRect.getWidth()) / 2;
        y = (int)(homeMenuController.getControllerMenuButton().getHeight() - mTxtRect.getHeight()) / 2;

        x += homeMenuController.getControllerMenuButton().x;
        y += homeMenuController.getControllerMenuButton().y + (homeMenuController.getControllerStartButton().height * 0.9);

        if(homeMenuController.getControllerMenuClicked()){
            Color tmp = g2d.getColor();

            g2d.setColor(CLICKED_BUTTON_COLOR);
            g2d.draw(homeMenuController.getControllerMenuButton());
            g2d.setColor(CLICKED_TEXT);
            g2d.drawString(MENU_TEXT,x,y);
            g2d.setColor(tmp);
        }
        else{
            g2d.draw(homeMenuController.getControllerMenuButton());
            g2d.drawString(MENU_TEXT,x,y);
        }




    }
}
