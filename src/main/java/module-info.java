module sn.dev.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens sn.dev.demo to javafx.fxml;
    exports sn.dev.demo;
}