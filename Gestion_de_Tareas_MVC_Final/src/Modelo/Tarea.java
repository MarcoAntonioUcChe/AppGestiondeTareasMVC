
package Modelo;

/**
 *
 * @author Marco Uc
 * Clase Tarea que almacena los atributos de una Actividad
 */
public class Tarea {
    
    private int id;
    private String nombre;
    private String fecha_inicio;
    private String fecha_fin;

    /**
     *
     * @return la fecha_fin actual de la actividad
     */
    public String getFecha_fin() {
        return fecha_fin;
    }

    /**
     *
     * @param fecha_fin para almacenar la fech_fin de una actividad
     */
    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    /**
     *
     * @return el tiempo utilizado durante esta actividad
     */
    public String getTiempo() {
        return tiempo;
    }

    /**
     *
     * @param tiempo para almacenar tiempo utilizado durante esta actividad
     */
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    /**
     *
     * @return el las pausas echas durante la ejecución de está actividad
     */
    public String getPausa() {
        return pausa;
    }

    /**
     *
     * @param pausa para almacenar las pausas durante la ejecución de la actividad
     */
    public void setPausa(String pausa) {
        this.pausa = pausa;
    }
    private String tiempo;
    private String pausa;

    /**
     *
     * @return la fecha de inicio de la actividad
     */
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     *
     * @param fecha_inicio para almacenar la fecha de inicio de la actividad
     */
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    private String categoria;

    /**
     *
     * @return la categoria de la actividad actual
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     *
     * @param categoria almacena la categoria de la actividad actual
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     *
     * @return el id de la actividad
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id para almacenar el id de cada actividad
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return el nombre actual de la actividad
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre para almacenar el nombre de la actividad
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
