module com.jandryespol.loteria {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.jandryespol.loteria to javafx.fxml;
    exports com.jandryespol.loteria;
}