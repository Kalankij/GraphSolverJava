package grafsolver;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;

public class Redraw extends Draw implements EventHandler<ActionEvent>{

    private static Group root;
    private static ArrayList<Line [] > lines = new ArrayList<>();

    public Redraw ( Group root ) {
        Redraw.root = root;
    }
    @Override
    public void handle(ActionEvent event) {
            for ( Line [] l : lines) {
                if ( l != null)
                root.getChildren().removeAll(l);
            }
            if ( getPathline()!= null)
            root.getChildren().removeAll(getPathline());
    }
    public static void run () {
        lines.add(getPathline());
    }
    public  static void clear () {
        for ( Line [] l : lines) {
            if ( l != null)
                root.getChildren().removeAll(l);
        }
        if ( getPathline()!= null)
            root.getChildren().removeAll(getPathline());
    }

}
