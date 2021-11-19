package com.medclinic.service;

import com.medclinic.dto.MedicalCardBodyDto;
import com.medclinic.entity.MedicalCardClient;

import java.util.List;

public interface IMedicalCardClientService {

    MedicalCardClient createNewMedicalCard(MedicalCardClient cardClient);
    MedicalCardClient findById(long id);
    List<MedicalCardClient> findByDoctorId(long id);
    List<MedicalCardClient> findByChronicDisease(String diseases);
    MedicalCardClient findByClientId(long id);
    void newRecordInCard(long medCardID, MedicalCardBodyDto dto);
}
