
package com.emergentes.model;

import java.sql.Date;

public class Mensaje {
    private int id;
    private String asunto ;
    private Date fecha_envio;
    private int id_usuario;
    private int id_sala;
    private int id_tipo_mensaje;
    private String estado;
    private String nombre_usuario;
    private String nombre_sala;
    private String tipo_mensaje;

    public Mensaje() {
    }
    
    public Mensaje(int id, String asunto, Date fecha_envio, int id_usuario, int id_sala, int id_tipo_mensaje, String estado, String nombre_usuario, String nombre_sala, String tipo_mensaje) {
        this.id = id;
        this.asunto = asunto;
        this.fecha_envio = fecha_envio;
        this.id_usuario = id_usuario;
        this.id_sala = id_sala;
        this.id_tipo_mensaje = id_tipo_mensaje;
        this.estado = estado;
        this.nombre_usuario = nombre_usuario;
        this.nombre_sala = nombre_sala;
        this.tipo_mensaje = tipo_mensaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public int getId_tipo_mensaje() {
        return id_tipo_mensaje;
    }

    public void setId_tipo_mensaje(int id_tipo_mensaje) {
        this.id_tipo_mensaje = id_tipo_mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getNombre_sala() {
        return nombre_sala;
    }

    public void setNombre_sala(String nombre_sala) {
        this.nombre_sala = nombre_sala;
    }

    public String getTipo_mensaje() {
        return tipo_mensaje;
    }

    public void setTipo_mensaje(String tipo_mensaje) {
        this.tipo_mensaje = tipo_mensaje;
    }
    
}
