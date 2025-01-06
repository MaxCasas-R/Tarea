package application.Vista;

import application.Controlador.ControlVehiEspecificos;
import javafx.application.Application;
import javafx.stage.Stage;

public class InfoFiat extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        // Crear instancia del controlador general para Fiat
        ControlVehiEspecificos fiat = new ControlVehiEspecificos(
            "Fiat 500", // Nombre del vehículo
            "Todo un clásico", // Descripción
            "-50 caballos de fuerza de sobra.\n" +
            "En un eje pequeño, seguro y confiable.\n" +
            "-Para todo lo que necesites.\n" +
            "0 a 100 en 2 días hábiles", // Detalles del motor
            "/application/Recursos/Fiat.jpg", // Ruta de la imagen
            "-El que se te ocurra\n-En todos hay", // Colores disponibles
            stage // Stage principal
        );

        // Mostrar la ventana
        fiat.mostrarInformacion();
    }
}
