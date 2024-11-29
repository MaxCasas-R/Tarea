package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	public static void main (String[]args) {
		launch();
	}
//---------------------Funcion principal
	public void start (Stage stage) {
		GridPane gridPane=creaPane();
		BotonesIniciales(gridPane);
		//Creamos la escena 
		Scene scene=new Scene(gridPane);
		stage.setMaximized(true);//Con esto hacemos que este en pantalla completa
		stage.setTitle("Prime-Wheels");
		stage.setScene(scene);
		stage.show();
	}
//------------------Botones
private void BotonesIniciales(GridPane gridPane) { //Funcion para los botones
	Button botonVehiculos=new Button("Vehiculos");
	botonVehiculos.setPrefSize(300, 70);
	Button botonComprar=new Button("Comprar");
	botonComprar.setPrefSize(300, 70);
	Button botonConocenos=new Button("Conocenos");
	botonConocenos.setPrefSize(300, 70);
	gridPane.add(botonVehiculos, 0, 0);
	gridPane.add(botonComprar, 8, 0);
	gridPane.add(botonConocenos, 17, 0);
	
	}
//--------------------Cuadricula
private GridPane creaPane() { //Creamos la cuadricula
	GridPane gridPane=new GridPane();
	gridPane.setAlignment(Pos.TOP_LEFT);
	gridPane.setPadding(new Insets(20,20,20,20));
	gridPane.setVgap(30);
	gridPane.setHgap(30);
	return gridPane;
	}

private void EtiquetasIniciales(GridPane gridPane) {
	Label tecnologia=new Label("Tecnología para innovar");
	
}
























}