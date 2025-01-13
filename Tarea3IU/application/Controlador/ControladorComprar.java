package application.Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ControladorComprar {

    // Método para guardar los datos en la base de datos
    public void guardarDatos(String nombreUsuario, String apellidoP, String apellidoM, String codigoPostal, String correoElectronico) {
        String url = "jdbc:mysql://localhost:3306/agencia";
        String user = "root";
        String password = "thegoku37";
        
        String query = "INSERT INTO contactos (nombre, apellidop, apellidom, cp, correo) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nombreUsuario);
            statement.setString(2, apellidoP);
            statement.setString(3, apellidoM);
            statement.setString(4, codigoPostal);
            statement.setString(5, correoElectronico);

            statement.executeUpdate();
            System.out.println("Datos guardados correctamente.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
