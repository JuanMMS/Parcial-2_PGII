package uniquindio.empresa.viewcontroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import uniquindio.empresa.controller.DTOInfoTecnico;
import uniquindio.empresa.controller.SolicitudController;
import uniquindio.empresa.model.Cliente;
import uniquindio.empresa.model.IElemento;
import uniquindio.empresa.model.Paquete;
import uniquindio.empresa.model.ServicioTecnologico;

import java.io.IOException;

public class RegistroSolicitudViewController {

    @FXML private TextField txtCodigoSol;
    @FXML private ComboBox<Cliente> cbCliente;
    @FXML private ListView<IElemento> lvElementosContratados;
    @FXML private DatePicker dpFechaProgramada;
    @FXML private TextField txtNivelPrioridad;
    @FXML private TextArea txtObservaciones;
    @FXML private TextField txtEspecialidadTecnico;
    @FXML private TextArea txtInfoTecnico;
    @FXML private Label lblCostoTotalSolicitud;

    private final SolicitudController controller = new SolicitudController();
    private double costoDesplazamientoActual = 0.0;
    private boolean tecnicoDisponible = false;

    @FXML
    public void initialize() {
        cbCliente.setItems(FXCollections.observableArrayList(controller.obtenerClientes()));
        cbCliente.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Cliente item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getNombreCompleto() + " (" + item.getDocumento() + ")");
            }
        });
        cbCliente.setButtonCell(cbCliente.getCellFactory().call(null));

        ObservableList<IElemento> elementos = FXCollections.observableArrayList();
        elementos.addAll(controller.obtenerServiciosTecnologicos());
        elementos.addAll(controller.obtenerPaquetes());
        lvElementosContratados.setItems(elementos);
        lvElementosContratados.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        lvElementosContratados.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(IElemento item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText("");
                } else if (item instanceof ServicioTecnologico s) {
                    setText("[Servicio] " + s.getNombre() + " - $" + s.calcularCosto());
                } else if (item instanceof Paquete p) {
                    setText("[Paquete] " + p.getNombre() + " - $" + p.calcularCosto());
                } else {
                    setText(item.toString());
                }
            }
        });
    }

    @FXML
    void consultarTecnico() {
        String codigoEspecialidad = txtEspecialidadTecnico.getText();
        if (codigoEspecialidad == null || codigoEspecialidad.isBlank()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Ingrese el código de especialidad.");
            return;
        }

        DTOInfoTecnico infoTecnico = controller.consultarTecnicoLegacy(codigoEspecialidad);
        tecnicoDisponible = infoTecnico.isDisponible();
        costoDesplazamientoActual = infoTecnico.getCostoDesplazamiento();

        StringBuilder sb = new StringBuilder();
        sb.append("Técnico ID: ").append(infoTecnico.getCodigoTecnico()).append("\n");
        sb.append("Estado: ").append(tecnicoDisponible ? "DISPONIBLE" : "NO DISPONIBLE").append("\n");
        sb.append("Costo Desplazamiento: $").append(costoDesplazamientoActual);

        txtInfoTecnico.setText(sb.toString());
        calcularTotalSolicitud();
    }

    @FXML
    void calcularTotalSolicitud() {
        ObservableList<IElemento> seleccionados = lvElementosContratados.getSelectionModel().getSelectedItems();
        double subtotal = 0.0;
        for (IElemento elem : seleccionados) {
            subtotal += elem.calcularCosto();
        }
        double total = subtotal + costoDesplazamientoActual;
        lblCostoTotalSolicitud.setText(String.format("Total: $%.2f", total));
    }

    @FXML
    void registrarSolicitud() {
        String codigo = txtCodigoSol.getText();
        Cliente cliente = cbCliente.getValue();
        ObservableList<IElemento> seleccionados = lvElementosContratados.getSelectionModel().getSelectedItems();
        boolean requiereTecnico = !txtEspecialidadTecnico.getText().isBlank();

        try {
            boolean exito = controller.registrarSolicitud(
                    codigo, cliente, seleccionados,
                    dpFechaProgramada.getValue(),
                    txtObservaciones.getText(),
                    txtNivelPrioridad.getText(),
                    requiereTecnico,
                    tecnicoDisponible
            );

            if (exito) {
                mostrarAlerta(Alert.AlertType.INFORMATION, "Solicitud Registrada", "La solicitud fue creada exitosamente.");
                limpiarFormulario();
            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "Ya existe una solicitud registrada con ese código.");
            }
        } catch (IllegalStateException | IllegalArgumentException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de Validación", e.getMessage());
        }
    }

    private void limpiarFormulario() {
        txtCodigoSol.clear();
        cbCliente.setValue(null);
        lvElementosContratados.getSelectionModel().clearSelection();
        dpFechaProgramada.setValue(null);
        txtNivelPrioridad.clear();
        txtObservaciones.clear();
        txtEspecialidadTecnico.clear();
        txtInfoTecnico.clear();
        costoDesplazamientoActual = 0.0;
        tecnicoDisponible = false;
        lblCostoTotalSolicitud.setText("Total: $0.0");
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