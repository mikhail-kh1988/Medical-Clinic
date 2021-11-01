package com.medclinic.repository.impl;

import com.medclinic.entity.MedicalService;
import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IMedicalServiceRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicalServiceRepository extends GenericDAOImpl implements IMedicalServiceRepository {
    public MedicalServiceRepository() {
        this.setEntityClass(MedicalService.class);
    }

    @Override
    public List findByName(String name) {
        return null;
    }

    @Override
    public List findByActive() {
        return null;
    }

    @Override
    public List findByInActive() {
        return null;
    }

    @Override
    public Object findByExternalCode(String code) {
        return null;
    }
}
