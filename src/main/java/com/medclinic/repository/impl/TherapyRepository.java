package com.medclinic.repository.impl;

import com.medclinic.entity.Therapy;
import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.ITherapyRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TherapyRepository extends GenericDAOImpl implements ITherapyRepository {
    public TherapyRepository() {
        this.setEntityClass(Therapy.class);
    }

    @Override
    public List findByDiseaseId(long id) {
        return null;
    }

    @Override
    public List findByDescribeComplaint(String describe) {
        return null;
    }
}
