package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import com.medclinic.entity.MedicalCardClient;

import java.util.List;


public interface IMedicalCardClientRepository extends GenericDAO<MedicalCardClient> {
    List<MedicalCardClient> findByDoctorId(long id);
    List<MedicalCardClient> findByChronicDisease(String diseases);
    MedicalCardClient findByClientId(long id);
}
