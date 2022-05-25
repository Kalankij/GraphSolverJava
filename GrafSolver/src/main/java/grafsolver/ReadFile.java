package grafsolver;

import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.FileNotFoundException;

public class ReadFile implements EventHandler<ActionEvent> {

    private Button readfileButton;
    private Button chooseButton;
    private TextField pathTxt;
    private Group root;
    private final FileChooser fileChooser = new FileChooser();;

    public ReadFile ( Group root ) {
        this.root = root;
    }
    @Override
    public void handle(ActionEvent event) {
        root.setDisable(true);
        Group secRoot =  new Group();
        Scene secScene = new Scene(secRoot,300,200);
        Stage secStage = new Stage();

        chooseButton = new Button("Choose File");
        chooseButton.setLayoutX(50);
        chooseButton.setLayoutY(30);
        chooseButton.setPrefSize(200,25);
        chooseButton.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.ITALIC,20));
        chooseButton.setFocusTraversable(false);
        chooseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    File file = fileChooser.showOpenDialog(secStage);
                    if ( !file.toString().endsWith(".txt")) {
                        pathTxt.setPrefSize(300,15);
                        pathTxt.setLayoutX(0);
                        pathTxt.setStyle("-fx-background-color: red; -fx-fill-text: black;");
                        pathTxt.setText("WYMAGANE ROZSZERZENIE: \".txt\"!!");
                        pathTxt.setAlignment(Pos.CENTER);
                    } else {
                        pathTxt.setPrefSize(200,15);
                        pathTxt.setLayoutX(50);
                        pathTxt.setStyle(null);
                        pathTxt.setText(file.getName());
                        pathTxt.setAlignment(Pos.CENTER_LEFT);
                    }
                } catch ( NullPointerException ignored) {
                }
            }
        });

        pathTxt = new TextField();
        pathTxt.setText("Uploaded File");
        pathTxt.setLayoutX(50);
        pathTxt.setLayoutY(80);
        pathTxt.setPrefSize(200,15);
        pathTxt.setEditable(false);
        pathTxt.setAlignment(Pos.CENTER);
        pathTxt.setMouseTransparent(true);
        pathTxt.setFocusTraversable(false);
        pathTxt.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));

        readfileButton = new Button("Read File");
        readfileButton.setLayoutX(50);
        readfileButton.setLayoutY(130);
        readfileButton.setPrefSize(200,25);
        readfileButton.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.ITALIC,20));
        readfileButton.setFocusTraversable(false);
        readfileButton.setStyle("-fx-background-color: grey");

        secRoot.getChildren().add(chooseButton);
        secRoot.getChildren().add(pathTxt);
        secRoot.getChildren().add(readfileButton);


        secStage.setScene(secScene);
        secStage.show();
        secStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                root.setDisable(false);
            }
        });
    }
}
