package com.example.ms2_packvehicule1.web;

import com.example.ms2_packvehicule1.Service.IserviceVoiture;
import com.example.ms2_packvehicule1.dto.clientResponseDTO;
import com.example.ms2_packvehicule1.entities.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping(path = "api")
@CrossOrigin("*")
public class ClientWebREST {
    @Autowired
    IserviceVoiture iserviceVoiture;


    @GetMapping(path = "/client")
    public clientResponseDTO getClient(@PathVariable(name = "id") Long id){
        return iserviceVoiture.voitureClient(id);
    }
    @GetMapping(path = "/clients")
    public List<clientResponseDTO> listeClient(){
        return iserviceVoiture.VOITURE_LIST();
    }

}
