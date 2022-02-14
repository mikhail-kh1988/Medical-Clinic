package com.medclinic.service;

import com.medclinic.dto.CreateClientDto;
import com.medclinic.dto.DoctorDto;
import com.medclinic.entity.User;
import com.medclinic.exception.NotUniqueUserRegistrationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    User changePassword(String login, String oldPassword, String newPassword);
    User registerClient(CreateClientDto dto) throws NotUniqueUserRegistrationException;
    User registerDoctor(DoctorDto dto) throws NotUniqueUserRegistrationException;
    User findByLogin(String login);
    User findByEmail(String email);
    User findByID(long id);
    List<User> findByStatus(String status);
    List<User> findAll();
    UserDetails findByLoginAndPassword(String login, String password);

}
