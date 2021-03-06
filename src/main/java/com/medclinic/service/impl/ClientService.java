package com.medclinic.service.impl;

import com.medclinic.dto.ClientUpdateDto;
import com.medclinic.dto.ClientWorkFlowDto;
import com.medclinic.dto.CreateClientDto;
import com.medclinic.dto.ServicesClientDto;
import com.medclinic.entity.*;
import com.medclinic.exception.NotUniqueUserRegistrationException;
import com.medclinic.repository.IClientRepository;
import com.medclinic.service.IAnalysisSvcResultService;
import com.medclinic.service.IClientService;
import com.medclinic.utils.DateParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.PassThroughSourceExtractor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class ClientService implements IClientService {

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IAnalysisSvcResultService resultService;

    /*@Autowired
    private PasswordEncoder encoder;*/

    @Transactional
    @Override
    public Client createClient(CreateClientDto dto) throws NotUniqueUserRegistrationException {
        //Client currentClient = (Client) clientRepository.findByLogin(dto.getLogin());
        Client client = new Client();
        /*if (currentClient.getLogin().equals(dto.getLogin()) | currentClient.getEmail().equals(dto.getEmail()) |
                currentClient.getPhoneNumber().equals(dto.getPhoneNumber())){
            Exception exception =  new NotUniqueUserRegistrationException("Login or email or phone already registered!");
            log.warn(exception.getMessage());
            return currentClient;
        }else {*/
            client.setLogin(dto.getLogin());
            //client.setPassword(encoder.encode(dto.getPassword()));
            client.setFullName(dto.getFullName());
            client.setFamilyName(dto.getFamilyName());
            client.setFirstSymbolName(dto.getFamilyName().charAt(0));
            client.setEmail(dto.getEmail());
            client.setAge(dto.getAge());
            client.setActualAddress(dto.getActualAddress());
            client.setPhoneNumber(dto.getPhoneNumber());
            client.setAbout(dto.getAbout());
            client.setBirthDay(DateParser.getDateByString(dto.getBirthDay()));
            client.setStatus(StatusUser.ACTIVE);

            Set<Role> roles = new HashSet<>();
            roles.add(Role.CLIENT);

            client.setRole(roles);
            clientRepository.save(client);
            return client;
        //}
    }

    @Transactional
    @Override
    public void deleteClient(long clientID) {
        Client client = (Client) clientRepository.findByID(clientID);
        clientRepository.delete(client);
    }

    @Override
    public List<AnalysisServiceResult> getAnalysisResult(ServicesClientDto dto) {
        return resultService.findByClient(dto.getClientID());
    }

    @Override
    public List<Analysis> getListAnalysisFromDoctor(ServicesClientDto dto) {
        return null;
    }

    @Override
    public List<Client> findByFamily(String family) {
        return clientRepository.findByFamily(family);
    }

    @Override
    public List<Client> findByFullName(String fullName) {
        return clientRepository.findByFullName(fullName);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findByPhoneNumber(String number) {
        return clientRepository.findByPhoneNumber(number);
    }

    @Override
    public Client findById(long id) {
        return clientRepository.findByID(id);
    }

    @Override
    public Client findByLogin(String login) {
        return clientRepository.findByLogin(login);
    }

    @Override
    public void update(long clientID, ClientUpdateDto dto) {
        Client client = clientRepository.findByID(clientID);
        client.setAbout(dto.getAbout());
        client.setActualAddress(dto.getActualAddress());
        client.setPhoneNumber(dto.getPhoneNumber());

        clientRepository.save(client);
    }

    @Override
    public void setRecipeToDoctor(ClientWorkFlowDto dto) {

    }
}
