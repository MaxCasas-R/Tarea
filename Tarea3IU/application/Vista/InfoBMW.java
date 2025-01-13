package application.Vista;

import application.Controlador.ControlVehiEspecificos;
import javafx.application.Application;
import javafx.stage.Stage;

public class InfoBMW extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) {
        // Crear instancia del controlador general para BMW
        ControlVehiEspecificos bmw = new ControlVehiEspecificos(
            "BMW M8\n\n"  // Nombre del vehículo
            + "Precio: $3,455,000 MXN",
            "Máximo dinamismo y exclusividad", // Descripción
            "-Motor de gasolina M TwinPower Turbo de 8\n" +
            "cilindros de alto rendimiento de 625 hp.\n" +
            "-M xDrive con diferencial M activa y transmisión\n" +
            "M Steptronic de 8 velocidades con Drivelogic.\n" +
            "-625 hp, 750 Nm, 0-100 km/h en 3.2 s", // Detalles del motor
            "/application/Recursos/MBWM8.jpg", // Ruta de la imagen
            "-Frozen tazantine\n-Aventurine res\n-Brilliant white", // Colores disponibles
            stage // Stage principal
        );

        // Mostrar la ventana
        bmw.mostrarInformacion();
    }
}
