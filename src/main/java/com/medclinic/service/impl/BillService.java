package com.medclinic.service.impl;

import com.medclinic.entity.Bill;
import com.medclinic.entity.Client;
import com.medclinic.entity.Doctor;
import com.medclinic.repository.IBillRepository;
import com.medclinic.service.IBillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import java.util.List;

@Slf4j
@Service
public class BillService implements IBillService {

    @Autowired
    private IBillRepository billRepository;

    @Override
    public List<Bill> findByPaid() {
        return billRepository.findByPaid();
    }

    @Override
    public Bill findById(long id) {
        return (Bill) billRepository.findByID(id);
    }

    @Override
    public List<Bill> findByDoctorID(long id) {
        return billRepository.findByDoctorID(id);
    }

    @Override
    public List<Bill> findByClientID(long id) {
        return billRepository.findByClientID(id);
    }

    @Override
    public long getCountBill(){
        return billRepository.getCount();
    }

    @Transactional
    @Override
    public void toPaid(long id) {
        Bill bill = (Bill) billRepository.findByID(id);
        bill.setPaid(true);
        bill.setPaidDate(LocalDate.now());
        billRepository.save(bill);
    }

    @Override
    public Bill createNewBill(Client client, Doctor doctor, int sum) {
        Bill bill = new Bill();

        bill.setClient(client);
        bill.setDoctor(doctor);
        bill.setCreateDate(LocalDate.now());
        bill.setSum(sum);

        billRepository.save(bill);

        return billRepository.save(bill);
    }
}
