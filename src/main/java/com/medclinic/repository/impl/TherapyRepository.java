package com.medclinic.repository.impl;

import com.medclinic.entity.Therapy;
import com.medclinic.config.hibernate.GenericDAOImpl;
import com.medclinic.repository.ITherapyRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TherapyRepository extends GenericDAOImpl<Therapy> implements ITherapyRepository {
    public TherapyRepository() {
        this.setEntityClass(Therapy.class);
    }

    @Override
    public List<Therapy> findByDiseaseId(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Therapy> criteria = builder.createQuery(Therapy.class);
        Root<Therapy> root = criteria.from(Therapy.class);
        criteria.select(root).where(builder.equal(root.get("disease"), id));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List<Therapy> findByDescribeComplaint(String describe) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Therapy> criteria = builder.createQuery(Therapy.class);
        Root<Therapy> root = criteria.from(Therapy.class);
        criteria.select(root).where(builder.equal(root.get("describeComplaint"), describe));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }
}
