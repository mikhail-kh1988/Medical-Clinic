package com.medclinic.service;

import com.medclinic.dto.CreateResultDTO;
import com.medclinic.dto.DescribeUpdateAnalysisSvcResult;
import com.medclinic.entity.*;
import java.util.List;

public interface IAnalysisSvcResultService {
    AnalysisServiceResult createResultByAnalysis(CreateResultDTO dto);
    AnalysisServiceResult createResultByMedService(CreateResultDTO dto);
    List <AnalysisServiceResult> findByClient(long clientID);
    List <AnalysisServiceResult> findByNotPaid();
    List <AnalysisServiceResult> findByDoctor(long doctorID);
    List <AnalysisServiceResult> findByAnalysis(long analysisID);
    List <AnalysisServiceResult> findByService(long serviceID);
    AnalysisServiceResult findById(long id);
    void remove(AnalysisServiceResult result);
    void update(AnalysisServiceResult result, DescribeUpdateAnalysisSvcResult describeUpdate);
}
