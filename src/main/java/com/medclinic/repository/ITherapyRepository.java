package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import java.util.List;

public interface ITherapyRepository<T> extends GenericDAO {
    List<T> findByDiseaseId(long id);
    List<T> findByDescribeComplaint(String describe);
}
