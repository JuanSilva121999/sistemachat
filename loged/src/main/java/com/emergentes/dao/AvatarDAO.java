package com.emergentes.dao;

import com.emergentes.model.Avatar;
import java.util.List;

public interface AvatarDAO {

    public void insert(Avatar avatar) throws Exception;

    public void update(Avatar avatar) throws Exception;

    public void delete(int id) throws Exception;

    public Avatar getById(int id) throws Exception;

    public List<Avatar> getAll() throws Exception;
}
