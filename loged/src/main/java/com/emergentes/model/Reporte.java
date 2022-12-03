
package com.emergentes.model;


public class Reporte {
    private int id;
    private int id_usuario;
    private int id_reporte;
    private String nombre_usuario;
    private String tipo_reporte;

    public Reporte() {
    }

    public Reporte(int id, int id_usuario, int id_reporte, String nombre_usuario, String tipo_reporte) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_reporte = id_reporte;
        this.nombre_usuario = nombre_usuario;
        this.tipo_reporte = tipo_reporte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_reporte() {
        return id_reporte;
    }

    public void setId_reporte(int id_reporte) {
        this.id_reporte = id_reporte;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getTipo_reporte() {
        return tipo_reporte;
    }

    public void setTipo_reporte(String tipo_reporte) {
        this.tipo_reporte = tipo_reporte;
    }
    
}
