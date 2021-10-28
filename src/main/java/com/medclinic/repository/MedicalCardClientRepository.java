package com.medclinic.repository;

import com.medclinic.hibernate.GenericDAO;
import java.util.List;


public interface MedicalCardClientRepository<T, ID> extends GenericDAO {
    List<T> findByDoctorId(long id);
    List<T> findByChronicDisease(String diseases);
    T findByClientId(long id);
}
