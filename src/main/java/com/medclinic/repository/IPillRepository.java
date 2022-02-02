package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import com.medclinic.entity.Pills;

import java.util.List;

public interface IPillRepository extends GenericDAO<Pills> {
    Pills findByName(String name);
    List<Pills> findByActiveElement(String element);
}
