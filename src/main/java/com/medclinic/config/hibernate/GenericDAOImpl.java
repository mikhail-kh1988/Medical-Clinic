package com.medclinic.config.hibernate;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO{

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> entityClass;

    @Override
    public Object findByID(long id) {
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
    public Object save(Object entity) {
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }

    @Override
    public void delete(Object entity) {
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
