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

        ServicioTecnologico decorado = controller.construirServicioPersonalizado(
                seleccionado, chkPrioritaria.isSelected(), chkSoporte.isSelected(), chkDomicilio.isSelected()
        );
        lblCostoTotalServicio.setText(String.format("Costo Total: $%.2f", decorado.calcularCosto()));
    }

    @FXML
    void crearServicio() {
        ServicioTecnologico base = cbServiciosBase.getValue();
        if (base == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Seleccione un servicio base.");
            return;
        }

        boolean exito = controller.guardarServicioPersonalizado(
                base, chkPrioritaria.isSelected(), chkSoporte.isSelected(), chkDomicilio.isSelected()
        );

        if (exito) {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Servicio personalizado creado e integrado al catálogo.");
            cbServiciosBase.setItems(FXCollections.observableArrayList(controller.obtenerServiciosTecnologicos()));
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo registrar el servicio personalizado.");
        }
    }

    @FXML
    void volverMenuPrincipal(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/uniquindio/empresa/view/MainMenuView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Menú Principal - TechSolutions");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}