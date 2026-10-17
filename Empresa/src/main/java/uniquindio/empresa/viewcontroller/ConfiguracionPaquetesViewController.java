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
import uniquindio.empresa.controller.PaqueteController;
import uniquindio.empresa.model.IElemento;
import uniquindio.empresa.model.Paquete;
import uniquindio.empresa.model.ServicioTecnologico;

import java.io.IOException;

public class ConfiguracionPaquetesViewController {

    @FXML private TextField txtCodigoPaquete;
    @FXML private TextField txtNombrePaquete;
    @FXML private ComboBox<IElemento> cbElementosDisponibles;
    @FXML private ListView<IElemento> lvContenidoPaquete;
    @FXML private Label lblCostoTotalPaquete;

    private final PaqueteController controller = new PaqueteController();
    private final ObservableList<IElemento> elementosPaqueteActual = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        lvContenidoPaquete.setItems(elementosPaqueteActual);
        cargarElementosDisponibles();

        cbElementosDisponibles.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(IElemento item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText("");
                } else if (item instanceof ServicioTecnologico s) {
                    setText("[Servicio] " + s.getNombre() + " ($" + s.calcularCosto() + ")");
                } else if (item instanceof Paquete p) {
                    setText("[Paquete] " + p.getNombre() + " ($" + p.calcularCosto() + ")");
                } else {
                    setText(item.toString());
                }
            }
        });
        cbElementosDisponibles.setButtonCell(cbElementosDisponibles.getCellFactory().call(null));

        lvContenidoPaquete.setCellFactory(param -> new ListCell<>() {
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

    private void cargarElementosDisponibles() {
        ObservableList<IElemento> todos = FXCollections.observableArrayList();
        todos.addAll(controller.obtenerServiciosTecnologicos());
        todos.addAll(controller.obtenerPaquetes());
        cbElementosDisponibles.setItems(todos);
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
                cargarElementosDisponibles();
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