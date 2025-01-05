package application.Controlador;

import application.Vista.Comprar;
import application.Vista.QuienesSomos;
import application.Vista.Vehiculos;
import javafx.stage.Stage;

public class ControladorMain {
    private Stage mainStage;

    public ControladorMain(Stage stage) {
        this.mainStage = stage; // Guardar la referencia del Stage principal
    }

    // Cambiar a la escena de "Vehiculos"
    public void abrirVehiculos() {
        try {
            Vehiculos vehiculos = new Vehiculos();
            vehiculos.start(mainStage); // Se reutiliza el mainStage correctamente
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Cambiar a la escena de "Comprar"
    public void abrirComprar() {
        try {
            Comprar comprar = new Comprar();
            comprar.start(mainStage); // Reemplazar la escena del Stage principal
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cambiar a la escena de "Quienes Somos"
    public void abrirQuienesSomos() {
        try {
            QuienesSomos quienesSomos = new QuienesSomos();
            quienesSomos.start(mainStage); // Reemplazar la escena del Stage principal
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
