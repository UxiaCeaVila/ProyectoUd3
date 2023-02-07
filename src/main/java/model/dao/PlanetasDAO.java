package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.entities.Planeta;

import java.util.List;

public class PlanetasDAO implements InterfaceDAO<Planeta> {
    @Override
    public void insert(Planeta planeta, EntityManager factory) {
        factory.getTransaction().begin();
        factory.persist(planeta);
        factory.getTransaction().commit();
    }

    @Override
    public List<Planeta> select(EntityManager entityManager) {
        Query select = entityManager.createQuery("select planeta from Planeta planeta");
        Planeta planeta  = new Planeta("1", "Roshar", "Sistema de Roshar", "Esquirla Honor");
        List<Planeta> planetaList = select.getResultList();
        return planetaList;
    }

    @Override
    public boolean delete(Planeta planeta, EntityManager factory) {
        try {
            factory.getTransaction().begin();
            factory.remove(planeta);
            factory.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void update(Planeta planeta, EntityManager factory) {
        factory.getTransaction().begin();
        factory.persist(planeta);
        factory.getTransaction().commit();
    }



    @Override
    public Planeta find(EntityManager factory, String nombre) {
        Planeta planeta = null;
        Query select = factory.createQuery("select planeta from Planeta planeta where planeta.nombre = '"+nombre+"'");
        if (!select.getResultList().isEmpty()){
            planeta  = (Planeta) select.getSingleResult();
        }
        return planeta;
    }
}
