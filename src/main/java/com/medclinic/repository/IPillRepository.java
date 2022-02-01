package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import java.util.List;

public interface IPillRepository<T> extends GenericDAO {
    T findByName(String name);
    List<T> findByActiveElement(String element);
}
