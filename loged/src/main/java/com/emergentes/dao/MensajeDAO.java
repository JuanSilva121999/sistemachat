package com.emergentes.dao;

import com.emergentes.model.Mensaje;
import java.util.List;

public interface MensajeDAO {

    public void insert(Mensaje mensaje) throws Exception;

    public void update(Mensaje mensaje) throws Exception;

    public void delete(int id) throws Exception;

    public Mensaje getById(int id) throws Exception;

    public List<Mensaje> getAll() throws Exception;
    
    public List<Mensaje> mensajesSala(int id) throws Exception;
}
