package com.medclinic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medclinic.dto.ClientUpdateDto;
import com.medclinic.dto.CreateClientDto;
import com.medclinic.entity.Client;
import com.medclinic.exception.NotUniqueUserRegistrationException;
import com.medclinic.service.IBillService;
import com.medclinic.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private IClientService clientService;

    @Autowired
    private IBillService billService;

    @PostMapping("/register")
    public ResponseEntity<String> registerClient(@RequestBody CreateClientDto dto) throws JsonProcessingException, NotUniqueUserRegistrationException {
        return new ResponseEntity<>(mapper.writeValueAsString(clientService.createClient(dto).getId()), HttpStatus.OK);
    }

    @GetMapping("/{login}")
    public ResponseEntity<String> getClientByLogin(@PathVariable String login) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(clientService.findByLogin(login)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClientNew(@PathVariable long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@PathVariable long id, @RequestBody ClientUpdateDto dto){
        clientService.update(id, dto);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<String> getAllClients() throws JsonProcessingException{
        return new ResponseEntity<String>(mapper.writeValueAsString(clientService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}/bills")
    public ResponseEntity<String> getBillsByClient(@PathVariable long id) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(billService.findByClientID(id)), HttpStatus.OK);
    }

}
