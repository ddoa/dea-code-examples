package nl.oose.dea.orderservice.withisp;

import java.util.List;

public interface Repository<T> {
    void add(T entity);

    void update(T updatedEntity);

    void remove(T entity);

    List<T> list();

    T find(int id);
}
