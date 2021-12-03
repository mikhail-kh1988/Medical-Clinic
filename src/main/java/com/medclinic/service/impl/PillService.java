package com.medclinic.service.impl;

import com.medclinic.dto.DrugDto;
import com.medclinic.entity.Pills;
import com.medclinic.repository.IPillRepository;
import com.medclinic.service.IPillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class PillService implements IPillService {

    @Autowired
    private IPillRepository drugRepository;

    @Override
    public Pills findByName(String name) {
        return (Pills) drugRepository.findByName(name);
    }

    @Override
    public List<Pills> findByActiveElement(String element) {
        return drugRepository.findByActiveElement(element);
    }

    @Transactional
    @Override
    public Pills createNewDrug(DrugDto dto) {
        Pills pills = new Pills();
        pills.setName(dto.getName());
        pills.setActiveElement(dto.getActiveElement());
        pills.setComposition(dto.getComposition());
        pills.setDosage(dto.getDosage());

        drugRepository.save(pills);

        log.info("Create drug by name: "+ pills.getName());
        return pills;
    }

    @Transactional
    @Override
    public void deleteDrug(long drugsID) {
        Pills currentPills = (Pills) drugRepository.findByID(drugsID);
        drugRepository.delete(currentPills);
        log.info("Delete drugs by name"+ currentPills.getName()+" and id: "+drugsID);
    }

    @Transactional
    @Override
    public void updateDrug(long ID, DrugDto dto) {
        Pills pills = (Pills) drugRepository.findByID(ID);
        pills.setActiveElement(dto.getActiveElement());
        pills.setDosage(dto.getDosage());
        pills.setName(dto.getName());
        pills.setComposition(dto.getComposition());

        drugRepository.save(pills);
        log.info("Update pills "+ pills.getName());
    }
}
