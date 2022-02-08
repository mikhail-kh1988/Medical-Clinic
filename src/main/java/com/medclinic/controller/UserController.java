package com.medclinic.controller;


import com.medclinic.dto.CreateClientDto;
import com.medclinic.dto.DoctorDto;
import com.medclinic.entity.User;
import com.medclinic.exception.NotUniqueUserRegistrationException;
import com.medclinic.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable long id) {
        return ResponseEntity.ok(userService.findByID(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/doctor")
    public ResponseEntity<String> createNewDoctor(@RequestBody @Validated DoctorDto dto) throws NotUniqueUserRegistrationException {
        return ResponseEntity.ok(""+userService.registerDoctor(dto).getId());
    }

    @GetMapping("/doctor/{login}")
    public ResponseEntity<User> getDoctorByID(@PathVariable String login) {
        return ResponseEntity.ok(userService.findByLogin(login));
    }

    @PostMapping("/client")
    public ResponseEntity<String> createNewClient(@RequestBody @Validated CreateClientDto dto) throws NotUniqueUserRegistrationException{
        return ResponseEntity.ok(""+userService.registerClient(dto).getId());
    }
    @GetMapping("/client/{login}")
    public ResponseEntity<User> getClientByID(@PathVariable String login) {
        return ResponseEntity.ok(userService.findByLogin(login));
    }

}
