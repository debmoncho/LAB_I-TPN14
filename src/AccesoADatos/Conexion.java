
package AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static String url = "jdbc:mysql://localhost/gestionulp";
    private static String usuario = "root";
    private static String password = "";

    private static Conexion conexion = null;

    // Carga de drivers
    private Conexion() {

        try {

            Class.forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, "Error al cargar el driver. Error: " + ex.getMessage());
            ex.printStackTrace();

        }
    }

    // conexion a base de datos
    public static Connection getConexion() {

        Connection con = null;

        if (conexion == null) {

            conexion = new Conexion();
        }
        try {

            // Setup the connection with the DB
            con = DriverManager.getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + usuario + "&password=" + password);

        } catch (SQLException ex) {

            int error = ex.getErrorCode();
            /* Para saber el numero de error que puedo tener en
            la ejecucion del codigo y buscarlos en la tabla de errores de sql*/

            JOptionPane.showMessageDialog(null, "Error de conexion a base de datos. Error: " + ex.getMessage());

            System.out.println("Codigo de error: " + error);

            ex.printStackTrace();
        }

        return con;
    }
    
}
