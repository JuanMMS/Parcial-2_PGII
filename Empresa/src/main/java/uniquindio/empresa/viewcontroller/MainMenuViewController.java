package uniquindio.empresa.viewcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainMenuViewController {

    @FXML
    void abrirGestionServicios(ActionEvent event) {
        abrirNuevaVentana("/uniquindio/empresa/GestionServiciosView.fxml", "Gestión de Servicios");
    }

    @FXML
    void abrirConfiguracionPaquetes(ActionEvent event) {
        abrirNuevaVentana("/uniquindio/empresa/ConfiguracionPaquetesView.fxml", "Configuración de Paquetes");
    }

    @FXML
    void abrirRegistroSolicitudes(ActionEvent event) {
        abrirNuevaVentana("/uniquindio/empresa/RegistroSolicitudView.fxml", "Solicitudes y Técnicos");
    }

    @FXML
    void salirSistema(ActionEvent event) {
        System.exit(0); // Cierra la aplicación completamente
    }

    /**
     * Método auxiliar para cargar el FXML y abrir una NUEVA ventana
     */

    private void abrirNuevaVentana(String fxmlPath, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            // Creamos un nuevo Stage (nueva ventana)
            Stage nuevaVentana = new Stage();
            Scene scene = new Scene(root);

            nuevaVentana.setTitle("TechSolutions - " + titulo);
            nuevaVentana.setScene(scene);
            nuevaVentana.show(); // Abre la ventana sin cerrar la anterior

        } catch (IOException e) {
            System.err.println("Error al abrir la ventana: " + fxmlPath);
            e.printStackTrace();
        }
    }
}