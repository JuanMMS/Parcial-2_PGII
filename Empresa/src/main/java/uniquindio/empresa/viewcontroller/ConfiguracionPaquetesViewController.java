package uniquindio.empresa.viewcontroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import uniquindio.empresa.controller.PaqueteController;
import uniquindio.empresa.model.IElemento;
import uniquindio.empresa.model.Paquete;
import uniquindio.empresa.model.ServicioTecnologico;

public class ConfiguracionPaquetesViewController {

    @FXML private TextField txtCodigoPaquete;
    @FXML private TextField txtNombrePaquete;

    @FXML private ComboBox<IElemento> cbElementosDisponibles;
    @FXML private ListView<IElemento> lvDetalleSeleccionado; // Nueva lista para detalles
    @FXML private ListView<IElemento> lvContenidoPaquete;
    @FXML private Label lblCostoTotalPaquete;

    private final PaqueteController controller = new PaqueteController();
    private final ObservableList<IElemento> elementosPaqueteActual = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        lvContenidoPaquete.setItems(elementosPaqueteActual);
        cargarElementosDisponibles();

        // Configurar formato visual para todos los listados usando código reutilizable
        configurarCeldaComboBox(cbElementosDisponibles);
        configurarCeldaListView(lvContenidoPaquete);
        configurarCeldaListView(lvDetalleSeleccionado);

        // LISTENER MAGICO: Cuando el usuario selecciona algo, actualiza la lista de detalles
        cbElementosDisponibles.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            actualizarDetallesSeleccion(newVal);
        });
    }

    private void cargarElementosDisponibles() {
        ObservableList<IElemento> todos = FXCollections.observableArrayList();
        todos.addAll(controller.obtenerServiciosTecnologicos());
        todos.addAll(controller.obtenerPaquetes());
        cbElementosDisponibles.setItems(todos);
    }

    // Método que aprovecha el patrón Composite para mostrar el contenido
    private void actualizarDetallesSeleccion(IElemento seleccionado) {
        if (seleccionado == null) {
            lvDetalleSeleccionado.getItems().clear();
            return;
        }

        // El método obtenerElementos() funciona para Servicios (devuelve 1) y Paquetes (devuelve todos)
        ObservableList<IElemento> contenidos = FXCollections.observableArrayList(seleccionado.obtenerElementos());
        lvDetalleSeleccionado.setItems(contenidos);
    }

    @FXML
    void agregarElementoAPaquete() {
        IElemento seleccionado = cbElementosDisponibles.getValue();
        if (seleccionado == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Atención", "Seleccione un elemento de la lista desplegable.");
            return;
        }
        elementosPaqueteActual.add(seleccionado);
        calcularCostoPaquete();
    }

    @FXML
    void crearPaquete() {
        String codigo = txtCodigoPaquete.getText();
        String nombre = txtNombrePaquete.getText();

        try {
            boolean exito = controller.crearPaquete(codigo, nombre, elementosPaqueteActual);
            if (exito) {
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Paquete creado correctamente.");
                txtCodigoPaquete.clear();
                txtNombrePaquete.clear();
                elementosPaqueteActual.clear();
                lblCostoTotalPaquete.setText("Total Paquete: $0.0");
                cargarElementosDisponibles(); // Actualiza el combo para mostrar el nuevo paquete
                lvDetalleSeleccionado.getItems().clear(); // Limpia los detalles mostrados
            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "Ya existe un paquete registrado con ese código.");
            }
        } catch (IllegalArgumentException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Validación de Negocio", e.getMessage());
        }
    }

    @FXML
    void calcularCostoPaquete() {
        double total = 0.0;
        for (IElemento elem : elementosPaqueteActual) {
            total += elem.calcularCosto();
        }
        lblCostoTotalPaquete.setText(String.format("Total Paquete: $%.2f", total));
    }

    @FXML
    void volverMenuPrincipal(ActionEvent event) {
        Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ventanaActual.close();
    }

    // ======================= MÉTODOS DE UTILIDAD Y LIMPIEZA =======================

    private void configurarCeldaComboBox(ComboBox<IElemento> comboBox) {
        comboBox.setCellFactory(param -> new CeldaElemento());
        comboBox.setButtonCell(new CeldaElemento());
    }

    private void configurarCeldaListView(ListView<IElemento> listView) {
        listView.setCellFactory(param -> new CeldaElemento());
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Clase interna que elimina todo el código basura duplicado de las ListCell
    private static class CeldaElemento extends ListCell<IElemento> {
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
    }
}