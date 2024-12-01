package application;
	
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Comprar extends Application {
	public static void main (String[]args) {
		launch();
	}
	
	public void start (Stage stage) throws Exception{
		GridPane  gridPane = creaPane();
		agregaControles(gridPane);
		Scene scene = new Scene(gridPane);
		stage.setTitle("Comprar");
		stage.setScene(scene);
		stage.show();
}
	
	private GridPane creaPane() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.BASELINE_LEFT);
		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		return gridPane;
	}
	
	
	private void agregaControles(GridPane gridPane) {
	Label labelSeleccionatuauto = new Label ("Selecciona Tu Auto:");
	Label labelNombre = new Label ("Nombre:");
	Label labelApellidoP = new Label ("Apellido Paterno:");
	Label labelApellidoM = new Label ("Apellido Materno:");
	Label labelCP = new Label ("Codigo Postal:");
	Label labelCorreo = new Label ("Correo Electronico:");
	Label labelAcuerdo = new Label ("He leído y acepto el acuerdo de privacidad: ");
	ChoiceBox<String> box = new ChoiceBox<String>();
	box.setTooltip(new  Tooltip("Seleccione un coche"));
	ObservableList<String> obslista = box.getItems();
	obslista.addAll("coche1", "coche2" , "coche3");
	TextField textFieldNombre = new TextField();
	TextField textFieldApeP = new TextField();
	TextField textFieldApeM = new TextField();
	TextField textFieldCP = new TextField();
	TextField textFieldCorreo = new TextField();
	CheckBox checkBx = new CheckBox("");
	checkBx.setSelected(false);
	
	gridPane.add(labelSeleccionatuauto, 0, 0);
	gridPane.add(labelNombre, 0, 1);
	gridPane.add(labelApellidoP, 0, 2);
	gridPane.add(labelApellidoM, 0, 3);
	gridPane.add(labelCP, 0, 4);
	gridPane.add(labelCorreo, 0, 5);
	gridPane.add(labelAcuerdo, 0, 6);
	gridPane.add(box, 1, 0);
	gridPane.add(textFieldNombre, 1, 1);
	gridPane.add(textFieldApeP, 1, 2);
	gridPane.add(textFieldApeM, 1, 3);
	gridPane.add(textFieldCP, 1, 4);
	gridPane.add(textFieldCorreo, 1, 5);
	gridPane.add(checkBx, 1, 6);
	}


}