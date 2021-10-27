package com.medclinic.hibernate;
import java.util.List;

public interface GenericDAO <T, ID>{
    T findByID(long id);
    List<T> findAll();
    long getCount();
    T save(T entity);
    void delete(T entity);
}
