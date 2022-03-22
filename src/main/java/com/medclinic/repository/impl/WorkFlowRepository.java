package com.medclinic.repository.impl;

import com.medclinic.entity.WorkFlow;
import com.medclinic.config.hibernate.GenericDAOImpl;
import com.medclinic.repository.IWorkFlowRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class WorkFlowRepository extends GenericDAOImpl<WorkFlow> implements IWorkFlowRepository {
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

    @Override
    public WorkFlow findWorkFlowByCurrentDate(LocalDateTime currentDate, long doctor_Id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<WorkFlow> criteria = builder.createQuery(WorkFlow.class);
        Root<WorkFlow> root = criteria.from(WorkFlow.class);
        Predicate doctorPredicate = builder.and(
                builder.equal(root.get("doctor"), doctor_Id));

        Path<LocalDateTime> startDate = root.get("startDate");
        Path<LocalDateTime> endDate = root.get("endDate");

        Predicate currentDatePredicate = builder.between(builder.literal(currentDate), startDate, endDate);

        criteria.select(root).where(builder.and(doctorPredicate, currentDatePredicate));

        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }
}
