package com.medclinic.service;

import com.medclinic.dto.CreateResultDto;
import com.medclinic.dto.DescribeUpdateAnalysisSvcResult;
import com.medclinic.entity.*;
import java.util.List;

public interface IAnalysisSvcResultService {
    AnalysisServiceResult createResultByAnalysis(CreateResultDto dto);
    AnalysisServiceResult createResultByMedService(long serviceId, CreateResultDto dto);
    List <AnalysisServiceResult> findByClient(long clientID);
    List <AnalysisServiceResult> findByNotPaid();
    List <AnalysisServiceResult> findByDoctor(long doctorID);
    List <AnalysisServiceResult> findByAnalysis(long analysisID);
    List <AnalysisServiceResult> findByService(long serviceID);
    AnalysisServiceResult findById(long id);
    void remove(long resultID);
    void update(long result, DescribeUpdateAnalysisSvcResult describeUpdate);
}
