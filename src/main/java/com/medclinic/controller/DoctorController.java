package com.medclinic.controller;

import com.medclinic.dto.DoctorDto;
import com.medclinic.dto.DoctorWorkFlowDto;
import com.medclinic.dto.MedicalCardBodyDto;
import com.medclinic.dto.MedicalCardDto;
import com.medclinic.entity.Doctor;
import com.medclinic.entity.MedicalCardClient;
import com.medclinic.entity.WorkFlow;
import com.medclinic.entity.WorkFlowBody;
import com.medclinic.exception.NotUniqueUserRegistrationException;
import com.medclinic.service.IDoctorService;
import com.medclinic.service.IWorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private IDoctorService doctorService;

    @Autowired
    private IWorkFlowService workFlowService;


    @GetMapping("/")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.findAll());
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> updateDoctor(@PathVariable long id, @RequestBody @Validated DoctorDto dto){
        doctorService.updateDoctor(id, dto);
        return ResponseEntity.ok("success!");
    }

    @GetMapping("/{doctorID}/{serviceID}")
    public ResponseEntity<String> addNewService(@PathVariable long serviceID, @PathVariable long doctorID){
        doctorService.addNewService(serviceID, doctorID);
        return ResponseEntity.ok("success!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable long id){
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("success!");
    }

    @PutMapping("/")
    public ResponseEntity<Doctor> createDoctor(@RequestBody @Validated DoctorDto dto) throws NotUniqueUserRegistrationException{
        return ResponseEntity.ok(doctorService.createNewDoctor(dto));
    }

    @PostMapping("/{login}/createWF")
    public ResponseEntity<String> createWorkFlow(@RequestBody @Validated DoctorWorkFlowDto dto, @PathVariable String login){
        return ResponseEntity.ok("success! wfID:"+doctorService.setWorkFlow(login, dto));
    }

    @PostMapping("/{wfID}/{login}/updateWF")
    public ResponseEntity<String> updateWorkFlow(@RequestBody @Validated DoctorWorkFlowDto dto, @PathVariable long wfID, @PathVariable String login){
        workFlowService.updateWorkFlow(wfID, login, dto);
        return ResponseEntity.ok("success!");
    }

    @GetMapping("/{wfID}/recipe")
    public ResponseEntity<String> recipeClient(@PathVariable long wfID){
        workFlowService.toRecipeClient(wfID);
        return ResponseEntity.ok("success!");
    }

    @GetMapping("/{doctorID}/getWF")
    public ResponseEntity<List<WorkFlow>> getWorkFlow(@PathVariable long doctorID) {
        return ResponseEntity.ok(doctorService.getListMyWorkFlow(doctorID));
    }

    @GetMapping("/{wfId}/clientsRec")
    public ResponseEntity<Set<WorkFlowBody>> getMyPlaningReceipt(@PathVariable long wfId){
        return ResponseEntity.ok(workFlowService.findWorkFlowBodiesById(wfId));
    }

    @PutMapping("/{doctorID}/medicalCard")
    public ResponseEntity<MedicalCardClient> createMedicalCard(@PathVariable long doctorID, @RequestBody @Validated MedicalCardDto dto) {
        return ResponseEntity.ok(doctorService.createMedicalCard(dto, doctorID));
    }

    @GetMapping("/{clientID}/medicalCard")
    public ResponseEntity<MedicalCardClient> getMedicalCard(@PathVariable long clientID){
        return ResponseEntity.ok(doctorService.getMedicalCard(clientID));
    }

    @PostMapping("/{medcardID}/medicalCard")
    public ResponseEntity<String> addNewRecordInMedcard(@PathVariable long medcardID, @RequestBody @Validated MedicalCardBodyDto dto){
        doctorService.addNewRecordInMedicalCardClient(dto, medcardID);
        return ResponseEntity.ok("success!");
    }


}
