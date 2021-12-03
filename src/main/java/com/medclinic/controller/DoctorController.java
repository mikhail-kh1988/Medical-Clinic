package com.medclinic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medclinic.dto.DoctorDto;
import com.medclinic.dto.DoctorWorkFlowDto;
import com.medclinic.dto.MedicalCardBodyDto;
import com.medclinic.dto.MedicalCardDto;
import com.medclinic.exception.NotUniqueUserRegistrationException;
import com.medclinic.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private IDoctorService doctorService;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/")
    public ResponseEntity<String> getAllDoctors() throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(doctorService.findAll()), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> updateDoctor(@PathVariable long id, @RequestBody DoctorDto dto){
        doctorService.updateDoctor(id, dto);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }

    @GetMapping("/{doctorID}/{serviceID}")
    public ResponseEntity<String> addNewService(@PathVariable long serviceID, @PathVariable long doctorID){
        doctorService.addNewService(serviceID, doctorID);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable long id){
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<String> createDoctor(@RequestBody DoctorDto dto) throws NotUniqueUserRegistrationException, JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(doctorService.createNewDoctor(dto)), HttpStatus.OK);
    }

    @PostMapping("/{login}/createWF")
    public ResponseEntity<String> createWorkFlow(@RequestBody DoctorWorkFlowDto dto, @PathVariable String login){
        doctorService.setWorkFlow(login, dto);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }

    @GetMapping("/{doctorID}/getWF")
    public ResponseEntity<String> getWorkFlow(@PathVariable long doctorID) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(doctorService.getMyWorkFlow(LocalDate.now(), doctorID)), HttpStatus.OK);
    }

    @PutMapping("/{doctorID}/medicalCard")
    public ResponseEntity<String> createMedicalCard(@PathVariable long doctorID, @RequestBody MedicalCardDto dto) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(doctorService.createMedicalCard(dto, doctorID)), HttpStatus.OK);
    }

    @GetMapping("/{clientID}/medicalCard")
    public ResponseEntity<String> getMedicalCard(@PathVariable long clientID) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(doctorService.getMedicalCard(clientID)), HttpStatus.OK);
    }

    @PostMapping("/{medcardID}/medicalCard")
    public ResponseEntity<String> addNewRecordInMedcard(@PathVariable long medcardID, @RequestBody MedicalCardBodyDto dto){
        doctorService.addNewRecordInMedicalCardClient(dto, medcardID);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }


}
