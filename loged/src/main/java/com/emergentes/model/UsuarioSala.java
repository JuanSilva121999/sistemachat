package com.emergentes.model;

public class UsuarioSala {
    private int id;
    private int id_sala;
    private int id_usuario;
    private String nombre_sala;
    private String nombre_usuario;

    public UsuarioSala() {
    }

    public UsuarioSala(int id, int id_sala, int id_usuario, String nombre_sala, String nombre_usuario) {
        this.id = id;
        this.id_sala = id_sala;
        this.id_usuario = id_usuario;
        this.nombre_sala = nombre_sala;
        this.nombre_usuario = nombre_usuario;
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

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_sala() {
        return nombre_sala;
    }

    public void setNombre_sala(String nombre_sala) {
        this.nombre_sala = nombre_sala;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    
}
