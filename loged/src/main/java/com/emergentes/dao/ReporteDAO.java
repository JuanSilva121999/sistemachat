package com.emergentes.dao;

import com.emergentes.model.Reporte;
import java.util.List;

public interface ReporteDAO {

    public void insert(Reporte reporte) throws Exception;

    public void update(Reporte reporte) throws Exception;

    public void delete(int id) throws Exception;

    public Reporte getById(int id) throws Exception;

    public List<Reporte> getAll() throws Exception;
}
