package com.medclinic.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medclinic.entity.*;
import com.medclinic.repository.*;
import com.medclinic.repository.impl.*;
import com.medclinic.service.*;
import com.medclinic.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    public ICommentRepository getCommentRepository(){
        CommentRepository commentRepository = new CommentRepository();
        commentRepository.setEntityClass(Comment.class);
        return commentRepository;
    }

    @Bean
    public IUserRepository getUserRepository(){
        UserRepository repository = new UserRepository();
        repository.setEntityClass(User.class);
        return repository;
    }

    @Bean
    public IWorkFlowRepository getWorkFlowRepository(){
        WorkFlowRepository repository = new WorkFlowRepository();
        repository.setEntityClass(WorkFlow.class);
        return repository;
    }

    @Bean
    public IWorkFlowBodyRepository getWorkFlowBodyRepository(){
        return new WorkFlowBodyRepository();
    }

    @Bean
    public IWorkFlowService getWorkFlowService(){
        return new WorkFlowService();
    }

    @Bean
    public IUserService getUserService(){
        return new UserService();
    }

    @Bean
    public IDoctorService getDoctorService(){
        return new DoctorService();
    }

    @Bean
    public IMedicalSvcService getMedicalService(){
        return new MedicalSvcService();
    }

    @Bean
    public IMedicalCardClientRepository getMedicalCardClientRepository(){
        MedicalCardClientRepository cardClientRepository = new MedicalCardClientRepository();
        cardClientRepository.setEntityClass(MedicalCardClient.class);
        return cardClientRepository;
    }

    @Bean
    public IMedicalCardClientService getMedicalCardService(){
        return new MedicalCardClientService();
    }

    @Bean
    public IMedicalCardClientBodyRepository getMedicalCardClientBodyRepository(){
        return new MedicalCardClientBodyRepository();
    }

    @Bean
    public IDiseaseRepository getDiseaseRepository(){
        DiseaseRepository diseaseRepository = new DiseaseRepository();
        diseaseRepository.setEntityClass(Disease.class);
        return diseaseRepository;
    }

    @Bean
    public IDiseaseService getDiseaseService(){
        return new DiseaseService();
    }

    @Bean
    public IDepartmentRepository getDepartmentRepository(){
        DepartmentRepository departmentRepository = new DepartmentRepository();
        departmentRepository.setEntityClass(Department.class);
        return departmentRepository;
    }

    @Bean
    public IDepartmentService getDepartmentService(){
        return new DepartmentService();
    }

    @Bean
    public ICommentService getCommentService(){
        return new CommentService();
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
    public IBillService getBillService(){
        return new BillService();
    }

    @Bean
    public ClientService getClientService(){
        return new ClientService();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        return encoder;
    }

    @Bean
    public ObjectMapper getMapper(){
        return new ObjectMapper();
    }

}
