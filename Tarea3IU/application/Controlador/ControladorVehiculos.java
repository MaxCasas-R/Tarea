package application.Controlador;
import application.Vista.InfoAudi;
import application.Vista.InfoBMW;
import application.Vista.InfoC8;
import application.Vista.InfoFiat;
import application.Vista.InfoM3;
import application.Vista.InfoPorsche;
import application.Vista.Vehiculos;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControladorVehiculos {   
	private Stage mainStage;

public ControladorVehiculos(Stage stage) {
    this.mainStage = stage; // Guardar la referencia del Stage principal
}
public void abrirInfoBMW() {
    InfoBMW infoBMW = new InfoBMW();
    try {
        infoBMW.start(mainStage);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void abrirInfoC8() {
    InfoC8 infoC8 = new InfoC8();
    try {
        infoC8.start(mainStage);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void abrirInfoM3() {
    InfoM3 infoM3 = new InfoM3();
    try {
        infoM3.start(mainStage);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void abrirInfoPorsche() {
    InfoPorsche infoPorsche = new InfoPorsche();
    try {
        infoPorsche.start(mainStage);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void abrirInfoAudi() {
    InfoAudi infoAudi = new InfoAudi();
    try {
        infoAudi.start(mainStage);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void abrirInfoFiat() {
    InfoFiat infoFiat = new InfoFiat();
    try {
        infoFiat.start(mainStage);
    } catch (Exception e) {
        e.printStackTrace();
    }
}



}
