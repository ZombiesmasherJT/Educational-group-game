module com.example.scenebuilderdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.scenebuilderdemo to javafx.fxml;
    exports com.example.scenebuilderdemo;
}