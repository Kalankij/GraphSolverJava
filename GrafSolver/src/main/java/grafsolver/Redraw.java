package grafsolver;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Redraw extends Draw implements EventHandler<ActionEvent>{

    private static Group root;

    public Redraw ( Group root ) {
        Redraw.root = root;
    }
    @Override
    public void handle(ActionEvent event) {
        root.getChildren().removeAll(getPathline());
    }
    public static void run () {
        if ( getPathline() != null )
            root.getChildren().removeAll(getPathline());
    }
}
