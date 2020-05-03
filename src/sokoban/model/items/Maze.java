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

    public MoveResult moveMan(Direction dir) {
        Pair next = dir.next(man.getPosition());
        GameObject ob = new GameObject(next.getRow(), next.getColumn());
        if (containsObject(ob, walls)) {
            return MoveResult.IMPOSSIBLE;
        }
        Pair next2 = dir.next(next);
        GameObject ob2 = new GameObject(next2.getRow(),next2.getColumn());

        if (containsObject(ob, boxes) && (containsObject(ob2, boxes) || containsObject(ob2, walls))) {
            return MoveResult.IMPOSSIBLE;
        }
        boxes.stream().filter(b->b.getPosition().equals(ob.getPosition())).findFirst().ifPresent(box -> box.setPosition(next2));
        man.setPosition(next);
        boolean win = checkWin();
        if (win) return MoveResult.WIN; else return MoveResult.SIMPLE;
    }

    private boolean containsObject(GameObject ob2, List<? extends GameObject> objects) {
        return objects.stream().anyMatch(b -> b.getPosition().equals(ob2.getPosition()));
    }

    private boolean checkWin() {
        if (boxes.containsAll(targets)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Победа");
            alert.setHeaderText("Вы прошли уровень");
            alert.setContentText("С чем вас и поздравляем!");
            alert.showAndWait();
            return true;
        }
        return false;
    }
}
