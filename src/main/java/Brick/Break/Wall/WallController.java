package Brick.Break.Wall;

import Brick.Break.Attribute.Move;
import Brick.Break.Ball.BallController;
import Brick.Break.Ball.RubberBall.RubberBall;
import Brick.Break.Ball.RubberBall.RubberBallController;
import Brick.Break.Brick.BrickController;
import Brick.Break.Brick.CementBrick.CementBrick;
import Brick.Break.Brick.CementBrick.CementBrickController;
import Brick.Break.Brick.ClayBrick.ClayBrick;
import Brick.Break.Brick.ClayBrick.ClayBrickController;
import Brick.Break.Brick.Crack.CrackController;
import Brick.Break.Brick.GoldBrick.GoldBrick;
import Brick.Break.Brick.GoldBrick.GoldBrickController;
import Brick.Break.Brick.SteelBrick.SteelBrick;
import Brick.Break.Brick.SteelBrick.SteelBrickController;
import Brick.Break.Player.Player;
import Brick.Break.Player.PlayerController;

import java.awt.*;
import java.awt.geom.Point2D;

public class WallController implements Move {
    private Wall wallModel;
    private int level;

    public WallController(Wall wallModel){
        this.wallModel = wallModel;
        wallModel.setLevels( makeLevels(wallModel.getDrawArea(),wallModel.getBrickCount(),wallModel.getLineCount(),wallModel.getBrickDimensionRatio()));
        wallModel.setLevel(0);
        makeBall(wallModel.getBallPos());
        level = wallModel.getLevel();
        wallModel.setStartPoint(new Point(wallModel.getBallPos()));
        wallModel.setBallAmount(new BallAmount(wallModel.getBallCount(), wallModel.getBallLost()));
        wallModel.getBallAmount().setBallCount(3);
        wallModel.getBallAmount().setBallLost(false);

        wallModel.setBrickAmount(new BrickAmount(wallModel.getBrickCount()));

        int speedX,speedY;
        do{
            speedX = 3;
        }while(speedX == 0);
        do{
            speedY = -3;
        }while(speedY == 0);

        wallModel.getBallController().setSPEED(speedX,speedY);

        wallModel.setPlayerController(new PlayerController(new Player((Point) wallModel.getBallPos().clone(),150,10, wallModel.getDrawArea())));

       wallModel.setArea(wallModel.getDrawArea());
    }

    private BrickController[] makeSingleTypeLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, int type){
        /*
          if brickCount is not divisible by line count,brickCount is adjusted to the biggest
          multiple of lineCount smaller then brickCount
         */
        brickCnt -= brickCnt % lineCnt;

        int brickOnLine = brickCnt / lineCnt;

        double brickLen = drawArea.getWidth() / brickOnLine;
        double brickHgt = brickLen / brickSizeRatio;

        brickCnt += lineCnt / 2;

        BrickController[] tmp  = new BrickController[brickCnt];

        Dimension brickSize = new Dimension((int) brickLen,(int) brickHgt);
        Point p = new Point();

        int i;
        for(i = 0; i < tmp.length; i++){
            int line = i / brickOnLine;
            if(line == lineCnt)
                break;
            double x = (i % brickOnLine) * brickLen;
            x =(line % 2 == 0) ? x : (x - (brickLen / 2));
            double y = (line) * brickHgt;
            p.setLocation(x,y);
            tmp[i] = makeBrick(p,brickSize,type);
        }

        for(double y = brickHgt;i < tmp.length;i++, y += 2*brickHgt){
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p.setLocation(x,y);
            tmp[i] = new ClayBrickController(new ClayBrick(p,brickSize));
        }
        return tmp;

    }

    private BrickController[] makeChessboardLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, int typeA, int typeB){
        /*
          if brickCount is not divisible by line count,brickCount is adjusted to the biggest
          multiple of lineCount smaller then brickCount
         */
        brickCnt -= brickCnt % lineCnt;

        int brickOnLine = brickCnt / lineCnt;

        int centerLeft = brickOnLine / 2 - 1;
        int centerRight = brickOnLine / 2 + 1;

        double brickLen = drawArea.getWidth() / brickOnLine;
        double brickHgt = brickLen / brickSizeRatio;

        brickCnt += lineCnt / 2;

        BrickController[] tmp  = new BrickController[brickCnt];

        Dimension brickSize = new Dimension((int) brickLen,(int) brickHgt);
        Point p = new Point();

        int i;
        for(i = 0; i < tmp.length; i++){
            int line = i / brickOnLine;
            if(line == lineCnt)
                break;
            int posX = i % brickOnLine;
            double x = posX * brickLen;
            x =(line % 2 == 0) ? x : (x - (brickLen / 2));
            double y = (line) * brickHgt;
            p.setLocation(x,y);

            boolean b = ((line % 2 == 0 && i % 2 == 0) || (line % 2 != 0 && posX > centerLeft && posX <= centerRight));
            tmp[i] = b ?  makeBrick(p,brickSize,typeA) : makeBrick(p,brickSize,typeB);
        }

        for(double y = brickHgt;i < tmp.length;i++, y += 2*brickHgt){
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p.setLocation(x,y);
            tmp[i] = makeBrick(p,brickSize,typeA);
        }
        return tmp;
    }

    private void makeBall(Point2D ballPos){
        wallModel.setBallController(new RubberBallController(new RubberBall(ballPos)));
    }

    private BrickController[][] makeLevels(Rectangle drawArea,int brickCount,int lineCount,double brickDimensionRatio){
        BrickController[][] tmp = new BrickController[Wall.getLevelsCount()][];
        tmp[0] = makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,Wall.getClay());
        tmp[1] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,Wall.getClay(),Wall.getCement());
        tmp[2] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,Wall.getClay(),Wall.getSteel());
        tmp[3] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,Wall.getSteel(),Wall.getCement());
        tmp[4] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,Wall.getSteel(),Wall.getSteel());
        tmp[5] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,Wall.getGold(),Wall.getSteel());
        return tmp;
    }

    @Override
    public void move(){
        wallModel.getPlayerController().move();
        wallModel.getBallController().move();
    }

    public void findImpacts(){
        if(wallModel.getPlayerController().impact( wallModel.getBallController())){
            wallModel.getBallController().ReverseY();
        }
        else if(impactWall()){
            /*for efficiency reverse is done into method impactWall
             * because for every brick program checks for horizontal and vertical impacts
             */
            wallModel.getBrickAmount().setBrickCount(wallModel.getBrickAmount().getBrickCount() - 1);
        }
        else if(impactBorder()) {
            wallModel.getBallController().ReverseX();
        }
        else if( wallModel.getBallController().getBallPosition().getY() < wallModel.getArea().getY()){
            wallModel.getBallController().ReverseY();
        }
        else if( wallModel.getBallController().getBallPosition().getY() > wallModel.getArea().getY() + wallModel.getArea().getHeight()){
            wallModel.getBallAmount().setBallCount(wallModel.getBallAmount().getBallCount() - 1);
            wallModel.getBallAmount().setBallLost(true);
        }
    }

    private boolean impactWall(){
        for(BrickController b : wallModel.getBricks()){
            //Vertical Impact
            if (b.findImpact(wallModel.getBallController()) == BrickController.getImpactUp()){
                wallModel.getBallController().ReverseY();
                return b.setImpact( wallModel.getBallController().getBallDown(), CrackController.getUP());
            }
            else if(b.findImpact( wallModel.getBallController()) == BrickController.getImpactDown()){
                wallModel.getBallController().ReverseY();
                return b.setImpact( wallModel.getBallController().getBallUp(), CrackController.getDOWN());
            }//Horizontal Impact
            else if(b.findImpact( wallModel.getBallController()) == BrickController.getImpactLeft()){
                wallModel.getBallController().ReverseX();
                return b.setImpact( wallModel.getBallController().getBallRight(), CrackController.getLEFT());
            }
            else if(b.findImpact( wallModel.getBallController())== BrickController.getImpactRight()){
                wallModel.getBallController().ReverseX();
                return b.setImpact( wallModel.getBallController().getBallLeft(), CrackController.getCrackRIGHT());
            }
        }
        return false;
    }

    private boolean impactBorder(){
        Point2D p =  wallModel.getBallController().getBallPosition();
        return ((p.getX() < wallModel.getArea().getX()) ||(p.getX() > (wallModel.getArea().getX() + wallModel.getArea().getWidth())));
    }



    public void ballReset(){
        wallModel.getPlayerController().moveTo(wallModel.getStartPoint());
        wallModel.getBallController().moveTo(wallModel.getStartPoint());
        int speedX,speedY;
        do{
            speedX = 3;
        }while(speedX == 0);
        do{
            speedY = -3;
        }while(speedY == 0);

        wallModel.getBallController().setSPEED(speedX,speedY);
        wallModel.getBallAmount().setBallLost(false);
    }

    public void wallReset(){
        for(BrickController b : wallModel.getBricks())
            b.repair();
        wallModel.getBrickAmount().setBrickCount(wallModel.getBricks().length);
        wallModel.getBallAmount().setBallCount(3);
    }



    public void nextLevel(){
        wallModel.setBricks(wallModel.getLevels()[level++]);
        wallModel.getBrickAmount().setBrickCount(wallModel.getBricks().length);
    }

    public boolean hasLevel(){
        return wallModel.getLevel() < wallModel.getLevels().length;
    }

    public void setBallXSpeed(int s){
        wallModel.getBallController().setSpeedX(s);
    }

    public void setBallYSpeed(int s){
        wallModel.getBallController().setSpeedY(s);
    }


    private BrickController makeBrick(Point point, Dimension size, int type){
        BrickController out;
        if (type == Wall.getClay()) {
            out = new ClayBrickController(new ClayBrick(point, size));
        }
        else if (type == Wall.getSteel()) {
            out = new SteelBrickController(new SteelBrick(point, size));
        }
        else if (type == Wall.getCement()) {
            out = new CementBrickController(new CementBrick(point, size));
        }
        else if (type == Wall.getGold()) {
            out = new GoldBrickController(new GoldBrick(point, size));
        }
        else{
                throw  new IllegalArgumentException(String.format("Unknown Type:%d\n",type));
        }
        return  out;
    }

    public BallController getWallBallController(){
        return wallModel.getBallController();
    }
    public PlayerController getWallPlayerController(){
        return wallModel.getPlayerController();
    }

    public BrickAmount getWallBrickAmount(){
        return wallModel.getBrickAmount();
    }
    public BallAmount getWallBallAmount(){
        return wallModel.getBallAmount();
    }
    public BrickController[] getWallBricks(){
        return wallModel.getBricks();
    }

}
