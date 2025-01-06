package application.Vista;

import application.Controlador.ControlVehiEspecificos;
import javafx.application.Application;
import javafx.stage.Stage;

public class InfoPorsche extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        // Crear instancia del controlador general para Porsche GT3RS
        ControlVehiEspecificos porsche = new ControlVehiEspecificos(
            "Porsche GT3RS", // Nombre del vehículo
            "La perfección nunca es el principio", // Descripción
            "-Pero siempre es el objetivo.\n" +
            "El 911 GT3 RS, aún más deportivo.\n" +
            "Optimizado para el circuito.\n" +
            "-525 hp, 750 Nm, 0-100 km/h en 3.2 s", // Detalles del motor
            "/application/Recursos/Porsche.jpg", // Ruta de la imagen
            "-Black\n-Red", // Colores disponibles
            stage // Stage principal
        );

        // Mostrar la ventana
        porsche.mostrarInformacion();
    }
}
