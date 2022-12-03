
package com.emergentes.dao;

import com.emergentes.model.TipoSala;
import java.util.List;

public interface TipoSalaDAO {
    public void insert(TipoSala tiposala) throws Exception;

    public void update(TipoSala tiposala) throws Exception;

    public void delete(int id) throws Exception;

    public TipoSala getById(int id) throws Exception;

    public List<TipoSala> getAll() throws Exception;
    
    
}
