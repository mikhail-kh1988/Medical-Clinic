package com.medclinic.config.hibernate;
import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T extends Serializable>{
    T findByID(long id);
    List<T> findAll();
    long getCount();
    T save(T entity);
    void delete(T entity);
}
