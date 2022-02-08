package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import com.medclinic.entity.Analysis;

import java.util.List;

public interface IAnalysisRepository extends GenericDAO<Analysis> {

    Analysis findByName(String name);
    List<Analysis> findByPrice(int price);

}
