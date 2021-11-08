package com.medclinic.service;

import com.medclinic.dto.TherapyDTO;
import com.medclinic.entity.Therapy;

import java.util.List;

public interface ITherapyService {
    Therapy createNewTherapy(TherapyDTO dto);
    void deleteTherapy(long id);
    void updateTherapy(long id, TherapyDTO dto);
    List<Therapy> findByDiseaseId(long id);
    List<Therapy> findByDescribeComplaint(String describe);
}
