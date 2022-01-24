package com.medclinic.service;

import com.medclinic.config.ApplicationConfigurationTest;
import com.medclinic.config.HibernateConfigurationTest;
import com.medclinic.entity.Department;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.NoResultException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = {ApplicationConfigurationTest.class, HibernateConfigurationTest.class})
class IDepartmentServiceTest {

    @Autowired
    private IDepartmentService departmentService;
    private Department department;

    @Nested
    @DisplayName("THis test find dep by name")
    class TestFindDepByName{

        @Test
        @DisplayName("When name is exists")
        void testFindDepByNameWhenNameIsExists(){
            department = departmentService.findDepartmentByName("Therapy Department");

            assertEquals("Therapy Department", department.getDepartmentName());
        }

    }

    @Nested
    @DisplayName("This test find dep by id")
    class TestFindDepByID{

        @Test
        @DisplayName("When id is exist")
        void findDepartmentWhenExistID(){
            department = departmentService.findDepartmentByID(1);
            assertEquals("Therapy Department", department.getDepartmentName());
        }

        @Test
        @DisplayName("When id is not exists")
        void findDepartmentWhenIdNotExists(){
            department = departmentService.findDepartmentByID(212121);
            assertNull(department);
        }
    }

    @Nested
    @DisplayName("This test for create department")
    class CreateDepartmentTest{

        @Test
        @DisplayName("This test create department")
        void createNewDepartment(){
            department = departmentService.createNewDepartment("Test DEPTH");
            assertNotNull(department);
            assertEquals("Test DEPTH", department.getDepartmentName());
        }

    }

    @Nested
    @DisplayName("This test for updatable department")
    class TestUpdateDepartment{

        @Test
        @DisplayName("Update department")
        void updateDepartment(){

            department = departmentService.createNewDepartment("Test update dep");

            assertNotNull(department);

            long tempID = department.getId();

            departmentService.updateDepartment("Test update dep", "after update");

            department = null;

            department = departmentService.findDepartmentByID(tempID);

            assertEquals("after update", department.getDepartmentName());
        }
    }
}