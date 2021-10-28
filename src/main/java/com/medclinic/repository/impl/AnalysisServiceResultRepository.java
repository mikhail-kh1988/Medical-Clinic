package com.medclinic.repository.impl;

import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IAnalysisServiceResultRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnalysisServiceResultRepository extends GenericDAOImpl implements IAnalysisServiceResultRepository {

    public AnalysisServiceResultRepository() {
        this.setEntityClass(this.getClass());
    }

    @Override
    public List findByAnalysisID(long id) {
        return null;
    }

    @Override
    public List findByServiceID(long id) {
        return null;
    }

    @Override
    public List findByDoctorID(long id) {
        return null;
    }

    @Override
    public List findByClientID(long id) {
        return null;
    }

    @Override
    public Object findByBillID(long id) {
        return null;
    }

    @Override
    public List findByNotPaidResults() {
        return null;
    }
}
