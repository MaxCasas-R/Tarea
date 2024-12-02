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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Vehiculos extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) throws Exception {
    	GridPane gridPane = creaPane();
        agregaControles(gridPane);
        Scene scene = new Scene(gridPane);
        stage.setMaximized(true);
        stage.setTitle("Vehículos");
        stage.setScene(scene);
        stage.show();
    }
    
    private GridPane creaPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(50);
        gridPane.setHgap(40);
        return gridPane;
    }
    
    private void agregaControles(GridPane gridPane) {
    	// Crear una fuente común con tamaño grande
        Font fuenteGrande = new Font("Arial", 30);

        // Etiquetas con tamaño de fuente ajustado
        Label labelBMWm8 = new Label("BMW m8");
        labelBMWm8.setFont(fuenteGrande);

        Label labelCorvetteC8 = new Label("Corvette C8");
        labelCorvetteC8.setFont(fuenteGrande);

        Label labelBMWM3 = new Label("BMW M3");
        labelBMWM3.setFont(fuenteGrande);

        Label labelPorscheGt = new Label("Porsche Gt3 RS");
        labelPorscheGt.setFont(fuenteGrande);

        Label labelAudiA1 = new Label("Audi A1");
        labelAudiA1.setFont(fuenteGrande);
        
        Label labelFiat = new Label ("Fiat");
        labelFiat.setFont(fuenteGrande);
        
        Image bmwM=new Image(getClass().getResourceAsStream("MBWM8.jpg"));
	    ImageView imagen = new ImageView(bmwM);
	    // Ajustamos el tamaño de la imagen
	    imagen.setFitWidth(350);  // Ancho deseado
	    imagen.setFitHeight(300); // Altura deseada
	    imagen.setPreserveRatio(true); // 
	    
	    Image Corvette=new Image(getClass().getResourceAsStream("Corvette C8.jpg"));
	    ImageView imagen2 = new ImageView(Corvette);
	    // Ajustamos el tamaño de la imagen
	    imagen2.setFitWidth(350);  // Ancho deseado
	    imagen2.setFitHeight(300); // Altura deseada
	    imagen2.setPreserveRatio(true); // 
	    
	    Image bmwM3=new Image(getClass().getResourceAsStream("bmw m3.png"));
	    ImageView imagen3 = new ImageView(bmwM3);
	    // Ajustamos el tamaño de la imagen
	    imagen3.setFitWidth(350);  // Ancho deseado
	    imagen3.setFitHeight(300); // Altura deseada
	    imagen3.setPreserveRatio(true); // 
	    
	    Image porsche=new Image(getClass().getResourceAsStream("Porsche.jpg"));
	    ImageView imagen4 = new ImageView(porsche);
	    // Ajustamos el tamaño de la imagen
	    imagen4.setFitWidth(350);  // Ancho deseado
	    imagen4.setFitHeight(300); // Altura deseada
	    imagen4.setPreserveRatio(true); //
	    
	    Image audi=new Image(getClass().getResourceAsStream("AudiA1.jpg"));
	    ImageView imagen5 = new ImageView(audi);
	    // Ajustamos el tamaño de la imagen
	    imagen5.setFitWidth(350);  // Ancho deseado
	    imagen5.setFitHeight(300); // Altura deseada
	    imagen5.setPreserveRatio(true);
	    
	    Image fiat=new Image(getClass().getResourceAsStream("Fiat.jpg"));
	    ImageView imagen6 = new ImageView(fiat);
	    // Ajustamos el tamaño de la imagen
	    imagen6.setFitWidth(350);  // Ancho deseado
	    imagen6.setFitHeight(300); // Altura deseada
	    imagen6.setPreserveRatio(true); // 
	    
	    gridPane.add(imagen, 0, 0);
    	gridPane.add(imagen2, 1, 0);
    	gridPane.add(imagen3, 2, 0);
    	gridPane.add(labelBMWm8, 0, 1);
    	gridPane.add(labelCorvetteC8, 1, 1);
    	gridPane.add(labelBMWM3, 2, 1);
    	gridPane.add(imagen4, 0, 2);
    	gridPane.add(imagen5, 1, 2);
    	gridPane.add(imagen6, 2, 2);
    	gridPane.add(labelPorscheGt, 0, 3);
    	gridPane.add(labelAudiA1, 1, 3);
    	gridPane.add(labelFiat, 2, 3);
    
    }
}
