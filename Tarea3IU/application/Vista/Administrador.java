package application.Vista;

import application.Main;
import application.Controlador.ControladorAdministrador;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Administrador extends Application {
    private Stage primaryStage; // Usar el primaryStage
    private ControladorAdministrador controlador;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        primaryStage = stage; // Guardamos la referencia del Stage principal
        controlador = new ControladorAdministrador();

        GridPane gridPane = crearLayout();
        agregarControles(gridPane);

        Scene scene = new Scene(gridPane, 700, 500);
        primaryStage.setTitle("Administrador de Usuarios");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane crearLayout() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(15);
        gridPane.setHgap(15);
        return gridPane;
    }

    private void agregarControles(GridPane gridPane) {
        // Campos de entrada para el nuevo usuario
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");

        TextField txtApellidoP = new TextField();
        txtApellidoP.setPromptText("Apellido Paterno");

        TextField txtApellidoM = new TextField();
        txtApellidoM.setPromptText("Apellido Materno");

        TextField txtCP = new TextField();
        txtCP.setPromptText("Código Postal");

        TextField txtCorreo = new TextField();
        txtCorreo.setPromptText("Correo Electrónico");

        // Botón para guardar usuario
        Button btnGuardar = new Button("Guardar Trabajador");
        btnGuardar.setOnAction(e -> {
            controlador.guardarUsuario(
                txtNombre.getText(),
                txtApellidoP.getText(),
                txtApellidoM.getText(),
                txtCP.getText(),
                txtCorreo.getText()
            );
            limpiarCampos(txtNombre, txtApellidoP, txtApellidoM, txtCP, txtCorreo);
        });

        // Botón para consultar usuarios
        Button btnConsultar = new Button("Consultar Trabajadores");
        btnConsultar.setOnAction(e -> controlador.consultarUsuario());
        
        // Botón para consultar usuarios
        Button btnConsultar2 = new Button("Consultar Clientes");
        btnConsultar2.setOnAction(e -> controlador.consultarUsuario2());

        // Campo de entrada y botón para eliminar usuario por correo
        TextField txtCorreoEliminar = new TextField();
        txtCorreoEliminar.setPromptText("Introduce Correo");

        Button btnEliminar = new Button("Eliminar Trabajador");
        btnEliminar.setOnAction(e -> controlador.eliminarUsuario(txtCorreoEliminar.getText()));
        
        Button btnEliminar2 = new Button("Eliminar Cliente");
        btnEliminar2.setOnAction(e -> controlador.eliminarUsuario2(txtCorreoEliminar.getText()));

        // Nuevo botón para generar gráfica
        Button btnGenerarGrafica = new Button("Generar Gráfica de Interes de Autos");
        btnGenerarGrafica.setOnAction(e -> controlador.generarGraficaCP());

        // NUEVOS TextFields para los códigos postales (del 1 al 6) y el botón asociado
        TextField txtCP1 = new TextField();
        txtCP1.setPromptText("Código Postal 1 (1-6)");

        TextField txtCP2 = new TextField();
        txtCP2.setPromptText("Código Postal 2 (1-6)");

        // Botón para generar la gráfica desde los códigos postales ingresados
        Button btnGenerarGraficaCP = new Button("Generar Gráfica por CP");
        btnGenerarGraficaCP.setOnAction(e -> controlador.generarGraficaDesdeTextFields(txtCP1, txtCP2));

        // Crear el botón "Regresar"
        Button buttonRegresar = new Button("Regresar");
        buttonRegresar.setPrefSize(100, 50);
        buttonRegresar.setOnAction(e -> regresar());

        // Agregar controles al GridPane
        gridPane.add(new Label("Datos del Usuario:"), 0, 0, 2, 1);
        gridPane.add(txtNombre, 0, 1);
        gridPane.add(txtApellidoP, 1, 1);
        gridPane.add(txtApellidoM, 0, 2);
        gridPane.add(txtCP, 1, 2);
        gridPane.add(txtCorreo, 0, 3);

        gridPane.add(btnGuardar, 1, 3);
        
        gridPane.add(new Label("Consulta:"), 0, 4);
        gridPane.add(btnConsultar, 0, 5);
        gridPane.add(btnConsultar2, 1, 5);

        gridPane.add(new Label("Eliminar Usuario:"), 0, 6);
        gridPane.add(txtCorreoEliminar, 0, 7);
        gridPane.add(btnEliminar, 1, 7);
        gridPane.add(btnEliminar2, 2, 7);

        gridPane.add(new Label("Graficas de Interes:"), 0, 8);
        gridPane.add(btnGenerarGrafica, 0, 9, 2, 1);

        // NUEVO bloque para los códigos postales y generar gráfica
        gridPane.add(new Label("Generar Gráfica por Código Postal:"), 0, 10);
        gridPane.add(txtCP1, 0, 11);
        gridPane.add(txtCP2, 1, 11);
        gridPane.add(btnGenerarGraficaCP, 0, 12, 2, 1);

        // Colocar el botón "Regresar" en la esquina superior derecha
        GridPane.setConstraints(buttonRegresar, 2, 0);
        gridPane.add(buttonRegresar, 2, 0);
    }

    private void limpiarCampos(TextField... campos) {
        for (TextField campo : campos) {
            campo.clear();
        }
    }

    // Método para regresar a la pantalla principal (Main)
    private void regresar() {
        try {
            // Verificar si el primaryStage está presente antes de intentar cerrarlo
            if (primaryStage != null) {
                primaryStage.close(); // Cerrar la ventana de administrador
            }

            // Iniciar la clase Main y mostrar la pantalla principal
            Main main = new Main();
            main.start(new Stage()); // Crear una nueva ventana para la pantalla principal

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarGrafica(String[] categorias, int[] valores) {
        // Crear un gráfico de barras
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        // Establecer los valores en las barras
        xAxis.setLabel("BMW M8         Corvette C8         BMW M3         Porsche GT3         Audi A1         Fiat 500");
        yAxis.setLabel("Cantidad de Usuarios");

        // Crear las series de datos
        BarChart.Series<String, Number> series = new BarChart.Series<>();
        for (int i = 0; i < categorias.length; i++) {
            series.getData().add(new BarChart.Data<>(categorias[i], valores[i]));
        }

        barChart.getData().add(series);

        // Mostrar el gráfico en una nueva ventana
        Stage chartStage = new Stage();
        chartStage.setTitle("Gráfica de Usuarios por CP");
        chartStage.setScene(new Scene(barChart, 600, 400));
        chartStage.show();
    }
}
