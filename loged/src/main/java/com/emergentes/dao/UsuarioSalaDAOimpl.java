package com.emergentes.dao;

import com.emergentes.model.UsuarioSala;
import com.emergentes.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioSalaDAOimpl extends ConexionDB implements UsuarioSalaDAO {

    @Override
    public void insert(UsuarioSala usuariosala) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO usuario_sala (ID_USUARIO, ID_SALA) VALUES ( ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, usuariosala.getId_usuario());
            ps.setInt(2, usuariosala.getId_sala());
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al insetar datos  de usuario a sala" + e);
        }
    }

    @Override
    public void update(UsuarioSala usuariosala) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE usuario_sala SET ID_USUARIO = ?, ID_SALA =? WHERE usuario_sala.ID = ?;";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, usuariosala.getId_usuario());
            ps.setInt(2, usuariosala.getId_sala());
            ps.setInt(3, usuariosala.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al modificar datos  de usuario a sala" + e);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM usuario_sala WHERE usuario_sala.ID = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
           
            System.out.println("Error al eliminar datos  de usuario a sala" + e);
        }
    }

    @Override
    public UsuarioSala getById(int id) throws Exception {
        UsuarioSala us = new UsuarioSala();
        try {
            this.conectar();
            String sql = "SELECT * FROM usuario_sala WHERE usuario_sala.id_usuario=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                us.setId(rs.getInt("id"));
                us.setId_usuario(rs.getInt("id_usuario"));
                us.setId_sala(rs.getInt("id_sala"));

            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos usuarioSala" + e);
            throw e;
        }
        return us;
    }

    @Override
    public List<UsuarioSala> getAll() throws Exception {
        List<UsuarioSala> lista = null;
        try {
            this.conectar();
            String sql = "SELECT us.*,u.NOMBRE as usuario, s.NOMBRE as sala FROM usuario_sala us LEFT JOIN usuario u ON us.ID_USUARIO=u.ID LEFT JOIN sala s on us.ID_SALA= s.ID;";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<UsuarioSala>();
            while (rs.next()) {
                UsuarioSala us = new UsuarioSala();
                us.setId(rs.getInt("id"));
                us.setId_usuario(rs.getInt("id_usuario"));
                us.setId_sala(rs.getInt("id_sala"));
                us.setNombre_usuario(rs.getString("usuario"));
                us.setNombre_sala(rs.getString("sala"));
                lista.add(us);

            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos de usuario sala"+e);
        }
        return lista;
    }

    @Override
    public List<UsuarioSala> getSalaPrivada(int i) throws Exception {
        List<UsuarioSala> lista = null;
        try {
            this.conectar();
            String sql = "SELECT us.*,u.NOMBRE as usuario, s.NOMBRE as sala FROM usuario_sala us LEFT JOIN usuario u ON us.ID_USUARIO=u.ID LEFT JOIN sala s on us.ID_SALA= s.ID WHERE u.ID=?;";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<UsuarioSala>();
            while (rs.next()) {
                UsuarioSala us = new UsuarioSala();
                us.setId(rs.getInt("id"));
                us.setId_usuario(rs.getInt("id_usuario"));
                us.setId_sala(rs.getInt("id_sala"));
                us.setNombre_usuario(rs.getString("usuario"));
                us.setNombre_sala(rs.getString("sala"));
                lista.add(us);

            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al obtener datos de usuario sala con id "+e);
        }
        return lista;

    }

}
