module com.guiprog {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.guiprog to javafx.fxml;
    exports com.guiprog;
}
