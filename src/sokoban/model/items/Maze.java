package sokoban.model.items;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugeny on 23.02.2016.
 */
public class Maze {
    private Man man;
    private List<Wall> walls;
    private List<Target> targets;
    private List<Box> boxes;

    public Maze() {
        walls = new ArrayList<>();
        targets = new ArrayList<>();
        boxes = new ArrayList<>();
    }

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

    public void moveMan(Direction dir) {
        man.setPosition(dir.next(man.getPosition()));
        System.out.println(man.getX() + " " + man.getY());
    }
}
