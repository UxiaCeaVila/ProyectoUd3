package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.entities.Personaje;
import model.entities.Sagas;

import java.util.ArrayList;
import java.util.List;

public class PersonajeDAO implements InterfaceDAO<Personaje> {
    @Override
    public void insert(Personaje personaje, EntityManager factory) {
        factory.getTransaction().begin();
        factory.persist(personaje);
        factory.getTransaction().commit();
    }

    @Override
    public List<Personaje> select(EntityManager entityManager) {
        Query select = entityManager.createQuery("select personaje from Personaje personaje");
        Personaje personaje = new Personaje();
        List<Personaje> personajeList = select.getResultList();
        return personajeList;
    }

    @Override
    public boolean delete(Personaje personaje, EntityManager factory) {
        try {
            factory.getTransaction().begin();
            factory.remove(personaje);
            factory.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void update(Personaje personaje, EntityManager factory) {
        factory.getTransaction().begin();
        factory.persist(personaje);
        factory.getTransaction().commit();
    }



    @Override
    public Personaje find(EntityManager factory, String nombre) {
        Query select = factory.createQuery("select personaje from Personaje personaje where personaje.nombre = '"+nombre+"'");
        Personaje personaje  = (Personaje) select.getSingleResult();
        return personaje;
    }
}
