package com.medclinic.service.impl;

import com.medclinic.dto.ClientUpdateDTO;
import com.medclinic.dto.ClientWorkFlowDTO;
import com.medclinic.dto.CreateClientDTO;
import com.medclinic.dto.ServicesClientDTO;
import com.medclinic.entity.Analysis;
import com.medclinic.entity.AnalysisServiceResult;
import com.medclinic.entity.Client;
import com.medclinic.entity.StatusUser;
import com.medclinic.repository.IClientRepository;
import com.medclinic.service.IAnalysisSvcResultService;
import com.medclinic.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IAnalysisSvcResultService resultService;

    @Transactional
    @Override
    public Client createClient(CreateClientDTO dto) {
        Client client = new Client();
        client.setLogin(dto.getLogin());
        client.setPassword(dto.getPassword());
        client.setFullName(dto.getFullName());
        client.setFamilyName(dto.getFamilyName());
        client.setFirstSymbolName(dto.getFamilyName().charAt(0));
        client.setEmail(dto.getEmail());
        client.setAge(dto.getAge());
        client.setActualAddress(dto.getActualAddress());
        client.setPhoneNumber(dto.getPhoneNumber());
        client.setAbout(dto.getAbout());
        //client.setBirthDay(GregorianCalendar.from(ZonedDateTime.now()));
        client.setStatus(StatusUser.ACTIVE);
        clientRepository.save(client);
        return client;
    }

    @Transactional
    @Override
    public void deleteClient(long clientID) {
        Client client = (Client) clientRepository.findByID(clientID);
        clientRepository.delete(client);
    }

    @Override
    public List<AnalysisServiceResult> getAnalysisResult(ServicesClientDTO dto) {
        return resultService.findByClient(dto.getClientID());
    }

    @Override
    public List<Analysis> getListAnalysisFromDoctor(ServicesClientDTO dto) {
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
    public Client findByPhoneNumber(String number) {
        return (Client) clientRepository.findByPhoneNumber(number);
    }

    @Override
    public Client findById(long id) {
        return (Client) clientRepository.findByID(id);
    }

    @Override
    public Client findByLogin(String login) {
        return (Client) clientRepository.findByLogin(login);
    }

    @Override
    public void update(Client client, ClientUpdateDTO dto) {

    }

    @Override
    public void setRecipeToDoctor(ClientWorkFlowDTO dto) {

    }
}
