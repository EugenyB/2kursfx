package sokoban.model.items;


import java.util.List;

/**
 * Created by eugeny on 23.02.2016.
 */
public class Maze {
    Man man;
    List<Wall> walls;
    List<Target> targets;
    List<Box> boxes;

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void setMan(Man man) {
        this.man = man;
    }
}
