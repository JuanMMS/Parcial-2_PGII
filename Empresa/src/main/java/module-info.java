module uniquindio.empresa {
    requires javafx.controls;
    requires javafx.fxml;


    opens uniquindio.empresa to javafx.fxml;
    exports uniquindio.empresa;
}