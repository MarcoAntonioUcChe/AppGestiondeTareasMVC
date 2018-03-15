/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Clase que almacena los atributos de una categoria
 * @author Marco Uc
 */
public class categoria {

    /**
     *
     * @param id
     * @param nombre para almacenar el nombre actual de una categoria
     */
    public categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    int id;
    String nombre;

    /**
     * Método constructor de la clase categoria
     */
    public categoria() {
        
    }

    /**
     * Método que regresa el id de la actividad
     * @return el id de la categoría
     */
    public int getId() {
        return id;
    }

    /**
     * Método que almacena el id de la actividad
     * @param id para almacenar el id de la categoría
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *  Método que regresa el Nombre de la actividad
     * @return el nombre actual de la actividad
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que almacena el nombre de la actividad
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que regresa el nombre de la actividad como tipo String
     * @return nombre de la actividad
     */
    public String toString(){
        return this.nombre;
    }
}

