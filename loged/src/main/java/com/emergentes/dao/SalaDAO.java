package com.emergentes.dao;

import com.emergentes.model.Sala;
import java.util.List;

public interface SalaDAO {

    public void insert(Sala sala) throws Exception;

    public void update(Sala sala) throws Exception;

    public void delete(int id) throws Exception;

    public Sala getById(int id) throws Exception;

    public List<Sala> getAll() throws Exception;
}
