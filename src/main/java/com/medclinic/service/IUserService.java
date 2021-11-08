package com.medclinic.service;

import com.medclinic.dto.CreateClientDTO;
import com.medclinic.dto.DoctorDTO;
import com.medclinic.entity.User;

import java.util.List;

public interface IUserService {
    User changePassword(String login, String oldPassword, String newPassword);
    User registerClient(CreateClientDTO dto);
    User registerDoctor(DoctorDTO dto);
    User findByLogin(String login);
    User findByEmail(String email);
    List<User> findByStatus(String status);

}
