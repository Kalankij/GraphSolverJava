package grafsolver;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Delete extends Draw implements EventHandler<ActionEvent>  {

    private static Group root;

    public Delete ( Group root ) {
        Delete.root = root;
    }
    @Override
    public void handle(ActionEvent event) {
        root.getChildren().removeAll(getPoint());
        root.getChildren().removeAll(getLine());
    }

    public static void run () {
        if ( getPoint() != null || getLine() != null ) {
            root.getChildren().removeAll(getPoint());
            root.getChildren().removeAll(getLine());
        }
    }
}
