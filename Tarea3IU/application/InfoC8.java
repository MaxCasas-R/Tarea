package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class InfoC8 extends Application{
    public static void main (String[] args) {
        launch();
    }

    public void start(Stage stage) throws Exception {
        BorderPane main = new BorderPane();
        GridPane gridPane = creaPane();
        VBox info = informacion();
        etiquetasD(info);
        etiquetasI(gridPane, stage);  // Pasa el stage al método
        main.setRight(info);
        main.setLeft(gridPane);
        Scene scene = new Scene(main);
        stage.setMaximized(true); // Con esto hacemos que esté en pantalla completa
        stage.setTitle("Corvette C8");
        stage.setScene(scene);
        stage.show();
    }

    private void etiquetasD(VBox informacion) {
        // Establecer un tamaño de fuente común
        Font fuente = new Font("Arial", 30);
        Label titulo = new Label("Corvette C8");
        titulo.setFont(fuente);
        Label maximo = new Label("Increíble potencia y rendimiento");
        maximo.setFont(fuente);
        Label motor = new Label("-Motor V8 de 6.3 Lts\n" +
                                "Potencia de 495 HP y 470 lb-pie de torque.");
        motor.setFont(fuente);
        Label xDrive = new Label("3 modos de manejo de alto desempeño: Tour, Sport y Track\n" +
                                 "Rines delanteros de aluminio de 19” y traseros de 20");
        xDrive.setFont(fuente);
        Label elemento = new Label("-Asientos GT2 forrados en piel napa con insertos en tacto piel\n");
        elemento.setFont(fuente);
        // Agregar las etiquetas al VBox
        informacion.getChildren().addAll(titulo, maximo, motor, xDrive, elemento);
    }

    private void etiquetasI(GridPane gridPane, Stage stage) {
        Image corvette = new Image(getClass().getResourceAsStream("Corvette C8.jpg"));
        ImageView imagen = new ImageView(corvette);
        imagen.setFitWidth(700);
        imagen.setFitHeight(350);
        imagen.setPreserveRatio(true);
        gridPane.add(imagen, 1, 2);

        Label Colores = new Label("Colores:\n" +
                "-Torch Red\n" +
                "-Rapid Blue\n" +
                "-Black");
        Colores.setFont(new Font("Arial", 30));
        gridPane.add(Colores, 1, 5);

        Button cotizalo = new Button("Cotízalo aquí");
        cotizalo.setPrefSize(200, 100);
        cotizalo.setOnAction(e -> cambiarAComprar(stage));  // Evento para cambiar de escena
        gridPane.add(cotizalo, 1, 8);
    }

    // Método para cambiar a la escena de comprar
    private void cambiarAComprar(Stage stage) {
        Comprar comprar = new Comprar();
        try {
            comprar.start(stage); // Llamamos al método start() de la clase Comprar, pasándole el mismo Stage
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para crear la cuadricula
    private GridPane creaPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER_LEFT);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        return gridPane;
    }

    // Método para crear el VBox de información
    private VBox informacion() {
        VBox info = new VBox(25);
        info.setPadding(new Insets(30));
        info.setAlignment(Pos.CENTER_LEFT);
        return info;
    }
}
