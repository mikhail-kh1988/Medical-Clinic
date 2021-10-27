package com.medclinic.hibernate;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO{

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> entityClass;

    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

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
        return entityManager.merge(entity);
    }

    @Override
    public void delete(Object entity) {
        entityManager.remove(entity);
    }
}
