package grafsolver;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Delete implements EventHandler<ActionEvent> {

    private Group root;

    public Delete ( Group root ) {
        this.root = root;
    }
    @Override
    public void handle(ActionEvent event) {

    }
}
