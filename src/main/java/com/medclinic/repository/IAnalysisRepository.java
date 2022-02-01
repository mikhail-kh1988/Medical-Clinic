package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import java.util.List;

public interface IAnalysisRepository<T> extends GenericDAO {

    List<T> findByName(String name);
    List<T> findByPrice(int price);

}
