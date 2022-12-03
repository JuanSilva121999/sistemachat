
package com.emergentes.model;

public class TipoMensaje {
    private int id;
    private String url;
    private String nombre;
    private int id_administrador;
    private String nombre_aministrador;

    public TipoMensaje() {
    }

    public TipoMensaje(int id, String url, String nombre, int id_administrador, String nombre_aministrador) {
        this.id = id;
        this.url = url;
        this.nombre = nombre;
        this.id_administrador = id_administrador;
        this.nombre_aministrador = nombre_aministrador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getNombre_aministrador() {
        return nombre_aministrador;
    }

    public void setNombre_aministrador(String nombre_aministrador) {
        this.nombre_aministrador = nombre_aministrador;
    }
    
}
