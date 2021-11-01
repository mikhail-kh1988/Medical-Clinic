package com.medclinic.repository.impl;

import com.medclinic.entity.AnalysisServiceResult;
import com.medclinic.entity.Bill;
import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IAnalysisServiceResultRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class AnalysisServiceResultRepository extends GenericDAOImpl implements IAnalysisServiceResultRepository {

    public AnalysisServiceResultRepository() {
        this.setEntityClass(AnalysisServiceResult.class);
    }

    @Override
    public List findByAnalysisID(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(AnalysisServiceResult.class);
        Root<AnalysisServiceResult> root = criteria.from(AnalysisServiceResult.class);
        criteria.select(root).where(builder.equal(root.get("analysis"), id));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List findByServiceID(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(AnalysisServiceResult.class);
        Root<AnalysisServiceResult> root = criteria.from(AnalysisServiceResult.class);
        criteria.select(root).where(builder.equal(root.get("service"), id));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List findByDoctorID(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(AnalysisServiceResult.class);
        Root<AnalysisServiceResult> root = criteria.from(AnalysisServiceResult.class);
        criteria.select(root).where(builder.equal(root.get("doctor"), id));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List findByClientID(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(AnalysisServiceResult.class);
        Root<AnalysisServiceResult> root = criteria.from(AnalysisServiceResult.class);
        criteria.select(root).where(builder.equal(root.get("client"), id));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public Object findByBillID(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(AnalysisServiceResult.class);
        Root<AnalysisServiceResult> root = criteria.from(AnalysisServiceResult.class);
        criteria.select(root).where(builder.equal(root.get("bill"), id));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }

    @Override
    public List findByNotPaidResults() {

        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<AnalysisServiceResult> root = criteria.from(AnalysisServiceResult.class);
        Subquery<Long> sq = criteria.subquery(Long.class);
        Root<Bill> billRoot = sq.from(Bill.class);
        sq.select().where(builder.equal(billRoot.get("paid"), false));
        criteria.select(root);
        criteria.where(builder.greaterThan(sq, ))

        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    public List getTestList(){
        this.setEntityClass(Bill.class);
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Bill.class);
        Root<Bill> root = criteria.from(Bill.class);
        criteria.select(root).where(builder.equal(root.get("paid"), false));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }
}
