package com.medclinic.service;

import com.medclinic.config.ApplicationConfigurationTest;
import com.medclinic.config.HibernateConfigurationTest;
import com.medclinic.dto.DescribeAnalysisDto;
import com.medclinic.entity.Analysis;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = {ApplicationConfigurationTest.class, HibernateConfigurationTest.class})
class IAnalysisServiceTest{

    @Autowired
    private  IAnalysisService analysisService;
    private Analysis analysis;

    @Nested
    @DisplayName("Test for dto")
    class WhenEmptyDTO{
        @Test
        @DisplayName("This test create new analysis from DTO")
        void testCreateAnalysis() {
            DescribeAnalysisDto dto = new DescribeAnalysisDto();
            dto.setDescribe("TEST");
            dto.setName("TEST NAME");
            dto.setPrice(111);

            assertAll("Test DTO",
                    ()-> assertEquals("TEST", dto.getDescribe()),
                    ()-> assertEquals("TEST NAME", dto.getName()),
                    ()-> assertEquals(111, dto.getPrice()));

            analysis = analysisService.createAnalysis(dto);

            assertAll("Test fields ",
                    ()-> assertEquals("TEST", analysis.getDescribe()),
                    ()-> assertEquals("TEST NAME", analysis.getName()),
                    ()-> assertEquals(111, analysis.getPrice()));

        }

        @Test
        @DisplayName("When empty DTO")
        void testCreateAnalysisWithoutDTO(){
            assertThrows(NullPointerException.class, ()->analysisService.createAnalysis(null));
        }
    }


    @Nested
    @DisplayName("Nested test find analysis")
    class FindByName{
        @Test
        @DisplayName("Test when find analysis by name")
        void testFindByAnalysisByName() {

            List<Analysis> analysisList = new ArrayList<>();
            analysisList.add(analysis);

            assertAll("Counting test", ()-> assertEquals(1, analysisService.findByAnalysisByName("BLOOD TEST").size()));

            List<Analysis> analysisListActual = analysisService.findByAnalysisByName("BLOOD TEST");

            assertAll("Matching test", ()-> assertEquals("BLOOD TEST", analysisListActual.get(0).getName()),
                    ()-> assertEquals("BLOOD TEST ALL THIS", analysisListActual.get(0).getDescribe()),
                    ()-> assertEquals(111, analysisListActual.get(0).getPrice()));
        }

        @Test
        @DisplayName("Test when not found analysis by name")
        void testFindByAnalysisByNameWhereNotFoundExceptin(){

            assertNotNull(analysisService.findByAnalysisByName("LDSKJFl"));

        }

    }

    @Nested
    @DisplayName("Test when get all analysis")
    class GetAllAnalysis{

        @Test
        @DisplayName("return all analysis when exists data")
        void getAllAnalysisWhenExistsData(){
            assertNotNull(analysisService.findAllAnalysis());
        }

        @Test
        @Order(1)
        @DisplayName("return analysis when no data")
        void getAllAnalysisWhenNoData(){

            assertEquals(true ,analysisService.findAllAnalysis().isEmpty());

        }

    }

    @Nested
    @DisplayName("Find analysis when find by id")
    class NestedClassFindAnalysisByID{

        @Test
        @DisplayName("Find by id")
        void findAnalysisByID(){

            analysis = analysisService.findAnalysisByID(2);

            assertAll("Matched fields analysis",
                    ()-> assertEquals(2, analysis.getId()),
                    ()-> assertEquals("BLOOD TEST ALL THIS", analysis.getDescribe()),
                    ()-> assertEquals("BLOOD TEST", analysis.getName()),
                    ()-> assertEquals(111, analysis.getPrice()));

        }

        @Test
        @DisplayName("Find not exists id")
        void findAnalysisByNotExistID(){
            assertNull(analysisService.findAnalysisByID(898));
        }

    }


    @Nested
    @DisplayName("This test updatable fields")
    class TestUpdateFieldsAnalysis{

        @Test
        @DisplayName("when update method in service")
        void testWhenUpdateData(){
            DescribeAnalysisDto dto = new DescribeAnalysisDto();
            dto.setName("TEST UPDATE");
            dto.setPrice(123);
            dto.setDescribe("0000000");

            analysis = analysisService.createAnalysis(dto);
            long tempId = analysis.getId();

            assertAll("Match fields",
                    ()-> assertEquals("TEST UPDATE", analysis.getName()),
                    ()-> assertEquals("0000000", analysis.getDescribe()),
                    ()-> assertEquals(123, analysis.getPrice()));

            analysis = null;

            DescribeAnalysisDto updatableDTO = new DescribeAnalysisDto();
            updatableDTO.setDescribe("Test describe");
            updatableDTO.setName("Passed Test Name");
            updatableDTO.setPrice(1);

            analysis = analysisService.updateAnalysis(updatableDTO, tempId);

            assertAll("Match updatable fields",
                    ()-> assertEquals("Test describe", analysis.getDescribe()),
                    ()-> assertEquals("Passed Test Name", analysis.getName()),
                    ()-> assertEquals(1, analysis.getPrice()));
        }
    }

    @Test
    void testDeleteAnalysis() {
    }

    @Nested
    @DisplayName("This nested test for ckecked deleted function")
    class WhenTestedCheckedDeleteFunctionServiceAnalaysis{


        @Test
        @DisplayName("When check deleted analysis")
        void deleteAnalysisFromAnalysisService(){
            DescribeAnalysisDto dto = new DescribeAnalysisDto();
            dto.setName("KDJFH UPDATE");
            dto.setPrice(123);
            dto.setDescribe("0000000");

            analysis = analysisService.createAnalysis(dto);
            long tempId = analysis.getId();

            List<Analysis> analysisList = new ArrayList<>();

            assertNotNull(analysisService.findAnalysisByID(tempId));

            analysisService.deleteAnalysis(tempId);

            assertNull(analysisService.findAnalysisByID(tempId));

        }
    }
}