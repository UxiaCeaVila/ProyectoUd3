package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.entities.Especies;
import model.entities.Libro;

import java.util.ArrayList;
import java.util.List;

public class LibroDAO implements InterfaceDAO<Libro> {
    @Override
    public void insert(Libro libro, EntityManager factory) {
        factory.getTransaction().begin();
        factory.persist(libro);
        factory.getTransaction().commit();
    }

    @Override
    public List<Libro> select(EntityManager entityManager) {
        Query select = entityManager.createQuery("select libros from Libro libros");
        Libro libros  = new Libro();
        List<Libro> librosList = select.getResultList();
        return librosList;
    }

    @Override
    public boolean delete(Libro libro, EntityManager factory) {
        try {
            factory.getTransaction().begin();
            factory.remove(libro);
            factory.getTransaction().commit();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void update(Libro libro, EntityManager factory) {
        factory.getTransaction().begin();
        factory.persist(libro);
        factory.getTransaction().commit();
    }


    @Override
    public Libro find(EntityManager factory, String nombre) {
        Query select = factory.createQuery("select libros from Libro libros where libros.nombre = '"+nombre+"'");
        Libro libros  = (Libro) select.getSingleResult();
        return libros;
    }
}
