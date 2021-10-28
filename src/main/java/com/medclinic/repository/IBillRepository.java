package com.medclinic.repository;

import com.medclinic.hibernate.GenericDAO;
import java.util.List;

public interface IBillRepository<T, ID> extends GenericDAO {
    List<T> findByPaid();
    List<T> findByClientID(long id);
    List<T> findByDoctorID(long id);
}
