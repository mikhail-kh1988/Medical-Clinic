package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import java.util.List;

public interface IMedicalServiceRepository<T,ID> extends GenericDAO {
    List<T> findByName(String name);
    List<T> findByActive();
    List<T> findByInActive();
    T findByExternalCode(String code);
}
