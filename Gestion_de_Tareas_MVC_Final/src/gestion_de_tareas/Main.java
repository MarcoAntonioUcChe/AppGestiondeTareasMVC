/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_de_tareas;

import Controlador.CtrlTarea;
import Modelo.ConsultasTarea;
import Modelo.Tarea;
import Vista.ReporteHrs;
import Vista.Ventana_Principal;
/**
 * Clase Main que permite inicializar la aplicación
 * @author Marco Uc
 */
public class Main {

    /**
     * Método definido por el lenguage que 
     * permite inicializar los procesos de las clases
     * @param args
     */
    public static void main(String[] args) {
        //Objeto de la clase Módelo Tarea
        Tarea objModeloTarea = new Tarea();
        //Objeto de la clase Módelo ConsultasTarea
        ConsultasTarea objModeloConsultaTarea = new ConsultasTarea();
        //Objeto de la clase vista_Principal
        Ventana_Principal objVentanaPrincipal = new Ventana_Principal();
        //Objeto de la clase Vista ReporteHrs 
        ReporteHrs objVentanaReportes= new ReporteHrs();
       //Objeto de la clase Controlador CtrlTarea
        CtrlTarea ctrl = new CtrlTarea(objModeloTarea, objModeloConsultaTarea, objVentanaPrincipal,objVentanaReportes);
        ctrl.iniciar();
        objVentanaPrincipal.setVisible(true);
        
    }
}
