module uniquindio.empresa {
    requires javafx.controls;
    requires javafx.fxml;

    // Permitir que JavaFX acceda a los controladores para inyectar los @FXML
    opens uniquindio.empresa.viewcontroller to javafx.fxml;
    opens uniquindio.empresa.app to javafx.fxml;

    // Exportar los paquetes reales que contienen tus clases
    exports uniquindio.empresa.app;
    exports uniquindio.empresa.viewcontroller;
    exports uniquindio.empresa.controller;
    exports uniquindio.empresa.model;
}