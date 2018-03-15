package Controlador;
/**
 * @autor Marco Antonio Uc Che
 */
import Modelo.ConsultasTarea;
import Modelo.Tarea;
import Modelo.categoria;
import Modelo.categoriaDAO;
import Vista.ReporteHrs;
import Vista.Ventana_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 * @author Marco UC
 * @version 3.1.1
 */
public class CtrlTarea extends MouseAdapter implements ActionListener{
    
    //Crea una instancia objModeloCategoriaDAO la clase Tarea Llamado "objModeloTarea"
    private Tarea objModeloTarea;
    //Crea una instancia objModeloCategoriaDAO la clase ConculaTarea Llamado "objModeloConsultaTarea"
    private ConsultasTarea objModeloConsultaTarea;
    //Crea una instancia objModeloCategoriaDAO la clase Ventana_Principal Llamado "objVentanaPrincipal"
    private Ventana_Principal objVentanaPrincipal;
    private ReporteHrs objVentanaReportes;
    //El constructor inicializa los objetos objModeloCategoriaDAO las clases instanciadas

    /**
     *
     * @param objModeloTarea permite instanciar desde el método constructor de
     * de la clase el objeto de la clase "Tarea".
     * @param objModeloConsultaTarea permite instanciar desde el método constructor de
     * de la clase el objeto de la clase "ConsultasTarea".
     * @param objVentanaPrincipal permite instanciar desde el método constructor de
     * de la clase el objeto de la clase "Ventana_Principal".
     * @param objVentanaReportes permite instanciar desde el método constructor de
     * de la clase el objeto de la clase "ReportesHrs".
     */
    public CtrlTarea(Tarea objModeloTarea, ConsultasTarea objModeloConsultaTarea,
            Ventana_Principal objVentanaPrincipal, ReporteHrs objVentanaReportes) {
        this.objModeloTarea = objModeloTarea;
        this.objModeloConsultaTarea = objModeloConsultaTarea;
        this.objVentanaPrincipal = objVentanaPrincipal;
        this.objVentanaReportes=objVentanaReportes;
        this.objVentanaPrincipal.btnGuardar.addActionListener(this);
        this.objVentanaPrincipal.btnFinalizar.addActionListener(this);
        this.objVentanaPrincipal.btnIniciar.addActionListener(this);
        this.objVentanaPrincipal.btnPausar.addActionListener(this);
        this.objVentanaPrincipal.btnVer.addActionListener(this);
        this.objVentanaPrincipal.jtDatos.addMouseListener(this);
        this.objVentanaPrincipal.cmbxcat.addActionListener(actionListener);
    }
   
    /**
     * Método que desactiva los botones de la ventana principal
     * al ejecutarse la aplicación
     */
    public void iniciar() {
        objVentanaPrincipal.setTitle("Tareas");
        objVentanaPrincipal.setLocationRelativeTo(null);
        objVentanaPrincipal.btnIniciar.setEnabled(false);
        objVentanaPrincipal.btnPausar.setEnabled(false);
        objVentanaPrincipal.btnFinalizar.setEnabled(false);
        t = new Timer(10, acciones);
    }
    ConsultasTarea objModelConsTarea = new ConsultasTarea();

    /**
     * Método contructor de la clase
     */
    public CtrlTarea() {
    }
    /**
     * Objeto de la libreria Timer llamada "t"
     */
    private Timer t;
    /**
     * Variables définidas para almacenar los datos de tiempo
     * h para horas, m para minutos, s para segundos y cs para microsegundos
     */
    public int h,m,s,cs;
    /**
     * Método de la clase Timer para ejecutar el reloj utilizado durante la 
     * Ejecución de cada actividad
     */
  private ActionListener acciones = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent ae) {
            ++cs; 
            if(cs==100){
                cs = 0;
                ++s;
            }
            if(s==60) 
            {
                s = 0;
                ++m;
            }
            if(m==60)
            {
                m = 0;
                ++h;
            }
        
                actualizarLabel();
        
        }
        
    };
    /**
     * Método que permite ir actualizando el cronometro de la clase Vista_Principal
     */
    private void actualizarLabel() {      
        String tiempo2 = (h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s;
        objVentanaPrincipal.etiquetatiempo.setText(tiempo2);  
    }

    /**
     * Método que crea un TableModel para la VistaPrincipal
     * @param tablaD que representa al modelo de la tabla de categorias
     */
    public void LLenarTabla(JTable tablaD){
        DefaultTableModel  modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Id");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Categoria");
        
        Object[] columna = new Object[5];

        int numRegistros = objModelConsTarea.listTarea().size();

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = objModelConsTarea.listTarea().get(i).getId();
            columna[1] = objModelConsTarea.listTarea().get(i).getNombre();
            columna[2] = objModelConsTarea.listTarea().get(i).getCategoria();
            modeloT.addRow(columna);
        }
    }

    /**
     * Método que Envia al Combobox de categorías las categorías
     */
    public void llenar(){
        Ventana_Principal obj=new Ventana_Principal();
        categoria d_vo = (categoria)obj.cmbxcat.getSelectedItem();
        int id_de = d_vo.getId();
        String n = d_vo.getNombre();
        
        
    }
 

    /**
     * Método que obtiene el indíce la lista del combo box
     */
    int idcat;
    public void obteneridcat(){
         idcat=objVentanaPrincipal.cmbxcat.getSelectedIndex()+1;
    }  

    /**
     *
     * @param e Es el evento principa que permite a los botones de la clase
     * Vista_Principal poder ejecutar acciones cuando estos sean presionados
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == objVentanaPrincipal.btnGuardar) {
            objModeloTarea.setNombre(objVentanaPrincipal.txtNombre.getText());
            objVentanaPrincipal.txtNombre.setText("");
            obteneridcat();
            if(objModeloConsultaTarea.registrar(objModeloTarea,idcat)){
                JOptionPane.showMessageDialog(null, "Tarea Guardada"); 
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
                 LLenarTabla(objVentanaPrincipal.jtDatos);
        }
       
        if(e.getSource()==objVentanaPrincipal.btnPausar){
            t.stop();
            objVentanaPrincipal.btnIniciar.setEnabled(true);
            objVentanaPrincipal.btnPausar.setEnabled(false);
            objVentanaPrincipal.btnFinalizar.setEnabled(false);
            objModeloConsultaTarea.registrar_Tiempo(m,objVentanaPrincipal.id);
            h=0; m=0; s=0; cs=0;
            t.start();
        }
        
        if(e.getSource()==objVentanaPrincipal.btnIniciar){
            t.stop();
            objModeloConsultaTarea.registrar_Pausa(m,objVentanaPrincipal.id);
            h=0; m=0; s=0; cs=0;
            t.start();
            objVentanaPrincipal.btnIniciar.setEnabled(false);
            objVentanaPrincipal.btnIniciar.setText("Reanudar");
            objVentanaPrincipal.btnPausar.setEnabled(true);
            objVentanaPrincipal.btnFinalizar.setEnabled(true);
        }
        
        if(e.getSource()==objVentanaPrincipal.btnFinalizar){
            if(t.isRunning()){
            t.stop();
            objVentanaPrincipal.btnIniciar.setEnabled(true);
            }
            objVentanaPrincipal.btnIniciar.setText("Iniciar");
            objVentanaPrincipal.btnPausar.setEnabled(false);
            objVentanaPrincipal.btnFinalizar.setEnabled(false);
            h=0; m=0; s=0; cs=0;
            actualizarLabel();
                objModeloConsultaTarea.Cambiar_Status(objVentanaPrincipal.id);
                LLenarTabla(objVentanaPrincipal.jtDatos);
                limpiar();
        }
        
        if(e.getSource()==objVentanaPrincipal.btnVer){
            CtrlReporte obj=new CtrlReporte();
            objVentanaReportes.setVisible(true);
            obj.LLenarTabla(objVentanaReportes.jtDatos2);
        
        }
        
        }

  
    /**
     *Método que limpia los textos de la Vista_Principal seleccionar una nueva
     * actividad.
     */
    public void limpiar(){
        objVentanaPrincipal.txtIdtarea.setText("");
        objVentanaPrincipal.txtNombretarea.setText("");
    }
 
   /**
    * Método que ejecuta los eventos al seleccionar una opcion del Combobox de 
    * categorás en la clase Vista_Principal.
    */  
    ActionListener actionListener = new ActionListener() {
  public void actionPerformed(ActionEvent actionEvent) { 
       objVentanaPrincipal.cmbxcat.getSelectedItem(); 
        objVentanaPrincipal.cmbxcat.getSelectedIndex(); 
  }
    };
   }
