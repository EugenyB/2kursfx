package sokoban.model.items;

import sokoban.model.util.Level;
import sokoban.model.util.Levels;

import java.util.List;

public class Game {

    Level currentLevel;

    public Game() {
        currentLevel = Levels.getLevel(1);
        currentLevel.buildMaze();
    }

    public void move(Direction dir) {
        Maze maze = currentLevel.getStoredMaze();
        maze.moveMan(dir);
    }

    public List<Wall> getWalls() {
        return currentLevel.getStoredMaze().getWalls();
    }

    public List<Target> getTargets() {
        return currentLevel.getStoredMaze().getTargets();
    }

    public List<Box> getBoxes() {
        return currentLevel.getStoredMaze().getBoxes();
    }

    public Man getMan() {
        return currentLevel.getStoredMaze().getMan();
    }
}
