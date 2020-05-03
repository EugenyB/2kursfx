package sokoban.model.items;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private Man man;
    private final List<Wall> walls;
    private final List<Target> targets;
    private final List<Box> boxes;

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
        if (containsObject(ob, walls)) {
            return;
        }
        Pair next2 = dir.next(next);
        GameObject ob2 = new GameObject(next2.getRow(),next2.getColumn());

        if (containsObject(ob, boxes) && (containsObject(ob2, boxes) || containsObject(ob2, walls))) {
            return;
        }
        boxes.stream().filter(b->b.getPosition().equals(ob.getPosition())).findFirst().ifPresent(box -> box.setPosition(next2));
        man.setPosition(next);
        checkWin();
    }

    private boolean containsObject(GameObject ob2, List<? extends GameObject> objects) {
        return objects.stream().anyMatch(b -> b.getPosition().equals(ob2.getPosition()));
    }

    private void checkWin() {
        if (boxes.containsAll(targets)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Победа");
            alert.setHeaderText("Вы прошли уровень");
            alert.setContentText("С чем вас и поздравляем!");
            alert.show();
        }
    }
}
