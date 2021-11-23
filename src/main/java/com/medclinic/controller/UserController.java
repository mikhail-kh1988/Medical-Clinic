package com.medclinic.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medclinic.dto.CreateClientDto;
import com.medclinic.dto.DoctorDto;
import com.medclinic.exception.NotUniqueUserRegistrationException;
import com.medclinic.repository.impl.UserRepository;
import com.medclinic.service.IUserService;
import com.medclinic.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private IUserService userService;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping("")
    public ResponseEntity<String> getAllUsers() throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(repository.findAll()), HttpStatus.OK);
    }

    @PostMapping("/doctor")
    public ResponseEntity<String> createNewDoctor(@RequestBody DoctorDto dto) throws NotUniqueUserRegistrationException, JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(userService.registerDoctor(dto).getId()), HttpStatus.OK);
    }

    @PostMapping("/client")
    public ResponseEntity<String> createNewClient(@RequestBody CreateClientDto dto) throws NotUniqueUserRegistrationException, JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(userService.registerClient(dto).getId()), HttpStatus.OK);
    }

}
