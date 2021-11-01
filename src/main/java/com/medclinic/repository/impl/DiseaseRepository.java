package com.medclinic.repository.impl;

import com.medclinic.entity.Disease;
import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IDiseaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiseaseRepository extends GenericDAOImpl implements IDiseaseRepository {
    public DiseaseRepository() {
        this.setEntityClass(Disease.class);
    }

    @Override
    public Object findByInternalCode(String inCode) {
        return null;
    }

    @Override
    public Object findByExternalCode(String exCode) {
        return null;
    }

    @Override
    public Object findByWorldCode(String wlCode) {
        return null;
    }

    @Override
    public List findByName(String name) {
        return null;
    }
}
