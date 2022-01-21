package com.medclinic.service;

import com.medclinic.config.ApplicationConfigurationTest;
import com.medclinic.config.HibernateConfigurationTest;
import com.medclinic.entity.Bill;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = {ApplicationConfigurationTest.class, HibernateConfigurationTest.class})
class IBillServiceTest {

    @Autowired
    private IBillService billService;
    private Bill bill;


    @Test
    void findByPaid() {
    }

    @Nested
    @DisplayName("This test for find paid bill")
    class TestFindPaidBill{

        @Test
        @DisplayName("Find paid bill")
        void findPaidBill(){
            List<Bill> billList = billService.findByPaid();


            assertEquals(true, billService.findByPaid());
        }
    }

    @Test
    void findById() {
    }

    @Test
    void findByDoctorID() {
    }

    @Test
    void findByClientID() {
    }

    @Test
    void getCountBill() {
    }

    @Test
    void toPaid() {
    }
}