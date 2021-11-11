package com.medclinic.repository.impl;

import com.medclinic.entity.Analysis;
import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IAnalysisRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AnalysisRepository extends GenericDAOImpl implements IAnalysisRepository {

    public AnalysisRepository(){
        this.setEntityClass(Analysis.class);
    }

    @Override
    public List findByName(String name) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Analysis.class);
        Root<Analysis> root = criteria.from(Analysis.class);
        criteria.select(root).where(builder.like(root.get("name"), "%"+name+"%"));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List findByPrice(int price) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Analysis.class);
        Root<Analysis> root = criteria.from(Analysis.class);
        criteria.select(root).where(builder.equal(root.get("price"), price));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }
}