package com.medclinic.service;

import com.medclinic.dto.TherapyDto;
import com.medclinic.entity.Therapy;

import java.util.List;

public interface ITherapyService {
    Therapy createNewTherapy(TherapyDto dto);
    void deleteTherapy(long id);
    void updateTherapy(long id, TherapyDto dto);
    List<Therapy> findByDiseaseId(long id);
    List<Therapy> findByDescribeComplaint(String describe);
}
