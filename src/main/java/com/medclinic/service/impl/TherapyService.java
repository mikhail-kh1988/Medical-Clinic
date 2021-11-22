package com.medclinic.service.impl;

import com.medclinic.dto.TherapyDto;
import com.medclinic.entity.Disease;
import com.medclinic.entity.Therapy;
import com.medclinic.repository.ITherapyRepository;
import com.medclinic.service.IDiseaseService;
import com.medclinic.service.ITherapyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class TherapyService implements ITherapyService {

    @Autowired
    private ITherapyRepository therapyRepository;

    @Autowired
    private IDiseaseService diseaseService;

    @Transactional
    @Override
    public Therapy createNewTherapy(TherapyDto dto) {
        Therapy therapy = new Therapy();
        Disease disease = (Disease) findByDiseaseId(dto.getDiseaseID());
        log.debug("Find disease "+disease.getName()+"(id:"+disease.getId()+"). ");

        therapy.setTherapy(dto.getTherapy());
        therapy.setDisease(disease);
        therapy.setDescribeComplaint(dto.getDescribeComplaint());

        therapyRepository.save(therapy);
        log.info("Create new therapy for disease id:"+therapy.getDisease().getId()+" by name"+therapy.getDisease().getName()+" describe: "+therapy.getTherapy());
        return therapy;
    }

    @Transactional
    @Override
    public void deleteTherapy(long id) {
        Therapy therapy = (Therapy) therapyRepository.findByID(id);
        log.info("Was delete therapy "+therapy.getTherapy()+" (id:"+therapy.getId()+") .");
        therapyRepository.delete(therapy);
    }

    @Transactional
    @Override
    public void updateTherapy(long id, TherapyDto dto) {
        Disease disease = diseaseService.findByID(dto.getDiseaseID());
        Therapy therapy = (Therapy) therapyRepository.findByID(id);
        log.debug("Find updatable therapy "+therapy.getId());

        therapy.setTherapy(dto.getTherapy());
        therapy.setDisease(disease);
        therapy.setDescribeComplaint(dto.getDescribeComplaint());

        therapyRepository.save(disease);
        log.info("Update therapy "+therapy.getTherapy());
    }

    @Override
    public List<Therapy> findByDiseaseId(long id) {
        return therapyRepository.findByDiseaseId(id);
    }

    @Override
    public List<Therapy> findByDescribeComplaint(String describe) {
        return therapyRepository.findByDescribeComplaint(describe);
    }
}
