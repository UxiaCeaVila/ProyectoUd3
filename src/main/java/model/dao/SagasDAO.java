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
    public List<String> findAutocomplete(String nombre, EntityManager entityManager) {
        boolean correcto;
        Query select = entityManager.createQuery("select sagas.nombre from Sagas sagas ");

        List<String> selectStringSagas = select.getResultList();

        List<String> cadenaGuardada = new ArrayList<>();

        for(String string : selectStringSagas){
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
    public Sagas find(EntityManager factory, String nombre) {
        Query select = factory.createQuery("select sagas from Sagas sagas where sagas.nombre is "+nombre);
        Sagas sagas  = (Sagas) select.getSingleResult();
        return sagas;
    }
}
