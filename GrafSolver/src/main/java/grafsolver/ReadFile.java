package grafsolver;

import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogEvent;
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

import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile implements EventHandler<ActionEvent> {

    private Button readfileButton;
    private Button chooseButton;
    private TextField pathTxt;
    private Group root;
    private File file;
    private Group secRoot;
    private Scene secScene;
    private Stage secStage;
    private static Graf graf;
    private final FileChooser fileChooser = new FileChooser();

    public ReadFile (  Group root ) {
        this.root = root;
    }
    @Override
    public void handle(ActionEvent event) {
        root.setDisable(true);
        secRoot =  new Group();
         secScene = new Scene(secRoot,300,200);
         secStage = new Stage();

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
                     file = fileChooser.showOpenDialog(secStage);
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
                        if ( file != null ) readfileButton.setDisable(false);
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
        readfileButton.setDisable(true);
        readfileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    graf = wczytaj(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                root.setDisable(false);
                secStage.close();
            }
        });

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
    public Graf wczytaj(File f) throws IOException {
        Graf graf;
        Scanner in = new Scanner(f);
        int columns = 0;
        int rows = 0;
        try {
             columns = in.nextInt();
             rows = in.nextInt();
        } catch (InputMismatchException | NumberFormatException e) {
            secStage.close();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("Number of columns and rows must be an Integer and Natural!!");
            errorAlert.show();
        }
        int size = columns*rows;
        if ( size <= 0 ) {
            secStage.close();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("Number of columns and rows must be a natural!!");
            errorAlert.show();
        }
        graf = new Graf(rows,columns);
        for ( Wierzcholek w : graf) {
                if (w.getNumer() == 0 || w.getNumer() == columns - 1 || w.getNumer() == (rows - 1) * columns || w.getNumer() == columns * rows - 1) {
                    for (int i = 0; i < 2; i++) {
                        int tmp = 0;
                        try {
                            tmp = in.nextInt();
                            in.skip(" :");
                        } catch (NumberFormatException e ) {
                            secStage.close();
                            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                            errorAlert.setHeaderText("Input not valid");
                            errorAlert.setContentText("Number of vertex must be a natural!!");
                            errorAlert.show();
                        } catch ( NoSuchElementException e) {
                            System.err.println(file.getName());
                        }

                        double waga = 0;
                        try {
                            waga = Double.parseDouble(in.next());
                        } catch (InputMismatchException | NumberFormatException e) {
                            secStage.close();
                            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                            errorAlert.setHeaderText("Input not valid");
                            errorAlert.setContentText("Number of vertex must be a real number!!");
                            errorAlert.show();
                        }
                        w.addKrawedz(tmp, waga);
                    }
                } else if (w.getNumer() % columns == 0 || (w.getNumer() - 1) % columns == 0 || w.getNumer() < columns - 1 || w.getNumer() > (rows - 1) * columns) {
                    for (int i = 0; i < 3; i++) {
                        int tmp = in.nextInt();
                        in.skip(" :");
                        double waga = Double.parseDouble(in.next());
                        w.addKrawedz(tmp, waga);
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        int tmp = in.nextInt();
                        in.skip(" :");
                        double waga = Double.parseDouble(in.next());
                        w.addKrawedz(tmp, waga);
                    }
                }

        }
        if ( Generator.getGraf() != null )
            Generator.setGraf();
        in.close();
        return graf;
    }
    public static Graf getGraf() {
        return graf;
    }
    public static void setGraf() {
        graf = null;
    }
}
