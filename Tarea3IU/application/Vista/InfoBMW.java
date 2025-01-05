package application.Vista;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class InfoBMW extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) throws Exception {
        BorderPane main = new BorderPane();
        GridPane gridPane = creaPane();
        VBox info = informacion();
        etiquetasD(info);
        etiquetasI(gridPane, stage); // Modificado para pasar el stage
        main.setRight(info);
        main.setLeft(gridPane);
        Scene scene = new Scene(main);
        stage.setMaximized(true); // Con esto hacemos que esté en pantalla completa
        stage.setTitle("BMW M8");
        stage.setScene(scene);
        stage.show();
    }

    private void etiquetasD(VBox informacion) {
        Font fuente = new Font("Arial", 30);
        Label titulo = new Label("BMW M8");
        titulo.setFont(fuente);
        Label maximo = new Label("Máximo dinamismo y exclusividad");
        maximo.setFont(fuente);
        Label motor = new Label("-Motor de gasolina M TwinPower Turbo de 8\n" +
                                "cilindros de alto rendimiento de 625 hp.");
        motor.setFont(fuente);
        Label xDrive = new Label("-M xDrive con diferencial M activa y transmisión\n" +
                                 "M Steptronic de 8 velocidades con Drivelogic.");
        xDrive.setFont(fuente);
        Label elemento = new Label("-Elementos de diseño y equipamientos\n" +
                                   "exclusivos.");
        elemento.setFont(fuente);
        Label hp = new Label("-625 hp, 750 Nm, 0-100 km/h en 3.2 s");
        hp.setFont(fuente);
        informacion.getChildren().addAll(titulo, maximo, motor, xDrive, elemento, hp);
    }

    private void etiquetasI(GridPane gridPane, Stage stage) {
        Image bmwM = new Image(getClass().getResourceAsStream("MBWM8.jpg"));
        ImageView imagen = new ImageView(bmwM);
        imagen.setFitWidth(600);
        imagen.setFitHeight(500);
        imagen.setPreserveRatio(true);
        gridPane.add(imagen, 1, 2);

        Label Colores = new Label("Colores:\n" +
                "-Frozen tazantine\n" +
                "-Aventurine res\n" +
                "-Brilliant white");
        Colores.setFont(new Font("Arial", 30));
        gridPane.add(Colores, 1, 5);

        Button cotizalo = new Button("Cotízalo aquí");
        cotizalo.setPrefSize(200, 100);
        cotizalo.setOnAction(e -> cambiarAComprar(stage)); // Evento para cambiar de escena
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
