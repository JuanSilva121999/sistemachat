package com.emergentes.dao;


import com.emergentes.model.TipoSala;
import com.emergentes.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoSalaDAOimpl extends ConexionDB implements TipoSalaDAO {

    @Override
    public void insert(TipoSala tiposala) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO tipo_sala (NOMBRE, DESCRIPCION, ID_ADMINISTRADOR) VALUES ( ?, ?, ?);";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, tiposala.getNombre());
            ps.setString(2, tiposala.getDescripcion());
            ps.setInt(3, tiposala.getId_administrador());
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al insetar datos " + e);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM tipo_sala WHERE tipo_sala.ID = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al eliminar datos de tipo de sala " + e);
        }
    }

    @Override
    public void update(TipoSala tiposala) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE tipo_sala SET NOMBRE = ?, DESCRIPCION = ?, ID_ADMINISTRADOR = ? WHERE tipo_sala.ID = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, tiposala.getNombre());
            ps.setString(2, tiposala.getDescripcion());
            ps.setInt(3, tiposala.getId_administrador());
            ps.setInt(4, tiposala.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al modificar datos " + e);
        }
    }

    @Override
    public TipoSala getById(int id) throws Exception {
        TipoSala tr=new TipoSala();
        try {
            String sql="SELECT * FROM tipo_sala WHERE id=?";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                tr.setId(rs.getInt("id"));
                tr.setNombre(rs.getString("nombre"));
                tr.setDescripcion(rs.getString("descripcion"));
                tr.setId_administrador(rs.getInt("id_administrador"));
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos tiposala" +e);
            throw e;
            
        }
        return tr;
    }

    @Override
    public List<TipoSala> getAll() throws Exception {
        List<TipoSala> lista = null;
        try {
            this.conectar();
            String sql = "SELECT ts.*, a.USUARIO as administrador FROM tipo_sala ts LEFT JOIN administrador a on ts.ID_ADMINISTRADOR=a.ID;";
            PreparedStatement ps = this.conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<TipoSala>();
            while (rs.next()) {
                TipoSala tr = new TipoSala();
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
            System.out.println("Error al buscar todos los datos de tipo de salas " + e);
        } 

        return lista;
    }

}
