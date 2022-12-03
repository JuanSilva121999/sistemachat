package com.emergentes.model;

import java.sql.Date;

public class Sala {

    private int id;
    private int id_sala;
    private Date fecha_creacio;
    private String nombre;
    private String estado;
    private int id_avatar;
    private String nombre_sala;

    public Sala() {
    }

    public Sala(int id, int id_sala, Date fecha_creacio, String nombre, String estado, int id_avatar, String nombre_sala) {
        this.id = id;
        this.id_sala = id_sala;
        this.fecha_creacio = fecha_creacio;
        this.nombre = nombre;
        this.estado = estado;
        this.id_avatar = id_avatar;
        this.nombre_sala = nombre_sala;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public Date getFecha_creacio() {
        return fecha_creacio;
    }

    public void setFecha_creacio(Date fecha_creacio) {
        this.fecha_creacio = fecha_creacio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_avatar() {
        return id_avatar;
    }

    public void setId_avatar(int id_avatar) {
        this.id_avatar = id_avatar;
    }

    public String getNombre_sala() {
        return nombre_sala;
    }

    public void setNombre_sala(String nombre_sala) {
        this.nombre_sala = nombre_sala;
    }
    


    

}
