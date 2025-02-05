package application.Vista;

import application.Controlador.ControladorComprar;
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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import application.Main;

public class Comprar extends Application {
    
    private Stage mainStage; // Variable para guardar la referencia del Stage principal
    private ControladorComprar controlador; // Instancia del controlador

    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) throws Exception {
        mainStage = stage; // Guardar la referencia del Stage
        controlador = new ControladorComprar(); // Crear una instancia del controlador

        GridPane gridPane = creaPane();
        agregaControles(gridPane);

        Scene scene = new Scene(gridPane);
        stage.setMaximized(true); // Pantalla completa
        stage.setTitle("Comprar");
        stage.setScene(scene);
        stage.show();
    }

    // Crear GridPane
    private GridPane creaPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER_LEFT);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(50);
        gridPane.setHgap(40);
        return gridPane;
    }

    private void agregaControles(GridPane gridPane) {
        // Crear una fuente común con tamaño grande
        Font fuenteGrande = new Font("Arial", 30);

        // Etiquetas con tamaño de fuente ajustado
        Label labelSeleccionatuauto = new Label("Selecciona Tu Auto:");
        labelSeleccionatuauto.setFont(fuenteGrande);

        Label labelNombre = new Label("Nombre:");
        labelNombre.setFont(fuenteGrande);

        Label labelApellidoP = new Label("Apellido Paterno:");
        labelApellidoP.setFont(fuenteGrande);

        Label labelApellidoM = new Label("Apellido Materno:");
        labelApellidoM.setFont(fuenteGrande);

        Label labelCP = new Label("Código Postal:");
        labelCP.setFont(fuenteGrande);

        Label labelCorreo = new Label("Correo Electrónico:");
        labelCorreo.setFont(fuenteGrande);

        Label labelAcuerdo = new Label("He leído y acepto el acuerdo de privacidad:");
        labelAcuerdo.setFont(fuenteGrande);

        Label labelInfo = new Label("Permítenos ayudarte\nen tu proceso de\ncompra.");
        labelInfo.setFont(fuenteGrande);

        // Campos de entrada
        ChoiceBox<String> box = new ChoiceBox<>();
        box.setTooltip(new Tooltip("Seleccione un coche"));
        ObservableList<String> obslista = box.getItems();
        obslista.addAll("BMW m8", "Corvette C8", "BMW M3", "Porsche Gt3 RS", "Audi A1", "Fiat chincuichento");

        TextField textFieldNombre = new TextField();
        TextField textFieldApeP = new TextField();
        TextField textFieldApeM = new TextField();
        TextField textFieldCP = new TextField();
        TextField textFieldCorreo = new TextField();

        // Checkbox
        CheckBox checkBx = new CheckBox("");
        checkBx.setSelected(false);
        checkBx.setMaxHeight(Double.MAX_VALUE);
        checkBx.setMaxWidth(Double.MAX_VALUE);
        
        // Botón "Enviar"
        Button button = new Button("Enviar");
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMaxHeight(Double.MAX_VALUE);
        button.setOnAction(e -> {
            // Llamar al método del controlador para guardar los datos
            String nombreUsuario = textFieldNombre.getText();
            String apellidoP = textFieldApeP.getText();
            String apellidoM = textFieldApeM.getText();
            String codigoPostal = textFieldCP.getText();
            String correoElectronico = textFieldCorreo.getText();
            controlador.guardarDatos(nombreUsuario, apellidoP, apellidoM, codigoPostal, correoElectronico);
        });

        // Botón "Regresar"
        Button buttonRegresar = new Button("Regresar");
        buttonRegresar.setPrefSize(300, 70);
        buttonRegresar.setOnAction(e -> regresar());

        // Agregar elementos al GridPane
        gridPane.add(labelSeleccionatuauto, 0, 0);
        gridPane.add(labelNombre, 0, 1);
        gridPane.add(labelApellidoP, 0, 2);
        gridPane.add(labelApellidoM, 0, 3);
        gridPane.add(labelCP, 0, 4);
        gridPane.add(labelCorreo, 0, 5);
        gridPane.add(labelAcuerdo, 0, 6);
        gridPane.add(labelInfo, 5, 0);
        gridPane.add(box, 1, 0);
        gridPane.add(textFieldNombre, 1, 1);
        gridPane.add(textFieldApeP, 1, 2);
        gridPane.add(textFieldApeM, 1, 3);
        gridPane.add(textFieldCP, 1, 4);
        gridPane.add(textFieldCorreo, 1, 5);
        gridPane.add(checkBx, 1, 6);
        gridPane.add(button, 5, 5);
        gridPane.add(buttonRegresar, 5, 6); // Agregar el botón "Regresar"
    }

    // Método para regresar a la pantalla principal (Main)
    private void regresar() {
        try {
            Main main = new Main();
            main.start(mainStage); // Regresar a la escena principal
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

