package com.medclinic.repository.impl;

import com.medclinic.entity.WorkFlow;
import com.medclinic.config.hibernate.GenericDAOImpl;
import com.medclinic.repository.IWorkFlowRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class WorkFlowRepository extends GenericDAOImpl implements IWorkFlowRepository {
    public WorkFlowRepository() {
        this.setEntityClass(WorkFlow.class);
    }

    //TODO Необходимо описать критерию для вывода только не отработавших графиков.
    @Override
    public List<WorkFlow> findByDoctorId(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<WorkFlow> criteria = builder.createQuery(WorkFlow.class);
        Root<WorkFlow> root = criteria.from(WorkFlow.class);
        criteria.select(root).where(builder.equal(root.get("doctor"), id));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List<WorkFlow> findByServiceId(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<WorkFlow> criteria = builder.createQuery(WorkFlow.class);
        Root<WorkFlow> root = criteria.from(WorkFlow.class);
        criteria.select(root).where(builder.equal(root.get("service"), id));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }
}
