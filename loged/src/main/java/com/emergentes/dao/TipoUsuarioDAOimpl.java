package com.emergentes.dao;

import com.emergentes.model.TipoUsuario;
import com.emergentes.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipoUsuarioDAOimpl extends ConexionDB implements TipoUsuarioDAO{

    @Override
    public void insert(TipoUsuario tipousuario) throws Exception {
        try {
            this.conectar();
            String sql="INSERT INTO tipo_usuario ( `NOMBRE`, `DESCRIPCION`) VALUES (?, ?)";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ps.setString(1, tipousuario.getNombre());
            ps.setString(2, tipousuario.getDescripcion());

            
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al insetar datos en tipo de usuario " + e);
        }
    }

    @Override
    public void update(TipoUsuario tipousuario) throws Exception {
        try {
            this.conectar();
            String sql="UPDATE tipo_usuario SET NOMBRE = ?, DESCRIPCION = ? WHERE tipo_usuario.ID =?";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ps.setString(1, tipousuario.getNombre());
            ps.setString(2, tipousuario.getDescripcion());

            ps.setInt(3, tipousuario.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al editar datos en tipo de usuario " + e);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql="DELETE FROM tipo_usuario WHERE tipo_usuario.ID = ?";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al eliminar datos en tipo de usuario " + e);
        }
    }

    @Override
    public TipoUsuario getById(int id) throws Exception {
        TipoUsuario tu=new TipoUsuario();
        try {
            this.conectar();
            String sql="SELECT * FROM tipo_usuario where tipo_usuario.ID=?";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                tu.setId(rs.getInt("id"));
                tu.setNombre(rs.getString("nombre"));
                tu.setDescripcion(rs.getString("descripcion"));
                
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos tipousuario" +e);
            throw e;
        }
        return tu;
    }

    @Override
    public List<TipoUsuario> getAll() throws Exception {
        List<TipoUsuario> lista=null;
        try {
            this.conectar();
            String sql="SELECT tu.*, a.USUARIO as administrador FROM tipo_usuario tu LEFT JOIN administrador a on tu.ID_ADMINISTRADOR=a.ID;";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            lista=new ArrayList<TipoUsuario>();
            while(rs.next()){
                TipoUsuario tu=new TipoUsuario();
                tu.setId(rs.getInt("id"));
                tu.setNombre(rs.getString("nombre"));
                tu.setDescripcion(rs.getString("descripcion"));
                lista.add(tu);
                
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error para obtener los datos de Tipo usuario");
        }
        return lista;
    }
    
    
}
