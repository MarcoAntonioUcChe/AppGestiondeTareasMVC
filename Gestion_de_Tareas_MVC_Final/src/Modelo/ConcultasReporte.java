/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Vista.ReporteHrs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Marco Uc
 */
public class ConcultasReporte extends Conexion {
    
    /**
     *
     * @return Lista de tareas Activas
     */
    public ArrayList<Tarea> listTarea(){
        ArrayList listaTarea = new ArrayList();
        Tarea tarea;
        try {
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(""
            + "SELECT tarea.id, tarea.nombre,tarea.fecha_inicio,"
            + "tarea.fecha_fin,categoria.nombre,\n" +
            " SUM(pausa.tiempo)AS Tiempo\n" +
            " FROM tarea \n" +
            " INNER JOIN categoria on tarea.categoria_id="
            + "categoria.idcategoria\n" +
            " INNER JOIN pausa on tarea.id=pausa.tarea_id\n" +
            " where tarea.status_id=0 GROUP BY tarea.id;");
     
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tarea = new Tarea();
                
                 tarea.setId(rs.getInt(1));
                 tarea.setNombre(rs.getString(2));
                 tarea.setFecha_inicio(rs.getString(3));
                 tarea.setFecha_fin(rs.getString(4));
                 tarea.setCategoria(rs.getString(5));
                 tarea.setTiempo(rs.getString(6));
                listaTarea.add(tarea);
            }
        } catch (Exception e) {
        }
        return listaTarea;
       
    }    

    /**
     *
     * @return Lista de timepos pausados por cada Actividad
     */
    public ArrayList<Tarea> listPausa(){
        ArrayList listaTarea = new ArrayList();
        Tarea tarea;
        try {
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(""
              + "SELECT  SUM(tiempo_pausa.tiempo) AS Pausa\n" +
                " FROM tiempo_pausa INNER JOIN tarea  ON tarea.id "
              + "= tiempo_pausa.id_tarea\n" +
                " where tarea.status_id=0 GROUP BY tarea.id;");
     
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tarea = new Tarea();
                
                 tarea.setPausa(rs.getString(1));
                listaTarea.add(tarea);
            }
        } catch (Exception e) {
        }
        return listaTarea;
    } 
}
