package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import java.util.List;

public interface IWorkFlowRepository<T> extends GenericDAO {
    List<T> findByDoctorId(long id);
    List<T> findByServiceId(long id);
}
