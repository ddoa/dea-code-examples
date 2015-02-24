package nl.oose.dea.orderservice.withoutisp;

public interface Repository<T> extends ReadOnlyRepository<T>{
    void add(T entity);

    void update(T updatedEntity);

    void remove(T entity);
}
