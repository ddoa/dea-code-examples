package oose.dea.dataaccess;

import java.util.List;

public interface DAO<T> {
    void add(T entity);

    void update(T updatedEntity);

    void remove(T entity);

    List<T> list();

    T find(int id);
}
