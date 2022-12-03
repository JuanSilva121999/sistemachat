package com.emergentes.dao;

import com.emergentes.model.Usuario;
import java.util.List;

/**
 *
 * @author CJ
 */
public interface UsuarioDAO {

    public List<Usuario> findAllUsuarios();

    public Usuario findUsuarioById(Usuario usuario);
    
    public Usuario findUsuarioByEmail(Usuario usuario);

    public Usuario findRegistro(Usuario usuario);
    
    public Usuario verificarRegistro(Usuario usuario);

    public void insertUsuario(Usuario usuario);

    public void updateUsuario(Usuario usuario);
    
    public void updatedesUsuario(Usuario usuario);

    public void deleteUsuario(Usuario usuario);
    
    public Usuario getById(int id) throws Exception;
}
