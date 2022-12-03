package com.emergentes.dao;

import com.emergentes.model.Administrador;
import com.emergentes.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAOimpl extends ConexionDB implements AdministradorDAO {

    @Override
    public void insert(Administrador administrador) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO administrador (USUARIO, CONTRASEÑA) VALUES ( ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, administrador.getUsuario());
            ps.setString(2, administrador.getContraseña());

            ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error al insertar datos del Adminsitrador " + e);
        }
    }

    @Override
    public void update(Administrador administrador) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE administrador SET USUARIO = ?, `CONTRASEÑA` = ? WHERE administrador.ID = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, administrador.getUsuario());
            ps.setString(2, administrador.getContraseña());
            ps.setInt(3, administrador.getId());

            ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error al modificar datos del Adminsitrador " + e);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM administrador WHERE administrador.ID = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar datos del Adminsitrador " + e);
            throw e;
        }
    }

    @Override
    public Administrador getById(int id) throws Exception {
        Administrador admin = new Administrador();
        try {
            this.conectar();
            String sql = "SELECT * FROM administrador WHERE id=?;";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                admin.setId(rs.getInt("id"));
                admin.setUsuario(rs.getString("usuario"));
                admin.setContraseña(rs.getString("contraseña"));
            }
        } catch (Exception e) {
            System.out.println("Error al traer datos " + e);
            throw e;
        }
        return admin;
    }

    @Override
    public List<Administrador> getAll() throws Exception {
        List<Administrador> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM administrador";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Administrador>();
            while (rs.next()) {
                Administrador admin = new Administrador();
                admin.setId(rs.getInt("id"));
                admin.setUsuario(rs.getString("usuario"));
                admin.setContraseña(rs.getString("contraseña"));
                lista.add(admin);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar datos varios " + e);
        }
        return lista;
    }

    @Override
    public List<Administrador> findAllUsuarios() {
        String sql = "SELECT * FROM administrador";
        List<Administrador> lista = null;
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            lista = new ArrayList<Administrador>();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Administrador administrador = new Administrador();
                administrador.setId(rs.getInt("id"));
                administrador.setUsuario(rs.getString("usuario"));
                administrador.setContraseña(rs.getString("contraseña"));

                lista.add(administrador);
            }
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR: " + e.getMessage());
        } finally {

        }
        return lista;
    }

    @Override
    public Administrador findAdministradorById(Administrador administrador) {
        Administrador administradorr = new Administrador();
        String sql = "SELECT * FROM administrador WHERE id = ? ;";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, administrador.getId());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                administradorr.setId(rs.getInt("id"));
                administradorr.setUsuario(rs.getString("usuario"));
                administradorr.setContraseña(rs.getString("contraseña"));
            }

        } catch (Exception e) {
            System.out.println("ERROR AL OBTENER EL REGISTRO: " + e.getMessage());
        } finally {

        }
        return administradorr;
    }

    @Override
    public Administrador findRegistro(Administrador administrador) {
        Administrador administradorr = new Administrador();
        String sql = "SELECT * FROM administrador WHERE usuario = ? AND contraseña = ? ;";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, administrador.getUsuario());
            ps.setString(2, administrador.getContraseña());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                administradorr.setId(rs.getInt("id"));
                administradorr.setUsuario(rs.getString("usuario"));
                administradorr.setContraseña(rs.getString("contraseña"));
            }

        } catch (Exception e) {
            System.out.println("ERROR AL OBTENER EL REGISTRO desde DAO: " + e.getMessage());
        } finally {

        }
        return administradorr;
    }

    @Override
    public void insertAdministrador(Administrador administrador) {
        String sql = "INSERT INTO administrador (usuario, contraseña) "
                + "VALUES (?,?);";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, administrador.getUsuario());
            ps.setString(2, administrador.getContraseña());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar desde DAO: " + e.getMessage());
        }
    }

    @Override
    public void updateAdministrador(Administrador administrador) {
        String sql = "UPDATE administrador SET usuario = ? , contraseña = ? WHERE id = ? ;";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, administrador.getUsuario());
            ps.setString(2, administrador.getContraseña());
            ps.setInt(3, administrador.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar desde DAO: " + e.getMessage());
        }
    }

    @Override
    public void deleteAdministrador(Administrador administrador) {
        String sql = "DELETE FROM administrador WHERE id = ? ;";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, administrador.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR AL ELIMINAR: " + e.getMessage());
        }
    }

}
