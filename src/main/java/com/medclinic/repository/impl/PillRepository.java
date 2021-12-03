package com.medclinic.repository.impl;

import com.medclinic.entity.Pills;
import com.medclinic.config.hibernate.GenericDAOImpl;
import com.medclinic.repository.IPillRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PillRepository extends GenericDAOImpl implements IPillRepository {
    public PillRepository() {
        this.setEntityClass(Pills.class);
    }

    @Override
    public Object findByName(String name) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<Pills> root = criteria.from(Pills.class);
        criteria.select(root).where(builder.equal(root.get("name"), name));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }

    @Override
    public List findByActiveElement(String element) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<Pills> root = criteria.from(Pills.class);
        criteria.select(root).where(builder.equal(root.get("activeElement"), element));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }
}
