package com.medclinic.service;

import com.medclinic.dto.ClientUpdateDto;
import com.medclinic.dto.ClientWorkFlowDto;
import com.medclinic.dto.CreateClientDto;
import com.medclinic.dto.ServicesClientDto;
import com.medclinic.entity.Analysis;
import com.medclinic.entity.AnalysisServiceResult;
import com.medclinic.entity.Client;
import com.medclinic.exception.NotUniqueUserRegistrationException;

import java.util.List;

public interface IClientService {
    Client createClient(CreateClientDto dto) throws NotUniqueUserRegistrationException;
    void deleteClient(long clientID);
    List<AnalysisServiceResult> getAnalysisResult(ServicesClientDto dto);
    List<Analysis> getListAnalysisFromDoctor(ServicesClientDto dto);
    List<Client> findByFamily(String family);
    List<Client> findByFullName(String fullName);
    Client findByPhoneNumber(String number);
    Client findById(long id);
    Client findByLogin(String login);
    void update(Client client, ClientUpdateDto dto);
    void setRecipeToDoctor(ClientWorkFlowDto dto);
}
