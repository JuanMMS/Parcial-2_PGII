package uniquindio.empresa.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
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

    public static void main(String[] args) {
        launch(args);
    }
}