package model.dao;

import com.sun.istack.NotNull;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.entities.Especies;
import model.entities.Sagas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EspeciesDAO implements InterfaceDAO<Especies> {
    @Override
    public void insert(Especies especies, EntityManager factory) {
        try {
            factory.getTransaction().begin();
            factory.persist(especies);
            factory.getTransaction().commit();

        }catch (Exception e){
            factory.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Especies> select(EntityManager entityManager) {
        Query select = entityManager.createQuery("select especies from Especies especies");
        Especies especies  = new Especies();
        List<Especies> especiesList = select.getResultList();
        return especiesList;
    }

    @Override
    public boolean delete(Especies especies, EntityManager factory) {
        try {
            factory.getTransaction().begin();
            factory.remove(especies);
            factory.getTransaction().commit();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void update(Especies especies, EntityManager factory) {
        factory.getTransaction().begin();
        factory.persist(especies);
        factory.getTransaction().commit();
    }

    @Override
    public Especies find(EntityManager factory, String nombre) {
        Query select = factory.createQuery("select especies from Especies especies where especies.nombre = '"+nombre+"'");

        Especies especies  = (Especies) select.getSingleResult();
        return especies;
    }




}
