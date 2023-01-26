package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.entities.Planeta;

import java.util.ArrayList;
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
        Planeta planeta  = new Planeta();
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
    public List<String> findAutocomplete(String nombre, EntityManager entityManager) {
        boolean correcto;
        Query select = entityManager.createQuery("select planeta.nombre from Planeta planeta ");

        List<String> selectStringPlaneta = select.getResultList();

        List<String> cadenaGuardada = new ArrayList<>();

        for(String string : selectStringPlaneta){
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
    public Planeta find(EntityManager factory, String nombre) {
        Query select = factory.createQuery("select planeta from Planeta planeta where planeta.nombre is "+nombre);
        Planeta planeta  = (Planeta) select.getSingleResult();
        return planeta;
    }
}
