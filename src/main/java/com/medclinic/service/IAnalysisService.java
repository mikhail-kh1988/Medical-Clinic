package com.medclinic.service;

import com.medclinic.dto.DescribeAnalysisDTO;
import com.medclinic.dto.ResultByAnalysisDTO;
import com.medclinic.entity.Analysis;
import com.medclinic.entity.AnalysisServiceResult;
import com.medclinic.entity.Client;
import com.medclinic.entity.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IAnalysisService {
    Analysis createAnalysis(DescribeAnalysisDTO dto);
    List<Analysis> findByAnalysisByName(String name);
    List<Analysis> findAllAnalysis();
    Analysis findAnalysisByID(long id);
    AnalysisServiceResult createResultByAnalysis(ResultByAnalysisDTO dto);
    Analysis updateAnalysis(DescribeAnalysisDTO dto, long analysisID);
    void deleteAnalysis(long id);
}
