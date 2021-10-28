package com.medclinic.repository.impl;

import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IBillRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class BillRepository extends GenericDAOImpl implements IBillRepository {
    public BillRepository() {
        this.setEntityClass(this.getClass());
    }

    @Override
    public List findByPaid() {
        return null;
    }

    @Override
    public List findByClientID(long id) {
        return null;
    }

    @Override
    public List findByDoctorID(long id) {
        return null;
    }
}
