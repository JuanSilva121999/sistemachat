package com.emergentes.dao;

import com.emergentes.model.Mensaje;
import com.emergentes.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MensajeDAOimpl extends ConexionDB implements MensajeDAO {

    @Override
    public void insert(Mensaje mensaje) throws Exception {
        try {
            this.conectar();
            String sql="INSERT INTO mensaje (ASUNTO, FECHA_ENVIO, ID_USUARIO, ID_TIPO_MENSAJE, ID_SALA, ESTADO) VALUES (?,CURDATE(),?,?,?,?)";
            PreparedStatement ps= this.conn.prepareStatement(sql);
            ps.setString(1, mensaje.getAsunto());
            ps.setInt(2,mensaje.getId_usuario());
            ps.setInt(3,mensaje.getId_tipo_mensaje());
            ps.setInt(4, mensaje.getId_sala());
            ps.setString(5, mensaje.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al insertar datos del Mensaje " + e);
        }

    }

    @Override
    public void update(Mensaje mensaje) throws Exception {
                try {
            this.conectar();
            String sql="UPDATE mensaje SET ASUNTO = ?, FECHA_ENVIO = ?,ID_USUARIO=?, ID_TIPO_MENSAJE = ?, ID_SALA=?,ESTADO = ? WHERE mensaje.ID = ?;";
            PreparedStatement ps= this.conn.prepareStatement(sql);
            ps.setString(1, mensaje.getAsunto());
            ps.setDate(2,mensaje.getFecha_envio());
            ps.setInt(3,mensaje.getId_usuario());
            ps.setInt(4,mensaje.getId_tipo_mensaje());
            ps.setInt(5, mensaje.getId_sala());
            ps.setString(6, mensaje.getEstado());
            ps.setInt(7, mensaje.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al modificar datos del Mensaje " + e);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql="DELETE FROM mensaje WHERE mensaje.ID = ?";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
            System.out.println("Error al eliminar datos del Mensaje " + e);
        }
    }

    @Override
    public Mensaje getById(int id) throws Exception {
        Mensaje men=new Mensaje();
        try {
            this.conectar();
            String sql="SELECT * FROM mensaje WHERE id=?";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                men.setId(rs.getInt("id"));
                men.setAsunto(rs.getString("asunto"));
                men.setFecha_envio(rs.getDate("fecha_envio"));
                men.setId_usuario(rs.getInt("id_usuario"));
                men.setId_tipo_mensaje(rs.getInt("id_tipo_mensaje"));
                men.setId_sala(rs.getInt("id_sala"));
                men.setEstado(rs.getString("estado"));
                
            }
        }  catch (Exception e) {
            System.out.println("Error al consultar datos del Mensaje "+e);
            throw e;
        }
        return men;
    }

    @Override
    public List<Mensaje> getAll() throws Exception {
        List<Mensaje> lista=null;
        try {
            this.conectar();
            String sql="SELECT m.*,u.NOMBRE as usuario, s.NOMBRE as sala, tm.NOMBRE as tipo FROM mensaje m left join usuario u on m.ID_USUARIO=u.ID LEFT JOIN sala s on m.ID_SALA=s.ID LEFT JOIN tipo_mensaje tm on m.ID_TIPO_MENSAJE = tm.ID;";
            PreparedStatement ps=this.conn.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            lista=new ArrayList<Mensaje>();
            while(rs.next()){
                Mensaje men=new Mensaje();
                men.setId(rs.getInt("id"));
                men.setAsunto(rs.getString("asunto"));
                men.setFecha_envio(rs.getDate("fecha_envio"));
                men.setId_usuario(rs.getInt("id_usuario"));
                men.setId_tipo_mensaje(rs.getInt("id_tipo_mensaje"));
                men.setId_sala(rs.getInt("id_sala"));
                men.setEstado(rs.getString("estado"));
                men.setNombre_sala(rs.getString("sala"));
                men.setNombre_usuario(rs.getString("usuario"));
                men.setTipo_mensaje(rs.getString("tipo"));
                lista.add(men);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar datos varios de mensaje"+e);
        }
        return lista;
    }

    @Override
    public List<Mensaje> mensajesSala(int id) throws Exception {
                List<Mensaje> lista=null;
        try {
            this.conectar();
            String sql="SELECT m.*,u.NOMBRE as usuario, s.NOMBRE as sala, tm.NOMBRE as tipo FROM mensaje m left join usuario u on m.ID_USUARIO=u.ID LEFT JOIN sala s on m.ID_SALA=s.ID LEFT JOIN tipo_mensaje tm on m.ID_TIPO_MENSAJE = tm.ID where m.ID_SALA= ?;";
            PreparedStatement ps=this.conn.prepareCall(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            lista=new ArrayList<Mensaje>();
            while(rs.next()){
                Mensaje men=new Mensaje();
                men.setId(rs.getInt("id"));
                men.setAsunto(rs.getString("asunto"));
                men.setFecha_envio(rs.getDate("fecha_envio"));
                men.setId_usuario(rs.getInt("id_usuario"));
                men.setId_tipo_mensaje(rs.getInt("id_tipo_mensaje"));
                men.setId_sala(rs.getInt("id_sala"));
                men.setEstado(rs.getString("estado"));
                men.setNombre_sala(rs.getString("sala"));
                men.setNombre_usuario(rs.getString("usuario"));
                men.setTipo_mensaje(rs.getString("tipo"));
                lista.add(men);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar datos varios de mensaje"+e);
        }
        return lista;
    }
}
