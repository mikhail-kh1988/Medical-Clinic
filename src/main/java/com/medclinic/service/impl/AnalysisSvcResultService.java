package com.medclinic.service.impl;

import com.medclinic.dto.CreateResultDTO;
import com.medclinic.dto.DescribeUpdateAnalysisSvcResult;
import com.medclinic.entity.*;
import com.medclinic.repository.*;
import com.medclinic.service.IAnalysisSvcResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class AnalysisSvcResultService implements IAnalysisSvcResultService {

    @Autowired
    private IAnalysisServiceResultRepository resultRepository;

    @Autowired
    private IAnalysisRepository analysisRepository;

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private IMedicalServiceRepository serviceRepository;

    @Autowired
    private IBillRepository billRepository;

    @Transactional
    @Override
    public AnalysisServiceResult createResultByAnalysis(CreateResultDTO dto) {

        Analysis analysis = (Analysis) analysisRepository.findByID(dto.getAnalysisID());
        Client client = (Client) clientRepository.findByID(dto.getClientID());
        Doctor doctor = (Doctor) doctorRepository.findByID(dto.getDoctorID());

        Bill bill = new Bill();
        bill.setSum(analysis.getPrice());
        bill.setCreateDate(GregorianCalendar.from(ZonedDateTime.now()));
        bill.setPaid(false);
        bill.setClient(client);
        bill.setDoctor(doctor);
        billRepository.save(bill);
        long tempBillId = bill.getId();

        Bill billForAnalysisResult = (Bill) billRepository.findByID(tempBillId);

        AnalysisServiceResult result = new AnalysisServiceResult();
        result.setAnalysis(analysis);
        result.setClient(client);
        result.setWhoSender(doctor);
        result.setBill(billForAnalysisResult);
        result.setCreateDate(GregorianCalendar.from(ZonedDateTime.now()));
        resultRepository.save(result);
        long tempResultID = result.getId();

        AnalysisServiceResult returnResult = (AnalysisServiceResult) resultRepository.findByID(tempResultID);
        returnResult.setTitle("an-"+analysis.getId()+"-"+result.getId());
        analysisRepository.save(returnResult);

        return returnResult;
    }

    @Transactional
    @Override
    public AnalysisServiceResult createResultByMedService(CreateResultDTO dto) {
        Client client = (Client) clientRepository.findByID(dto.getClientID());
        Doctor doctor = (Doctor) doctorRepository.findByID(dto.getDoctorID());
        MedicalService service = (MedicalService) serviceRepository.findByID(dto.getServiceID());

        Bill bill = new Bill();
        bill.setSum(service.getPrice());
        bill.setCreateDate(GregorianCalendar.from(ZonedDateTime.now()));
        bill.setPaid(false);
        bill.setClient(client);
        bill.setDoctor(doctor);
        billRepository.save(bill);
        long tempBillId = bill.getId();

        Bill billForAnalysisResult = (Bill) billRepository.findByID(tempBillId);

        AnalysisServiceResult result = new AnalysisServiceResult();
        result.setService(service);
        result.setClient(client);
        result.setWhoSender(doctor);
        result.setBill(billForAnalysisResult);
        result.setCreateDate(GregorianCalendar.from(ZonedDateTime.now()));
        resultRepository.save(result);
        long tempResultID = result.getId();

        AnalysisServiceResult returnResult = (AnalysisServiceResult) resultRepository.findByID(tempResultID);
        returnResult.setTitle("sc-"+service.getId()+"-"+result.getId());
        analysisRepository.save(returnResult);

        return returnResult;
    }

    @Override
    public List<AnalysisServiceResult> findByClient(long clientID) {
        return resultRepository.findByClientID(clientID);
    }

    @Override
    public List<AnalysisServiceResult> findByNotPaid() {
        return resultRepository.findByNotPaidResults();
    }

    @Override
    public List<AnalysisServiceResult> findByDoctor(long doctorID) {
        return resultRepository.findByDoctorID(doctorID);
    }

    @Override
    public List<AnalysisServiceResult> findByAnalysis(long analysisID) {
        return resultRepository.findByAnalysisID(analysisID);
    }

    @Override
    public List<AnalysisServiceResult> findByService(long serviceID) {
        return resultRepository.findByServiceID(serviceID);
    }

    @Override
    public AnalysisServiceResult findById(long id) {
        return (AnalysisServiceResult) resultRepository.findByID(id);
    }

    @Transactional
    @Override
    public void remove(long resultID) {
        AnalysisServiceResult result = (AnalysisServiceResult) resultRepository.findByID(resultID);
        resultRepository.delete(result);
    }

    @Transactional
    @Override
    public void update(long resultID, DescribeUpdateAnalysisSvcResult describeUpdate) {
        AnalysisServiceResult result = (AnalysisServiceResult) resultRepository.findByID(resultID);
        Doctor doctorChecked = (Doctor) doctorRepository.findByID(describeUpdate.getWhoCheckedID());

        result.setResult(describeUpdate.getResult());
        result.setMarks(describeUpdate.getMarks());
        result.setWhoMakeCheck(doctorChecked);
        result.setSubmitDate(GregorianCalendar.from(ZonedDateTime.now()));

        resultRepository.save(result);
    }
}
