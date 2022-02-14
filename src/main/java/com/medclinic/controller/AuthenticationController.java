package com.medclinic.controller;

import com.medclinic.config.security.jwt.AuthRequest;
import com.medclinic.config.security.jwt.AuthResponse;
import com.medclinic.config.security.jwt.JwtProvider;
import com.medclinic.entity.User;
import com.medclinic.service.IUserService;
import com.medclinic.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtProvider jwtProvider;


    @PostMapping
    public AuthResponse auth(@RequestBody AuthRequest request){
        UserDetails user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(user.getUsername());
        return new AuthResponse(token);
    }
}
