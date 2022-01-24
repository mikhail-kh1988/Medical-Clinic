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

import java.util.List;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = {ApplicationConfigurationTest.class, HibernateConfigurationTest.class})
class IBillServiceTest {

    @Autowired
    private IBillService billService;
    private Bill bill;


    @Nested
    @DisplayName("This test for found bill by id")
    class FindBillByID{

        @Test
        @DisplayName("Find bill by id")
        void findBillByID(){
            assertNotNull(billService.findById(1));
        }

        @Test
        @DisplayName("When id not exists")
        void findBillByNotExistsID(){
            assertNull(billService.findById(9898));
        }

    }

    @Nested
    @DisplayName("This test find count bills")
    class FindCountBills{

        @Test
        @DisplayName("Find count bill")
        void findCountBill(){
            assertNotNull(billService.getCountBill());
        }
    }


    @Nested
    @DisplayName("This test for trying paid bill")
    class TestTryingPaidBill{

        @Test
        @DisplayName("Try paid bill")
        void tryPaidBill(){

            bill = billService.findById(1);

            assertEquals(false, bill.isPaid());

            bill = null;

            billService.toPaid(1);

            bill = billService.findById(1);

            assertEquals(true, bill.isPaid());
        }

        @Test
        @DisplayName("Find paid bill")
        void findPaidBill(){
            List<Bill> billList = billService.findByPaid();

            assertEquals(false, billList.isEmpty());
        }
    }
}