package com.medclinic.service;

import com.medclinic.entity.Department;

public interface IDepartmentService {
    Department findDepartmentByName(String name);
    Department findDepartmentByID(long id);
    Department createNewDepartment(String nameDepth);
    void updateDepartment(String department, String newNameDep);
    void deleteDepartment(String department);
}
