/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Marco Uc
 */
import Vista.Ventana_Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * Clase categoriaDAO que obtine los datos de la tabla "categoria" en MySQL
 * @author Marco Uc
 */
public class categoriaDAO {
    
    /**
     * Método que obtiene las categorias de la consula MySQL
     * @param box que representa al modelo de combobox de las categorías
     */
    public void listar_departamento(JComboBox box){
        
        DefaultComboBoxModel value;
        Conexion conec = new Conexion();
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;
        try{
            con = conec.getConexion();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM categoria");
            value = new DefaultComboBoxModel();
            box.setModel(value);
            while(rs.next()){
                value.addElement(new categoria(rs.getInt(1),rs.getString(2)));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                st.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){
            }
        }
        
    }
    
    
}
