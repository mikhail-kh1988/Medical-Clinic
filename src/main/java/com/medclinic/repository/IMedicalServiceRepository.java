package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import com.medclinic.entity.MedicalService;

import java.util.List;

public interface IMedicalServiceRepository extends GenericDAO<MedicalService> {
    List<MedicalService> findByName(String name);
    List<MedicalService> findByActive();
    List<MedicalService> findByInActive();
    MedicalService findByExternalCode(String code);
}
