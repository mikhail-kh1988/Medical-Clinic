package com.medclinic.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medclinic.entity.*;
import com.medclinic.repository.*;
import com.medclinic.repository.impl.*;
import com.medclinic.service.IAnalysisService;
import com.medclinic.service.IAnalysisSvcResultService;
import com.medclinic.service.impl.AnalysisService;
import com.medclinic.service.impl.AnalysisSvcResultService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class ApplicationConfigurationTest {


    @Bean
    public IAnalysisRepository getAnalysisRepository(){
        AnalysisRepository analysisRepository = new AnalysisRepository();
        analysisRepository.setEntityClass(Analysis.class);
        return analysisRepository;
    }

    @Bean
    public IClientRepository getClientRepository(){
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.setEntityClass(Client.class);
        return clientRepository;
    }

    @Bean
    public IDoctorRepository getDoctorRepository(){
        DoctorRepository doctorRepository = new DoctorRepository();
        doctorRepository.setEntityClass(Doctor.class);
        return doctorRepository;
    }

    @Bean
    public IAnalysisServiceResultRepository getAnalaysisServiceResultRepo(){
        AnalysisServiceResultRepository analysisServiceResultRepository = new AnalysisServiceResultRepository();
        analysisServiceResultRepository.setEntityClass(AnalysisServiceResult.class);
        return analysisServiceResultRepository;
    }

    @Bean
    public IBillRepository getBillRepository(){
        BillRepository billRepository = new BillRepository();
        billRepository.setEntityClass(Bill.class);
        return billRepository;
    }

    @Bean
    public IMedicalServiceRepository getMedicalServiceRepository(){
        MedicalServiceRepository medicalServiceRepository = new MedicalServiceRepository();
        medicalServiceRepository.setEntityClass(MedicalService.class);
        return medicalServiceRepository;
    }

    @Bean
    public IAnalysisSvcResultService getAnalysisServiceResult(){
        AnalysisSvcResultService resultService = new AnalysisSvcResultService();
        return resultService;
    }

    @Bean
    public IAnalysisService getAnalysisService(){
        AnalysisService analysisService = new AnalysisService();
        return analysisService;
    }

    @Bean
    public ObjectMapper getMapper(){
        return new ObjectMapper();
    }

}
