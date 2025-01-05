package application.Vista;

import application.Controlador.ControladorMain;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class Vehiculos extends Application {
	private ControladorMain controladorMain;
    //public static void main(String[] args) {
      //  launch();
    //}

    public void start(Stage stage) throws Exception {
        GridPane gridPane = creaPane();
        agregaControles(gridPane, stage); // Pasamos el stage a la función de agregar controles
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

    private void agregaControles(GridPane gridPane, Stage stage) {
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

        Label labelFiat = new Label("Fiat");
        labelFiat.setFont(fuenteGrande);

        // Cargar las imágenes
        Image bmwM = new Image(getClass().getResourceAsStream("/application/Recursos/MBWM8.jpg"));
        ImageView imagen = new ImageView(bmwM);
        imagen.setFitWidth(350);
        imagen.setFitHeight(300);
        imagen.setPreserveRatio(true);

        // Evento al hacer clic en la imagen BMW M8
        imagen.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            // Al hacer clic en la imagen, se abre la ventana de InfoBMW
            InfoBMW infoBMW = new InfoBMW();
            try {
                infoBMW.start(stage); // Reutilizamos el mismo stage para mostrar la nueva ventana
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Image corvette = new Image(getClass().getResourceAsStream("/application/Recursos/Corvette C8.jpg"));
        ImageView imagen2 = new ImageView(corvette);
        imagen2.setFitWidth(350);
        imagen2.setFitHeight(300);
        imagen2.setPreserveRatio(true);

        // Evento al hacer clic en la imagen Corvette C8
        imagen2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            // Al hacer clic en la imagen, se abre la ventana de InfoC8
            InfoC8 infoC8 = new InfoC8();
            try {
                infoC8.start(stage); // Reutilizamos el mismo stage para mostrar la nueva ventana
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Image bmwM3 = new Image(getClass().getResourceAsStream("/application/Recursos/bmw m3.png"));
        ImageView imagen3 = new ImageView(bmwM3);
        imagen3.setFitWidth(350);
        imagen3.setFitHeight(300);
        imagen3.setPreserveRatio(true);

        // Evento al hacer clic en la imagen BMW M3
        imagen3.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            // Al hacer clic en la imagen, se abre la ventana de InfoM3
            InfoM3 infoM3 = new InfoM3();
            try {
                infoM3.start(stage); // Reutilizamos el mismo stage para mostrar la nueva ventana
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Image porsche = new Image(getClass().getResourceAsStream("/application/Recursos/Porsche.jpg"));
        ImageView imagen4 = new ImageView(porsche);
        imagen4.setFitWidth(350);
        imagen4.setFitHeight(300);
        imagen4.setPreserveRatio(true);

        // Evento al hacer clic en la imagen Porsche GT3 RS
        imagen4.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            // Al hacer clic en la imagen, se abre la ventana de InfoPorsche
            InfoPorsche infoPorsche = new InfoPorsche();
            try {
                infoPorsche.start(stage); // Reutilizamos el mismo stage para mostrar la nueva ventana
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Image audi = new Image(getClass().getResourceAsStream("/application/Recursos/AudiA1.jpg"));
        ImageView imagen5 = new ImageView(audi);
        imagen5.setFitWidth(350);
        imagen5.setFitHeight(300);
        imagen5.setPreserveRatio(true);

        // Evento al hacer clic en la imagen Audi A1
        imagen5.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            // Al hacer clic en la imagen, se abre la ventana de InfoAudi
            InfoAudi infoAudi = new InfoAudi();
            try {
                infoAudi.start(stage); // Reutilizamos el mismo stage para mostrar la nueva ventana
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Image fiat = new Image(getClass().getResourceAsStream("/application/Recursos/Fiat.jpg"));
        ImageView imagen6 = new ImageView(fiat);
        imagen6.setFitWidth(350);
        imagen6.setFitHeight(300);
        imagen6.setPreserveRatio(true);

        // Evento al hacer clic en la imagen Fiat
        imagen6.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            // Al hacer clic en la imagen, se abre la ventana de InfoFiat
            InfoFiat infoFiat = new InfoFiat();
            try {
                infoFiat.start(stage); // Reutilizamos el mismo stage para mostrar la nueva ventana
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Agregar las imágenes y etiquetas al gridPane
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
