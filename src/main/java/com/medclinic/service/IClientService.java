package com.medclinic.service;

import com.medclinic.dto.CreateClientDTO;
import com.medclinic.dto.ServicesClientDTO;
import com.medclinic.entity.Analysis;
import com.medclinic.entity.AnalysisServiceResult;
import com.medclinic.entity.Client;
import java.util.List;

public interface IClientService {

    Client createClient(CreateClientDTO dto);
    void deleteClient(long clientID);
    List<AnalysisServiceResult> getAnalysisResult(ServicesClientDTO dto);
    List<Analysis> getListAnalysisFromDoctor(ServicesClientDTO dto);
    List<Client> findByFamily(String family);
    List<Client> findByFullName(String fullName);
    Client findByPhoneNumber(String number);
    Client findById(long id);
    void update(Client client, CreateClientDTO dto);
}
