
package com.emergentes.model;

public class TipoSala {
    private int id;
    private String nombre;
    private String descripcion;
    private int id_administrador;
    private String nombre_administrador;

    public TipoSala() {
    }

    public TipoSala(int id, String nombre, String descripcion, int id_administrador, String nombre_administrador) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id_administrador = id_administrador;
        this.nombre_administrador = nombre_administrador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getNombre_administrador() {
        return nombre_administrador;
    }

    public void setNombre_administrador(String nombre_administrador) {
        this.nombre_administrador = nombre_administrador;
    }
    
    
}
