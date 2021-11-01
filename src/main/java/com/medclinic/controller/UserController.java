package com.medclinic.controller;

import com.medclinic.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserRepository repository;

    @GetMapping("/all")
    public String getAllUsers(){
        return repository.findAll().toString();
    }
}
