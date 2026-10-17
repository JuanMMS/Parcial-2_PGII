package uniquindio.empresa.viewcontroller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import uniquindio.empresa.controller.ServicioController;
import uniquindio.empresa.model.ServicioTecnologico;

import java.io.IOException;

public class GestionServiciosViewController {

    @FXML private ComboBox<ServicioTecnologico> cbServiciosBase;
    @FXML private CheckBox chkPrioritaria;
    @FXML private CheckBox chkSoporte;
    @FXML private CheckBox chkDomicilio;
    @FXML private Label lblCostoTotalServicio;

    private final ServicioController controller = new ServicioController();

    @FXML
    public void initialize() {
        cbServiciosBase.setItems(FXCollections.observableArrayList(controller.obtenerServiciosTecnologicos()));
        cbServiciosBase.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(ServicioTecnologico item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getNombre() + " ($" + item.calcularCosto() + ")");
            }
        });
        cbServiciosBase.setButtonCell(cbServiciosBase.getCellFactory().call(null));

        cbServiciosBase.setOnAction(e -> calcularCostoServicio());
        chkPrioritaria.setOnAction(e -> calcularCostoServicio());
        chkSoporte.setOnAction(e -> calcularCostoServicio());
        chkDomicilio.setOnAction(e -> calcularCostoServicio());
    }

    @FXML
    void calcularCostoServicio() {
        ServicioTecnologico seleccionado = cbServiciosBase.getValue();
        if (seleccionado == null) {
            lblCostoTotalServicio.setText("Costo Total: $0.0");
            return;
        }

        // Llamamos al método que simula matemáticamente el costo sin romper los tipos del diagrama
        double total = controller.calcularCostoSimulado(
                seleccionado, chkPrioritaria.isSelected(), chkSoporte.isSelected(), chkDomicilio.isSelected()
        );
        lblCostoTotalServicio.setText(String.format("Costo Total: $%.2f", total));
    }

    @FXML
    void crearServicio() {
        // En el diagrama de clases, los decoradores no se guardan en el listado base de la empresa.
        // Se instancian dinámicamente cuando se crea la SolicitudServicio.
        mostrarAlerta(Alert.AlertType.INFORMATION, "Información del Catálogo",
                "Según el modelo de negocio, los servicios personalizados (decorados) no se guardan en el catálogo base. Sus complementos se aplicarán automáticamente al registrar una Solicitud de Servicio con las opciones correspondientes.");
    }

    @FXML
    void volverMenuPrincipal(ActionEvent event) {
        // Obtiene la ventana (Stage) actual mediante el componente que disparó el evento y la cierra full
        Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ventanaActual.close();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}