package com.medclinic.repository;

import com.medclinic.hibernate.GenericDAO;
import java.util.List;

public interface DiseaseRepository<T, ID> extends GenericDAO {
    T findByInternalCode(String inCode);
    T findByExternalCode(String exCode);
    T findByWorldCode(String wlCode);
    List<T> findByName(String name);
}
