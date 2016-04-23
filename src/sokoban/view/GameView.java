package sokoban.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sokoban.model.items.*;

import java.util.List;

/**
 * Created by eugeny on 23.02.2016.
 */
public class GameView {
    Game game;
    Canvas canvas;

    public GameView(Game game, Canvas canvas) {
        this.game = game;
        this.canvas = canvas;
    }

    public void draw() {
        clear();
        GraphicsContext gc = canvas.getGraphicsContext2D();

        List<Wall> walls = game.getWalls();
        walls.stream().forEach(w->drawWall(w,gc));

        List<Target> targets = game.getTargets();
        targets.stream().forEach(t->drawTarget(t,gc));

        List<Box> boxes = game.getBoxes();
        boxes.stream().forEach(b->drawBox(b,gc));

        Man man = game.getMan();
        drawMan(man,gc);

    }

    private void drawMan(Man man, GraphicsContext gc) {
        gc.setFill(Color.RED);
        int row = man.getRow();
        int column = man.getColumn();
        double cellSize = getCellSize();
        gc.fillOval(column*cellSize, row*cellSize, cellSize, cellSize);
        gc.strokeOval(column*cellSize, row*cellSize, cellSize, cellSize);
    }

    private void drawBox(Box b, GraphicsContext gc) {
        gc.setFill(new Color(0,0,1.0,0.5));
        gc.setStroke(Color.BLACK);
        drawGameObject(b, gc);
    }

    private void drawTarget(Target t, GraphicsContext gc) {
        gc.setFill(Color.YELLOW);
        gc.setStroke(Color.BLACK);
        drawGameObject(t, gc);
    }

    private void drawWall(Wall w, GraphicsContext gc) {
        gc.setFill(Color.BLUEVIOLET);
        gc.setStroke(Color.BLUEVIOLET);
        drawGameObject(w, gc);
    }

    private void drawGameObject(GameObject gameObject, GraphicsContext gc) {
        int row = gameObject.getRow();
        int column = gameObject.getColumn();
        double cellSize = getCellSize();
        gc.fillRect(column*cellSize, row*cellSize, cellSize, cellSize);
        gc.strokeRect(column*cellSize, row*cellSize, cellSize, cellSize);
    }

    private double getCellSize() {
        double s1 = canvas.getWidth()/30;
        double s2 = canvas.getHeight()/22;
        return Math.min(s1,s2);
    }

    private void clear() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    }

}
