package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import com.medclinic.entity.Therapy;

import java.util.List;

public interface ITherapyRepository extends GenericDAO<Therapy> {
    List<Therapy> findByDiseaseId(long id);
    List<Therapy> findByDescribeComplaint(String describe);
}
