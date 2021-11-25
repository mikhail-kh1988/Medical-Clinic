package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import java.util.List;


public interface IMedicalCardClientRepository<T, ID> extends GenericDAO {
    List<T> findByDoctorId(long id);
    List<T> findByChronicDisease(String diseases);
    T findByClientId(long id);
}
