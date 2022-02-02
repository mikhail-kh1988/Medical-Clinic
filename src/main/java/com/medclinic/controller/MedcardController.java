package com.medclinic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medclinic.service.IMedicalCardClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medcards")
public class MedcardController {

    @Autowired
    private IMedicalCardClientService medicalCardClientService;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/")
    public ResponseEntity<String> getAllMedcard() throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(medicalCardClientService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getMedcardByID(@PathVariable long id) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(medicalCardClientService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/{doctorID}/doctor")
    public ResponseEntity<String> getCardsByDoctor(@PathVariable long doctorID) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(medicalCardClientService.findByDoctorId(doctorID)), HttpStatus.OK);
    }

    @GetMapping("/{clientID}/client")
    public ResponseEntity<String> getCardsByClient(@PathVariable long clientID) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(medicalCardClientService.findByClientId(clientID)), HttpStatus.OK);
    }
}
