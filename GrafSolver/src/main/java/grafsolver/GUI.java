package grafsolver;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.ArrayList;

public class GUI extends Application {
    private final int WIDTH = 850;
    private final int HEIGHT = 745;
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
    private static TextField resTxt;
    private Group root = new Group();
    private Scene scene = new Scene(root,WIDTH,HEIGHT);
    private Button examplebutton;
    private Line examplelineup;
    private Line examplelinedown;
    private Line examplelineleft;
    private Line examplelineright;
    private Label exampletextup;
    private Label exampletextdown;
    private Label exampletextleft;
    private Label exampletextright;
    private Rectangle examplecolorrectangle;

    private Label examplewageinfo;
    private TextField examplewagefrom;

    private TextField examplewageto;




    Stop[] stops = new Stop[] {
            new Stop(0, Color.RED),
            new Stop(0.25, Color.YELLOW),
            new Stop(0.5, Color.LIMEGREEN),
            new Stop(0.75, Color.CYAN),
            new Stop(1, Color.BLUE)
    };
    LinearGradient linearGradient =
            new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops);
    @Override
    public void start(Stage stage) throws IOException {

        examplebutton = new Button("  ");
        examplebutton.setLayoutX(720);
        examplebutton.setLayoutY(0);
        examplebutton.setPrefSize(60,60);
        examplebutton.setFocusTraversable(false);
        examplelineup = new Line(780, 20, 800, 20 );
        examplelinedown = new Line(780, 40, 800, 40);
        examplelineleft = new Line(740, 60, 740, 80);
        examplelineright = new Line(760, 60, 760, 80);
        exampletextup = new Label();
        exampletextup.setText("out");
        exampletextup.setLayoutX(805);
        exampletextup.setLayoutY(13);
        exampletextup.setFocusTraversable(false);
        exampletextup.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,10));
        exampletextdown = new Label();
        exampletextdown.setText("in");
        exampletextdown.setLayoutX(805);
        exampletextdown.setLayoutY(34);
        exampletextdown.setFocusTraversable(false);
        exampletextdown.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,10));
        exampletextleft = new Label();
        exampletextleft.setText("in");
        exampletextleft.setLayoutX(736);
        exampletextleft.setLayoutY(81);
        exampletextleft.setFocusTraversable(false);
        exampletextleft.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,10));
        exampletextright = new Label();
        exampletextright.setText("out");
        exampletextright.setLayoutX(751);
        exampletextright.setLayoutY(81);
        exampletextright.setFocusTraversable(false);
        exampletextright.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,10));
        examplecolorrectangle = new Rectangle(780, 170, 30, 550);
        examplecolorrectangle.setFill(linearGradient);
        examplewageinfo = new Label();
        examplewageinfo.setText("Edge color scale");
        examplewageinfo.setLayoutX(720);
        examplewageinfo.setLayoutY(420);
        examplewageinfo.setFocusTraversable(false);
        examplewageinfo.setRotate(-90);
        examplewageinfo.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,12));
        examplewagefrom = new TextField();
        examplewagefrom.setText("from");
        examplewagefrom.setLayoutX(770);
        examplewagefrom.setLayoutY(725);
        examplewagefrom.setPrefSize(50,13);
        examplewagefrom.setAlignment(Pos.CENTER);
        examplewagefrom.setEditable(false);
        examplewagefrom.setMouseTransparent(true);
        examplewagefrom.setFocusTraversable(false);
        examplewagefrom.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,12));
        examplewageto = new TextField();
        examplewageto.setText("to");
        examplewageto.setLayoutX(770);
        examplewageto.setLayoutY(142);
        examplewageto.setPrefSize(50,13);
        examplewageto.setAlignment(Pos.CENTER);
        examplewageto.setEditable(false);
        examplewageto.setMouseTransparent(true);
        examplewageto.setFocusTraversable(false);
        examplewageto.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,12));


        generateButton = new Button("Generate");
        generateButton.setPrefSize(100,25);
        generateButton.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));
        generateButton.setFocusTraversable(false);

        redrawButton = new Button("Redraw");
        redrawButton.setLayoutX(100);
        redrawButton.setLayoutY(0);
        redrawButton.setPrefSize(100,25);
        redrawButton.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));
        redrawButton.setFocusTraversable(false);

        saveButton = new Button("Save");
        saveButton.setLayoutX(200);
        saveButton.setLayoutY(0);
        saveButton.setPrefSize(100,25);
        saveButton.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));
        saveButton.setFocusTraversable(false);

        readfileButton = new Button("Read File");
        readfileButton.setLayoutX(300);
        readfileButton.setLayoutY(0);
        readfileButton.setPrefSize(100,25);
        readfileButton.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));
        readfileButton.setFocusTraversable(false);

        deleteButton = new Button("Delete");
        deleteButton.setLayoutX(400);
        deleteButton.setLayoutY(0);
        deleteButton.setPrefSize(100,25);
        deleteButton.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));
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

        readfileButton.setOnAction(new ReadFile(root,sizeTxt,cohTxt, examplewagefrom, examplewageto));
        generateButton.setOnAction(new Generator(root,sizeTxt,cohTxt, examplewagefrom, examplewageto));
        saveButton.setOnAction(new Save(root));
        deleteButton.setOnAction(new Delete(root));
        redrawButton.setOnAction(new Redraw(root));

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
        root.getChildren().add(examplebutton);
        root.getChildren().add(examplelineup);
        root.getChildren().add(examplelinedown);
        root.getChildren().add(examplelineleft);
        root.getChildren().add(examplelineright);
        root.getChildren().add(exampletextup);
        root.getChildren().add(exampletextdown);
        root.getChildren().add(exampletextleft);
        root.getChildren().add(exampletextright);
        root.getChildren().add(examplecolorrectangle);
        root.getChildren().add(examplewagefrom);
        root.getChildren().add(examplewageto);
        root.getChildren().add(examplewageinfo);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case G -> generateButton.fire();
                    case R -> redrawButton.fire();
                    case S -> saveButton.fire();
                    case F -> readfileButton.fire();
                    case D -> deleteButton.fire();
                }
            }
        });


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
    public static void setResult(TextField result,double suma) {
        result.setText(String.valueOf(suma));
        result.setAlignment(Pos.CENTER_LEFT);
    }

    public static TextField getResTxt() {
        return resTxt;
    }
}