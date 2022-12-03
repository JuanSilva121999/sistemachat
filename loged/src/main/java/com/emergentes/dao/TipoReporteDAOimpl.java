package com.emergentes.dao;

import com.emergentes.model.TipoReporte;
import com.emergentes.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoReporteDAOimpl extends ConexionDB implements TipoReporteDAO{

    @Override
    public void insert(TipoReporte tiporeporte) throws Exception {
        try {
            this.conectar();
            String sql="INSERT INTO tipo_reporte (NOMBRE, DESCRIPCION, ID_ADMINISTRADOR) VALUES (?,?, ?);";
            PreparedStatement ps= this.conn.prepareStatement(sql);
            ps.setString(1, tiporeporte.getNombre());
            ps.setString(2, tiporeporte.getDescripcion());
            ps.setInt(3, tiporeporte.getId_administrador());
            ps.executeUpdate();
            
        } catch (Exception e) {
            
            System.out.println("Error al ingresar datos "+e);
        }
    }

    @Override
    public void update(TipoReporte tiporeporte) throws Exception {
        try {
            this.conectar();
            String sql="UPDATE tipo_reporte SET NOMBRE = ?, DESCRIPCION = ?, ID_ADMINISTRADOR = ? WHERE tipo_reporte.ID = ?";
            PreparedStatement ps= this.conn.prepareStatement(sql);
            ps.setString(1, tiporeporte.getNombre());
            ps.setString(2, tiporeporte.getDescripcion());
            ps.setInt(3, tiporeporte.getId_administrador());
            ps.setInt(4, tiporeporte.getId());
            ps.executeUpdate();
            
        } catch (Exception e) {
            
            System.out.println("Error al ingresar datos "+e);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql="DELETE FROM tipo_reporte WHERE tipo_reporte.ID = ?";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al eliminar datos");
        }
    }

    @Override
    public TipoReporte getById(int id) throws Exception {
        TipoReporte tr= new TipoReporte();
        try {
            this.conectar();
            String sql="SELECT * FROM tipo_reporte WHERE id=?";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                tr.setId(rs.getInt("id"));
                tr.setNombre(rs.getString("nombre"));
                tr.setDescripcion(rs.getString("descripcion"));
                tr.setId_administrador(rs.getInt("id_administrador"));
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos " +e);
            throw e;
            
        }
        return tr;
    }

    @Override
    public List<TipoReporte> getAll() throws Exception {
        List<TipoReporte> lista = null;
        try {
            this.conectar();
            String sql="SELECT tr.*, a.USUARIO as administrador FROM tipo_reporte tr LEFT JOIN administrador a on tr.ID_ADMINISTRADOR=a.ID; ";
            PreparedStatement ps= this.conn.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            lista=new ArrayList<TipoReporte>();
            while(rs.next()){
                TipoReporte tr= new TipoReporte();
                tr.setId(rs.getInt("id"));
                tr.setNombre(rs.getString("nombre"));
                tr.setDescripcion(rs.getString("descripcion"));
                tr.setId_administrador(rs.getInt("id_administrador"));
                tr.setNombre_administrador(rs.getString("administrador"));
                lista.add(tr);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar datos de Tipo de Reporte "+e);
        }
        return lista;
    }
    
    
}
