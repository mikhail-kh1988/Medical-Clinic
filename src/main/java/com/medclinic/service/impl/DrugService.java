package com.medclinic.service.impl;

import com.medclinic.dto.DrugDto;
import com.medclinic.entity.Drugs;
import com.medclinic.repository.IDrugRepository;
import com.medclinic.service.IDrugService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DrugService implements IDrugService {

    @Autowired
    private IDrugRepository drugRepository;

    @Override
    public Drugs findByName(String name) {
        return (Drugs) drugRepository.findByName(name);
    }

    @Override
    public List<Drugs> findByActiveElement(String element) {
        return drugRepository.findByActiveElement(element);
    }

    @Transactional
    @Override
    public Drugs createNewDrug(DrugDto dto) {
        Drugs drugs = new Drugs();
        drugs.setName(dto.getName());
        drugs.setActiveElement(dto.getActiveElement());
        drugs.setComposition(dto.getComposition());
        drugs.setDosage(dto.getDosage());

        drugRepository.save(drugs);

        log.info("Create drug by name: "+drugs.getName());
        return drugs;
    }

    @Transactional
    @Override
    public void deleteDrug(long drugsID) {
        Drugs currentDrugs = (Drugs) drugRepository.findByID(drugsID);
        drugRepository.delete(currentDrugs);
        log.info("Delete drugs by name"+currentDrugs.getName()+" and id: "+drugsID);
    }

    @Transactional
    @Override
    public void updateDrug(long ID, DrugDto dto) {
        Drugs drugs = (Drugs) drugRepository.findByID(ID);
        drugs.setActiveElement(dto.getActiveElement());
        drugs.setDosage(dto.getDosage());
        drugs.setName(dto.getName());
        drugs.setComposition(dto.getComposition());

        drugRepository.save(drugs);
        log.info("Update drugs "+drugs.getName());
    }
}
