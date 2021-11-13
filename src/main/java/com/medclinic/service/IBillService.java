package com.medclinic.service;

import com.medclinic.entity.Bill;
import java.util.List;

public interface IBillService {
    List<Bill> findByPaid();
    Bill findById(long id);
    List<Bill> findByDoctorID(long id);
    List<Bill> findByClientID(long id);
    long getCountBill();
    void toPaid(long id);
}
