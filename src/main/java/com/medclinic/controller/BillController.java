package com.medclinic.controller;


import com.medclinic.entity.Bill;
import com.medclinic.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private IBillService billService;

    @GetMapping("/paid")
    public ResponseEntity<List<Bill>> getPaidBill(){
        return ResponseEntity.ok(billService.findByPaid());
    }

    @GetMapping("/paid/{id}")
    public ResponseEntity<String> toPaidBill(@PathVariable long id){
        billService.toPaid(id);
        return ResponseEntity.ok("success!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable long id){
        return ResponseEntity.ok(billService.findById(id));
    }

    @GetMapping("/{id}/doctor")
    public ResponseEntity<List<Bill>> getBillByDoctor(@PathVariable long id){
        return ResponseEntity.ok(billService.findByDoctorID(id));
    }

    @GetMapping("/{id}/client")
    public ResponseEntity<List<Bill>> getBillByClient(@PathVariable long id){
        return ResponseEntity.ok(billService.findByClientID(id));
    }

    @GetMapping("/count")
    public ResponseEntity<String> getCountBill(){
        return ResponseEntity.ok(""+billService.getCountBill());
    }


}
