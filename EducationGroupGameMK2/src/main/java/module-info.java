module com.example.scenebuilderdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scenebuilderdemo to javafx.fxml;
    exports com.example.scenebuilderdemo;
}