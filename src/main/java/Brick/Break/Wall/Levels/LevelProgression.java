package Brick.Break.Wall.Levels;

import Brick.Break.Brick.BrickController;
import Brick.Break.Wall.Wall;


public class LevelProgression {
    private LevelsCreation levelsCreation;
    private BrickController[][] levels;
    private int level;
    private Wall wallModel;

    public LevelProgression(Wall wallModel){
        this.wallModel = wallModel;
        levelsCreation = new LevelsCreation();
        levels = levelsCreation.makeLevels(wallModel.getDrawArea(), wallModel.getBrickCount(), wallModel.getLineCount(), wallModel.getBrickDimensionRatio());
        level = 0;

    }

    public void nextLevel(){
        wallModel.setBricks(levels[level++]);
        wallModel.getBrickAmount().setBrickCount(wallModel.getBricks().length);
    }

    public boolean hasLevel(){
        return level < levels.length;
    }

    public BrickController[] getLevelsBrick(){
        return wallModel.getBricks();
    }
    public void setLevel(int level){
        this.level = level;
    }
    public int getLevel(){
        return level;
    }
    public int getLevelBrickAmount(){
        return wallModel.getBrickAmount().getBrickCount();
    }
    public BrickController[][] getLevels(){
        return levels;
    }
    public void setLevelBrickAmount(int brickAmount){
        wallModel.getBrickAmount().setBrickCount(brickAmount);
    }
}
