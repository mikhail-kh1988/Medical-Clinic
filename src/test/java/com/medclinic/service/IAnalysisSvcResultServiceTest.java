package com.medclinic.service;


import com.medclinic.config.ApplicationConfigurationTest;
import com.medclinic.config.HibernateConfigurationTest;
import com.medclinic.dto.CreateResultDto;
import com.medclinic.entity.AnalysisServiceResult;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = {ApplicationConfigurationTest.class, HibernateConfigurationTest.class})
class IAnalysisSvcResultServiceTest{

    @Autowired
    private IAnalysisSvcResultService resultService;
    private AnalysisServiceResult result;

    @Nested
    @DisplayName("This test for create result on by analysis")
    class TestForResultByAnalysys{


        @Test
        @DisplayName("When exist analysis")
        void createResultByAnalysis(){
            CreateResultDto dto = new CreateResultDto();
            dto.setAnalysisID(1);
            dto.setClientID(2);
            dto.setDoctorID(3);

            result = resultService.createResultByAnalysis(1, dto);

            assertAll("Matching fields",
                    ()-> assertEquals("TEST DESCR", result.getAnalysis().getDescribe()),
                    ()-> assertEquals("TEST", result.getAnalysis().getName()),
                    ()-> assertEquals("Client", result.getClient().getFamilyName()),
                    ()-> assertEquals("Ivanov", result.getWhoSender().getFamilyName()));
        }
    }

}