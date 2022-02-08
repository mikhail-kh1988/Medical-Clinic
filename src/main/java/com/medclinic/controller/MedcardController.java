package com.medclinic.controller;

import com.medclinic.entity.MedicalCardClient;
import com.medclinic.service.IMedicalCardClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/medcards")
public class MedcardController {

    @Autowired
    private IMedicalCardClientService medicalCardClientService;


    @GetMapping("/")
    public ResponseEntity<List<MedicalCardClient>> getAllMedcard() {
        return ResponseEntity.ok(medicalCardClientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalCardClient> getMedcardByID(@PathVariable long id) {
        return ResponseEntity.ok(medicalCardClientService.findById(id));
    }

    @GetMapping("/{doctorID}/doctor")
    public ResponseEntity<List<MedicalCardClient>> getCardsByDoctor(@PathVariable long doctorID) {
        return ResponseEntity.ok(medicalCardClientService.findByDoctorId(doctorID));
    }

    @GetMapping("/{clientID}/client")
    public ResponseEntity<MedicalCardClient> getCardsByClient(@PathVariable long clientID) {
        return ResponseEntity.ok(medicalCardClientService.findByClientId(clientID));
    }
}
