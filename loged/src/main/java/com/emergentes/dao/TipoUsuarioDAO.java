
package com.emergentes.dao;

import com.emergentes.model.TipoUsuario;
import java.util.List;

public interface TipoUsuarioDAO {
    public void insert(TipoUsuario tipousuario) throws Exception;

    public void update(TipoUsuario tipousuario) throws Exception;

    public void delete(int id) throws Exception;

    public TipoUsuario getById(int id) throws Exception;

    public List<TipoUsuario> getAll() throws Exception;
}
