package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import com.medclinic.entity.Bill;

import java.io.Serializable;
import java.util.List;

public interface IBillRepository extends GenericDAO<Bill> {
    List<Bill> findByPaid();
    List<Bill> findByClientID(long id);
    List<Bill> findByDoctorID(long id);
}
