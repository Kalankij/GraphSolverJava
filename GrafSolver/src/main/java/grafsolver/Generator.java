package grafsolver;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Random;

public class Generator implements EventHandler<ActionEvent> {

    private Button generateButton;
    private Group root;
    private Label widthLabel;
    private TextField widthTxt;
    private Label lenLabel;
    private TextField lenTxt;
    private Label cohLabel;
    private TextField cohTxt;
    private TextField cohMainTxt;
    private TextField sizeMainTxt;
    private Label weightLabel;
    private TextField weightFromTxt;
    private TextField weightToTxt;

    public Generator (Group root , TextField sizeMainTxt, TextField cohMainTxt) {
        this.root = root;
        this.sizeMainTxt = sizeMainTxt;
        this.cohMainTxt = cohMainTxt;
    }
    @Override
    public void handle(ActionEvent event) {
        root.setDisable(true);
        Group secRoot =  new Group();
        Scene secScene = new Scene(secRoot,300,300);
        Stage secStage = new Stage();

        widthLabel = new Label("Width: ");
        widthLabel.setLayoutX(50);
        widthLabel.setLayoutY(30);
        widthLabel.setPrefSize(100,15);
        widthLabel.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,16));
        widthTxt = new TextField();
        widthTxt.setPromptText("1-1000");
        widthTxt.setLayoutX(150);
        widthTxt.setLayoutY(30);
        widthTxt.setPrefSize(100,15);
        widthTxt.setAlignment(Pos.CENTER);
        widthTxt.setFocusTraversable(false);
        widthTxt.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));

        lenLabel = new Label("Length: ");
        lenLabel.setLayoutX(50);
        lenLabel.setLayoutY(80);
        lenLabel.setPrefSize(100,15);
        lenLabel.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,16));
        lenTxt = new TextField();
        lenTxt.setPromptText("1-1000");
        lenTxt.setLayoutX(150);
        lenTxt.setLayoutY(80);
        lenTxt.setPrefSize(100,15);
        lenTxt.setAlignment(Pos.CENTER);
        lenTxt.setFocusTraversable(false);
        lenTxt.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));

        cohLabel = new Label("Coherent: ");
        cohLabel.setLayoutX(50);
        cohLabel.setLayoutY(130);
        cohLabel.setPrefSize(100,15);
        cohLabel.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,16));
        cohTxt = new TextField();
        cohTxt.setPromptText("true/false");
        cohTxt.setLayoutX(150);
        cohTxt.setLayoutY(130);
        cohTxt.setPrefSize(100,15);
        cohTxt.setAlignment(Pos.CENTER);
        cohTxt.setFocusTraversable(false);
        cohTxt.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));

        weightLabel = new Label("Weight: ");
        weightLabel.setLayoutX(50);
        weightLabel.setLayoutY(180);
        weightLabel.setPrefSize(100,15);
        weightLabel.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,16));
        weightFromTxt = new TextField();
        weightFromTxt.setPromptText("From");
        weightFromTxt.setLayoutX(150);
        weightFromTxt.setLayoutY(180);
        weightFromTxt.setPrefSize(50,15);
        weightFromTxt.setAlignment(Pos.CENTER);
        weightFromTxt.setFocusTraversable(false);
        weightFromTxt.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));
        weightToTxt = new TextField();
        weightToTxt.setPromptText("To");
        weightToTxt.setLayoutX(210);
        weightToTxt.setLayoutY(180);
        weightToTxt.setPrefSize(50,15);
        weightToTxt.setAlignment(Pos.CENTER);
        weightToTxt.setFocusTraversable(false);
        weightToTxt.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR,14));

        generateButton = new Button("Generate");
        generateButton.setLayoutX(50);
        generateButton.setLayoutY(230);
        generateButton.setPrefSize(200,25);
        generateButton.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.ITALIC,20));
        generateButton.setFocusTraversable(false);
        generateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int blad = 0;
                int width = 0;
                int length = 0;
                double from = 0;
                double to = 0;
                boolean coherent = false;
                if (widthTxt.getText().equals("")) {
                    widthTxt.setText("10");
                }
                if (lenTxt.getText().equals("")) {
                    lenTxt.setText("10");
                }
                if (cohTxt.getText().equals("")) {
                    cohTxt.setText("false");
                }
                if (weightFromTxt.getText().equals("")) {
                    weightFromTxt.setText("0.00");
                }
                if (weightToTxt.getText().equals("")) {
                    weightToTxt.setText("1.00");
                }
                try {
                    width = Integer.parseInt(widthTxt.getText());
                } catch (NumberFormatException e) {
                    widthTxt.setStyle("-fx-background-color: red");
                    widthTxt.setText("");
                    blad = 1;
                }
                try {
                    length = Integer.parseInt(lenTxt.getText());
                } catch (NumberFormatException e) {
                    lenTxt.setStyle("-fx-background-color: red");
                    lenTxt.setText("");
                    blad = 1;
                }
                try {
                    from = Double.parseDouble(weightFromTxt.getText());
                } catch (NumberFormatException e) {
                    weightFromTxt.setStyle("-fx-background-color: red");
                    weightFromTxt.setText("");
                    blad = 1;
                }
                try {
                    to = Double.parseDouble(weightToTxt.getText());
                } catch (NumberFormatException e) {
                    weightToTxt.setStyle("-fx-background-color: red");
                    weightToTxt.setText("");
                    blad = 1;
                }
                if (!cohTxt.getText().equals("true") && !cohTxt.getText().equals("false")) {
                    cohTxt.setStyle("-fx-background-color: red");
                    cohTxt.setText("");
                    blad = 1;
                } else {
                    coherent = Boolean.parseBoolean(cohTxt.getText());
                }
                if (blad == 0) {
                    run(width,length,from,to,coherent);
                    sizeMainTxt.setText(widthTxt.getText() + "x" + lenTxt.getText());
                    cohMainTxt.setText(cohTxt.getText());
                    secStage.close();
                    root.setDisable(false);
                }
            }
        });

        secRoot.getChildren().add(widthTxt);
        secRoot.getChildren().add(widthLabel);
        secRoot.getChildren().add(lenLabel);
        secRoot.getChildren().add(lenTxt);
        secRoot.getChildren().add(cohLabel);
        secRoot.getChildren().add(cohTxt);
        secRoot.getChildren().add(weightFromTxt);
        secRoot.getChildren().add(weightLabel);
        secRoot.getChildren().add(weightToTxt);
        secRoot.getChildren().add(generateButton);

        secStage.setScene(secScene);
        secStage.show();
        secStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                root.setDisable(false);
            }
        });
    }
    public void run ( int width,int length, double from, double to , boolean coherent ) {
        Graf graf = new Graf(width*length);
        Random random = new Random();
        for ( Wierzcholek w:graf) {
            w.addKrawedz(random.nextInt(0,width*length),random.nextDouble(from,to));
        }
        for ( Wierzcholek w: graf) {
            for ( Krawedz k : w) {
                System.out.println(k.getTo() + " " + k.getWaga());
            }
        }
    }
}
