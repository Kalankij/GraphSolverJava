package grafsolver;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Draw {

    private static int start = Integer.MIN_VALUE;
    private static int end = Integer.MAX_VALUE;
    private static Button [] point;
    private static Line [] line;
    private static Line [] pathline;
    public static void drawGraf(Graf graf, Group root) {
        point = new Button[graf.getRozmiar()];
        int g  = 0;
        for ( g = 0; g < graf.getRozmiar();g ++) {
            point[g] = new Button();
        }
        int suma = 0;
        for ( Wierzcholek w : graf) {
            for ( Krawedz k : w) {
                suma++;
            }
        }
        line = new Line[suma];
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
        g = 0;
        int z =0;
        for (Wierzcholek w : graf) {
            if (w.krawedzi.size() > 0 && w.getNumer() == w.krawedzi.get(0).getTo() - 1) { //prawa
                if (width == length)
                    line[z] = new Line(700 / width * k + 0.75 * 700 / width, 60 + 700 / length * j + 0.25 * 700 / length, 700 / width * (k + 1), 60 + 700 / length * j + 0.25 * 700 / length);
                if (width > length)
                    line[z] = new Line(700 / width * k + 0.75 * 700 / width, 60 + 700 / width * j + 0.25 * 700 / width, 700 / width * (k + 1), 60 + 700 / width * j + 0.25 * 700 / width);
                if (width < length)
                    line[z] = new Line(700 / length * k + 0.75 * 700 / length, 60 + 700 / length * j + 0.25 * 700 / length, 700 / length * (k + 1), 60 + 700 / length * j + 0.25 * 700 / length);
                if (w.krawedzi.get(0).getWaga() <= red)
                    line[z] .setStroke(Color.RED);
                if (w.krawedzi.get(0).getWaga() > red && w.krawedzi.get(0).getWaga() <= orange)
                    line[z] .setStroke(Color.ORANGE);
                if (w.krawedzi.get(0).getWaga() > orange && w.krawedzi.get(0).getWaga() <= yellow)
                    line[z] .setStroke(Color.YELLOW);
                if (w.krawedzi.get(0).getWaga() > yellow && w.krawedzi.get(0).getWaga() <= lightgreena)
                    line[z] .setStroke(Color.LIGHTGREEN);
                if (w.krawedzi.get(0).getWaga() > lightgreena && w.krawedzi.get(0).getWaga() <= limegreen)
                    line[z] .setStroke(Color.LIMEGREEN);
                if (w.krawedzi.get(0).getWaga() > limegreen && w.krawedzi.get(0).getWaga() <= lightgreenb)
                    line[z] .setStroke(Color.LIGHTGREEN);
                if (w.krawedzi.get(0).getWaga() > lightgreenb && w.krawedzi.get(0).getWaga() <= cyan)
                    line[z] .setStroke(Color.CYAN);
                if (w.krawedzi.get(0).getWaga() > cyan && w.krawedzi.get(0).getWaga() <= lightblue)
                    line[z] .setStroke(Color.LIGHTBLUE);
                if (w.krawedzi.get(0).getWaga() > lightblue)
                    line[z] .setStroke(Color.BLUE);
                root.getChildren().add(line[z++] );
            }
            if (i < width * length - width) { //dół
                if (w.krawedzi.size() > 1 && w.getNumer() == w.krawedzi.get(0).getTo() - 1 && w.getNumer() == w.krawedzi.get(1).getTo() - width) {
                    if (width == length)
                        line[z] = new Line(700 / width * k + 0.5 * 700 / width, 60 + 700 / length * j + 0.75 * 700 / length, 700 / width * k + 0.5 * 700 / width, 60 + 700 / length * (j + 1));
                    if (width > length)
                        line[z] = new Line(700 / width * k + 0.5 * 700 / width, 60 + 700 / width * j + 0.75 * 700 / width, 700 / width * k + 0.5 * 700 / width, 60 + 700 / width * (j + 1));
                    if (width < length)
                        line[z] = new Line(700 / length * k + 0.5 * 700 / length, 60 + 700 / length * j + 0.75 * 700 / length, 700 / length * k + 0.5 * 700 / length, 60 + 700 / length * (j + 1));
                    if (w.krawedzi.get(1).getWaga() <= red)
                        line[z].setStroke(Color.RED);
                    if (w.krawedzi.get(1).getWaga() > red && w.krawedzi.get(1).getWaga() <= orange)
                        line[z].setStroke(Color.ORANGE);
                    if (w.krawedzi.get(1).getWaga() > orange && w.krawedzi.get(1).getWaga() <= yellow)
                        line[z].setStroke(Color.YELLOW);
                    if (w.krawedzi.get(1).getWaga() > yellow && w.krawedzi.get(1).getWaga() <= lightgreena)
                        line[z].setStroke(Color.LIGHTGREEN);
                    if (w.krawedzi.get(1).getWaga() > lightgreena && w.krawedzi.get(1).getWaga() <= limegreen)
                        line[z].setStroke(Color.LIMEGREEN);
                    if (w.krawedzi.get(1).getWaga() > limegreen && w.krawedzi.get(1).getWaga() <= lightgreenb)
                        line[z].setStroke(Color.LIGHTGREEN);
                    if (w.krawedzi.get(1).getWaga() > lightgreenb && w.krawedzi.get(1).getWaga() <= cyan)
                        line[z].setStroke(Color.CYAN);
                    if (w.krawedzi.get(1).getWaga() > cyan && w.krawedzi.get(1).getWaga() <= lightblue)
                        line[z].setStroke(Color.LIGHTBLUE);
                    if (w.krawedzi.get(1).getWaga() > lightblue)
                        line[z].setStroke(Color.BLUE);
                    root.getChildren().add(line[z++]);
                }
                if (w.krawedzi.size() > 0 && w.getNumer() == w.krawedzi.get(0).getTo() - width) {
                    if (width == length)
                        line[z] = new Line(700 / width * k + 0.5 * 700 / width, 60 + 700 / length * j + 0.75 * 700 / length, 700 / width * k + 0.5 * 700 / width, 60 + 700 / length * (j + 1));
                    if (width > length)
                        line[z] = new Line(700 / width * k + 0.5 * 700 / width, 60 + 700 / width * j + 0.75 * 700 / width, 700 / width * k + 0.5 * 700 / width, 60 + 700 / width * (j + 1));
                    if (width < length)
                        line[z] = new Line(700 / length * k + 0.5 * 700 / length, 60 + 700 / length * j + 0.75 * 700 / length, 700 / length * k + 0.5 * 700 / length, 60 + 700 / length * (j + 1));
                    if (w.krawedzi.get(0).getWaga() <= red)
                        line[z].setStroke(Color.RED);
                    if (w.krawedzi.get(0).getWaga() > red && w.krawedzi.get(0).getWaga() <= orange)
                        line[z].setStroke(Color.ORANGE);
                    if (w.krawedzi.get(0).getWaga() > orange && w.krawedzi.get(0).getWaga() <= yellow)
                        line[z].setStroke(Color.YELLOW);
                    if (w.krawedzi.get(0).getWaga() > yellow && w.krawedzi.get(0).getWaga() <= lightgreena)
                        line[z].setStroke(Color.LIGHTGREEN);
                    if (w.krawedzi.get(0).getWaga() > lightgreena && w.krawedzi.get(0).getWaga() <= limegreen)
                        line[z].setStroke(Color.LIMEGREEN);
                    if (w.krawedzi.get(0).getWaga() > limegreen && w.krawedzi.get(0).getWaga() <= lightgreenb)
                        line[z].setStroke(Color.LIGHTGREEN);
                    if (w.krawedzi.get(0).getWaga() > lightgreenb && w.krawedzi.get(0).getWaga() <= cyan)
                        line[z].setStroke(Color.CYAN);
                    if (w.krawedzi.get(0).getWaga() > cyan && w.krawedzi.get(0).getWaga() <= lightblue)
                        line[z].setStroke(Color.LIGHTBLUE);
                    if (w.krawedzi.get(0).getWaga() > lightblue)
                        line[z].setStroke(Color.BLUE);
                    root.getChildren().add(line[z++]);
                }
            }
            if (i != width * j) { //lewa
                if (j == 0) {
                    if (w.krawedzi.size() > 0 && w.getNumer() == w.krawedzi.get(w.krawedzi.size() - 1).getTo() + 1) {
                        if (width == length)
                            line[z]  = new Line(700 / width * k, 60 + 700 / length * j + 0.5 * 700 / length, 700 / width * (k - 1) + 0.75 * 700 / width, 60 + 700 / length * j + 0.5 * 700 / length);
                        if (width > length)
                            line[z]  = new Line(700 / width * k, 60 + 700 / width * j + 0.5 * 700 / width, 700 / width * (k - 1) + 0.75 * 700 / width, 60 + 700 / width * j + 0.5 * 700 / width);
                        if (width < length)
                            line[z]  = new Line(700 / length * k, 60 + 700 / length * j + 0.5 * 700 / length, 700 / length * (k - 1) + 0.75 * 700 / length, 60 + 700 / length * j + 0.5 * 700 / length);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= red)
                            line[z] .setStroke(Color.RED);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > red && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= orange)
                            line[z] .setStroke(Color.ORANGE);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > orange && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= yellow)
                            line[z] .setStroke(Color.YELLOW);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > yellow && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= lightgreena)
                            line[z] .setStroke(Color.LIGHTGREEN);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > lightgreena && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= limegreen)
                            line[z] .setStroke(Color.LIMEGREEN);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > limegreen && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= lightgreenb)
                            line[z] .setStroke(Color.LIGHTGREEN);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > lightgreenb && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= cyan)
                            line[z] .setStroke(Color.CYAN);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > cyan && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= lightblue)
                            line[z] .setStroke(Color.LIGHTBLUE);
                        if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > lightblue)
                            line[z] .setStroke(Color.BLUE);
                        root.getChildren().add(line[z++] );
                    }
                }
                if (j != 0) {
                    if (w.krawedzi.size() > 0 && w.getNumer() == w.krawedzi.get(w.krawedzi.size() - 1).getTo() + width) {
                        if (w.krawedzi.size() > 1 && w.getNumer() == w.krawedzi.get(w.krawedzi.size() - 2).getTo() + 1) {
                            if (width == length)
                                line[z] = new Line(700 / width * k, 60 + 700 / length * j + 0.5 * 700 / length, 700 / width * (k - 1) + 0.75 * 700 / width, 60 + 700 / length * j + 0.5 * 700 / length);
                            if (width > length)
                                line[z] = new Line(700 / width * k, 60 + 700 / width * j + 0.5 * 700 / width, 700 / width * (k - 1) + 0.75 * 700 / width, 60 + 700 / width * j + 0.5 * 700 / width);
                            if (width < length)
                                line[z] = new Line(700 / length * k, 60 + 700 / length * j + 0.5 * 700 / length, 700 / length * (k - 1) + 0.75 * 700 / length, 60 + 700 / length * j + 0.5 * 700 / length);
                            if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() <= red)
                                line[z].setStroke(Color.RED);
                            if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() > red && w.krawedzi.get(w.krawedzi.size() - 2).getWaga() <= orange)
                                line[z].setStroke(Color.ORANGE);
                            if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() > orange && w.krawedzi.get(w.krawedzi.size() - 2).getWaga() <= yellow)
                                line[z].setStroke(Color.YELLOW);
                            if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() > yellow && w.krawedzi.get(w.krawedzi.size() - 2).getWaga() <= lightgreena)
                                line[z].setStroke(Color.LIGHTGREEN);
                            if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() > lightgreena && w.krawedzi.get(w.krawedzi.size() - 2).getWaga() <= limegreen)
                                line[z].setStroke(Color.LIMEGREEN);
                            if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() > limegreen && w.krawedzi.get(w.krawedzi.size() - 2).getWaga() <= lightgreenb)
                                line[z].setStroke(Color.LIGHTGREEN);
                            if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() > lightgreenb && w.krawedzi.get(w.krawedzi.size() - 2).getWaga() <= cyan)
                                line[z].setStroke(Color.CYAN);
                            if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() > cyan && w.krawedzi.get(w.krawedzi.size() - 2).getWaga() <= lightblue)
                                line[z].setStroke(Color.LIGHTBLUE);
                            if (w.krawedzi.get(w.krawedzi.size() - 2).getWaga() > lightblue)
                                line[z].setStroke(Color.BLUE);
                            root.getChildren().add(line[z++]);
                        }
                    }
                }
            }
            if (i - width >= 0) { //góra
                if (w.krawedzi.size() > 0 && w.getNumer() == w.krawedzi.get(w.krawedzi.size() - 1).getTo() + width) {
                    if (width == length)
                        line[z] = new Line(700 / width * k + 0.25 * 700 / width, 60 + 700 / length * j, 700 / width * k + 0.25 * 700 / width, 60 + 700 / length * (j - 1) + 0.75 * 700 / length);
                    if (width > length)
                        line[z] = new Line(700 / width * k + 0.25 * 700 / width, 60 + 700 / width * j, 700 / width * k + +0.25 * 700 / width, 60 + 700 / width * (j - 1) + 0.75 * 700 / width);
                    if (width < length)
                        line[z] = new Line(700 / length * k + 0.25 * 700 / length, 60 + 700 / length * j, 700 / length * k + +0.25 * 700 / length, 60 + 700 / length * (j - 1) + 0.75 * 700 / length);
                    if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= red)
                        line[z].setStroke(Color.RED);
                    if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > red && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= orange)
                        line[z].setStroke(Color.ORANGE);
                    if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > orange && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= yellow)
                        line[z].setStroke(Color.YELLOW);
                    if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > yellow && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= lightgreena)
                        line[z].setStroke(Color.LIGHTGREEN);
                    if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > lightgreena && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= limegreen)
                        line[z].setStroke(Color.LIMEGREEN);
                    if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > limegreen && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= lightgreenb)
                        line[z].setStroke(Color.LIGHTGREEN);
                    if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > lightgreenb && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= cyan)
                        line[z].setStroke(Color.CYAN);
                    if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > cyan && w.krawedzi.get(w.krawedzi.size() - 1).getWaga() <= lightblue)
                        line[z].setStroke(Color.LIGHTBLUE);
                    if (w.krawedzi.get(w.krawedzi.size() - 1).getWaga() > lightblue)
                        line[z].setStroke(Color.BLUE);
                    root.getChildren().add(line[z++]);
                }
            }
            point[g].setMinSize(4, 4);
            int finalG = g;
            point[g].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if ( getStart() == Integer.MIN_VALUE) {
                        setStart(finalG);
                    }
                    else if ( getEnd() == Integer.MAX_VALUE ){
                        setEnd(finalG);
                        Redraw.run();
                        drawPath(graf,root,getStart(),getEnd());
                        setEnd(Integer.MAX_VALUE);
                        setStart(Integer.MIN_VALUE);
                    }
                }
            });
            if (width == length) {
                if (k < width) {
                    point[g].setLayoutX(700 / width * k);
                }
                point[g].setLayoutY(60 + 700 / length * j);
                point[g].setPrefSize(700 / width - 0.25 * 700 / width, 700 / length - 0.25 * 700 / length);
            }
            if (width > length) {
                if (k < width) {
                    point[g].setLayoutX(700 / width * k);
                }
                point[g].setLayoutY(60 + 700 / width * j);
                point[g].setPrefSize(700 / width - 0.25 * 700 / width, 700 / width - 0.25 * 700 / width);
            }
            if (width < length) {
                if (k < width) {
                    point[g].setLayoutX(700 / length * k);
                }
                point[g].setLayoutY(60 + 700 / length * j);
                point[g].setPrefSize(700 / length - 0.25 * 700 / length, 700 / length - 0.25 * 700 / length);
            }
            point[g].setFocusTraversable(false);
            root.getChildren().add(point[g]);
            if (i == width * j + width - 1) {
                j++;
                k = -1;
            }
            i++;
            k++;
            g++;
        }
    }

    public static void drawPath(Graf graf, Group root, int start, int end) {
        if(start != end) {
            ArrayList<Wierzcholek> path = Dijkstra.run(graf, Draw.getStart(), Draw.getEnd());
            pathline = new Line[path.size()];
            int width = graf.getWidth();
            int length = graf.getLength();
            int iloscprzejsc = path.size()-1;
            int x = 0;
            double dlugoscliniipoziom = 0;
            double dlugoscliniipion = 0;
            int startingpointy = (int) start / width;
            int startingpointx = start - startingpointy * width;
            while ( iloscprzejsc > 0) {
                if(width == length) {
                    if (path.get(iloscprzejsc).getNumer() == path.get(iloscprzejsc - 1).getNumer() - 1) { //prawo
                        pathline[x] = new Line(700 / width * startingpointx + 0.375 * 700 / width + dlugoscliniipoziom, 700 / length * startingpointy + 60 + 0.375 * 700 / length + dlugoscliniipion, 700 / width * startingpointx + 0.375 * 700 / width + 700 / width + dlugoscliniipoziom, 700 / length * startingpointy + 60 + 0.375 * 700 / length + dlugoscliniipion);
                        dlugoscliniipoziom += 700 / width;
                        iloscprzejsc--;
                        root.getChildren().add(pathline[x]);
                        x++;
                    }
                    if (iloscprzejsc > 0 && path.get(iloscprzejsc).getNumer() == path.get(iloscprzejsc - 1).getNumer() - width) { //dół
                        pathline[x] = new Line(700 / width * startingpointx + 0.375 * 700 / width + dlugoscliniipoziom, 700 / length * startingpointy + 60 + 0.375 * 700 / length + dlugoscliniipion, 700 / width * startingpointx + 0.375 * 700 / width + dlugoscliniipoziom, 700 / length * startingpointy + 60 + 0.375 * 700 / length + 700 / length + dlugoscliniipion);
                        dlugoscliniipion += 700 / length;
                        iloscprzejsc--;
                        root.getChildren().add(pathline[x]);
                        x++;
                    }
                    if (iloscprzejsc > 0 && path.get(iloscprzejsc).getNumer() == path.get(iloscprzejsc - 1).getNumer() + 1) { //lewo
                        pathline[x] = new Line(700 / width * startingpointx + 0.375 * 700 / width + dlugoscliniipoziom, 700 / length * startingpointy + 60 + 0.375 * 700 / length + dlugoscliniipion, 700 / width * startingpointx + 0.375 * 700 / width - 700 / width + dlugoscliniipoziom, 700 / length * startingpointy + 60 + 0.375 * 700 / length + dlugoscliniipion);
                        dlugoscliniipoziom -= 700 / width;
                        iloscprzejsc--;
                        root.getChildren().add(pathline[x]);
                        x++;
                    }
                    if (iloscprzejsc > 0 && path.get(iloscprzejsc).getNumer() == path.get(iloscprzejsc - 1).getNumer() + width) { //góra
                        pathline[x] = new Line(700 / width * startingpointx + 0.375 * 700 / width + dlugoscliniipoziom, 700 / length * startingpointy + 60 + 0.375 * 700 / length + dlugoscliniipion, 700 / width * startingpointx + 0.375 * 700 / width + dlugoscliniipoziom, 700 / length * startingpointy + 60 + 0.375 * 700 / length - 700 / length + dlugoscliniipion);
                        dlugoscliniipion -= 700 / length;
                        iloscprzejsc--;
                        root.getChildren().add(pathline[x]);
                        x++;
                    }
                }
                if(width > length) {
                    if (path.get(iloscprzejsc).getNumer() == path.get(iloscprzejsc - 1).getNumer() - 1) { //prawo
                        pathline[x] = new Line(700 / width * startingpointx + 0.375 * 700 / width + dlugoscliniipoziom, 700 / width * startingpointy + 60 + 0.375 * 700 / width + dlugoscliniipion, 700 / width * startingpointx + 0.375 * 700 / width + 700 / width + dlugoscliniipoziom, 700 / width * startingpointy + 60 + 0.375 * 700 / width + dlugoscliniipion);
                        dlugoscliniipoziom += 700 / width;
                        iloscprzejsc--;
                        root.getChildren().add(pathline[x]);
                        x++;
                    }
                    if (iloscprzejsc > 0 && path.get(iloscprzejsc).getNumer() == path.get(iloscprzejsc - 1).getNumer() - width) { //dół
                        pathline[x] = new Line(700 / width * startingpointx + 0.375 * 700 / width + dlugoscliniipoziom, 700 / width * startingpointy + 60 + 0.375 * 700 / width + dlugoscliniipion, 700 / width * startingpointx + 0.375 * 700 / width + dlugoscliniipoziom, 700 / width * startingpointy + 60 + 0.375 * 700 / width + 700 / width + dlugoscliniipion);
                        dlugoscliniipion += 700 / width;
                        iloscprzejsc--;
                        root.getChildren().add(pathline[x]);
                        x++;
                    }
                    if (iloscprzejsc > 0 && path.get(iloscprzejsc).getNumer() == path.get(iloscprzejsc - 1).getNumer() + 1) { //lewo
                        pathline[x] = new Line(700 / width * startingpointx + 0.375 * 700 / width + dlugoscliniipoziom, 700 / width * startingpointy + 60 + 0.375 * 700 / width + dlugoscliniipion, 700 / width * startingpointx + 0.375 * 700 / width - 700 / width + dlugoscliniipoziom, 700 / width * startingpointy + 60 + 0.375 * 700 / width + dlugoscliniipion);
                        dlugoscliniipoziom -= 700 / width;
                        iloscprzejsc--;
                        root.getChildren().add(pathline[x]);
                        x++;
                    }
                    if (iloscprzejsc > 0 && path.get(iloscprzejsc).getNumer() == path.get(iloscprzejsc - 1).getNumer() + width) { //góra
                        pathline[x] = new Line(700 / width * startingpointx + 0.375 * 700 / width + dlugoscliniipoziom, 700 / width * startingpointy + 60 + 0.375 * 700 / width + dlugoscliniipion, 700 / width * startingpointx + 0.375 * 700 / width + dlugoscliniipoziom, 700 / width * startingpointy + 60 + 0.375 * 700 / width - 700 / width + dlugoscliniipion);
                        dlugoscliniipion -= 700 / width;
                        iloscprzejsc--;
                        root.getChildren().add(pathline[x]);
                        x++;
                    }
                }
                if(width < length) {
                    if (path.get(iloscprzejsc).getNumer() == path.get(iloscprzejsc - 1).getNumer() - 1) { //prawo
                        pathline[x] = new Line(700 / length * startingpointx + 0.375 * 700 / length + dlugoscliniipoziom, 700 / length * startingpointy + 60 + 0.375 * 700 / length + dlugoscliniipion, 700 / length * startingpointx + 0.375 * 700 / length + 700 / length + dlugoscliniipoziom, 700 / length * startingpointy + 60 + 0.375 * 700 / length + dlugoscliniipion);
                        dlugoscliniipoziom += 700 / length;
                        iloscprzejsc--;
                        root.getChildren().add(pathline[x]);
                        x++;
                    }
                    if (iloscprzejsc > 0 && path.get(iloscprzejsc).getNumer() == path.get(iloscprzejsc - 1).getNumer() - width) { //dół
                        pathline[x] = new Line(700 / length * startingpointx + 0.375 * 700 / length + dlugoscliniipoziom, 700 / length * startingpointy + 60 + 0.375 * 700 / length + dlugoscliniipion, 700 / length * startingpointx + 0.375 * 700 / length + dlugoscliniipoziom, 700 / length * startingpointy + 60 + 0.375 * 700 / length + 700 / length + dlugoscliniipion);
                        dlugoscliniipion += 700 / length;
                        iloscprzejsc--;
                        root.getChildren().add(pathline[x]);
                        x++;
                    }
                    if (iloscprzejsc > 0 && path.get(iloscprzejsc).getNumer() == path.get(iloscprzejsc - 1).getNumer() + 1) { //lewo
                        pathline[x] = new Line(700 / length * startingpointx + 0.375 * 700 / length + dlugoscliniipoziom, 700 / length * startingpointy + 60 + 0.375 * 700 / length + dlugoscliniipion, 700 / length * startingpointx + 0.375 * 700 / length - 700 / length + dlugoscliniipoziom, 700 / length * startingpointy + 60 + 0.375 * 700 / length + dlugoscliniipion);
                        dlugoscliniipoziom -= 700 / length;
                        iloscprzejsc--;
                        root.getChildren().add(pathline[x]);
                        x++;
                    }
                    if (iloscprzejsc > 0 && path.get(iloscprzejsc).getNumer() == path.get(iloscprzejsc - 1).getNumer() + width) { //góra
                        pathline[x] = new Line(700 / length * startingpointx + 0.375 * 700 / length + dlugoscliniipoziom, 700 / length * startingpointy + 60 + 0.375 * 700 / length + dlugoscliniipion, 700 / length * startingpointx + 0.375 * 700 / length + dlugoscliniipoziom, 700 / length * startingpointy + 60 + 0.375 * 700 / length - 700 / length + dlugoscliniipion);
                        dlugoscliniipion -= 700 / length;
                        iloscprzejsc--;
                        root.getChildren().add(pathline[x]);
                        x++;
                    }

                }
            }
        }
    }

    public static void setStart(int start) {
        Draw.start = start;
    }

    public static int getEnd() {
        return end;
    }

    public static int getStart() {
        return start;
    }

    public static void setEnd(int end) {
        Draw.end = end;
    }

    public static Button[] getPoint() {
        return point;
    }

    public static Line[] getLine() {
        return line;

    }
    public static Line[] getPathline() {
        return pathline;
    }
}