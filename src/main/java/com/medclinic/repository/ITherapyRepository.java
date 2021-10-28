package com.medclinic.repository;

import com.medclinic.hibernate.GenericDAO;
import java.util.List;

public interface ITherapyRepository<T, ID> extends GenericDAO {
    List<T> findByDiseaseId(long id);
    List<T> findByDescribeComplaint(String describe);
}
