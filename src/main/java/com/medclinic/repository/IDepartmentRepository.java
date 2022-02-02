package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import com.medclinic.entity.Department;

public interface IDepartmentRepository extends GenericDAO<Department> {

    Department findByDepName(String name);

}
