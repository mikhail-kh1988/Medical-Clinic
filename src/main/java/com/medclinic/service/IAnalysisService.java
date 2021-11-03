package com.medclinic.service;

import com.medclinic.dto.DescribeAnalysisDTO;
import com.medclinic.entity.Analysis;
import com.medclinic.entity.AnalysisServiceResult;
import com.medclinic.entity.Client;
import com.medclinic.entity.Doctor;

import java.util.List;

public interface IAnalysisService {
    Analysis createAnalysis(DescribeAnalysisDTO dto);
    List<Analysis> findByAnalysisByName(String name);
    Analysis findAnalysisByID(long id);
    AnalysisServiceResult createResultByAnalysis(Analysis analysis, Client client, Doctor doctor);
    Analysis updateAnalysis(DescribeAnalysisDTO dto, long analysisID);
    void deleteAnalysis(Analysis analysis);
}
