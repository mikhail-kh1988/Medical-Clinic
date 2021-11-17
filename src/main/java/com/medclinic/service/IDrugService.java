package com.medclinic.service;

import com.medclinic.dto.DrugDto;
import com.medclinic.entity.Drugs;

import java.util.List;

public interface IDrugService {
    Drugs findByName(String name);
    List<Drugs> findByActiveElement(String element);
    Drugs createNewDrug(DrugDto dto);
    void deleteDrug(long drugsID);
    void updateDrug(long ID, DrugDto dto);
}
