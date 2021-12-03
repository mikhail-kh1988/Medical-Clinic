package com.medclinic.service.impl;

import com.medclinic.dto.CreateClientDto;
import com.medclinic.dto.DoctorDto;
import com.medclinic.entity.User;
import com.medclinic.exception.NotUniqueUserRegistrationException;
import com.medclinic.repository.IUserRepository;
import com.medclinic.service.IClientService;
import com.medclinic.service.IDoctorService;
import com.medclinic.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IDoctorService doctorService;

    @Autowired
    private IClientService clientService;

    @Transactional
    @Override
    public User changePassword(String login, String oldPassword, String newPassword) {
        User user = (User) userRepository.findByLogin(login);
        log.debug("Find user "+user.getFullName()+" by login "+user.getLogin()+". ");

        user.setPassword(newPassword);
        userRepository.save(user);

        log.info("User "+login+" change password!");
        return user;
    }

    @Transactional
    @Override
    public User registerClient(CreateClientDto dto) throws NotUniqueUserRegistrationException {
        User user = clientService.createClient(dto);
        return user;
    }

    @Transactional
    @Override
    public User registerDoctor(DoctorDto dto) throws NotUniqueUserRegistrationException{
        User user = doctorService.createNewDoctor(dto);
        return user;
    }

    @Override
    public User findByLogin(String login) {
        return (User) userRepository.findByLogin(login);
    }

    @Override
    public User findByEmail(String email) {
        return (User) userRepository.findByEmail(email);
    }

    @Override
    public User findByID(long id) {
        return (User) userRepository.findByID(id);
    }

    @Override
    public List<User> findByStatus(String status) {
        return userRepository.findByStatus(status);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
