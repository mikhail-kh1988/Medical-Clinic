package com.medclinic.service.impl;

import com.medclinic.dto.DescribeAnalysisDTO;
import com.medclinic.dto.ResultByAnalysisDTO;
import com.medclinic.entity.*;
import com.medclinic.repository.*;
import com.medclinic.service.IAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
    public void setAnalysisRepository(IAnalysisRepository repository){
        this.analysisRepository = repository;
    }

    @Transactional
    @Override
    public Analysis createAnalysis(DescribeAnalysisDTO dto) {
        Analysis analysis = new Analysis();
        analysis.setName(dto.getName());
        analysis.setDescribe(dto.getDescribe());
        analysis.setPrice(dto.getPrice());

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

    @Transactional()
    @Override
    public AnalysisServiceResult createResultByAnalysis(ResultByAnalysisDTO dto) {
        Client client = (Client) clientRepository.findByID(dto.getClientID());
        Doctor doctor = (Doctor) doctorRepository.findByID(dto.getDoctorID());
        Analysis analysis = (Analysis) analysisRepository.findByID(dto.getAnalysisID());

        Bill bill = new Bill();
        bill.setSum(analysis.getPrice());
        bill.setPaid(false);
        bill.setDoctor(doctor);
        bill.setClient(client);
        bill.setCreateDate(GregorianCalendar.from(ZonedDateTime.now()));
        billRepository.save(bill);
        long tempID = bill.getId();
        Bill updBill = (Bill) billRepository.findByID(tempID);

        AnalysisServiceResult result = new AnalysisServiceResult();
        result.setClient(client);
        result.setWhoSender(doctor);
        result.setBill(updBill);
        result.setAnalysis(analysis);
        result.setCreateDate(GregorianCalendar.from(ZonedDateTime.now()));
        result.setTitle("an-"+analysis.getId()+"-"+result.getId());
        resultRepository.save(result);

        return result;
    }

    @Override
    public Analysis updateAnalysis(DescribeAnalysisDTO dto, long analysisID) {
        return null;
    }

    @Override
    public void deleteAnalysis(Analysis analysis) {

    }
}
