package Controlador;

import Modelo.ConcultasReporte;
import Modelo.ConsultasTarea;
import Modelo.Tarea;
import Vista.ReporteHrs;
import Vista.Ventana_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marco Uc
 */
public class CtrlReporte  {
    ConcultasReporte objModelConsultaReportes = new ConcultasReporte();
    DecimalFormat formato = new DecimalFormat("#.00");
    DefaultTableModel modelot;
    DefaultTableModel modelot2;
    double tamaño=0;
    String resultado="";
    String porcentaje = "";
     int sumatotal = 0;
      int cabletotal = 0;

    /**
     *
     * @param tablaDatos
     * Metodo que permite llenar la tabla de la vista
       ReporteHrs con las tareas finalizadas
     */
    public void LLenarTabla(JTable tablaDatos){
      
        DefaultTableModel  modeloT = new DefaultTableModel();
       
        ReporteHrs obj=new ReporteHrs();
        tablaDatos.setModel(modeloT);
        
        modeloT.addColumn("Id");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Categoria");
        modeloT.addColumn("Fecha Inicio");
        modeloT.addColumn("Fecha Fin");
        modeloT.addColumn("Tiempo Acumulado");
        modeloT.addColumn("Tiempo Pausado");
        
        Object[] columna = new Object[8];

        int numRegistros = objModelConsultaReportes.listTarea().size();

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = objModelConsultaReportes.listTarea().get(i).getId();
            columna[1] = objModelConsultaReportes.listTarea().get(i).getNombre();
            columna[2] = objModelConsultaReportes.listTarea().get(i).getCategoria();
            columna[3] = objModelConsultaReportes.listTarea().get(i).getFecha_inicio();
            columna[4] = objModelConsultaReportes.listTarea().get(i).getFecha_fin();
            columna[5] = objModelConsultaReportes.listTarea().get(i).getTiempo();
            columna[6] = objModelConsultaReportes.listPausa().get(i).getPausa();
            
            modeloT.addRow(columna);
           
            
        }
        for (int i = 0; i < tablaDatos.getRowCount(); i++) {
            double s = Double.parseDouble(String.valueOf(tablaDatos.getValueAt(i,6)));
            double d = Double.parseDouble(String.valueOf(tablaDatos.getValueAt(i,6)));
           
            
            sumatotal += s;
            
        }
       
        
        obj.txttotal.setText(String.valueOf(sumatotal)+" Hrs");
        obj.txt.setText(String.valueOf(sumatotal)+" Hrs");
        System.out.println(sumatotal);
        JOptionPane.showMessageDialog(null, String.valueOf("00:"+sumatotal)+":00"+" Hrs");
        if (sumatotal==60) {
            obj.txttotal.setText("01"+":00:"+"00");
        }else if(sumatotal>60&&sumatotal<120){
            int x= sumatotal-60;
            obj.txt.setText("01:"+x+":00");
            obj.txt.setText("01:"+"0"+x+":00");
            System.out.println("01:"+"0"+x+":00");
        }
       
    }
 
   
 
    
  }
