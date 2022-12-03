package com.emergentes.dao;

import com.emergentes.model.TipoUsuario;
import com.emergentes.model.Usuario;
import com.emergentes.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CJ
 */
public class UsuarioDAOimpl extends ConexionDB implements UsuarioDAO {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public List<Usuario> findAllUsuarios() {
        String sql = "SELECT * FROM usuario;";
        List<Usuario> lista = null;
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            lista = new ArrayList<Usuario>();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setAlias(rs.getString("alias"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setDescripcion(rs.getString("descripcion"));
                usuario.setCorreoElectronico(rs.getString("email"));
                usuario.setFechaRegistro(LocalDateTime.parse(rs.getString("fecha_registro"), formatter));
                usuario.setFechaNacimiento(LocalDate.parse(rs.getString("fecha_nacimiento")));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasenia(rs.getString("contraseña"));
                usuario.setEstado(rs.getString("estado"));
                lista.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR: " + e.getMessage());
        } finally {

        }
        return lista;
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        Usuario usuarioo = new Usuario();
        String sql = "SELECT * FROM usuario WHERE id = ? ;";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, usuario.getId());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuarioo.setId(rs.getInt("id"));
                usuarioo.setAlias(rs.getString("alias"));
                usuarioo.setNombre(rs.getString("nombre"));
                usuarioo.setDescripcion(rs.getString("descripcion"));
                usuarioo.setCorreoElectronico(rs.getString("email"));
                usuarioo.setFechaRegistro(LocalDateTime.parse(rs.getString("fecha_registro"), formatter));
                usuarioo.setFechaNacimiento(LocalDate.parse(rs.getString("fecha_nacimiento")));
                usuarioo.setUsuario(rs.getString("usuario"));
                usuarioo.setContrasenia(rs.getString("contraseña"));
                usuarioo.setEstado(rs.getString("estado"));
            }

        } catch (Exception e) {
            System.out.println("ERROR AL OBTENER EL REGISTRO: " + e.getMessage());
        } finally {

        }
        return usuarioo;
    }

    @Override
    public Usuario findUsuarioByEmail(Usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE email = ?;";
        Usuario usuarioo = new Usuario();
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, usuario.getCorreoElectronico());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuarioo.setId(rs.getInt("id"));
                usuarioo.setCorreoElectronico(rs.getString("email"));
                usuarioo.setUsuario(rs.getString("usuario"));
                usuarioo.setContrasenia(rs.getString("contraseña"));
                return usuarioo;
            }
        } catch (Exception e) {
            System.out.println("ERROR AL OBTENER EL EMAIL: " + e.getMessage());
        }
        return usuarioo;
    }

    @Override
    public Usuario findRegistro(Usuario usuario) {
        Usuario usuarioo = new Usuario();
        String sql = "SELECT u.*, t.nombre Nombre, t.descripcion Descripcion FROM usuario u LEFT JOIN tipo_usuario t ON u.id_tipo_usuario = t.id WHERE usuario = ? AND contraseña = ? ;";
        /**String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasenia = ?;";**/
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContrasenia());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuarioo.setId(rs.getInt("id"));
                usuarioo.setAlias(rs.getString("alias"));
                usuarioo.setNombre(rs.getString("nombre"));
                usuarioo.setDescripcion(rs.getString("descripcion"));
                usuarioo.setCorreoElectronico(rs.getString("email"));
                usuarioo.setFechaRegistro(LocalDateTime.parse(rs.getString("fecha_registro"), formatter));
                usuarioo.setFechaNacimiento(LocalDate.parse(rs.getString("fecha_nacimiento")));
                usuarioo.setUsuario(rs.getString("usuario"));
                usuarioo.setContrasenia(rs.getString("contraseña"));
                usuarioo.setEstado(rs.getString("estado"));
                usuarioo.setIdTipoUsuario(new TipoUsuario(rs.getInt("id_tipo_usuario"), rs.getString(12), rs.getString(13)));
            }

        } catch (Exception e) {
            System.out.println("ERROR AL OBTENER EL REGISTRO: " + e.getMessage());
        } finally {

        }
        return usuarioo;
    }

    @Override
    public Usuario verificarRegistro(Usuario usuario) {
        Usuario usuarioo = new Usuario();
        String sql = "SELECT * FROM usuario WHERE usuario = ? AND contraseña = ? AND email= ?;";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContrasenia());
            ps.setString(3, usuario.getCorreoElectronico());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuarioo.setId(rs.getInt("id"));
                usuarioo.setAlias(rs.getString("alias"));
                usuarioo.setNombre(rs.getString("nombre"));
                usuarioo.setDescripcion(rs.getString("descripcion"));
                usuarioo.setCorreoElectronico(rs.getString("email"));
                usuarioo.setFechaRegistro(LocalDateTime.parse(rs.getString("fecha_registro"), formatter));
                usuarioo.setFechaNacimiento(LocalDate.parse(rs.getString("fecha_nacimiento")));
                usuarioo.setUsuario(rs.getString("usuario"));
                usuarioo.setContrasenia(rs.getString("contraseña"));
                usuarioo.setEstado(rs.getString("estado"));
                usuarioo.setIdTipoUsuario(new TipoUsuario());
            }

        } catch (Exception e) {
            System.out.println("ERROR AL OBTENER EL REGISTRO desde DAO: " + e.getMessage());
        } finally {

        }
        return usuarioo;
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (alias, nombre, descripcion, email,"
                + "fecha_registro, fecha_nacimiento, usuario, contraseña, estado, id_tipo_usuario) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?);";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ps.setString(1, usuario.getAlias());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getDescripcion());
            ps.setString(4, usuario.getCorreoElectronico());
            ps.setString(5, usuario.getFechaRegistro().toString());
            ps.setString(6, usuario.getFechaNacimiento().toString());
            ps.setString(7, usuario.getUsuario());
            ps.setString(8, usuario.getContrasenia());
            ps.setString(9, usuario.getEstado());
            ps.setInt(10, usuario.getIdTipoUsuario().getId());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar desde DAO: " + e.getMessage());
        }
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET alias = ?, nombre = ?, descripcion = ?, email = ?,"
                + "fecha_registro = ?, fecha_nacimiento = ?, usuario = ?,"
                + "contraseña = ?, estado = 'Baneado', id_tipo_usuario = ? WHERE id = ? ;";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            System.out.println("usuario mas"+ usuario.getEstado());
            ps.setString(1, usuario.getAlias());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getDescripcion());
            ps.setString(4, usuario.getCorreoElectronico());
            ps.setString(5, usuario.getFechaRegistro().toString());
            ps.setString(6, usuario.getFechaNacimiento().toString());
            ps.setString(7, usuario.getUsuario());
            ps.setString(8, usuario.getContrasenia());
            ps.setInt(9, usuario.getIdTipoUsuario().getId());
            ps.setInt(10, usuario.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        } 
    }
        @Override
    public void updatedesUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET alias = ?, nombre = ?, descripcion = ?, email = ?,"
                + "fecha_registro = ?, fecha_nacimiento = ?, usuario = ?,"
                + "contraseña = ?, estado = 'Activo', id_tipo_usuario = ? WHERE id = ? ;";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            System.out.println("usuario mas"+ usuario.getEstado());
            ps.setString(1, usuario.getAlias());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getDescripcion());
            ps.setString(4, usuario.getCorreoElectronico());
            ps.setString(5, usuario.getFechaRegistro().toString());
            ps.setString(6, usuario.getFechaNacimiento().toString());
            ps.setString(7, usuario.getUsuario());
            ps.setString(8, usuario.getContrasenia());
            ps.setInt(9, usuario.getIdTipoUsuario().getId());
            ps.setInt(10, usuario.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        } 
    }
    
    @Override
    public void deleteUsuario(Usuario usuario) {
        String sql = "DELETE FROM usuario WHERE id = ? ;";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, usuario.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR AL ELIMINAR: " + e.getMessage());
        } finally {

        }
    }

    @Override
    public Usuario getById(int i) throws Exception {
        Usuario usuario = new Usuario();
        try {
            this.conectar();
            String sql= "SELECT * FROM usuario WHERE id=?";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setAlias(rs.getString("alias"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasenia(rs.getString("contraseña"));
                
            }
        } catch (Exception e) {
            System.out.println("Error en los datos DDAO usuario");
        }
        return usuario;
        
    }

}
