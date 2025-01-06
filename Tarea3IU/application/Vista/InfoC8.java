package application.Vista;

import application.Controlador.ControlVehiEspecificos;
import javafx.application.Application;
import javafx.stage.Stage;

public class InfoC8 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        // Crear instancia del controlador general para Corvette C8
        ControlVehiEspecificos corvette = new ControlVehiEspecificos(
            "Corvette C8", // Nombre del vehículo
            "Increíble potencia y rendimiento", // Descripción
            "-Motor V8 de 6.3 Lts\n" +
            "Potencia de 495 HP y 470 lb-pie de torque.\n" +
            "3 modos de manejo de alto desempeño: Tour, Sport y Track\n" +
            "Rines delanteros de aluminio de 19” y traseros de 20\n" +
            "-Asientos GT2 forrados en piel napa con insertos en tacto piel", // Detalles del motor
            "/application/Recursos/Corvette C8.jpg", // Ruta de la imagen
            "-Torch Red\n-Rapid Blue\n-Black", // Colores disponibles
            stage // Stage principal
        );

        // Mostrar la ventana
        corvette.mostrarInformacion();
    }
}

