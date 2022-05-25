package grafsolver;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Save implements EventHandler<ActionEvent> {

    private Button saveButton;
    private Group root;

    public Save (Button generateButton, Group root ) {
        this.saveButton = generateButton;
        this.root = root;
    }
    @Override
    public void handle(ActionEvent event) {

    }
}
