package com.medclinic.repository.impl;

import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IDrugRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DrugRepository extends GenericDAOImpl implements IDrugRepository {
    public DrugRepository() {
        this.setEntityClass(this.getClass());
    }

    @Override
    public Object findByName(String name) {
        return null;
    }

    @Override
    public List findByActiveElement(String element) {
        return null;
    }
}
