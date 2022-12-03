package com.emergentes.dao;

import com.emergentes.model.Administrador;
import java.util.List;

public interface AdministradorDAO {

    public void insert(Administrador administrador) throws Exception;

    public void update(Administrador administrador) throws Exception;

    public void delete(int id) throws Exception;

    public Administrador getById(int id) throws Exception;

    public List<Administrador> getAll() throws Exception;

    public List<Administrador> findAllUsuarios();

    public Administrador findAdministradorById(Administrador dministrador);

    public Administrador findRegistro(Administrador administrador);

    public void insertAdministrador(Administrador administrador);

    public void updateAdministrador(Administrador administrador);

    public void deleteAdministrador(Administrador administrador);
}
