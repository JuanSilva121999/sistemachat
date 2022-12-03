package com.emergentes.dao;

import com.emergentes.model.TipoMensaje;
import com.emergentes.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoMensajeDAOimpl extends ConexionDB implements TipoMensajeDAO {

    @Override
    public void insert(TipoMensaje tipomensaje) throws Exception {
        try {
            this.conectar();
            String sql="INSERT INTO tipo_mensaje ( NOMBRE, URL, ID_ADMINISTRADOR) VALUES (?, ?, ?)";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ps.setString(1, tipomensaje.getNombre());
            ps.setString(2, tipomensaje.getUrl());
            ps.setInt(3, tipomensaje.getId_administrador());
            ps.executeUpdate();
        } catch (Exception e) {
           
            System.out.println("Error al insertar datos del TipoMensaje " + e);
        }
    }

    @Override
    public void update(TipoMensaje tipomensaje) throws Exception {
        try {
            this.conectar();
            String sql="UPDATE tipo_mensaje SET NOMBRE = ?, `URL` = ?, `ID_ADMINISTRADOR` = ? WHERE tipo_mensaje.ID = ?";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ps.setString(1, tipomensaje.getNombre());
            ps.setString(2, tipomensaje.getUrl());
            ps.setInt(3, tipomensaje.getId_administrador());
            ps.setInt(4, tipomensaje.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al insertar modificar del TipoMensaje " + e);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql="DELETE FROM tipo_mensaje WHERE tipo_mensaje.ID = ?";
            PreparedStatement ps=this.conn.prepareStatement(sql);
     
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
           
            System.out.println("Error al insertar modificar del TipoMensaje " + e);
        }
    }

    @Override
    public TipoMensaje getById(int id) throws Exception {
        TipoMensaje TM=new TipoMensaje();
        try {
            this.conectar();
            String sql="SELECT *FROM tipo_mensaje WHERE tipo_mensaje.ID=?";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                TM.setId(rs.getInt("id"));
                TM.setNombre(rs.getString("nombre"));
                TM.setUrl(rs.getString("url"));
                TM.setId_administrador(rs.getInt("id_administrador"));
            }
        } catch (Exception e) {
            
            System.out.println("Error al Eliminar el tipo de mensaje " + e);
            throw e;
        }
        return TM;
    }

    @Override
    public List<TipoMensaje> getAll() throws Exception {
        List<TipoMensaje> lista =null;
        try {
            this.conectar();
            String sql = "SELECT tm.*, a.usuario as administrador FROM tipo_mensaje tm LEFT JOIN administrador a on tm.ID_ADMINISTRADOR= a.ID;";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            lista = new ArrayList<TipoMensaje>();
            while (rs.next()){
                TipoMensaje tm= new TipoMensaje();
                tm.setId(rs.getInt("id"));
                tm.setNombre(rs.getString("nombre"));
                tm.setUrl(rs.getString("url"));
                tm.setId_administrador(rs.getInt("id_administrador"));
                tm.setNombre_aministrador(rs.getString("administrador"));
                lista.add(tm);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar TipoMensaje "+e);
        }
        return lista;
    }

}
