package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import com.medclinic.entity.AnalysisServiceResult;

import java.io.Serializable;
import java.util.List;

public interface IAnalysisServiceResultRepository extends GenericDAO<AnalysisServiceResult> {
    List<AnalysisServiceResult> findByAnalysisID(long id);
    List<AnalysisServiceResult> findByServiceID(long id);
    List<AnalysisServiceResult> findByDoctorID(long id);
    List<AnalysisServiceResult> findByClientID(long id);
    AnalysisServiceResult findByBillID(long id);
    List<AnalysisServiceResult> findByNotPaidResults();
}
