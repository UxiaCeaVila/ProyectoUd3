package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.entities.Sagas;

import java.util.ArrayList;
import java.util.List;

public class SagasDAO implements InterfaceDAO<Sagas> {
    @Override
    public void insert(Sagas sagas, EntityManager factory) {
        factory.getTransaction().begin();
        factory.persist(sagas);
        factory.getTransaction().commit();
    }

    @Override
    public List<Sagas> select(EntityManager entityManager) {
        Query select = entityManager.createQuery("select saga from Sagas saga");
        Sagas saga  = new Sagas();
        List<Sagas> sagasList = select.getResultList();
        return sagasList;
    }

    @Override
    public boolean delete(Sagas sagas, EntityManager factory) {
        try {
            factory.getTransaction().begin();
            factory.remove(sagas);
            factory.getTransaction().commit();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void update(Sagas sagas, EntityManager factory) {
        factory.getTransaction().begin();
        factory.persist(sagas);
        factory.getTransaction().commit();
    }



    @Override
    public Sagas find(EntityManager factory, String nombre) {
        Query select = factory.createQuery("select sagas from Sagas sagas where sagas.nombre = '"+nombre+"'");
        Sagas sagas  = (Sagas) select.getSingleResult();
        return sagas;
    }
}
