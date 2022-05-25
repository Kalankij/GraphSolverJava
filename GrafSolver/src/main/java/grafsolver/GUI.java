package grafsolver;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class GUI extends Application {
    private final int WIDTH = 700;
    private final int HEIGHT = 700;
    private Button generateButton;
    private Button redrawButton;
    private Button saveButton;
    private Button readfileButton;
    private Button deleteButton;
    private Label sizeLabel;
    private Label cohLabel;
    private Label resLabel;
    private TextField sizeTxt;
    private TextField cohTxt;
    private TextField resTxt;
    private Group root = new Group();
    private Scene scene = new Scene(root,WIDTH,HEIGHT);;

    @Override
    public void start(Stage stage) throws IOException {

        generateButton = new Button("Generate");
        generateButton.setPrefSize(100,25);
        generateButton.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));
        generateButton.setFocusTraversable(false);

        redrawButton = new Button("Redraw");
        redrawButton.setLayoutX(100);
        redrawButton.setLayoutY(0);
        redrawButton.setPrefSize(100,25);
        redrawButton.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));
        redrawButton.setOnAction(new Redraw(redrawButton,root));
        redrawButton.setFocusTraversable(false);

        saveButton = new Button("Save");
        saveButton.setLayoutX(200);
        saveButton.setLayoutY(0);
        saveButton.setPrefSize(100,25);
        saveButton.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));
        saveButton.setOnAction(new Save(saveButton,root));
        saveButton.setFocusTraversable(false);

        readfileButton = new Button("Read File");
        readfileButton.setLayoutX(300);
        readfileButton.setLayoutY(0);
        readfileButton.setPrefSize(100,25);
        readfileButton.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));
        readfileButton.setOnAction(new ReadFile(root));
        readfileButton.setFocusTraversable(false);

        deleteButton = new Button("Delete");
        deleteButton.setLayoutX(400);
        deleteButton.setLayoutY(0);
        deleteButton.setPrefSize(100,25);
        deleteButton.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));
        deleteButton.setOnAction(new Delete(deleteButton,root));
        deleteButton.setFocusTraversable(false);

        sizeLabel = new Label("Grid Size: ");
        sizeLabel.setLayoutX(10);
        sizeLabel.setLayoutY(33);
        sizeLabel.setPrefSize(100,15);
        sizeLabel.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,16));
        sizeTxt = new TextField();
        sizeTxt.setText("Grid Size");
        sizeTxt.setLayoutX(100);
        sizeTxt.setLayoutY(30);
        sizeTxt.setPrefSize(100,15);
        sizeTxt.setAlignment(Pos.CENTER);
        sizeTxt.setEditable(false);
        sizeTxt.setMouseTransparent(true);
        sizeTxt.setFocusTraversable(false);
        sizeTxt.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));

        cohLabel = new Label("Coherent: ");
        cohLabel.setLayoutX(210);
        cohLabel.setLayoutY(33);
        cohLabel.setPrefSize(100,15);
        cohLabel.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,16));
        cohTxt = new TextField();
        cohTxt.setText("Coherent");
        cohTxt.setLayoutX(300);
        cohTxt.setLayoutY(30);
        cohTxt.setPrefSize(100,15);
        cohTxt.setAlignment(Pos.CENTER);
        cohTxt.setEditable(false);
        cohTxt.setMouseTransparent(true);
        cohTxt.setFocusTraversable(false);
        cohTxt.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));

        resLabel = new Label("Sum of weights: ");
        resLabel.setLayoutX(410);
        resLabel.setLayoutY(33);
        resLabel.setPrefSize(200,15);
        resLabel.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,16));
        resTxt = new TextField();
        resTxt.setText("Result");
        resTxt.setLayoutX(550);
        resTxt.setLayoutY(30);
        resTxt.setPrefSize(100,15);
        resTxt.setAlignment(Pos.CENTER);
        resTxt.setEditable(false);
        resTxt.setMouseTransparent(true);
        resTxt.setFocusTraversable(false);
        resTxt.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));

        generateButton.setOnAction(new Generator(root,sizeTxt,cohTxt));

        root.getChildren().add(generateButton);
        root.getChildren().add(redrawButton);
        root.getChildren().add(saveButton);
        root.getChildren().add(readfileButton);
        root.getChildren().add(deleteButton);
        root.getChildren().add(sizeLabel);
        root.getChildren().add(sizeTxt);
        root.getChildren().add(cohLabel);
        root.getChildren().add(cohTxt);
        root.getChildren().add(resLabel);
        root.getChildren().add(resTxt);

        stage.setTitle("GraphSolver");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

}