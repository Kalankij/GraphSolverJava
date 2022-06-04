module java.grafsolver {
    requires javafx.controls;
    requires javafx.fxml;


    opens grafsolver to javafx.fxml;
    exports grafsolver;
}