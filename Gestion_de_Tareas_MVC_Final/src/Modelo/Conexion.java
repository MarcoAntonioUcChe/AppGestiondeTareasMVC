
package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco Uc
 * Clase Conexión, enesta clase se encuentran los metodos
 * que permiten la conexión a MySQL.
 */
public class Conexion {
    
    private final String base = "tarea2";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;
    
    /**
     * Metodo para realizar la conexión a MySQL
     * @return conexión a MySQL
     */
    public Connection getConexion()
    {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            
        } catch(SQLException e)
        {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
      return con;  
    }

    /**
     *Metodo para cerrar un conexión sql
     */
    public void desconectar(){
        con = null;
    }
    
}
