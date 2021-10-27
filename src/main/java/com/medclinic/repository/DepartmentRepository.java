package com.medclinic.repository;

import com.medclinic.hibernate.GenericDAO;

public interface DepartmentRepository<T, ID> extends GenericDAO {

    T findByDepName(String name);

}
