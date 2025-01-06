package application.Vista;

import application.Controlador.ControladorVehiculos;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class Vehiculos extends Application {
    private ControladorVehiculos controladorVehiculos;

    public void start(Stage stage) throws Exception {
        controladorVehiculos = new ControladorVehiculos(stage); // Inicializar el controlador

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

        // Etiquetas
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

        Label labelFiat = new Label("Fiat");
        labelFiat.setFont(fuenteGrande);

        // Imágenes
        ImageView imagen = crearImagen("/application/Recursos/MBWM8.jpg", () -> controladorVehiculos.abrirInfoBMW());
        ImageView imagen2 = crearImagen("/application/Recursos/Corvette C8.jpg", () -> controladorVehiculos.abrirInfoC8());
        ImageView imagen3 = crearImagen("/application/Recursos/bmw m3.png", () -> controladorVehiculos.abrirInfoM3());
        ImageView imagen4 = crearImagen("/application/Recursos/Porsche.jpg", () -> controladorVehiculos.abrirInfoPorsche());
        ImageView imagen5 = crearImagen("/application/Recursos/AudiA1.jpg", () -> controladorVehiculos.abrirInfoAudi());
        ImageView imagen6 = crearImagen("/application/Recursos/Fiat.jpg", () -> controladorVehiculos.abrirInfoFiat());

        // Agregar elementos al GridPane
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

    private ImageView crearImagen(String ruta, Runnable eventoClick) {
        Image imagen = new Image(getClass().getResourceAsStream(ruta));
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(350);
        imageView.setFitHeight(300);
        imageView.setPreserveRatio(true);
        imageView.setOnMouseClicked(event -> eventoClick.run());
        return imageView;
    }
}
