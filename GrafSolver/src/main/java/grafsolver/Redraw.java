package grafsolver;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Redraw implements EventHandler<ActionEvent>{

    private Button redrawButton;
    private Group root;

    public Redraw (Button redrawButton, Group root ) {
        this.redrawButton = redrawButton;
        this.root = root;
    }
    @Override
    public void handle(ActionEvent event) {

    }
}
