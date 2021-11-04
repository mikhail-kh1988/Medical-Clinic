package com.medclinic.service;

import com.medclinic.dto.MedicalCardBodyDTO;
import com.medclinic.dto.MedicalCardDTO;
import com.medclinic.entity.MedicalCardClient;

import javax.persistence.Column;
import java.util.List;

public interface IMedicalCardClientService {

    MedicalCardClient createNewMedicalCard(MedicalCardDTO dto);
    MedicalCardClient findById(long id);
    List<MedicalCardClient> findByDoctorId(long id);
    List<MedicalCardClient> findByChronicDisease(String diseases);
    MedicalCardClient findByClientId(long id);
    void newRecordInCard(long medCardID, MedicalCardBodyDTO dto);
}
