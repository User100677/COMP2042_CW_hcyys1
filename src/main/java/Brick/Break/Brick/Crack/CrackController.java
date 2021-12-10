package Brick.Break.Brick.Crack;

import Brick.Break.Brick.Crack.Directions.Direction;
import Brick.Break.Brick.Crack.Directions.DirectionFactory;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

public class CrackController{
    private Crack crackModel;
    private CrackView crackView;

    public CrackController(Crack crackModel){
        this.crackModel = crackModel;
        crackView = new CrackView(this);
    }

    public GeneralPath renderCrack() {

        return crackView.drawCrack();
    }

    public void reset() {
       crackModel.getCrack().reset();
    }

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

    public int randomInBounds(int bound) {
        int n = (bound * 2) + 1;
        return crackModel.getRnd().nextInt(n) - bound;
    }

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

    private Point makeRandomPoint(Point from, Point to, int direction) {

        Point out = new Point();
        int pos;


            if(direction ==  crackModel.getHorizontal()) {
                pos = crackModel.getRnd().nextInt(to.x - from.x) + from.x;
                out.setLocation(pos, to.y);
            }
            else if(direction == crackModel.getVertical() ) {
                pos = crackModel.getRnd().nextInt(to.y - from.y) + from.y;
                out.setLocation(to.x, pos);
            }

        return out;
    }

    public static int getUP(){
        return Crack.getUp();
    }

    public static int getDOWN(){
        return Crack.getDown();
    }

    public static int getCrackRIGHT(){
        return Crack.getRight();
    }

    public static int getLEFT(){
        return Crack.getLeft();

    }
    public GeneralPath getControllerCrack(){
        return crackModel.getCrack();
    }
    public double getControllerJumpProbability(){
        return crackModel.getJumpProbability();
    }



}
