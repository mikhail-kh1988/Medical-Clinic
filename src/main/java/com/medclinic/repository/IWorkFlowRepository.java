package com.medclinic.repository;

import com.medclinic.hibernate.GenericDAO;
import java.util.List;

public interface IWorkFlowRepository<T, ID> extends GenericDAO {
    List<T> findByDoctorId(long id);
    List<T> findByServiceId(long id);
}
