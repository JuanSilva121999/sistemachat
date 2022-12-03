package com.emergentes.dao;

import com.emergentes.model.Sala;
import com.emergentes.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SalaDAOimpl extends ConexionDB implements SalaDAO {

    @Override
    public void insert(Sala sala) throws Exception {
        try {
            this.conectar();
            String sql="INSERT INTO sala (ID_TIPO_SALA, FECHA_CREACION, NOMBRE, ID_AVATAR, ESTADO) VALUES (?,CURDATE(),?,?,?);";
            PreparedStatement ps= this.conn.prepareCall(sql);
            ps.setInt(1, sala.getId_sala());
            ps.setString(2, sala.getNombre());
            ps.setInt(3, sala.getId_avatar());
            ps.setString(4, sala.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al insertar datos del sala " + e);
        }
    }

    @Override
    public void update(Sala sala) throws Exception {
        try {
            this.conectar();
            String sql="UPDATE sala SET ID_TIPO_SALA=?,NOMBRE = ?, ID_AVATAR = ?, ESTADO = ? WHERE sala.ID = ?;";
            PreparedStatement ps= this.conn.prepareCall(sql);
            ps.setInt(1, sala.getId_sala());
            ps.setString(2, sala.getNombre());
            ps.setInt(3, sala.getId_avatar());
            ps.setString(4, sala.getEstado());
            ps.setInt(5, sala.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al modificar datos del sala " + e);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql="DELETE FROM sala WHERE sala.ID = ?";
            PreparedStatement ps= this.conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al eliminar datos del sala " + e);
        }
    }

    @Override
    public Sala getById(int id) throws Exception {
        Sala sa=new Sala();
        try {
            this.conectar();
            String sql="SELECT * FROM  sala where id=?";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                sa.setId(rs.getInt("id"));
                sa.setId_sala(rs.getInt("id_tipo_sala"));
                sa.setFecha_creacio(rs.getDate("fecha_creacion"));
                sa.setNombre(rs.getString("nombre"));
                sa.setId_avatar(rs.getInt("id_avatar"));
                sa.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar informacion de sala"+e);
            throw e;
        }
        return sa;
    }

    @Override
    public List<Sala> getAll() throws Exception {
        List <Sala> lista =null;
        try {
            this.conectar();
            String sql="SELECT s.*, ts.NOMBRE as sala, a.NOMBRE as avatar FROM sala s LEFt JOIN tipo_sala ts on s.ID_TIPO_SALA=ts.ID LEFT JOIN avatar a on s.ID_AVATAR = a.ID;";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            lista = new ArrayList<Sala>();
            while(rs.next()){
                Sala sa=new Sala();
                sa.setId(rs.getInt("id"));
                sa.setId_sala(rs.getInt("id_tipo_sala"));
                sa.setFecha_creacio(rs.getDate("fecha_creacion"));
                sa.setNombre(rs.getString("nombre"));
                sa.setId_avatar(rs.getInt("id_avatar"));
                sa.setEstado(rs.getString("estado"));
                sa.setNombre_sala(rs.getString("sala"));
                lista.add(sa);
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            System.out.println("Error al mostrar toda la informacion de Salas"+e);
        }
        return lista;
    }

}
