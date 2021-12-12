package Brick.Break.Wall.Levels;

import Brick.Break.Brick.BrickController;
import Brick.Break.Wall.Wall;


/**
 * This class is for level checking and progression.
 * The methods in this class were extracted from "Wall" class.
 */
public class LevelProgression {
    private LevelsCreation levelsCreation;
    private BrickController[][] levels;
    private int level;
    private Wall wallModel;

    /**
     * This is the constructor of "LevelProgression" class.
     * This contructor get the data from "Wall" class.
     * @param wallModel This parameter is the object of "Wall" class.
     */
    public LevelProgression(Wall wallModel){
        this.wallModel = wallModel;
        levelsCreation = new LevelsCreation();
        levels = levelsCreation.makeLevels(wallModel.getDrawArea(), wallModel.getBrickCount(), wallModel.getLineCount(), wallModel.getBrickDimensionRatio());
        level = 0;

    }


    /**
     * This method is used to set up next level if the player progress or skip the current level.
     */
    public void nextLevel(){
        wallModel.setBricks(levels[level++]);
        wallModel.getBrickAmount().setBrickCount(wallModel.getBricks().length);
    }

    /**
     * This method is used to check if there are another level after the current level.
     * @return "true" or "false"
     */
    public boolean hasLevel(){
        return level < levels.length;
    }


    /**
     * This method is used to set total level progression manually.
     * @param level Total level progression.
     */
    public void setLevel(int level){
        this.level = level;
    }


    /**
     * This method is used to get all the level in the game.
     * @return "levels".
     */
    public BrickController[][] getLevels(){
        return levels;
    }

}
