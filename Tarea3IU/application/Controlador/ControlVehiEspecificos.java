package application.Controlador;

import application.Vista.Comprar;
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

public class ControlVehiEspecificos {
    private String nombre;
    private String descripcion;
    private String detallesMotor;
    private String rutaImagen;
    private String colores;
    private Stage stagePrincipal;

    public ControlVehiEspecificos(String nombre, String descripcion, String detallesMotor, String rutaImagen, String colores, Stage stagePrincipal) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.detallesMotor = detallesMotor;
        this.rutaImagen = rutaImagen;
        this.colores = colores;
        this.stagePrincipal = stagePrincipal;
    }

    public void mostrarInformacion() {
        BorderPane main = new BorderPane();
        GridPane gridPane = creaPane();
        VBox info = informacion();
        etiquetasD(info);
        etiquetasI(gridPane);
        main.setRight(info);
        main.setLeft(gridPane);
        Scene scene = new Scene(main);
        stagePrincipal.setMaximized(true); // Pantalla completa
        stagePrincipal.setTitle(nombre);
        stagePrincipal.setScene(scene);
        stagePrincipal.show();
    }

    private void etiquetasD(VBox informacion) {
        // Establecer un tamaño de fuente común
        Font fuente = new Font("Arial", 30);
        Label titulo = new Label(nombre);
        titulo.setFont(fuente);
        Label maximo = new Label(descripcion);
        maximo.setFont(fuente);
        Label motor = new Label(detallesMotor);
        motor.setFont(fuente);
        informacion.getChildren().addAll(titulo, maximo, motor);
    }

    private void etiquetasI(GridPane gridPane) {
        Image imagenVehiculo = new Image(getClass().getResourceAsStream(rutaImagen));
        ImageView imagen = new ImageView(imagenVehiculo);
        // Ajustamos el tamaño de la imagen
        imagen.setFitWidth(600);
        imagen.setFitHeight(380);
        imagen.setPreserveRatio(true);
        gridPane.add(imagen, 1, 2);

        Label coloresLabel = new Label("Colores:\n" + colores);
        coloresLabel.setFont(new Font("Arial", 30));
        gridPane.add(coloresLabel, 1, 5);

        Button cotizalo = new Button("Cotízalo aquí");
        cotizalo.setPrefSize(200, 100);
        cotizalo.setOnAction(e -> cambiarAComprar(stagePrincipal));
        gridPane.add(cotizalo, 1, 8);
    }

    private void cambiarAComprar(Stage stage) {
        Comprar comprar = new Comprar();
        try {
            comprar.start(stage); // Cambiar a la ventana de compra
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private GridPane creaPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER_LEFT);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        return gridPane;
    }

    private VBox informacion() {
        VBox info = new VBox(25);
        info.setPadding(new Insets(30));
        info.setAlignment(Pos.CENTER_LEFT);
        return info;
    }
}
