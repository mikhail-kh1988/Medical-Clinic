package com.medclinic.service;

import com.medclinic.dto.DiseaseDto;
import com.medclinic.entity.Disease;

import java.util.List;

public interface IDiseaseService {
    Disease createNewDisease(DiseaseDto dto);
    void updateDisease(String disease, DiseaseDto dto);
    void deleteDisease(String disease);
    Disease findByInternalCode(String inCode);
    Disease findByExternalCode(String exCode);
    Disease findByWorldCode(String wlCode);
    Disease findByID(long id);
    List<Disease> findByName(String name);
}
