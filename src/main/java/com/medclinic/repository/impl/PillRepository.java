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
    public Pills findByName(String name) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Pills> criteria = builder.createQuery(Pills.class);
        Root<Pills> root = criteria.from(Pills.class);
        criteria.select(root).where(builder.equal(root.get("name"), name));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Pills> findByActiveElement(String element) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Pills> criteria = builder.createQuery(Pills.class);
        Root<Pills> root = criteria.from(Pills.class);
        criteria.select(root).where(builder.equal(root.get("activeElement"), element));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }
}
