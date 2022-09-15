module com.example.puzzleproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.puzzleproject to javafx.fxml;
    exports com.example.puzzleproject;
}