package com.medclinic.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medclinic.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private IBillService billService;

    @GetMapping("/paid")
    public ResponseEntity<String> getPaidBill() throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(billService.findByPaid()), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<String> getBillById(@PathVariable long id) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(billService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/getByDoctorId/{id}")
    public ResponseEntity<String> getBillByDoctor(@PathVariable long id) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(billService.findByDoctorID(id)), HttpStatus.OK);
    }

    @GetMapping("/getByClientId/{id}")
    public ResponseEntity<String> getBillByClient(@PathVariable long id) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(billService.findByClientID(id)), HttpStatus.OK);
    }

    @GetMapping("/getCountBill")
    public ResponseEntity<String> getCountBill() throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(billService.getCountBill()), HttpStatus.OK);
    }

    @GetMapping("/toPaidBill/{id}")
    public ResponseEntity<String> toPaidBill(@PathVariable long id){
        billService.toPaid(id);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }


}
