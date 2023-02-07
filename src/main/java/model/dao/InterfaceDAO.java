package model.dao;

import jakarta.persistence.EntityManager;

import java.util.List;

public interface InterfaceDAO<T> {

    void insert(T t, EntityManager factory);
    List<T> select(EntityManager entityManager);
    boolean delete(T t, EntityManager factory);
    void update(T t, EntityManager factory);

    T find(EntityManager factory, String nombre);
}