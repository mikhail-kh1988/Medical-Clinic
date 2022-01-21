package com.medclinic.service;


import com.medclinic.config.ApplicationConfigurationTest;
import com.medclinic.config.HibernateConfigurationTest;
import com.medclinic.dto.CreateResultDto;
import com.medclinic.dto.DescribeUpdateAnalysisSvcResult;
import com.medclinic.entity.AnalysisServiceResult;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

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

    @Nested
    @DisplayName("This test for create result by service")
    class TestForResultByService{

        @Test
        @DisplayName("When create result on by service")
        void createResultByService(){
            CreateResultDto resultDto = new CreateResultDto();
            resultDto.setServiceID(1);
            resultDto.setClientID(2);
            resultDto.setDoctorID(3);

            result = resultService.createResultByMedService(1, resultDto);

            assertAll("Match fields",
                    ()-> assertEquals("TEST SERVICE", result.getService().getName()),
                    ()-> assertEquals("101-TST", result.getService().getExternalCode()),
                    ()-> assertEquals("Client", result.getClient().getFamilyName()),
                    ()-> assertEquals("Ivanov", result.getWhoSender().getFamilyName()));
        }

    }

    @Nested
    @DisplayName("This test for find result by client ID")
    class TestForFindResultByClientID{


        @Test
        @DisplayName("When exist id")
        void findResultByClientID(){

            assertNotNull(resultService.findByClient(2));

        }

        @Test
        @DisplayName("When not exist id")
        void findResultNotExistClientID(){
            assertEquals(true, resultService.findByClient(858).isEmpty());
        }

    }

    @Nested
    @DisplayName("This test for find result by ID")
    class TestForFindResultByDoctorID{

        @Test
        @DisplayName("When exist result ID")
        void findResultByDoctorIDExist(){
            assertNotNull(resultService.findById(1));
        }

        @Test
        @DisplayName("When not exist result ID")
        void findResultByResultID(){
            result = resultService.findById(5454);

            assertNull(result);
        }

    }

    @Nested
    @DisplayName("This test for remove results")
    class TestForRemoveResults{

        @Test
        @DisplayName("When exist result id")
        void removeResultByID(){
        }

        @Test
        @DisplayName("When not exist result ID")
        void removeResultWithoutID(){
        }
    }

    @Nested
    @DisplayName("This test for update result")
    class TestForUpdateResult{

        @Test
        @DisplayName("Check field update")
        void checkFieldUpdate(){

            DescribeUpdateAnalysisSvcResult resultDTO = new DescribeUpdateAnalysisSvcResult();

            resultDTO.setResult("TEST RESULT");
            resultDTO.setMarks("TEST MARK");
            resultDTO.setWhoCheckedID(1);

            resultService.update(1, resultDTO);

            result = resultService.findById(1);

            assertAll("Check fields.",
                    ()-> assertEquals("TEST RESULT", result.getResult()),
                    ()-> assertEquals("TEST MARK", result.getMarks()),
                    ()-> assertEquals(1, result.getWhoMakeCheck().getId()));

        }
    }


}