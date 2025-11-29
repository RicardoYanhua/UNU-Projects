package DataBase;

import Mesaage.ViewItem;
import Util.Glasspanepopup.GlassPanePopup;
import java.sql.Connection;
import java.sql.DriverManager;

public class Data {

    // Datos de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost/Producto";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() {
        Connection conexion = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Obtener la conexión
            if (conexion == null) {
                conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            }
            
            if(conexion == null){
                System.out.println("Error");
            }
        } catch (Exception ex) {

            System.out.println(ex.toString()); // Manejo básico de errores, puedes adaptarlo a tu aplicación
        }
        return conexion;
    }

}
