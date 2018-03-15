package Modelo;

import Vista.Ventana_Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Marco Uc
 * Clase que permite ejecutar las acciones que solicite la clase controlador
 * "CtrlTarea".
 */
public class ConsultasTarea extends Conexion {

    /**
     *
     * @param tarea
     * @param idcat
     * @return valor booleano
     * Método que permite guardar a la base dedatos una nueva tarea
     */
    public boolean registrar(Tarea tarea,int idcat) {
       PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO tarea (nombre,categoria_id,fecha_inicio ) "
                + "VALUES(?,?,now())";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tarea.getNombre());
            ps.setInt(2, idcat);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    /**
     *
     * @return La lista de tareas
     * Método que llama a la vista V_Tareas de la base de datos
     */
    public ArrayList<Tarea> listTarea(){
        ArrayList listaTarea = new ArrayList();
        Tarea tarea;
        try {
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement("select * from V_Tareas");
     
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tarea = new Tarea();
                
                 tarea.setId(rs.getInt(1));
                 tarea.setNombre(rs.getString(2));
                 tarea.setFecha_inicio(rs.getString(3));
                 tarea.setCategoria(rs.getString(4));
                listaTarea.add(tarea);
            }
        } catch (Exception e) {
        }
        return listaTarea;
    } 
    
    /**
     *
     * @param tiempo
     * @param id
     * @return valor booleano para comprobar la conexión a MySQL
     * Método que registra el tiempo en el cual una tarea se esta realizando.
     */
    public boolean registrar_Tiempo(int tiempo,int id) {
       Ventana_Principal frm=new Ventana_Principal();
       
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO pausa (tiempo,tarea_id ) VALUES(?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tiempo);
            ps.setInt(2,id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    /**
     *
     * @param tiempo
     * @param id de la actividad
     * @return valor booleano para comprobar la conexión a MySQL
     * Método que permite registrar los tiempos de pausa en los que se detiene 
     * una actividad
     */
    public boolean registrar_Pausa(int tiempo,int id) {
       Ventana_Principal frm=new Ventana_Principal();
    
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO tiempo_pausa (tiempo,id_tarea ) VALUES(?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tiempo);
            ps.setInt(2,id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
   
    /**
     *
     * @param id
     * @return valor booleano para comprobar la conexión a MySQL
     * Método que cambia el estatus de una actividad cuando se esta se
     * marca como finalizadó
     */
    public boolean Cambiar_Status(int id) {
       Ventana_Principal frm=new Ventana_Principal();
       
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE tarea set status_id=0,fecha_fin=now() WHERE id=(?)";
      

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
   
    /**
     *
     * @param id
     * @return valor booleano para comprobar la conexión a MySQL
     * Método que actualiza la fecha de inicio de una actividad cuando está se
     * inicia por primera vez.
     */
    public boolean Cambiar_fechaInicio(int id) {
       Ventana_Principal frm=new Ventana_Principal();
       
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE tarea set fecha_inicio=now() WHERE id=(?)";
      

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
