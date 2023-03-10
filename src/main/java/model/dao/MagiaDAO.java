package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.entities.Libro;
import model.entities.Magia;

import java.util.ArrayList;
import java.util.List;

public class MagiaDAO implements InterfaceDAO<Magia> {
    @Override
    public void insert(Magia magia, EntityManager factory) {
        try {

            factory.getTransaction().begin();
            factory.persist(magia);
            factory.getTransaction().commit();
        }catch (Exception e){
            factory.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Magia> select(EntityManager entityManager) {
        Query select = entityManager.createQuery("select magia from Magia magia");
        Magia magia  = new Magia();
        List<Magia> magiasList = select.getResultList();
        return magiasList;
    }

    @Override
    public boolean delete(Magia magia, EntityManager factory) {
        try {
            factory.getTransaction().begin();
            factory.remove(magia);
            factory.getTransaction().commit();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void update(Magia magia, EntityManager factory) {
        factory.getTransaction().begin();
        factory.persist(magia);
        factory.getTransaction().commit();
    }


    @Override
    public Magia find(EntityManager factory, String nombre) {
        Query select = factory.createQuery("select magia from Magia magia where magia.nombre = '"+nombre+"'");
        Magia magia  = (Magia) select.getSingleResult();
        return magia;
    }
}
