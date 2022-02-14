package com.medclinic.config.hibernate;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDAOImpl<T extends Serializable> implements GenericDAO<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> entityClass;

    public GenericDAOImpl(){
    }

    @Override
    public T findByID(long id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> cr = entityManager.getCriteriaBuilder().createQuery(entityClass);
        cr.select(cr.from(entityClass));
        return entityManager.createQuery(cr).getResultList();
    }

    @Override
    public long getCount() {
        CriteriaQuery<Long> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Long.class);
        criteriaQuery.select(entityManager.getCriteriaBuilder().count(criteriaQuery.from(entityClass)));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public T save(T entity) {
        entityManager.merge(entity);
        entityManager.flush();
        return entity;
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void setEntityClass(Class<T> tClass){
        this.entityClass = tClass;
    }

    public EntityManager getEntityManager(){
        return this.entityManager;
    }

    public void setEntityManager(EntityManager em){
        this.entityManager = em;
    }
}
