module uniquindio.empresa {
    requires javafx.controls;
    requires javafx.fxml;

    opens uniquindio.empresa to javafx.fxml;
    opens uniquindio.empresa.viewcontroller to javafx.fxml;
    opens uniquindio.empresa.controller to javafx.fxml;

    exports uniquindio.empresa;
    exports uniquindio.empresa.controller;
    exports uniquindio.empresa.viewcontroller;
}