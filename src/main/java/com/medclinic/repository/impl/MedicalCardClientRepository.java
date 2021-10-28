package com.medclinic.repository.impl;

import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IMedicalCardClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicalCardClientRepository extends GenericDAOImpl implements IMedicalCardClientRepository {
    public MedicalCardClientRepository() {
        this.setEntityClass(this.getClass());
    }

    @Override
    public List findByDoctorId(long id) {
        return null;
    }

    @Override
    public List findByChronicDisease(String diseases) {
        return null;
    }

    @Override
    public Object findByClientId(long id) {
        return null;
    }
}
