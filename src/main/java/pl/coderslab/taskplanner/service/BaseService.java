package pl.coderslab.taskplanner.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface BaseService<D, I extends Serializable> {

    D save(D dto);

    D update(D dto, I id);

    D find(I id);

    Boolean remove(I id);

    List<D> getAll();

}

