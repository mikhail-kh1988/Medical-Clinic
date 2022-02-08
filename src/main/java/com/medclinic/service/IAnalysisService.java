package com.medclinic.service;

import com.medclinic.dto.DescribeAnalysisDto;
import com.medclinic.dto.ResultByAnalysisDto;
import com.medclinic.entity.Analysis;
import com.medclinic.entity.AnalysisServiceResult;

import java.util.List;

public interface IAnalysisService {
    Analysis createAnalysis(DescribeAnalysisDto dto);
    Analysis findByAnalysisByName(String name);
    List<Analysis> findAllAnalysis();
    Analysis findAnalysisByID(long id);
    AnalysisServiceResult createResultByAnalysis(long analysisId, ResultByAnalysisDto dto);
    Analysis updateAnalysis(DescribeAnalysisDto dto, long analysisID);
    void deleteAnalysis(long id);
}
