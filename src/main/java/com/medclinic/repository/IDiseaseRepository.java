package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import com.medclinic.entity.Disease;

import java.util.List;

public interface IDiseaseRepository extends GenericDAO<Disease> {
    Disease findByInternalCode(String inCode);
    Disease findByExternalCode(String exCode);
    Disease findByWorldCode(String wlCode);
    List<Disease> findByName(String name);
}
