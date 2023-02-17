package com.example.ms2_packvehicule1.Service;

import com.example.ms2_packvehicule1.Repositories.ClientRepositories;
import com.example.ms2_packvehicule1.dto.clientRequestDTO;
import com.example.ms2_packvehicule1.dto.clientResponseDTO;
import com.example.ms2_packvehicule1.entities.Voiture;
import com.example.ms2_packvehicule1.entities.client;
import com.example.ms2_packvehicule1.openFeigne.FeignRestClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class IserviceVoitureImpl implements IserviceVoiture {
    @Autowired
    private   ClientRepositories clientRepositories;
@Autowired
private FeignRestClient feignRestClient;



    @Override
    public clientResponseDTO voitureClient(Long id) {

        client cl=clientRepositories.findById(id).get();
        clientResponseDTO responseDTO=fromClient(cl);

        return responseDTO;

    }

            @Override
            public List<clientResponseDTO> VOITURE_LIST() {
                List<client> clients = clientRepositories.findAll();
                List<clientResponseDTO> clientResponseDTOS =
                        clients.stream().map(c -> fromClient(c)).collect(Collectors.toList());
//
                for (clientResponseDTO cl : clientResponseDTOS) {
                    try {
                        System.out.println(cl.getIdv()+"weee"+cl.getPrenom());

                        Voiture voiture1 = feignRestClient.getVoiture(cl.getIdv());
                        cl.setVoiture(voiture1);
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }
                    return clientResponseDTOS;



}
            public clientResponseDTO saveClient(clientRequestDTO client1) {
            client c2=fromRequestDTO(client1);
            c2=clientRepositories.save(c2);
            clientResponseDTO clientResponseDTO=fromClient(c2);
            return clientResponseDTO;
    }

    @Override
    public client fromRequestDTO(clientRequestDTO clientRequestDTO) {
        client c1=new client();
        c1.setId_client(clientRequestDTO.getId_client());
        c1.setNom(clientRequestDTO.getNom());
        c1.setEmail(clientRequestDTO.getEmail());
        c1.setAdresse(clientRequestDTO.getAdresse());
        c1.setCin(clientRequestDTO.getCin());
        c1.setDateLocation(clientRequestDTO.getDateLocation());
        c1.setIdv(clientRequestDTO.getIdv());
        c1.setPrenom(clientRequestDTO.getPrenom());
        c1.setTel(clientRequestDTO.getTel());
        c1.setDateRetour(clientRequestDTO.getDateRetour());
        return c1;
    }

    @Override
    public clientResponseDTO fromClient(client client) {
        clientResponseDTO c1=new clientResponseDTO();
        c1.setId_client(client.getId_client());
        c1.setNom(client.getNom());
        c1.setEmail(client.getEmail());
        c1.setAdresse(client.getAdresse());
        c1.setCin(client.getCin());
        c1.setDateLocation(client.getDateLocation());
        c1.setIdv(client.getIdv());
        c1.setDateRetour(client.getDateRetour());
        c1.setPrenom(client.getPrenom());
        c1.setTel(client.getTel());
        c1.setVoiture(client.getV1());
        return c1;
    }
}
