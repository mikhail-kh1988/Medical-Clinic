package com.medclinic.service;

import com.medclinic.dto.DiseaseDTO;
import com.medclinic.entity.Disease;

import java.util.List;

public interface IDiseaseService {
    Disease createNewDisease(DiseaseDTO dto);
    void updateDisease(Disease disease, DiseaseDTO dto);
    void deleteDisease(Disease disease);
    Disease findByInternalCode(String inCode);
    Disease findByExternalCode(String exCode);
    Disease findByWorldCode(String wlCode);
    List<Disease> findByName(String name);
}
