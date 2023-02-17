package com.example.ms2_packvehicule1.Service;

import com.example.ms2_packvehicule1.dto.clientRequestDTO;
import com.example.ms2_packvehicule1.dto.clientResponseDTO;
import com.example.ms2_packvehicule1.entities.client;

import java.util.*;
public interface IserviceVoiture {

    public clientResponseDTO voitureClient(Long id);
    public List<clientResponseDTO> VOITURE_LIST();
    public clientResponseDTO saveClient(clientRequestDTO client1);
    public client fromRequestDTO(clientRequestDTO clientRequestDTO);
    public clientResponseDTO fromClient(client client);
}
