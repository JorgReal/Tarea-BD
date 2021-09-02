package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection miConexion;
    private static final String url = "jdbc:mysql://localhost/empresa";
    private static final String user = "root";
    private static final String password = "";

    public Connection getMiConexion() {
        return miConexion;
    }
    
    public Connection Conectar() {
        try {
            miConexion = (Connection) DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miConexion;
    }

    public void cerrarConexion() {
        try {
            if (miConexion != null) {
                if (miConexion.isClosed() == false) {
                    miConexion.close();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
