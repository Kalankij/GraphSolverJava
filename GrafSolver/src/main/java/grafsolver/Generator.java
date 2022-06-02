package grafsolver;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Random;

public class Generator implements EventHandler<ActionEvent> {

    private Button generateButton;
    private static Group root;
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
    private static Graf graf;

    private static Button point;
    private static Line line;

    private TextField wagescalefrom;
    private TextField wagescaleto;

    public Generator ( Group root , TextField sizeMainTxt, TextField cohMainTxt, TextField wagescalefrom, TextField wagescaleto) {
        this.root = root;
        this.sizeMainTxt = sizeMainTxt;
        this.cohMainTxt = cohMainTxt;
        this.wagescalefrom = wagescalefrom;
        this.wagescaleto = wagescaleto;
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
                    cohTxt.setText("true");
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
                    graf = run(width,length,from,to,coherent);
                    drawgraph(from, to);
                    sizeMainTxt.setText(widthTxt.getText() + "x" + lenTxt.getText());
                    if (bfs(width, length))
                        cohMainTxt.setText("true(BFS)");
                    if (!bfs(width, length))
                        cohMainTxt.setText("false(BFS)");
                    wagescalefrom.setText(weightFromTxt.getText());
                    wagescaleto.setText(weightToTxt.getText());
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
    public Graf run ( int width,int length, double from, double to , boolean coherent ) {
        Graf graf = new Graf(length, width);
        Random random = new Random();
        if (coherent) {
            int i = 0;
            int j = 0;
            for (Wierzcholek w : graf) {
                if (width == 1 && length == 1)  //wyjątek dla grafu 1x1
                    w.addKrawedz(1, 0);
                if (i != (width * (j + 1)) - 1)  //prawa
                    w.addKrawedz(i + 1, random.nextDouble(from, to));
                if (i < width * length - width)  //dół
                    w.addKrawedz(width + i, random.nextDouble(from, to));
                if (i != width * j)  //lewa
                    w.addKrawedz(i - 1, random.nextDouble(from, to));
                if (i - width >= 0)  //góra
                    w.addKrawedz(i - width, random.nextDouble(from, to));
                if (i == width * j + width - 1)
                    j++;
                i++;
            }
        }
        if (!coherent) {
            int i = 0;
            int j = 0;
            for (Wierzcholek w : graf) {
                if (width == 1 && length == 1) { //wyjątek dla grafu 1x1
                        w.addKrawedz(1, 0);
                }
                if (i != (width * (j + 1)) - 1) { //prawa
                    if (random.nextDouble(0, 1) > 0.7) {
                        w.addKrawedz(i + 1, random.nextDouble(from, to));
                    }
                }
                if (i < width * length - width) { //dół
                    if (random.nextDouble(0, 1) > 0.7) {
                        w.addKrawedz(width + i, random.nextDouble(from, to));
                    }
                }
                if (i != width * j) { //lewa
                    if (random.nextDouble(0, 1) > 0.7) {
                        w.addKrawedz(i - 1, random.nextDouble(from, to));
                    }
                }
                if (i - width >= 0) { //góra
                    if (random.nextDouble(0, 1) > 0.7) {
                        w.addKrawedz(i - width, random.nextDouble(from, to));
                    }
                }
                if (i == width * j + width - 1) {
                    j++;
                }
                i++;
            }
        }
        if (ReadFile.getGraf() != null)
            ReadFile.setGraf();
        return graf;
    }
    public static void drawgraph(double from, double to) {
        int width = Graf.getWidth();
        int length = Graf.getLength();
        double red = (to-from)*0.1 + from;
        double orange = (to-from)*0.2 + from;
        double yellow = (to-from)*0.35 + from;
        double lightgreena = (to-from)*0.45 + from;
        double limegreen = (to-from)*0.55 + from;
        double lightgreenb = (to-from)*0.65 + from;
        double cyan = (to-from)*0.8 + from;
        double lightblue = (to-from)*0.9 + from;
        int i = 0;
        int j = 0;
        int k = 0;
        for (Wierzcholek w : graf) {
            if (i != (width * (j + 1)) - 1) { //prawa
                if(w.krawedzi.size() > 0) {
                    if (width == length)
                        line = new Line(700 / width * k + 0.75 * 700 / width, 60 + 700 / length * j + 0.25 * 700 / length, 700 / width * (k + 1), 60 + 700 / length * j + 0.25 * 700 / length);
                        //if(w.getNumer() == w.krawedzi.get(0).getTo() - 1 && w.krawedzi.get(0).getWaga() > 0.5)
                    if (width > length)
                        line = new Line(700 / width * k + 0.75 * 700 / width, 60 + 700 / width * j + 0.25 * 700 / width, 700 / width * (k + 1), 60 + 700 / width * j + 0.25 * 700 / width);
                    if (width < length)
                        line = new Line(700 / length * k + 0.75 * 700 / length, 60 + 700 / length * j + 0.25 * 700 / length, 700 / length * (k + 1), 60 + 700 / length * j + 0.25 * 700 / length);
                    if(w.getNumer() == w.krawedzi.get(0).getTo() - 1) {
                        if (w.krawedzi.get(0).getWaga() <= red)
                            line.setStroke(Color.RED);
                        if (w.krawedzi.get(0).getWaga() > red && w.krawedzi.get(0).getWaga() <= orange)
                            line.setStroke(Color.ORANGE);
                        if (w.krawedzi.get(0).getWaga() > orange && w.krawedzi.get(0).getWaga() <= yellow)
                            line.setStroke(Color.YELLOW);
                        if (w.krawedzi.get(0).getWaga() > yellow && w.krawedzi.get(0).getWaga() <= lightgreena)
                            line.setStroke(Color.LIGHTGREEN);
                        if (w.krawedzi.get(0).getWaga() > lightgreena && w.krawedzi.get(0).getWaga() <= limegreen)
                            line.setStroke(Color.LIMEGREEN);
                        if (w.krawedzi.get(0).getWaga() > limegreen && w.krawedzi.get(0).getWaga() <= lightgreenb)
                            line.setStroke(Color.LIGHTGREEN);
                        if (w.krawedzi.get(0).getWaga() > lightgreenb && w.krawedzi.get(0).getWaga() <= cyan)
                            line.setStroke(Color.CYAN);
                        if (w.krawedzi.get(0).getWaga() > cyan && w.krawedzi.get(0).getWaga() <= lightblue)
                            line.setStroke(Color.LIGHTBLUE);
                        if (w.krawedzi.get(0).getWaga() > lightblue)
                            line.setStroke(Color.BLUE);
                    }
                    root.getChildren().add(line);
                }
            }
            if (i < width * length - width) { //dół
                if(w.krawedzi.size() > 1) {
                    if (width == length)
                        line = new Line(700 / width * k + 0.5 * 700 / width, 60 + 700 / length * j + 0.75 * 700 / length, 700 / width * k + 0.5 * 700 / width, 60 + 700 / length * (j + 1));
                    if (width > length)
                        line = new Line(700 / width * k + 0.5 * 700 / width, 60 + 700 / width * j + 0.75 * 700 / width, 700 / width * k + 0.5 * 700 / width, 60 + 700 / width * (j + 1));
                    if (width < length)
                        line = new Line(700 / length * k + 0.5 * 700 / length, 60 + 700 / length * j + 0.75 * 700 / length, 700 / length * k + 0.5 * 700 / length, 60 + 700 / length * (j + 1));
                    if(w.getNumer() == w.krawedzi.get(1).getTo() - width || w.getNumer() == w.krawedzi.get(0).getTo() - width) {
                        if (w.krawedzi.get(1).getWaga() <= red)
                            line.setStroke(Color.RED);
                        if (w.krawedzi.get(1).getWaga() > red && w.krawedzi.get(0).getWaga() <= orange)
                            line.setStroke(Color.ORANGE);
                        if (w.krawedzi.get(1).getWaga() > orange && w.krawedzi.get(0).getWaga() <= yellow)
                            line.setStroke(Color.YELLOW);
                        if (w.krawedzi.get(1).getWaga() > yellow && w.krawedzi.get(0).getWaga() <= lightgreena)
                            line.setStroke(Color.LIGHTGREEN);
                        if (w.krawedzi.get(1).getWaga() > lightgreena && w.krawedzi.get(0).getWaga() <= limegreen)
                            line.setStroke(Color.LIMEGREEN);
                        if (w.krawedzi.get(1).getWaga() > limegreen && w.krawedzi.get(0).getWaga() <= lightgreenb)
                            line.setStroke(Color.LIGHTGREEN);
                        if (w.krawedzi.get(1).getWaga() > lightgreenb && w.krawedzi.get(0).getWaga() <= cyan)
                            line.setStroke(Color.CYAN);
                        if (w.krawedzi.get(1).getWaga() > cyan && w.krawedzi.get(0).getWaga() <= lightblue)
                            line.setStroke(Color.LIGHTBLUE);
                        if (w.krawedzi.get(1).getWaga() > lightblue)
                            line.setStroke(Color.BLUE);
                    }
                    root.getChildren().add(line);
                }
            }
            if (i != width * j) { //lewa
                if(j == 0) {
                    if (w.krawedzi.size() > 0 && w.getNumer() == w.krawedzi.get(w.krawedzi.size() - 1).getTo() + 1) {
                        if (width == length)
                            line = new Line(700 / width * k, 60 + 700 / length * j + 0.5 * 700 / length, 700 / width * (k - 1) + 0.75 * 700 / width, 60 + 700 / length * j + 0.5 * 700 / length);
                        if (width > length)
                            line = new Line(700 / width * k, 60 + 700 / width * j + 0.5 * 700 / width, 700 / width * (k - 1) + 0.75 * 700 / width, 60 + 700 / width * j + 0.5 * 700 / width);
                        if (width < length)
                            line = new Line(700 / length * k, 60 + 700 / length * j + 0.5 * 700 / length, 700 / length * (k - 1) + 0.75 * 700 / length, 60 + 700 / length * j + 0.5 * 700 / length);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= red)
                            line.setStroke(Color.RED);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > red && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= orange)
                            line.setStroke(Color.ORANGE);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > orange && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= yellow)
                            line.setStroke(Color.YELLOW);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > yellow && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= lightgreena)
                            line.setStroke(Color.LIGHTGREEN);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > lightgreena && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= limegreen)
                            line.setStroke(Color.LIMEGREEN);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > limegreen && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= lightgreenb)
                            line.setStroke(Color.LIGHTGREEN);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > lightgreenb && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= cyan)
                            line.setStroke(Color.CYAN);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > cyan && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= lightblue)
                            line.setStroke(Color.LIGHTBLUE);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > lightblue)
                            line.setStroke(Color.BLUE);
                        root.getChildren().add(line);
                    }
                }
                if(j != 0){
                    if (w.krawedzi.size() > 1 && w.getNumer() == w.krawedzi.get(w.krawedzi.size() - 2).getTo() + 1) {
                        if (width == length)
                            line = new Line(700 / width * k, 60 + 700 / length * j + 0.5 * 700 / length, 700 / width * (k - 1) + 0.75 * 700 / width, 60 + 700 / length * j + 0.5 * 700 / length);
                        if (width > length)
                            line = new Line(700 / width * k, 60 + 700 / width * j + 0.5 * 700 / width, 700 / width * (k - 1) + 0.75 * 700 / width, 60 + 700 / width * j + 0.5 * 700 / width);
                        if (width < length)
                            line = new Line(700 / length * k, 60 + 700 / length * j + 0.5 * 700 / length, 700 / length * (k - 1) + 0.75 * 700 / length, 60 + 700 / length * j + 0.5 * 700 / length);
                        if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() <= red)
                            line.setStroke(Color.RED);
                        if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() > red && w.krawedzi.get(w.krawedzi.size() - 2).getWaga() <= orange)
                            line.setStroke(Color.ORANGE);
                        if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() > orange && w.krawedzi.get(w.krawedzi.size() - 2).getWaga() <= yellow)
                            line.setStroke(Color.YELLOW);
                        if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() > yellow && w.krawedzi.get(w.krawedzi.size() - 2).getWaga() <= lightgreena)
                            line.setStroke(Color.LIGHTGREEN);
                        if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() > lightgreena && w.krawedzi.get(w.krawedzi.size() - 2).getWaga() <= limegreen)
                            line.setStroke(Color.LIMEGREEN);
                        if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() > limegreen && w.krawedzi.get(w.krawedzi.size() - 2).getWaga() <= lightgreenb)
                            line.setStroke(Color.LIGHTGREEN);
                        if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() > lightgreenb && w.krawedzi.get(w.krawedzi.size() - 2).getWaga() <= cyan)
                            line.setStroke(Color.CYAN);
                        if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() > cyan && w.krawedzi.get(w.krawedzi.size() - 2).getWaga() <= lightblue)
                            line.setStroke(Color.LIGHTBLUE);
                        if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() > lightblue)
                            line.setStroke(Color.BLUE);
                        root.getChildren().add(line);
                    }
                }
            }
            if (i - width >= 0) { //góra
                if(w.krawedzi.size() > 0 && w.getNumer() == w.krawedzi.get(w.krawedzi.size()-1).getTo() + width) {
                    if (width == length)
                        line = new Line(700 / width * k + 0.25 * 700 / width, 60 + 700 / length * j, 700 / width * k + 0.25 * 700 / width, 60 + 700 / length * (j - 1) + 0.75 * 700 / length);
                    if (width > length)
                        line = new Line(700 / width * k + 0.25 * 700 / width, 60 + 700 / width * j, 700 / width * k + +0.25 * 700 / width, 60 + 700 / width * (j - 1) + 0.75 * 700 / width);
                    if (width < length)
                        line = new Line(700 / length * k + 0.25 * 700 / length, 60 + 700 / length * j, 700 / length * k + +0.25 * 700 / length, 60 + 700 / length * (j - 1) + 0.75 * 700 / length);
                    if (w.krawedzi.get(w.krawedzi.size()-1).getWaga() <= red)
                        line.setStroke(Color.RED);
                    if (w.krawedzi.get(w.krawedzi.size()-1).getWaga() > red && w.krawedzi.get(w.krawedzi.size()-1).getWaga() <= orange)
                        line.setStroke(Color.ORANGE);
                    if (w.krawedzi.get(w.krawedzi.size()-1).getWaga() > orange && w.krawedzi.get(w.krawedzi.size()-1).getWaga() <= yellow)
                        line.setStroke(Color.YELLOW);
                    if (w.krawedzi.get(w.krawedzi.size()-1).getWaga() > yellow && w.krawedzi.get(w.krawedzi.size()-1).getWaga() <= lightgreena)
                        line.setStroke(Color.LIGHTGREEN);
                    if (w.krawedzi.get(w.krawedzi.size()-1).getWaga() > lightgreena && w.krawedzi.get(w.krawedzi.size()-1).getWaga() <= limegreen)
                        line.setStroke(Color.LIMEGREEN);
                    if (w.krawedzi.get(w.krawedzi.size()-1).getWaga() > limegreen && w.krawedzi.get(w.krawedzi.size()-1).getWaga() <= lightgreenb)
                        line.setStroke(Color.LIGHTGREEN);
                    if (w.krawedzi.get(w.krawedzi.size()-1).getWaga() > lightgreenb && w.krawedzi.get(w.krawedzi.size()-1).getWaga() <= cyan)
                        line.setStroke(Color.CYAN);
                    if (w.krawedzi.get(w.krawedzi.size()-1).getWaga() > cyan && w.krawedzi.get(w.krawedzi.size()-1).getWaga() <= lightblue)
                        line.setStroke(Color.LIGHTBLUE);
                    if (w.krawedzi.get(w.krawedzi.size()-1).getWaga() > lightblue)
                        line.setStroke(Color.BLUE);
                    root.getChildren().add(line);
                }
            }
            point = new Button();
            point.setMinSize(4,4);
            if(width == length) {
                if (k < width) {
                    point.setLayoutX(700 / width * k);
                }
                point.setLayoutY(60 + 700/ length * j);
                point.setPrefSize(700 / width - 0.25*700/width, 700/ length - 0.25*700/length);
            }
            if(width > length) {
                if (k < width) {
                    point.setLayoutX(700 / width * k);
                }
                point.setLayoutY(60 + 700 / width * j);
                point.setPrefSize(700 / width - 0.25*700/width, 700 / width - 0.25*700/width);
            }
            if(width < length) {
                if (k < width) {
                    point.setLayoutX(700/ length * k);
                }
                point.setLayoutY(60 + 700/ length * j);
                point.setPrefSize(700/ length - 0.25*700/length, 700/ length - 0.25*700/length);
            }
            point.setFocusTraversable(false);
            root.getChildren().add(point);
            if (i == width * j + width - 1) {
                j++;
                k = -1;
            }
            i++;
            k++;
        }
    }

    public boolean bfs(int width, int length) {
        if(width == 1 && length == 1)
            return true;
        final int ilosc_wierzcholkow = width * length;
        int[][] zwiedzone;
        zwiedzone = new int[ilosc_wierzcholkow][2];
        for (int i = 0; i < ilosc_wierzcholkow; i++) {
            zwiedzone[i][0] = i;
            zwiedzone[i][1] = 0;
        }
        zwiedzone[0][1] = 1;
        int[] v;
        v = new int[ilosc_wierzcholkow];
        Graf graf = Generator.getGraf();
        int vs = 1, vz = 0, i;
        v[0] = 0;
        int nrw = 0;
        while (vz < vs) {
            i = 0;
            Wierzcholek x = graf.getWierzcholek(v[vz]);
            while (x.krawedzi.size() > i) {
                nrw = x.krawedzi.get(i).getTo();
                if (zwiedzone[nrw][1] == 0) {
                    v[vs++] = nrw;
                    zwiedzone[nrw][1] = 1;
                }
                i++;
            }
            vz++;
        }
        int wynik = 0;
        for (int koniec = 0; koniec < ilosc_wierzcholkow; koniec++) {
            if (zwiedzone[koniec][1] == 1)
                wynik++;
        }
        if (wynik == ilosc_wierzcholkow)
            return true;
        else
            return false;
    }
    public static Graf getGraf() {
        return graf;
    }
    public static void setGraf() {
        graf = null;
    }
}
