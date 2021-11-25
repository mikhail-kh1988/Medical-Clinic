package com.medclinic.repository.impl;
import com.medclinic.entity.MedicalService;
import com.medclinic.config.hibernate.GenericDAOImpl;
import com.medclinic.repository.IMedicalServiceRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class MedicalServiceRepository extends GenericDAOImpl implements IMedicalServiceRepository {
    public MedicalServiceRepository() {
        this.setEntityClass(MedicalService.class);
    }

    @Override
    public List findByName(String name) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<MedicalService> root = criteria.from(MedicalService.class);
        criteria.select(root).where(builder.equal(root.get("name"), name));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List findByActive() {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<MedicalService> root = criteria.from(MedicalService.class);
        criteria.select(root).where(builder.equal(root.get("active"), true));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List findByInActive() {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<MedicalService> root = criteria.from(MedicalService.class);
        criteria.select(root).where(builder.equal(root.get("active"), false));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public Object findByExternalCode(String code) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<MedicalService> root = criteria.from(MedicalService.class);
        criteria.select(root).where(builder.equal(root.get("externalCode"), code));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }
}
