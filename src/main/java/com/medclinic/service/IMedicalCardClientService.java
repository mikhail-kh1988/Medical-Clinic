package com.medclinic.service;

import com.medclinic.dto.MedicalCardBodyDto;
import com.medclinic.dto.MedicalCardDto;
import com.medclinic.entity.MedicalCardClient;

import java.util.List;

public interface IMedicalCardClientService {

    MedicalCardClient createNewMedicalCard(MedicalCardDto dto);
    MedicalCardClient findById(long id);
    List<MedicalCardClient> findByDoctorId(long id);
    List<MedicalCardClient> findByChronicDisease(String diseases);
    MedicalCardClient findByClientId(long id);
    void newRecordInCard(long medCardID, MedicalCardBodyDto dto);
}
