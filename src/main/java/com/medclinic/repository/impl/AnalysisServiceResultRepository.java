package com.medclinic.repository.impl;

import com.medclinic.entity.AnalysisServiceResult;
import com.medclinic.entity.Bill;
import com.medclinic.config.hibernate.GenericDAOImpl;
import com.medclinic.repository.IAnalysisServiceResultRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class AnalysisServiceResultRepository extends GenericDAOImpl implements IAnalysisServiceResultRepository {

    public AnalysisServiceResultRepository() {
        this.setEntityClass(AnalysisServiceResult.class);
    }

    @Override
    public List<AnalysisServiceResult> findByAnalysisID(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<AnalysisServiceResult> criteria = builder.createQuery(AnalysisServiceResult.class);
        Root<AnalysisServiceResult> root = criteria.from(AnalysisServiceResult.class);
        criteria.select(root).where(builder.equal(root.get("analysis"), id));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List<AnalysisServiceResult> findByServiceID(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<AnalysisServiceResult> criteria = builder.createQuery(AnalysisServiceResult.class);
        Root<AnalysisServiceResult> root = criteria.from(AnalysisServiceResult.class);
        criteria.select(root).where(builder.equal(root.get("service"), id));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List<AnalysisServiceResult> findByDoctorID(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<AnalysisServiceResult> criteria = builder.createQuery(AnalysisServiceResult.class);
        Root<AnalysisServiceResult> root = criteria.from(AnalysisServiceResult.class);
        criteria.select(root).where(builder.equal(root.get("doctor"), id));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List<AnalysisServiceResult> findByClientID(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<AnalysisServiceResult> criteria = builder.createQuery(AnalysisServiceResult.class);
        Root<AnalysisServiceResult> root = criteria.from(AnalysisServiceResult.class);
        criteria.select(root).where(builder.equal(root.get("client"), id));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public Object findByBillID(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<AnalysisServiceResult> criteria = builder.createQuery(AnalysisServiceResult.class);
        Root<AnalysisServiceResult> root = criteria.from(AnalysisServiceResult.class);
        criteria.select(root).where(builder.equal(root.get("bill"), id));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }

    @Override
    public List<AnalysisServiceResult> findByNotPaidResults() {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<AnalysisServiceResult> root = criteria.from(AnalysisServiceResult.class);
        Subquery<Bill> sq = criteria.subquery(Bill.class);
        Root<Bill> billRoot = sq.from(Bill.class);
        sq.select(billRoot).where(builder.equal(billRoot.get("paid"), false));
        criteria.select(root);
        criteria.where(builder.in(root.get("bill")).value(sq));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

}
