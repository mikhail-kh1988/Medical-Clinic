package com.medclinic.repository.impl;

import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IWorkFlowRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkFlowRepository extends GenericDAOImpl implements IWorkFlowRepository {
    public WorkFlowRepository() {
        this.setEntityClass(this.getClass());
    }

    @Override
    public List findByDoctorId(long id) {
        return null;
    }

    @Override
    public List findByServiceId(long id) {
        return null;
    }
}
