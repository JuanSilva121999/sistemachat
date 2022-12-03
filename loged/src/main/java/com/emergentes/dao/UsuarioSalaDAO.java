package com.emergentes.dao;

import com.emergentes.model.UsuarioSala;
import java.util.List;

public interface UsuarioSalaDAO {

    public void insert(UsuarioSala usuariosala) throws Exception;

    public void update(UsuarioSala usuariosala) throws Exception;

    public void delete(int id) throws Exception;

    public UsuarioSala getById(int id) throws Exception;

    public List<UsuarioSala> getAll() throws Exception;
    public List<UsuarioSala> getSalaPrivada(int id) throws Exception;
}
