package oose.dea.dataaccess;

import javax.persistence.*;
import java.util.List;

public class ItemJpaDAO implements DAO<Item> {
    private EntityManager em;

    public ItemJpaDAO()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simpleorder");
        this.em = emf.createEntityManager();
    }

    public void add(Item entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
    }

    public void update(Item updatedEntity) {
        if(em.find(Item.class, updatedEntity.getId()) == null){
            throw new IllegalArgumentException("Unknown Item");
        }
        em.getTransaction().begin();
        em.merge(updatedEntity);
        em.getTransaction().commit();
    }

    public void remove(Item entityToRemove) {
        if(em.find(Item.class, entityToRemove.getId()) == null){
            throw new IllegalArgumentException("Unknown Item");
        }
        em.getTransaction().begin();
        em.remove(entityToRemove);
        em.getTransaction().commit();
    }

    public List<Item> list() {
        Query query = em.createQuery("SELECT e FROM Item e");
        return (List<Item>) query.getResultList();
    }

    public Item find(int id) {
        return em.find(Item.class, id);
    }
}
