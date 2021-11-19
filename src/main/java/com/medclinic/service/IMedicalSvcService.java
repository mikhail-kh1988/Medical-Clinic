package com.medclinic.service;

import com.medclinic.dto.MedicalServiceDto;
import com.medclinic.entity.MedicalService;

import java.util.List;

public interface IMedicalSvcService {

    MedicalService findById(long id);
    MedicalService createNewMedService(MedicalServiceDto dto);
    List<MedicalService> findByName(String name);
    List<MedicalService> findByActive();
    List<MedicalService> findByInActive();
    MedicalService findByExternalCode(String code);
    void setServiceIsInActive(String code);
}
