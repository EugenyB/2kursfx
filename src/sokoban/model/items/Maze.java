package sokoban.model.items;


import javafx.scene.control.Alert;

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

    public Man getMan() {
        return man;
    }

    public void moveMan(Direction dir) {
        Pair next = dir.next(man.getPosition());
        GameObject ob = new GameObject(next.getRow(), next.getColumn());
        if (walls.contains(ob)) {
            return;
        }
        Pair next2 = dir.next(next);
        GameObject ob2 = new GameObject(next2.getRow(),next2.getColumn());
        if (boxes.contains(ob) && (boxes.contains(ob2) || walls.contains(ob2))) {
            return;
        }
        if (boxes.contains(ob)) {
            int i = boxes.indexOf(ob);
            boxes.get(i).setPosition(next2);
        }
        man.setPosition(next);
        checkWin();
    }

    private void checkWin() {
        if (boxes.containsAll(targets)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Победа");
            alert.setHeaderText("Вы прошли уровень");
            alert.setContentText("С чем вас и поздравляем!");
            alert.showAndWait();
        }
    }
}
