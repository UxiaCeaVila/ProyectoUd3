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
        factory.getTransaction().begin();
        factory.persist(magia);
        factory.getTransaction().commit();
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
    public List<String> findAutocomplete(String nombre, EntityManager entityManager) {
        boolean correcto;
        Query select = entityManager.createQuery("select magia.nombre from Magia magia ");

        List<String> selectStringMagia = select.getResultList();

        List<String> cadenaGuardada = new ArrayList<>();

        for(String string : selectStringMagia){
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
    public Magia find(EntityManager factory, String nombre) {
        Query select = factory.createQuery("select magia from Magia magia where magia.nombre is "+nombre);
        Magia magia  = (Magia) select.getSingleResult();
        return magia;
    }
}
