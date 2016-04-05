package sokoban.model.items;

import sokoban.model.util.Level;
import sokoban.model.util.Levels;

/**
 * Created by eugeny on 23.02.2016.
 */
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
}
