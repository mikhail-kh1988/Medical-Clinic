package com.medclinic.repository.impl;

import com.medclinic.config.hibernate.GenericDAOImpl;
import com.medclinic.entity.WorkFlowBody;
import com.medclinic.repository.IWorkFlowBodyRepository;
import org.springframework.stereotype.Repository;

@Repository
public class WorkFlowBodyRepository extends GenericDAOImpl<WorkFlowBody> implements IWorkFlowBodyRepository {
}
