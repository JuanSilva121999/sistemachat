package com.emergentes.model;

/**
 *
 * @author CJ
 */
public class TipoUsuario {
    private int id;
    private String nombre;
    private String descripcion;

    /**private Administrador idAdministrador;**/
    
    public TipoUsuario() {
        this.id = 1;
        this.nombre = "Comun";
        this.descripcion = "Usuario Comun";
    }
    public void TipoUsuarioVacio(){
        this.id = 0;
        this.nombre = "";
        this.descripcion = "";
    }

    public TipoUsuario(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    @Override
    public String toString() {
        return "TipoUsuario{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
    
    
}
