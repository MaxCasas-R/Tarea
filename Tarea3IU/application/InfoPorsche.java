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

public class InfoPorsche extends Application{
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
        stage.setTitle("Porsche GT3RS");
        stage.setScene(scene);
        stage.show();
    }

    private void etiquetasD(VBox informacion) {
        // Establecer un tamaño de fuente común
        Font fuente = new Font("Arial", 30);
        Label titulo = new Label("Porsche GT3RS");
        titulo.setFont(fuente);
        Label maximo = new Label("La perfección nunca es el principio");
        maximo.setFont(fuente);
        Label motor = new Label("-Pero siempre es el objetivo\n");
        motor.setFont(fuente);
        Label xDrive = new Label("El 911 GT3 RS. aún más deportivo");
        xDrive.setFont(fuente);
        Label elemento = new Label("Optimizado para el circuito");
        elemento.setFont(fuente);
        Label hp = new Label("-525 hp, 750 Nm, 0-100 km/h en 3.2 s");
        hp.setFont(fuente);
        // Agregar las etiquetas al VBox
        informacion.getChildren().addAll(titulo, maximo, motor, xDrive, elemento, hp);
    }

    private void etiquetasI(GridPane gridPane, Stage stage) {
        Image porsche = new Image(getClass().getResourceAsStream("Porsche.jpg"));
        ImageView imagen = new ImageView(porsche);
        // Ajustamos el tamaño de la imagen
        imagen.setFitWidth(600);  // Ancho deseado
        imagen.setFitHeight(500); // Altura deseada
        imagen.setPreserveRatio(true);
        gridPane.add(imagen, 1, 2);

        Label Colores = new Label("Colores:\n" +
                                  "-Black\n" +
                                  "-Red");
        Colores.setFont(new Font("Arial", 30));
        gridPane.add(Colores, 1, 5);

        Button cotizalo = new Button("Cotízalo aquí");
        cotizalo.setPrefSize(200, 100);
        cotizalo.setOnAction(e -> cambiarAComprar(stage));  // Llamamos al método para cambiar a la ventana de compra
        gridPane.add(cotizalo, 1, 8);
    }

    // Método para cambiar a la escena de compra
    private void cambiarAComprar(Stage stage) {
        Comprar comprar = new Comprar();
        try {
            comprar.start(stage); // Llamamos al método start() de la clase Comprar, pasándole el mismo Stage
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //-------------------- Cuadricula
    private GridPane creaPane() { // Creamos la cuadricula
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER_LEFT);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        return gridPane;
    }

    //----------------------- VBox
    private VBox informacion() {
        VBox info = new VBox(25);
        info.setPadding(new Insets(30));
        info.setAlignment(Pos.CENTER_LEFT);
        return info;
    }
}
