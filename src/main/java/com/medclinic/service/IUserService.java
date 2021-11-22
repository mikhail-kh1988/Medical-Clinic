package com.medclinic.service;

import com.medclinic.dto.CreateClientDto;
import com.medclinic.dto.DoctorDto;
import com.medclinic.entity.User;
import com.medclinic.exception.NotUniqueUserRegistrationException;

import java.util.List;

public interface IUserService {
    User changePassword(String login, String oldPassword, String newPassword);
    User registerClient(CreateClientDto dto) throws NotUniqueUserRegistrationException;
    User registerDoctor(DoctorDto dto) throws NotUniqueUserRegistrationException;
    User findByLogin(String login);
    User findByEmail(String email);
    List<User> findByStatus(String status);

}
