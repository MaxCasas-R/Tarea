package application.Vista;

import application.Controlador.ControlVehiEspecificos;
import javafx.application.Application;
import javafx.stage.Stage;

public class InfoAudi extends Application {
    @Override
    public void start(Stage stage) {
        ControlVehiEspecificos audi = new ControlVehiEspecificos(
            "Audi A1\n\n"
        	+ "Precio: $500,000 MXN",
            "Épico, emocional y dinámico",
            "-Motor de gasolina EGO\nEGO: el motor 1.5 TSFI con 150 hp",
            "/application/Recursos/AudiA1.jpg",
            "-Negro\n-Blanco",
            stage
        );

        audi.mostrarInformacion();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


