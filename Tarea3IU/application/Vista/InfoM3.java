package application.Vista;

import application.Controlador.ControlVehiEspecificos;
import javafx.application.Application;
import javafx.stage.Stage;

public class InfoM3 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        // Crear instancia del controlador general para BMW M3
        ControlVehiEspecificos bmw = new ControlVehiEspecificos(
            "BMW M3\n\n" // Nombre del vehículo
        	+ "Precio: $2,175,000 MXN",
            "Confort y potencia increíbles", // Descripción
            "-Motor de gasolina M Turbo de 6\n" +
            "cilindros de alto rendimiento de 425 hp.\n" +
            "-M xDrive con diferencial M activa y transmisión\n" +
            "M Steptronic de 7 velocidades con Drivelogic.\n" +
            "-Elementos de diseño y equipamientos exclusivos.\n" +
            "-425 hp, 600 Nm, 0-100 km/h en 3.7 s", // Detalles del motor
            "/application/Recursos/bmw m3.png", // Ruta de la imagen
            "-Black\n-Red", // Colores disponibles
            stage // Stage principal
        );

        // Mostrar la ventana
        bmw.mostrarInformacion();
    }
}
