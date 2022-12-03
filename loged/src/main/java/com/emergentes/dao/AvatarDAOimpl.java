package com.emergentes.dao;

import com.emergentes.model.Avatar;
import com.emergentes.utils.ConexionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvatarDAOimpl extends ConexionDB implements AvatarDAO {

    @Override
    public void insert(Avatar avatar) throws Exception {

        try {
            this.conectar();
            String sql = "INSERT INTO avatar ( NOMBRE, URL, fecha_creacion) VALUES (?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, avatar.getNombre());
            ps.setString(2, "#");
            ps.setDate(3, avatar.getFecha_creacion());
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al insertar datos del Avatar " + e);
        }
    }

    @Override
    public void update(Avatar avatar) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE avatar SET NOMBRE = ?, URL = ?, `fecha_creacion` = ? WHERE avatar.ID = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, avatar.getNombre());
            ps.setString(2, "#");
            ps.setDate(3, avatar.getFecha_creacion());
            ps.setInt(4, avatar.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al modificar datos del Avatar " + e);
        }

    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql="DELETE FROM avatar WHERE avatar.ID = ?";
            PreparedStatement ps =this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar datos del Avatar "+e);
            throw e;
        }
    }

    @Override
    public Avatar getById(int id) throws Exception {
        Avatar ava= new Avatar();
        try {
            this.conectar();
            String sql="SELECT * FROM avatar WHERE id=?";
            PreparedStatement ps= this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                ava.setId(rs.getInt("id"));
                ava.setNombre(rs.getString("nombre"));
                ava.setUrl(rs.getString("url"));
                ava.setFecha_creacion(rs.getDate("fecha_creacion"));
            }
            
        }  catch (Exception e) {
            System.out.println("Error al consultar datos del Avatar "+e);
            throw e;
        }
        return ava;
    }

    @Override
    public List<Avatar> getAll() throws Exception {
        List<Avatar> lista = null;
        try {
            this.conectar();
            String sql="SELECT * FROM avatar";
            PreparedStatement ps= this.conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            lista=new ArrayList<Avatar>();
            while(rs.next()){
                Avatar ava= new Avatar();
                ava.setId(rs.getInt("id"));
                ava.setNombre(rs.getString("nombre"));
                ava.setUrl(rs.getString("url"));
                ava.setFecha_creacion(rs.getDate("fecha_creacion"));
                lista.add(ava);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar datos varios de avatar"+e);
        }
        return lista;
    }

}
