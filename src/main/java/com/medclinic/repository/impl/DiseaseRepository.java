package com.medclinic.repository.impl;

import com.medclinic.entity.Department;
import com.medclinic.entity.Disease;
import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IDiseaseRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DiseaseRepository extends GenericDAOImpl implements IDiseaseRepository {
    public DiseaseRepository() {
        this.setEntityClass(Disease.class);
    }

    @Override
    public Object findByInternalCode(String inCode) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<Disease> root = criteria.from(Disease.class);
        criteria.select(root).where(builder.equal(root.get("internalCode"), inCode));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }

    @Override
    public Object findByExternalCode(String exCode) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<Disease> root = criteria.from(Disease.class);
        criteria.select(root).where(builder.equal(root.get("externalCode"), exCode));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }

    @Override
    public Object findByWorldCode(String wlCode) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<Disease> root = criteria.from(Disease.class);
        criteria.select(root).where(builder.equal(root.get("worldCode"), wlCode));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }

    @Override
    public List findByName(String name) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<Disease> root = criteria.from(Disease.class);
        criteria.select(root).where(builder.equal(root.get("name"), name));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }
}
