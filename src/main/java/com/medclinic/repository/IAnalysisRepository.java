package com.medclinic.repository;

import com.medclinic.hibernate.GenericDAO;
import java.util.List;

public interface IAnalysisRepository<T, ID> extends GenericDAO {

    T findByName(String name);
    List<T> findByPrice(int price);

}
