package application.Controlador;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TextField;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import java.sql.*;
import java.util.Optional;
import application.Vista.Administrador;

public class ControladorAdministrador {

    private static String MASTER_PASSWORD = "1234"; // Contraseña maestra

    // Verificar contraseña antes de ejecutar acciones
    private boolean verificarContraseña() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Verificación de Seguridad");
        dialog.setHeaderText("Acceso Restringido");
        dialog.setContentText("Por favor, ingrese la contraseña maestra:");

        Optional<String> resultado = dialog.showAndWait();
        return resultado.isPresent() && resultado.get().equals(MASTER_PASSWORD);
    }

    public void guardarUsuario(String nombre, String apellidoP, String apellidoM, String codigoPostal, String correo) {
        if (verificarContraseña()) {
            String query = "INSERT INTO Administradores (nombre, apellidop, apellidom, cp, correo) VALUES (?, ?, ?, ?, ?)";
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "thegoku37");
                 PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setString(1, nombre);
                statement.setString(2, apellidoP);
                statement.setString(3, apellidoM);
                statement.setString(4, codigoPostal);
                statement.setString(5, correo);

                statement.executeUpdate();
                mostrarAlerta("Usuario guardado correctamente.", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                mostrarAlerta("Error al guardar el usuario: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            mostrarAlerta("Contraseña incorrecta. Operación cancelada.", Alert.AlertType.WARNING);
        }
    }

    public void consultarUsuario() {
        if (verificarContraseña()) {
            String query = "SELECT * FROM Administradores";
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "thegoku37");
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                StringBuilder resultadoConsulta = new StringBuilder();
                while (resultSet.next()) {
                    resultadoConsulta.append("ID: ").append(resultSet.getInt("id"))
                            .append(", Nombre: ").append(resultSet.getString("nombre"))
                            .append(", Apellido Paterno: ").append(resultSet.getString("apellidop"))
                            .append(", Apellido Materno: ").append(resultSet.getString("apellidom"))
                            .append(", CP: ").append(resultSet.getString("cp"))
                            .append(", Correo: ").append(resultSet.getString("correo"))
                            .append("\n");
                }

                mostrarAlerta(resultadoConsulta.toString(), Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                mostrarAlerta("Error al consultar usuarios: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            mostrarAlerta("Contraseña incorrecta. Operación cancelada.", Alert.AlertType.WARNING);
        }
    }

    public void consultarUsuario2() {
        if (verificarContraseña()) {
            String query = "SELECT * FROM contactos";
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "thegoku37");
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                StringBuilder resultadoConsulta = new StringBuilder();
                while (resultSet.next()) {
                    resultadoConsulta.append("ID: ").append(resultSet.getInt("id"))
                            .append(", Nombre: ").append(resultSet.getString("nombre"))
                            .append(", Apellido Paterno: ").append(resultSet.getString("apellidop"))
                            .append(", Apellido Materno: ").append(resultSet.getString("apellidom"))
                            .append(", CP: ").append(resultSet.getString("cp"))
                            .append(", Correo: ").append(resultSet.getString("correo"))
                            .append("\n");
                }

                mostrarAlerta(resultadoConsulta.toString(), Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                mostrarAlerta("Error al consultar usuarios: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            mostrarAlerta("Contraseña incorrecta. Operación cancelada.", Alert.AlertType.WARNING);
        }
    }

    public void eliminarUsuario(String correo) {
        if (verificarContraseña()) {
            String query = "DELETE FROM Administradores WHERE correo = ?";
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "thegoku37");
                 PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setString(1, correo);
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    mostrarAlerta("Usuario eliminado correctamente.", Alert.AlertType.INFORMATION);
                } else {
                    mostrarAlerta("No se encontró ningún usuario con el correo proporcionado.", Alert.AlertType.WARNING);
                }
            } catch (Exception e) {
                mostrarAlerta("Error al eliminar el usuario: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            mostrarAlerta("Contraseña incorrecta. Operación cancelada.", Alert.AlertType.WARNING);
        }
    }

    public void eliminarUsuario2(String correo) {
        if (verificarContraseña()) {
            String query = "DELETE FROM contactos WHERE correo = ?";
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "thegoku37");
                 PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setString(1, correo);
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    mostrarAlerta("Usuario eliminado correctamente.", Alert.AlertType.INFORMATION);
                } else {
                    mostrarAlerta("No se encontró ningún usuario con el correo proporcionado.", Alert.AlertType.WARNING);
                }
            } catch (Exception e) {
                mostrarAlerta("Error al eliminar el usuario: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            mostrarAlerta("Contraseña incorrecta. Operación cancelada.", Alert.AlertType.WARNING);
        }
    }

    // Método original para generar la gráfica de CP
    public void generarGraficaCP() {
        if (verificarContraseña()) {
            String[] cpCategorias = {"1", "2", "3", "4", "5", "6"};
            int[] cpValores = new int[6];
            String query = "SELECT cp, COUNT(*) AS cantidad FROM contactos WHERE cp IN ('1', '2', '3', '4', '5', '6') GROUP BY cp";

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "thegoku37");
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    String cp = resultSet.getString("cp");
                    int cantidad = resultSet.getInt("cantidad");

                    // Actualizar los valores de CP
                    switch (cp) {
                        case "1": cpValores[0] = cantidad; break;
                        case "2": cpValores[1] = cantidad; break;
                        case "3": cpValores[2] = cantidad; break;
                        case "4": cpValores[3] = cantidad; break;
                        case "5": cpValores[4] = cantidad; break;
                        case "6": cpValores[5] = cantidad; break;
                    }
                }

                // Mostrar la gráfica con los valores
                Platform.runLater(() -> {
                    Administrador adminVista = new Administrador();
                    adminVista.mostrarGrafica(cpCategorias, cpValores);
                });
            } catch (Exception e) {
                mostrarAlerta("Error al generar la gráfica: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            mostrarAlerta("Contraseña incorrecta. Operación cancelada.", Alert.AlertType.WARNING);
        }
    }

    // Nuevo método para generar la gráfica desde los TextFields
    public void generarGraficaDesdeTextFields(TextField txtCP1, TextField txtCP2) {
        if (verificarContraseña()) {
            try {
                int cp1 = Integer.parseInt(txtCP1.getText());
                int cp2 = Integer.parseInt(txtCP2.getText());

                if (cp1 < 1 || cp1 > 6 || cp2 < 1 || cp2 > 6) {
                    mostrarAlerta("Los códigos postales deben estar entre 1 y 6.", Alert.AlertType.WARNING);
                    return;
                }

                String[] cpCategorias = {String.valueOf(cp1), String.valueOf(cp2)};
                int[] cpValores = new int[2];
                String query = "SELECT cp, COUNT(*) AS cantidad FROM contactos WHERE cp IN (?, ?) GROUP BY cp";

                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "thegoku37");
                     PreparedStatement statement = connection.prepareStatement(query)) {

                    statement.setInt(1, cp1);
                    statement.setInt(2, cp2);
                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        String cp = resultSet.getString("cp");
                        int cantidad = resultSet.getInt("cantidad");

                        if (cp.equals(String.valueOf(cp1))) {
                            cpValores[0] = cantidad;
                        } else if (cp.equals(String.valueOf(cp2))) {
                            cpValores[1] = cantidad;
                        }
                    }

                    // Mostrar la gráfica con los valores
                    Platform.runLater(() -> {
                        Administrador adminVista = new Administrador();
                        adminVista.mostrarGrafica(cpCategorias, cpValores);
                    });
                }
            } catch (Exception e) {
                mostrarAlerta("Error al generar la gráfica: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            mostrarAlerta("Contraseña incorrecta. Operación cancelada.", Alert.AlertType.WARNING);
        }
    }

    // Mostrar alertas en JavaFX
    private void mostrarAlerta(String mensaje, Alert.AlertType tipo) {
        Platform.runLater(() -> {
            Alert alert = new Alert(tipo);
            alert.setTitle("Resultado de la Operación");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
        });
    }
}
