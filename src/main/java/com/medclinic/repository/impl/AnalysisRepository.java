package com.medclinic.repository.impl;

import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IAnalysisRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnalysisRepository extends GenericDAOImpl implements IAnalysisRepository {

    public AnalysisRepository(){
        this.setEntityClass(this.getClass());
    }

    @Override
    public Object findByName(String name) {
        return null;
    }

    @Override
    public List findByPrice(int price) {
        return null;
    }
}
