package nl.oose.dea.orderservice.withoutisp;

import java.util.List;

public interface ReadOnlyRepository<T> {
    List<T> list();

    T find(int id);
}
