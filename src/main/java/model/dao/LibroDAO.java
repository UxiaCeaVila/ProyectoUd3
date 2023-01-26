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
    public List<String> findAutocomplete(String nombre, EntityManager entityManager) {
        boolean correcto;
        Query select = entityManager.createQuery("select libros.nombre from Libro libros ");

        List<String> selectStringLibros = select.getResultList();

        List<String> cadenaGuardada = new ArrayList<>();

        for(String string : selectStringLibros){
            correcto  =true;
            for(int i =0 ; i < nombre.length() && correcto; i++){
                if(string.toLowerCase().charAt(i) == nombre.toLowerCase().charAt(i)){
                    if(i == (nombre.length() - 1)){
                        cadenaGuardada.add(string);
                    }
                }else {
                    correcto = false;
                }
            }
        }

        return cadenaGuardada;
    }

    @Override
    public Libro find(EntityManager factory, String nombre) {
        Query select = factory.createQuery("select libros from Libro libros where libros.nombre is "+nombre);
        Libro libros  = (Libro) select.getSingleResult();
        return libros;
    }
}
