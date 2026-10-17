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
import uniquindio.empresa.model.TecnicoLegacyService;
import uniquindio.empresa.model.AdapterLegacy;
import uniquindio.empresa.model.IConsultaTecnico;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. Cargamos los datos quemados en el Singleton
        inicializarDatosQuemados();

        // 2. Probamos que el adaptador de técnicos Legacy funciona correctamente
        probarAdaptadorTecnicos();

        try {
            // Carga la vista principal. Asegúrate de que la ruta coincida con tu carpeta resources.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/uniquindio/empresa/MainMenuView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("TechSolutions - Menú Principal");
            primaryStage.setResizable(false);
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
        paqueteBasico.getListServiciosTecnologicosPaquete().add(red);
        paqueteBasico.getListServiciosTecnologicosPaquete().add(mantPrev);

        empresa.crearPaquete(paqueteBasico);

        System.out.println("✅ Datos quemados inicializados correctamente en TechSolutions.");
    }

    /**
     * Método para simular la llegada de datos del sistema Legacy y probar el Adapter
     */
    private void probarAdaptadorTecnicos() {
        System.out.println("\n--- PROBANDO ADAPTADOR LEGACY ---");

        // Simulamos las respuestas que daría el sistema antiguo (Legacy)
        TecnicoLegacyService tecnico1 = new TecnicoLegacyService("105", "TEC-105|DISPONIBLE|30000");
        TecnicoLegacyService tecnico2 = new TecnicoLegacyService("102", "TEC-102|NO_DISPONIBLE|25000");

        // Pasamos los técnicos por nuestro Adaptador
        IConsultaTecnico adaptador = new AdapterLegacy(tecnico1); // Inicializamos con el primero

        System.out.println("Traduciendo Técnico 1:");
        System.out.println("  ID: " + adaptador.consultarCodigoTecnico(tecnico1));
        System.out.println("  Disponible: " + adaptador.consultarDisponibilidad(tecnico1));
        System.out.println("  Costo Desplazamiento: $" + adaptador.consultarValorDesplazamiento(tecnico1));

        System.out.println("Traduciendo Técnico 2:");
        System.out.println("  ID: " + adaptador.consultarCodigoTecnico(tecnico2));
        System.out.println("  Disponible: " + adaptador.consultarDisponibilidad(tecnico2));
        System.out.println("  Costo Desplazamiento: $" + adaptador.consultarValorDesplazamiento(tecnico2));
        System.out.println("---------------------------------\n");
    }

    public static void main(String[] args) {
        launch(args);
    }
}