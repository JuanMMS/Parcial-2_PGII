package uniquindio.empresa.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Importamos las clases de tu modelo
import uniquindio.empresa.model.Cliente;
import uniquindio.empresa.model.Empresa;
import uniquindio.empresa.model.InstalacionRedes;
import uniquindio.empresa.model.MantenimientoPreventivo;
import uniquindio.empresa.model.Paquete;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. Cargamos los datos quemados en el Singleton antes de iniciar la interfaz
        inicializarDatosQuemados();

        try {
            // Carga la vista principal. Asegúrate de que la ruta coincida con tu carpeta resources.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/uniquindio/empresa/MainMenuView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("TechSolutions - Menú Principal");
            primaryStage.setResizable(false); // Opcional: evita que la ventana cambie de tamaño
            primaryStage.show();
        } catch (IOException e) {
            System.err.println("Error al cargar la vista principal: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método para cargar datos iniciales (quemados) en el sistema.
     */
    private void inicializarDatosQuemados() {
        // Obtenemos la única instancia del sistema (Singleton)
        Empresa empresa = Empresa.getInstance();

        // 1. Crear e inyectar Clientes
        empresa.crearCliente(new Cliente("1094123456", "Juan Manuel", "juan@email.com"));
        empresa.crearCliente(new Cliente("1094654321", "Maria Gomez", "maria@email.com"));

        // 2. Crear e inyectar Servicios Tecnológicos
        InstalacionRedes red = new InstalacionRedes("SRV-001", "Instalación Red LAN", "Instalación de puntos de red empresariales");
        MantenimientoPreventivo mantPrev = new MantenimientoPreventivo("SRV-002", "Mantenimiento Preventivo", "Limpieza de hardware y software");

        empresa.crearServicioTecnologico(red);
        empresa.crearServicioTecnologico(mantPrev);

        // 3. Crear e inyectar Paquetes
        Paquete paqueteBasico = new Paquete("PAQ-001", "Paquete Corporativo Básico");
        // Agregamos los servicios al paquete usando el Composite
        paqueteBasico.getListServiciosTecnologicosPaquete().add(red);
        paqueteBasico.getListServiciosTecnologicosPaquete().add(mantPrev);

        empresa.crearPaquete(paqueteBasico);

        // Mensaje de verificación en consola
        System.out.println("✅ Datos quemados inicializados correctamente en TechSolutions.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}