package com.emergentes.dao;

import com.emergentes.model.TipoMensaje;
import java.util.List;

public interface TipoMensajeDAO {

    public void insert(TipoMensaje tipomensaje) throws Exception;

    public void update(TipoMensaje tipomensaje) throws Exception;

    public void delete(int id) throws Exception;

    public TipoMensaje getById(int id) throws Exception;

    public List<TipoMensaje> getAll() throws Exception;
}
