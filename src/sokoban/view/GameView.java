package sokoban.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sokoban.model.items.Game;

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
        gc.strokeLine(0,0,canvas.getWidth(),canvas.getHeight());
    }

    private void clear() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    }
}
