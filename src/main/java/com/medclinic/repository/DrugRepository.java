package com.medclinic.repository;

import com.medclinic.hibernate.GenericDAO;
import java.util.List;

public interface DrugRepository<T, ID> extends GenericDAO {
    T findByName(String name);
    List<T> findByActiveElement(String element);
}
