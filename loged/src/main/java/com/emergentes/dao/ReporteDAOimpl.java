package com.emergentes.dao;

import com.emergentes.model.Reporte;
import com.emergentes.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReporteDAOimpl extends ConexionDB implements ReporteDAO {

    @Override
    public void insert(Reporte reporte) throws Exception {
        try {
            this.conectar();
            String sql="INSERT INTO reporte (ID_USUARIO, ID_REPORTE) VALUES (?, ?)";
            PreparedStatement ps=this.conn.prepareCall(sql);
            ps.setInt(1, reporte.getId_usuario());
            ps.setInt(2, reporte.getId_reporte());
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al insertar datos del reporte " + e);
        }
    }

    @Override
    public void update(Reporte reporte) throws Exception {
        try {
            this.conectar();
            String sql="UPDATE reporte SET ID_USUARIO = ?, ID_REPORTE = ? WHERE reporte.ID = ?";
            PreparedStatement ps=this.conn.prepareCall(sql);
            ps.setInt(1, reporte.getId_usuario());
            ps.setInt(2, reporte.getId_reporte());
            ps.setInt(3, reporte.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al modificar datos del reporte " + e);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql="DELETE FROM reporte WHERE reporte.ID = ?";
            PreparedStatement ps=this.conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al Eliminar datos del Reporte " + e);
        }
    }

    @Override
    public Reporte getById(int id) throws Exception {
        Reporte reporte=new Reporte();
        try {
            this.conectar();
            String sql="SELECT * FROM reporte WHERE reporte.ID=?";
            PreparedStatement ps=this.conn.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                reporte.setId(rs.getInt("id"));
                reporte.setId_usuario(rs.getInt("id_usuario"));
                reporte.setId_reporte(rs.getInt("id_reporte"));
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar informacion de Rerpote"+e);
            throw e;
        }
        return reporte;
    }

    @Override
    public List<Reporte> getAll() throws Exception {
        List<Reporte> lista=null;
        
        try {
            this.conectar();
            String sql="SELECT r.*,u.NOMBRE as usuario,tr.NOMBRE as nombre FROM reporte r LEFT JOIN usuario u on r.ID_USUARIO=u.ID LEFT JOIN tipo_reporte tr on r.ID_REPORTE=tr.ID";
            PreparedStatement ps=this.conn.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            lista=new ArrayList<Reporte>();
            
            while(rs.next()){
                Reporte reporte=new Reporte();
                reporte.setId(rs.getInt("id"));
                reporte.setId_usuario(rs.getInt("id_usuario"));
                reporte.setId_reporte(rs.getInt("id_reporte"));
                reporte.setNombre_usuario(rs.getString("usuario"));
                reporte.setTipo_reporte(rs.getString("nombre"));
                lista.add(reporte);
            }
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            System.out.println("Error al mostrar toda la informacion de Rerpote"+e);

        }
        return lista;
    }

}
