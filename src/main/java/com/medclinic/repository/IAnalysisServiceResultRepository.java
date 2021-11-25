package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import java.util.List;

public interface IAnalysisServiceResultRepository<T, ID> extends GenericDAO {
    List<T> findByAnalysisID(long id);
    List<T> findByServiceID(long id);
    List<T> findByDoctorID(long id);
    List<T> findByClientID(long id);
    T findByBillID(long id);
    List<T> findByNotPaidResults();
}
