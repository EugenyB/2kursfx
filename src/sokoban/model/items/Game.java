package sokoban.model.items;

import sokoban.model.util.Level;
import sokoban.model.util.Levels;

import java.util.List;

public class Game {

    private final Level currentLevel;

    public Game() {
        currentLevel = Levels.getLevel(1);
        currentLevel.buildMaze();
    }

    public Game(int level) {
        currentLevel = Levels.getLevel(level);
        currentLevel.buildMaze();
    }

    public MoveResult move(Direction dir) {
        Maze maze = currentLevel.getStoredMaze();
        return maze.moveMan(dir);
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
