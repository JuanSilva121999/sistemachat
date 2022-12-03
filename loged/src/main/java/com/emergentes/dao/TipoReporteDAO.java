package com.emergentes.dao;

import com.emergentes.model.TipoReporte;
import java.util.List;

public interface TipoReporteDAO {

    public void insert(TipoReporte tiporeporte) throws Exception;

    public void update(TipoReporte tiporeporte) throws Exception;

    public void delete(int id) throws Exception;

    public TipoReporte getById(int id) throws Exception;

    public List<TipoReporte> getAll() throws Exception;
}
