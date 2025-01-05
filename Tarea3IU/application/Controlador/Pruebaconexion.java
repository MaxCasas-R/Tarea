package application.Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Pruebaconexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/agencia";
        String user = "root";
        String password = "18112003";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("¡Conexión exitosa!");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos:");
            e.printStackTrace();
        }
    }

}
