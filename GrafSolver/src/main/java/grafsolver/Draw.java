package grafsolver;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.Arrays;

public class Draw {

    public static void drawGraf(Graf graf, Group root) {
        Button point;
        Line line = null;
        double to = graf.getTo();
        double from = graf.getFrom();
        int width = graf.getWidth();
        int length = graf.getLength();
        double red = (to - from) * 0.1 + from;
        double orange = (to - from) * 0.2 + from;
        double yellow = (to - from) * 0.35 + from;
        double lightgreena = (to - from) * 0.45 + from;
        double limegreen = (to - from) * 0.55 + from;
        double lightgreenb = (to - from) * 0.65 + from;
        double cyan = (to - from) * 0.8 + from;
        double lightblue = (to - from) * 0.9 + from;
        int i = 0;
        int j = 0;
        int k = 0;
        for (Wierzcholek w : graf) {
            if (i != (width * (j + 1)) - 1) { //prawa
                if (w.krawedzi.size() > 0 && w.getNumer() == w.krawedzi.get(0).getTo() - 1) {
                    if (width == length)
                        line = new Line(700 / width * k + 0.75 * 700 / width, 60 + 700 / length * j + 0.25 * 700 / length, 700 / width * (k + 1), 60 + 700 / length * j + 0.25 * 700 / length);
                    if (width > length)
                        line = new Line(700 / width * k + 0.75 * 700 / width, 60 + 700 / width * j + 0.25 * 700 / width, 700 / width * (k + 1), 60 + 700 / width * j + 0.25 * 700 / width);
                    if (width < length)
                        line = new Line(700 / length * k + 0.75 * 700 / length, 60 + 700 / length * j + 0.25 * 700 / length, 700 / length * (k + 1), 60 + 700 / length * j + 0.25 * 700 / length);
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
                    root.getChildren().add(line);
                }
            }
            if (i < width * length - width) { //dół
                if (w.krawedzi.size() > 1 && w.getNumer() == w.krawedzi.get(0).getTo() - 1 && w.getNumer() == w.krawedzi.get(1).getTo() - width) {
                    if (width == length)
                        line = new Line(700 / width * k + 0.5 * 700 / width, 60 + 700 / length * j + 0.75 * 700 / length, 700 / width * k + 0.5 * 700 / width, 60 + 700 / length * (j + 1));
                    if (width > length)
                        line = new Line(700 / width * k + 0.5 * 700 / width, 60 + 700 / width * j + 0.75 * 700 / width, 700 / width * k + 0.5 * 700 / width, 60 + 700 / width * (j + 1));
                    if (width < length)
                        line = new Line(700 / length * k + 0.5 * 700 / length, 60 + 700 / length * j + 0.75 * 700 / length, 700 / length * k + 0.5 * 700 / length, 60 + 700 / length * (j + 1));
                        if (w.krawedzi.get(1).getWaga() <= red)
                            line.setStroke(Color.RED);
                        if (w.krawedzi.get(1).getWaga() > red && w.krawedzi.get(1).getWaga() <= orange)
                            line.setStroke(Color.ORANGE);
                        if (w.krawedzi.get(1).getWaga() > orange && w.krawedzi.get(1).getWaga() <= yellow)
                            line.setStroke(Color.YELLOW);
                        if (w.krawedzi.get(1).getWaga() > yellow && w.krawedzi.get(1).getWaga() <= lightgreena)
                            line.setStroke(Color.LIGHTGREEN);
                        if (w.krawedzi.get(1).getWaga() > lightgreena && w.krawedzi.get(1).getWaga() <= limegreen)
                            line.setStroke(Color.LIMEGREEN);
                        if (w.krawedzi.get(1).getWaga() > limegreen && w.krawedzi.get(1).getWaga() <= lightgreenb)
                            line.setStroke(Color.LIGHTGREEN);
                        if (w.krawedzi.get(1).getWaga() > lightgreenb && w.krawedzi.get(1).getWaga() <= cyan)
                            line.setStroke(Color.CYAN);
                        if (w.krawedzi.get(1).getWaga() > cyan && w.krawedzi.get(1).getWaga() <= lightblue)
                            line.setStroke(Color.LIGHTBLUE);
                        if (w.krawedzi.get(1).getWaga() > lightblue)
                            line.setStroke(Color.BLUE);
                    root.getChildren().add(line);
                }
                if (w.krawedzi.size() > 0 && w.getNumer() == w.krawedzi.get(0).getTo() - width) {
                    if (width == length)
                        line = new Line(700 / width * k + 0.5 * 700 / width, 60 + 700 / length * j + 0.75 * 700 / length, 700 / width * k + 0.5 * 700 / width, 60 + 700 / length * (j + 1));
                    if (width > length)
                        line = new Line(700 / width * k + 0.5 * 700 / width, 60 + 700 / width * j + 0.75 * 700 / width, 700 / width * k + 0.5 * 700 / width, 60 + 700 / width * (j + 1));
                    if (width < length)
                        line = new Line(700 / length * k + 0.5 * 700 / length, 60 + 700 / length * j + 0.75 * 700 / length, 700 / length * k + 0.5 * 700 / length, 60 + 700 / length * (j + 1));
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
                    root.getChildren().add(line);
                }
            }
            if (i != width * j) { //lewa
                if (j == 0) {
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
                if (j != 0) {
                    if (w.krawedzi.size() > 0 && w.getNumer() == w.krawedzi.get(w.krawedzi.size() - 1).getTo() + width) {
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
            }
            if (i - width >= 0) { //góra
                if (w.krawedzi.size() > 0 && w.getNumer() == w.krawedzi.get(w.krawedzi.size() - 1).getTo() + width) {
                    if (width == length)
                        line = new Line(700 / width * k + 0.25 * 700 / width, 60 + 700 / length * j, 700 / width * k + 0.25 * 700 / width, 60 + 700 / length * (j - 1) + 0.75 * 700 / length);
                    if (width > length)
                        line = new Line(700 / width * k + 0.25 * 700 / width, 60 + 700 / width * j, 700 / width * k + +0.25 * 700 / width, 60 + 700 / width * (j - 1) + 0.75 * 700 / width);
                    if (width < length)
                        line = new Line(700 / length * k + 0.25 * 700 / length, 60 + 700 / length * j, 700 / length * k + +0.25 * 700 / length, 60 + 700 / length * (j - 1) + 0.75 * 700 / length);
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
            point = new Button();
            point.setMinSize(4, 4);
            if (width == length) {
                if (k < width) {
                    point.setLayoutX(700 / width * k);
                }
                point.setLayoutY(60 + 700 / length * j);
                point.setPrefSize(700 / width - 0.25 * 700 / width, 700 / length - 0.25 * 700 / length);
            }
            if (width > length) {
                if (k < width) {
                    point.setLayoutX(700 / width * k);
                }
                point.setLayoutY(60 + 700 / width * j);
                point.setPrefSize(700 / width - 0.25 * 700 / width, 700 / width - 0.25 * 700 / width);
            }
            if (width < length) {
                if (k < width) {
                    point.setLayoutX(700 / length * k);
                }
                point.setLayoutY(60 + 700 / length * j);
                point.setPrefSize(700 / length - 0.25 * 700 / length, 700 / length - 0.25 * 700 / length);
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
}