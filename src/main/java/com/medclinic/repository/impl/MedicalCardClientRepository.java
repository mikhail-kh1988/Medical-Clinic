package com.medclinic.repository.impl;

import com.medclinic.entity.MedicalCardClient;
import com.medclinic.config.hibernate.GenericDAOImpl;
import com.medclinic.repository.IMedicalCardClientRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class MedicalCardClientRepository extends GenericDAOImpl implements IMedicalCardClientRepository {
    public MedicalCardClientRepository() {
        this.setEntityClass(MedicalCardClient.class);
    }

    @Override
    public List<MedicalCardClient> findByDoctorId(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<MedicalCardClient> criteria = builder.createQuery(MedicalCardClient.class);
        Root<MedicalCardClient> root = criteria.from(MedicalCardClient.class);
        criteria.select(root).where(builder.equal(root.get("therapyDoctor"), id));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List<MedicalCardClient> findByChronicDisease(String diseases) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<MedicalCardClient> criteria = builder.createQuery(MedicalCardClient.class);
        Root<MedicalCardClient> root = criteria.from(MedicalCardClient.class);
        criteria.select(root).where(builder.like(root.get("chronicDisease"), "%"+diseases+"%"));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public MedicalCardClient findByClientId(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<MedicalCardClient> criteria = builder.createQuery(MedicalCardClient.class);
        Root<MedicalCardClient> root = criteria.from(MedicalCardClient.class);
        criteria.select(root).where(builder.equal(root.get("client"), id));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }
}
