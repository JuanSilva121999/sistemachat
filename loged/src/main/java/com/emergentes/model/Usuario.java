package com.emergentes.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


/**
 *
 * @author CJ
 */

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String alias;
    private String nombre;
    private String descripcion;
    private String correoElectronico;
    private LocalDateTime fechaRegistro;
    private LocalDate fechaNacimiento;
    private String usuario;
    private String contrasenia;
    private String estado;
    private TipoUsuario idTipoUsuario;

    public Usuario() {
        this.id = 0;
        this.alias = "";
        this.nombre = "";
        this.descripcion = "";
        this.correoElectronico = "";
        this.fechaRegistro = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        this.fechaNacimiento = LocalDate.now();
        this.usuario = "";
        this.contrasenia = "";
        this.estado = "activo";
        this.idTipoUsuario = new TipoUsuario();
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String alias, String nombre, String correoElectronico, LocalDateTime fechaRegistro, LocalDate fechaNacimiento, String usuario, String contrasenia, String estado, TipoUsuario idTipoUsuario) {
        this.id = id;
        this.alias = alias;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.fechaRegistro = fechaRegistro;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.estado = estado;
        this.idTipoUsuario = idTipoUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoUsuario getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(TipoUsuario idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.model.Usuario[ id=" + id + " ]";
    }
    
}
