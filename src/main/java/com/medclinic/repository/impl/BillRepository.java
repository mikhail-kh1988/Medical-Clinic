package com.medclinic.repository.impl;

import com.medclinic.entity.Bill;
import com.medclinic.config.hibernate.GenericDAOImpl;
import com.medclinic.repository.IBillRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class BillRepository extends GenericDAOImpl<Bill> implements IBillRepository {
    public BillRepository() {
        this.setEntityClass(Bill.class);
    }

    @Override
    public List<Bill> findByPaid() {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Bill> criteria = builder.createQuery(Bill.class);
        Root<Bill> root = criteria.from(Bill.class);
        criteria.select(root).where(builder.equal(root.get("paid"), true));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List<Bill> findByClientID(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Bill> criteria = builder.createQuery(Bill.class);
        Root<Bill> root = criteria.from(Bill.class);
        criteria.select(root).where(builder.equal(root.get("client"), id));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List<Bill> findByDoctorID(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Bill> criteria = builder.createQuery(Bill.class);
        Root<Bill> root = criteria.from(Bill.class);
        criteria.select(root).where(builder.equal(root.get("doctor"), id));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }
}
