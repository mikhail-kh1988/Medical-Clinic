package com.medclinic.controller;

import com.medclinic.dto.ClientUpdateDto;
import com.medclinic.dto.ClientWorkFlowDto;
import com.medclinic.dto.CreateClientDto;
import com.medclinic.entity.Bill;
import com.medclinic.entity.Client;
import com.medclinic.exception.NotUniqueUserRegistrationException;
import com.medclinic.service.IBillService;
import com.medclinic.service.IClientService;
import com.medclinic.service.IWorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @Autowired
    private IBillService billService;

    @Autowired
    private IWorkFlowService workFlowService;

    @PostMapping("/register")
    public ResponseEntity<String> registerClient(@RequestBody @Validated CreateClientDto dto) throws NotUniqueUserRegistrationException {
        return ResponseEntity.ok(""+clientService.createClient(dto).getId());
    }

    @PutMapping("/{wfID}/receipt")
    public ResponseEntity<String> receiptForDoctor(@RequestBody ClientWorkFlowDto dto, @PathVariable long wfID){
        return ResponseEntity.ok(""+workFlowService.createWorkFlowBody(dto, wfID).toString());
    }

    @GetMapping("/{login}")
    public ResponseEntity<Client> getClientByLogin(@PathVariable String login) {
        return ResponseEntity.ok(clientService.findByLogin(login));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClientNew(@PathVariable long id){
        clientService.deleteClient(id);
        return ResponseEntity.ok("success!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@PathVariable long id, @RequestBody @Validated ClientUpdateDto dto){
        clientService.update(id, dto);
        return ResponseEntity.ok("success!");
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Client>> getAllClients(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{id}/bills")
    public ResponseEntity<List<Bill>> getBillsByClient(@PathVariable long id) {
        return ResponseEntity.ok(billService.findByClientID(id));
    }

}
