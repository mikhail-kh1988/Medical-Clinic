package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import java.util.List;

public interface IBillRepository<T> extends GenericDAO {
    List<T> findByPaid();
    List<T> findByClientID(long id);
    List<T> findByDoctorID(long id);
}
