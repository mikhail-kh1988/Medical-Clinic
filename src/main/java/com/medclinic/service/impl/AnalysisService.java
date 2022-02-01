package com.medclinic.service.impl;

import com.medclinic.dto.DescribeAnalysisDto;
import com.medclinic.dto.ResultByAnalysisDto;
import com.medclinic.entity.*;
import com.medclinic.repository.*;
import com.medclinic.service.IAnalysisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class AnalysisService implements IAnalysisService {

    @Autowired
    private IAnalysisRepository analysisRepository;

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private IAnalysisServiceResultRepository resultRepository;

    @Autowired
    private IBillRepository billRepository;

    // УДАЛИТЬ ДАННЫЙ МЕТОД!
    /*public void setAnalysisRepository(IAnalysisRepository repository){
        this.analysisRepository = repository;
    }*/

    @Transactional
    @Override
    public Analysis createAnalysis(DescribeAnalysisDto dto) {
        Analysis analysis = new Analysis();
        analysis.setName(dto.getName());
        analysis.setDescribe(dto.getDescribe());
        analysis.setPrice(dto.getPrice());

        log.info("Created new analysis on name: "+analysis.getName());

        analysisRepository.save(analysis);
        return  analysis;
    }

    @Override
    public List<Analysis> findByAnalysisByName(String name) {
        return analysisRepository.findByName(name);
    }

    @Override
    public List<Analysis> findAllAnalysis() {
        return analysisRepository.findAll();
    }

    @Override
    public Analysis findAnalysisByID(long id) {
        return (Analysis) analysisRepository.findByID(id);
    }

    @Transactional
    @Override
    public AnalysisServiceResult createResultByAnalysis(long analysisId, ResultByAnalysisDto dto) {
        Client client = (Client) clientRepository.findByID(dto.getClientID());
        Doctor doctor = (Doctor) doctorRepository.findByID(dto.getDoctorID());
        Analysis analysis = (Analysis) analysisRepository.findByID(analysisId);
        log.debug("Create temporal data client login="+client.getLogin()+", doctor login="+doctor.getLogin());

        Bill bill = new Bill();
        bill.setSum(analysis.getPrice());
        bill.setPaid(false);
        bill.setDoctor(doctor);
        bill.setClient(client);
        bill.setCreateDate(LocalDate.now());
        billRepository.save(bill);
        long tempID = bill.getId();
        Bill updBill = (Bill) billRepository.findByID(tempID);
        log.debug("Create bill with id:"+ tempID);

        AnalysisServiceResult result = new AnalysisServiceResult();
        result.setClient(client);
        result.setWhoSender(doctor);
        result.setBill(updBill);
        result.setAnalysis(analysis);
        result.setCreateDate(LocalDate.now());
        resultRepository.save(result);

        AnalysisServiceResult newResult = (AnalysisServiceResult) resultRepository.findByID(result.getId());
        newResult.setTitle("an-"+analysis.getId()+"-"+result.getId());
        analysisRepository.save(newResult);
        return newResult;
    }

    @Transactional
    @Override
    public Analysis updateAnalysis(DescribeAnalysisDto dto, long analysisID) {
        Analysis analysis = (Analysis) analysisRepository.findByID(analysisID);
        analysis.setPrice(dto.getPrice());
        analysis.setName(dto.getName());
        analysis.setDescribe(dto.getDescribe());
        analysisRepository.save(analysis);
        return analysis;
    }

    @Transactional
    @Override
    public void deleteAnalysis(long analysisID) {
        Analysis analysis = (Analysis) analysisRepository.findByID(analysisID);
        analysisRepository.delete(analysis);
    }
}
