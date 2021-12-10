package Brick.Break.Wall.Levels;

import Brick.Break.Brick.BrickController;
import Brick.Break.Brick.ClayBrick.ClayBrick;
import Brick.Break.Brick.ClayBrick.ClayBrickController;
import Brick.Break.Wall.Wall;


import java.awt.*;

public class LevelsCreation {
    private CreateBrickType createBrickType = new CreateBrickType();


    public BrickController[] makeSingleTypeLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, int type){
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
            tmp[i] = createBrickType.makeBrick(p,brickSize,type);
        }

        for(double y = brickHgt;i < tmp.length;i++, y += 2*brickHgt){
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p.setLocation(x,y);
            tmp[i] = new ClayBrickController(new ClayBrick(p,brickSize));
        }
        return tmp;

    }

    public BrickController[] makeChessboardLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, int typeA, int typeB){
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
            tmp[i] = b ?  createBrickType.makeBrick(p,brickSize,typeA) : createBrickType.makeBrick(p,brickSize,typeB);
        }

        for(double y = brickHgt;i < tmp.length;i++, y += 2*brickHgt){
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p.setLocation(x,y);
            tmp[i] = createBrickType.makeBrick(p,brickSize,typeA);
        }
        return tmp;
    }

    protected BrickController[][] makeLevels(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio){
        BrickController[][] tmp = new BrickController[Wall.getLevelsCount()][];
        tmp[0] = makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,Wall.getClay());
        tmp[1] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,Wall.getClay(),Wall.getCement());
        tmp[2] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,Wall.getClay(),Wall.getSteel());
        tmp[3] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,Wall.getSteel(),Wall.getCement());
        tmp[4] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,Wall.getSteel(),Wall.getSteel());
        tmp[5] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,Wall.getGold(),Wall.getSteel());
        tmp[6] = makeChessboardLevel(drawArea,50,5,brickDimensionRatio,Wall.getGold(),Wall.getGold());
        return tmp;
    }

}
