package grafsolver;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save implements EventHandler<ActionEvent> {

    private Group root;
    private Group secRoot;
    private Scene secScene;
    private Stage secStage;
    private final FileChooser fileChooser = new FileChooser();
    private File file;
    private Graf graf;

    public Save ( Group root ) {
        this.root = root;
    }
    @Override
    public void handle(ActionEvent event) {
        root.setDisable(true);
        secRoot =  new Group();
        secScene = new Scene(secRoot,300,200);
        secStage = new Stage();
        fileChooser.setInitialFileName("graf.txt");
        file = fileChooser.showSaveDialog(secStage);
        if ( Generator.getGraf() != null ) {
            graf = Generator.getGraf();
        }
        else if ( ReadFile.getGraf() != null) {
            graf = ReadFile.getGraf();
        }
        try {
            if (!file.getName().endsWith(".txt") && graf != null) {
                Alert errorAlert = new Alert(Alert.AlertType.WARNING);
                errorAlert.setHeaderText("WARNING!!");
                errorAlert.setContentText("You need to save file as \"TXT\"!");
                errorAlert.show();
            }
        if ( graf == null && file != null) {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setHeaderText("WARNING!!");
            errorAlert.setContentText("You don't have any graph to save! Please generate or upload one.");
            errorAlert.show();
            root.setDisable(false);
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                secStage.close();
                e.printStackTrace();
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Couldn't save file");
                errorAlert.setContentText("Something went wrong while saving file");
                errorAlert.show();
                root.setDisable(false);
            }
            zapisz(file, graf);
            secStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    root.setDisable(false);
                }
            });
            root.setDisable(false);
        }
        } catch (NullPointerException e) {
            root.setDisable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void zapisz ( File f, Graf graf ) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(f)) ;
        bw.write(graf.getLength() + " " + graf.getWidth() + "\n");
        for ( Wierzcholek w: graf) {
            for (Krawedz k : w ) {
                bw.write(k.getTo() + " :" + k.getWaga() + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
