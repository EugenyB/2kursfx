package sokoban.controller;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import sokoban.model.items.Direction;
import sokoban.model.items.Game;
import sokoban.model.items.MoveResult;
import sokoban.model.util.Level;
import sokoban.model.util.Levels;
import sokoban.view.GameView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Game game;
    GameView gv;

    @FXML
    Canvas canvas;

    @FXML
    Pane pane;

    public void close() {
        Platform.exit();
    }

    public void processKey(Event event) {
        KeyEvent keyEvent = (KeyEvent) event;
        KeyCode keyCode = keyEvent.getCode();
        MoveResult res = MoveResult.IMPOSSIBLE;
        switch (keyCode) {
            case UP: res = game.move(Direction.UP);
                break;
            case DOWN: res = game.move(Direction.DOWN);
                break;
            case LEFT: res = game.move(Direction.LEFT);
                break;
            case RIGHT: res = game.move(Direction.RIGHT);
                break;
        }
        if (res==MoveResult.WIN) {
            if (Levels.getCurrentLevel()==Levels.getTotal()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Победа");
                alert.setHeaderText("Вы прошли все уровни");
                alert.setContentText("С чем вас и поздравляем!");
                alert.showAndWait();
                Platform.exit();
            }
            game = new Game(Levels.getCurrentLevel()+1);
            gv = new GameView(game, canvas);
        }
        gv.draw();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().bind(pane.heightProperty());

        canvas.widthProperty().addListener(e->gv.draw());
        canvas.heightProperty().addListener(e->gv.draw());

        game = new Game();
        gv = new GameView(game, canvas);
    }
}
