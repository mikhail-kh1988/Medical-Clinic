package com.medclinic.repository.impl;

import com.medclinic.config.hibernate.GenericDAOImpl;
import com.medclinic.entity.MedicalCardBody;
import com.medclinic.repository.IMedicalCardClientBodyRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MedicalCardClientBodyRepository extends GenericDAOImpl<MedicalCardBody> implements IMedicalCardClientBodyRepository {
}
