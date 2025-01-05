package application.Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
    private static final String URL = "jdbc:mysql://localhost:3306/agencia";
    private static final String USER = "root";
    private static final String PASSWORD = "18112003";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
