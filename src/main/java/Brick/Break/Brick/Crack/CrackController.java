package Brick.Break.Brick.Crack;

import Brick.Break.Brick.Crack.Directions.Direction;
import Brick.Break.Brick.Crack.Directions.DirectionFactory;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

/**
 * This is the Controller of Model class(Crack Class) in Crack MVC design pattern.
 */
public class  CrackController{
    private Crack crackModel;
    private CrackView crackView;

    /**
     * This is the constructor of "CrackController" class.
     * This constructor will set the default value for the data in model class(Crack class) once it is called by another class.
     * @param crackModel This parameter is the object of model class(Crack class).
     */
    public CrackController(Crack crackModel){
        this.crackModel = crackModel;
        crackView = new CrackView(this);
    }

    /**
     * This method get the "drawCrack" method from "CrackView" class and draw out the ball to the screen.
     */
    public GeneralPath renderCrack() {

        return crackView.drawCrack();
    }

    /**
     * This method clear the crack from teh brick.
     */
    public void reset() {
       crackModel.getCrack().reset();
    }

    /**
     * This method is to determined where the crack will appear.
     * The if-else statement in this class is design in factory design pattern.
     * @param point This parameter is the position of the impact.
     * @param direction This parameter is the direction of the crack.
     */
    public void makeCrack(Point2D point, int direction) {
        Rectangle bounds = crackModel.getCrackBrick().getBRICKFace().getBounds();

        Point impact = new Point((int) point.getX(), (int) point.getY());
        Point start = new Point();
        Point end = new Point();

        DirectionFactory directionFactory = new DirectionFactory();
        Direction directions ;
        if(direction == crackModel.getLeft()){
            directions = directionFactory.getDirection(crackModel.getLeft());
            Point tmp = makeRandomPoint(directions.setStartLocation(start, bounds),directions.setEndLocation(end, bounds),crackModel.getVertical());
            makeCrack(impact,tmp);
        }
        else if(direction == crackModel.getRight()){
            directions = directionFactory.getDirection( crackModel.getRight());
            Point tmp = makeRandomPoint(directions.setStartLocation(start, bounds),directions.setEndLocation(end, bounds),crackModel.getVertical());
            makeCrack(impact,tmp);
        }
        else if(direction == crackModel.getUp()){
            directions = directionFactory.getDirection(crackModel.getUp());
            Point tmp = makeRandomPoint(directions.setStartLocation(start, bounds),directions.setEndLocation(end, bounds),crackModel.getHorizontal());
            makeCrack(impact,tmp);
        }
        else if(direction == crackModel.getDown()){
            directions = directionFactory.getDirection(crackModel.getDown());
            Point tmp = makeRandomPoint(directions.setStartLocation(start, bounds),directions.setEndLocation(end, bounds),crackModel.getHorizontal());
            makeCrack(impact,tmp);
        }




    }

    /**
     * This method is to determine how should the crack appear on the brick
     * @param start This parameter is the start point of the crack.
     * @param end This parameter is the end point of the crack.
     */
    protected void makeCrack(Point start, Point end) {

        GeneralPath path = new GeneralPath();


        path.moveTo(start.x, start.y);

        double w = (end.x - start.x) / (double) crackModel.getSteps();
        double h = (end.y - start.y) / (double) crackModel.getSteps();

        int bound = crackModel.getCrackDepth();
        int jump = bound * 5;

        double x, y;

        for (int i = 1; i < crackModel.getSteps(); i++) {

            x = (i * w) + start.x;
            y = (i * h) + start.y + randomInBounds(bound);

            if (inMiddle(i, crackModel.getCrackSections(), crackModel.getSteps()))
                y += jumps(jump, crackModel.getJumpProbability());

            path.lineTo(x, y);

        }

        path.lineTo(end.x, end.y);
        crackModel.getCrack().append(path, true);
    }

    /**
     * This method is to randomize the boundary of the crack appearance.
     * @param bound This parameter is the boundary of the crack.
     */
    public int randomInBounds(int bound) {
        int n = (bound * 2) + 1;
        int s = crackModel.getRnd().nextInt(n) & Integer.MAX_VALUE;
        return s - bound;
    }

    /**
     * This method determine if the crack is in the middle.
     */
    public boolean inMiddle(int i, int steps, int divisions) {
        int low = (steps / divisions);
        int up = low * (divisions - 1);

        return (i > low) && (i < up);
    }


    private int jumps(int bound, double probability) {
        if (crackModel.getRnd().nextDouble() > probability)
            return randomInBounds(bound);
        return 0;

    }

    /**
     * This method make th crack appear in a random point.
     * @param from  This parameter is the start of a point.
     * @param to This parameter is the end of the point.
     * @param direction This parameter is the direction of the crack.
     * @return new Point(value)
     */
    private Point makeRandomPoint(Point from, Point to, int direction) {

        Point out = new Point();
        int pos;


            if(direction ==  crackModel.getHorizontal()) {
                pos = crackModel.getRnd().nextInt(to.x - from.x) + from.x & Integer.MAX_VALUE;
                out.setLocation(pos, to.y);
            }
            else if(direction == crackModel.getVertical() ) {
                pos = crackModel.getRnd().nextInt(to.y - from.y) + from.y & Integer.MAX_VALUE;
                out.setLocation(to.x, pos);
            }

        return out;
    }

    /**
     * This is a getter method which get the up direction of the crack from the model class(crack class).
     * @return "30" from model class (Crack class)
     */
    public static int getUP(){
        return Crack.getUp();
    }

    /**
     * This is a getter method which get the down direction of the crack from the model class(crack class).
     * @return "40" from model class (Crack class)
     */
    public static int getDOWN(){
        return Crack.getDown();
    }

    /**
     * This is a getter method which get the right direction of the crack from the model class(crack class).
     * @return "20" from model class (Crack class)
     */
    public static int getCrackRIGHT(){
        return Crack.getRight();
    }

    /**
     * This is a getter method which get the left direction of the crack from the model class(crack class).
     * @return "10" from model class (Crack class)
     */
    public static int getLEFT(){
        return Crack.getLeft();

    }
    /**
     * This is a getter method which get the crack appearance from the model class(crack class).
     * @return "GeneralPath crack" from model class (Crack class)
     */
    public GeneralPath getControllerCrack(){
        return crackModel.getCrack();
    }

    /**
     * This is a getter method which get the jump probability from the model class(crack class).
     * @return "0.7" from model class (Crack class)
     */
    public double getControllerJumpProbability(){
        return crackModel.getJumpProbability();
    }



}
