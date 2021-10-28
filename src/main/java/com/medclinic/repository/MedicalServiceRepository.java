package com.medclinic.repository;

import com.medclinic.hibernate.GenericDAO;
import java.util.List;

public interface MedicalServiceRepository<T,ID> extends GenericDAO {
    List<T> findByName(String name);
    List<T> findByActive();
    List<T> findByInActive();
    T findByExternalCode(String code);
}
