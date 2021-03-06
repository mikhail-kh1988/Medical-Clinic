package com.medclinic.service.impl;

import com.medclinic.dto.CreateResultDto;
import com.medclinic.dto.DescribeUpdateAnalysisSvcResult;
import com.medclinic.entity.*;
import com.medclinic.repository.*;
import com.medclinic.service.IAnalysisSvcResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;


@Slf4j
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
    public AnalysisServiceResult createResultByAnalysis(long analysisId , CreateResultDto dto) {

        Analysis analysis = analysisRepository.findByID(analysisId);
        Client client = clientRepository.findByID(dto.getClientID());
        Doctor doctor = doctorRepository.findByID(dto.getDoctorID());

        Bill bill = new Bill();
        bill.setSum(analysis.getPrice());
        bill.setCreateDate(LocalDate.now());
        bill.setPaid(false);
        bill.setClient(client);
        bill.setDoctor(doctor);
        billRepository.save(bill);
        long tempBillId = bill.getId();

        Bill billForAnalysisResult = billRepository.findByID(tempBillId);

        AnalysisServiceResult result = new AnalysisServiceResult();
        result.setAnalysis(analysis);
        result.setClient(client);
        result.setWhoSender(doctor);
        result.setBill(billForAnalysisResult);
        result.setCreateDate(LocalDate.now());
        resultRepository.save(result);
        long tempResultID = result.getId();

        AnalysisServiceResult returnResult = resultRepository.findByID(tempResultID);
        returnResult.setTitle("an-"+analysis.getId()+"-"+result.getId());
        resultRepository.save(returnResult);

        return returnResult;
    }

    @Transactional
    @Override
    public AnalysisServiceResult createResultByMedService(long serviceId, CreateResultDto dto) {
        Client client = clientRepository.findByID(dto.getClientID());
        Doctor doctor = doctorRepository.findByID(dto.getDoctorID());
        MedicalService service = serviceRepository.findByID(serviceId);

        Bill bill = new Bill();
        bill.setSum(service.getPrice());
        bill.setCreateDate(LocalDate.now());
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
        result.setCreateDate(LocalDate.now());
        resultRepository.save(result);
        long tempResultID = result.getId();

        AnalysisServiceResult returnResult = resultRepository.findByID(tempResultID);
        returnResult.setTitle("sc-"+service.getId()+"-"+result.getId());
        resultRepository.save(returnResult);

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
        return resultRepository.findByID(id);
    }

    @Transactional
    @Override
    public void remove(long resultID) {
        AnalysisServiceResult result = resultRepository.findByID(resultID);
        resultRepository.delete(result);
    }

    @Transactional
    @Override
    public void update(long resultID, DescribeUpdateAnalysisSvcResult describeUpdate) {
        AnalysisServiceResult result = resultRepository.findByID(resultID);
        Doctor doctorChecked = doctorRepository.findByID(describeUpdate.getCheckerID());

        result.setResult(describeUpdate.getResult());
        result.setMarks(describeUpdate.getMarks());
        result.setWhoMakeCheck(doctorChecked);
        result.setSubmitDate(LocalDate.now());

        resultRepository.save(result);
    }
}
