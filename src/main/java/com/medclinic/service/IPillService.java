package com.medclinic.service;

import com.medclinic.dto.DrugDto;
import com.medclinic.entity.Pills;

import java.util.List;

public interface IPillService {
    Pills findByName(String name);
    List<Pills> findByActiveElement(String element);
    Pills createNewDrug(DrugDto dto);
    void deleteDrug(long drugsID);
    void updateDrug(long ID, DrugDto dto);
}
