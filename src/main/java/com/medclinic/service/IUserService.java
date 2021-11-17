package com.medclinic.service;

import com.medclinic.dto.CreateClientDto;
import com.medclinic.dto.DoctorDto;
import com.medclinic.entity.User;

import java.util.List;

public interface IUserService {
    User changePassword(String login, String oldPassword, String newPassword);
    User registerClient(CreateClientDto dto);
    User registerDoctor(DoctorDto dto);
    User findByLogin(String login);
    User findByEmail(String email);
    List<User> findByStatus(String status);

}
