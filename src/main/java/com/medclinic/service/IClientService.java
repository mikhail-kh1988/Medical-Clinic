package com.medclinic.service;

import com.medclinic.dto.ClientUpdateDTO;
import com.medclinic.dto.ClientWorkFlowDTO;
import com.medclinic.dto.CreateClientDTO;
import com.medclinic.dto.ServicesClientDTO;
import com.medclinic.entity.Analysis;
import com.medclinic.entity.AnalysisServiceResult;
import com.medclinic.entity.Client;
import com.medclinic.exception.NotUniqueUserRegistrationException;

import java.util.List;

public interface IClientService {
    Client createClient(CreateClientDTO dto) throws NotUniqueUserRegistrationException;
    void deleteClient(long clientID);
    List<AnalysisServiceResult> getAnalysisResult(ServicesClientDTO dto);
    List<Analysis> getListAnalysisFromDoctor(ServicesClientDTO dto);
    List<Client> findByFamily(String family);
    List<Client> findByFullName(String fullName);
    Client findByPhoneNumber(String number);
    Client findById(long id);
    Client findByLogin(String login);
    void update(Client client, ClientUpdateDTO dto);
    void setRecipeToDoctor(ClientWorkFlowDTO dto);
}
