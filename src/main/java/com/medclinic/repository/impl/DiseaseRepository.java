package com.medclinic.repository.impl;

import com.medclinic.entity.Disease;
import com.medclinic.config.hibernate.GenericDAOImpl;
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
    public Disease findByInternalCode(String inCode) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Disease> criteria = builder.createQuery(Disease.class);
        Root<Disease> root = criteria.from(Disease.class);
        criteria.select(root).where(builder.equal(root.get("internalCode"), inCode));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }

    @Override
    public Disease findByExternalCode(String exCode) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Disease> criteria = builder.createQuery(Disease.class);
        Root<Disease> root = criteria.from(Disease.class);
        criteria.select(root).where(builder.equal(root.get("externalCode"), exCode));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }

    @Override
    public Disease findByWorldCode(String wlCode) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Disease> criteria = builder.createQuery(Disease.class);
        Root<Disease> root = criteria.from(Disease.class);
        criteria.select(root).where(builder.equal(root.get("worldCode"), wlCode));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Disease> findByName(String name) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Disease> criteria = builder.createQuery(Disease.class);
        Root<Disease> root = criteria.from(Disease.class);
        criteria.select(root).where(builder.equal(root.get("name"), name));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }
}
