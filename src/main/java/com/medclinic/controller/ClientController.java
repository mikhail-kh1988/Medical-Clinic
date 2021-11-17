package com.medclinic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medclinic.dto.CreateClientDto;
import com.medclinic.exception.NotUniqueUserRegistrationException;
import com.medclinic.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private IClientService clientService;

    @PostMapping("/register")
    public ResponseEntity<String> registerClient(@RequestBody CreateClientDto dto) throws JsonProcessingException, NotUniqueUserRegistrationException {
        return new ResponseEntity<>(mapper.writeValueAsString(clientService.createClient(dto).getId()), HttpStatus.OK);
    }

    @GetMapping("/deleteClient/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable long id) throws JsonProcessingException {
        clientService.deleteClient(id);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }

    @GetMapping("/getClientByLogin/{login}")
    public ResponseEntity<String> getClientByLogin(@PathVariable String login) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(clientService.findByLogin(login)), HttpStatus.OK);
    }
}
