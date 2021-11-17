package com.medclinic.service.impl;

import com.medclinic.dto.DiseaseDto;
import com.medclinic.entity.Disease;
import com.medclinic.repository.IDiseaseRepository;
import com.medclinic.service.IDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DiseaseService implements IDiseaseService {

    @Autowired
    private IDiseaseRepository diseaseRepository;

    @Transactional
    @Override
    public Disease createNewDisease(DiseaseDto dto) {

        Disease disease = new Disease();
        disease.setName(dto.getName());
        disease.setWorldCode(dto.getWorldCode());
        disease.setInternalCode(dto.getInternalCode());
        disease.setExternalCode(dto.getExternalCode());

        diseaseRepository.save(disease);

        return disease;
    }

    @Transactional
    @Override
    public void updateDisease(String disease, DiseaseDto dto) {
        Disease currentDisease = (Disease) diseaseRepository.findByName(disease);
        currentDisease.setExternalCode(dto.getExternalCode());
        currentDisease.setInternalCode(dto.getInternalCode());
        currentDisease.setWorldCode(dto.getWorldCode());
        currentDisease.setName(dto.getName());

        diseaseRepository.save(currentDisease);
    }

    @Transactional
    @Override
    public void deleteDisease(String diseaseInternalId) {
        Disease currentDisease = (Disease) diseaseRepository.findByInternalCode(diseaseInternalId);
    }

    @Override
    public Disease findByInternalCode(String inCode) {
        return (Disease) diseaseRepository.findByInternalCode(inCode);
    }

    @Override
    public Disease findByExternalCode(String exCode) {
        return (Disease) diseaseRepository.findByExternalCode(exCode);
    }

    @Override
    public Disease findByWorldCode(String wlCode) {
        return (Disease) diseaseRepository.findByWorldCode(wlCode);
    }

    @Override
    public List<Disease> findByName(String name) {
        return diseaseRepository.findByName(name);
    }
}
