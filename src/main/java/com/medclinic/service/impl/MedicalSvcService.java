package com.medclinic.service.impl;

import com.medclinic.dto.MedicalServiceDto;
import com.medclinic.entity.MedicalService;
import com.medclinic.repository.IMedicalServiceRepository;
import com.medclinic.service.IMedicalSvcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class MedicalSvcService implements IMedicalSvcService {

    @Autowired
    private IMedicalServiceRepository serviceRepository;

    @Override
    public MedicalService findById(long id) {
        return (MedicalService) serviceRepository.findByID(id);
    }

    @Transactional
    @Override
    public MedicalService createNewMedService(MedicalServiceDto dto) {
        MedicalService medicalService = new MedicalService();
        medicalService.setName(dto.getName());
        medicalService.setDescribe(dto.getDescribe());
        medicalService.setPrice(dto.getPrice());
        medicalService.setExternalCode(dto.getExternalCode());

        serviceRepository.save(medicalService);

        log.info("Create new medical service "+medicalService.getName());
        return medicalService;
    }

    @Override
    public List<MedicalService> findByName(String name) {
        return serviceRepository.findByName(name);
    }

    @Override
    public List<MedicalService> findByActive() {
        return serviceRepository.findByActive();
    }

    @Override
    public List<MedicalService> findByInActive() {
        return serviceRepository.findByInActive();
    }

    @Override
    public MedicalService findByExternalCode(String code) {
        return (MedicalService) serviceRepository.findByExternalCode(code);
    }

    @Transactional
    @Override
    public void setServiceIsInActive(String code) {
        MedicalService medicalService = (MedicalService) serviceRepository.findByExternalCode(code);
        medicalService.setActive(false);
        log.info("Medical service "+medicalService.getName()+" is INACTIVE!");
        serviceRepository.save(medicalService);
    }
}
