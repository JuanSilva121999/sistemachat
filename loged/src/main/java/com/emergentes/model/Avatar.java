
package com.emergentes.model;

import java.sql.Date;

public class Avatar {
    private int id;
    private String nombre;
    private String url;
    private Date fecha_creacion;

    public Avatar() {
    }

    public Avatar(int id, String nombre, String url, Date fecha_creacion) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
        this.fecha_creacion = fecha_creacion;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
}
